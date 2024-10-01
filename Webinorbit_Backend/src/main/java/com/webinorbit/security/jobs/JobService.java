package com.webinorbit.security.jobs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final AtomicLong idCounter = new AtomicLong(1); // Simple ID generator

    // Get all jobs
    public List<JobResponse> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Get a job by ID
    public JobResponse getJobById(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Job with id " + id + " not found."));
        return mapToResponse(job);
    }

    // Create a new job with a manually generated ID
    public JobResponse createJob(JobRequest jobRequest) {
        Job job = mapToEntity(jobRequest);
        job.setId(idCounter.getAndIncrement()); // Manually set the ID
        Job savedJob = jobRepository.save(job);
        return mapToResponse(savedJob);
    }

    // Update a job
    public JobResponse updateJob(Long id, JobRequest jobRequest) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Job with id " + id + " not found."));

        job.setCompanyName(jobRequest.getCompanyName());
        job.setCompanyLogo(jobRequest.getCompanyLogo());
        job.setJobType(jobRequest.getJobType());
        job.setRole(jobRequest.getRole());
        job.setLocation(jobRequest.getLocation());
        job.setDuration(jobRequest.getDuration());
        job.setBatch(jobRequest.getBatch());
        job.setSalary(jobRequest.getSalary());
        job.setDescription(jobRequest.getDescription());
        job.setApplyLink(jobRequest.getApplyLink());

        Job updatedJob = jobRepository.save(job);
        return mapToResponse(updatedJob);
    }

    // Delete a job
    public void deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new IllegalArgumentException("Job with id " + id + " not found.");
        }
        jobRepository.deleteById(id);
    }

    // Mapping methods for DTOs
    private JobResponse mapToResponse(Job job) {
        JobResponse response = new JobResponse();
        response.setId(job.getId());
        response.setCompanyName(job.getCompanyName());
        response.setCompanyLogo(job.getCompanyLogo());
        response.setJobType(job.getJobType());
        response.setRole(job.getRole());
        response.setLocation(job.getLocation());
        response.setDuration(job.getDuration());
        response.setBatch(job.getBatch());
        response.setSalary(job.getSalary());
        response.setDescription(job.getDescription());
        response.setApplyLink(job.getApplyLink());
        return response;
    }

    private Job mapToEntity(JobRequest jobRequest) {
        return Job.builder()
                .companyName(jobRequest.getCompanyName())
                .companyLogo(jobRequest.getCompanyLogo())
                .jobType(jobRequest.getJobType())
                .role(jobRequest.getRole())
                .location(jobRequest.getLocation())
                .duration(jobRequest.getDuration())
                .batch(jobRequest.getBatch())
                .salary(jobRequest.getSalary())
                .description(jobRequest.getDescription())
                .applyLink(jobRequest.getApplyLink())
                .build();
    }
}