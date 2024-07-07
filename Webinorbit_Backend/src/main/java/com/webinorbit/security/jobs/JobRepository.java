package com.webinorbit.security.jobs;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JobRepository implements JpaRepository<Job, Integer> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Job> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Job> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Job> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Job getOne(Integer integer) {
        return null;
    }

    @Override
    public Job getById(Integer integer) {
        return null;
    }

    @Override
    public Job getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Job> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Job> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Job> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Job> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Job> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Job> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Job, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Job> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Job> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Job> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Job> findAll() {
        return null;
    }

    @Override
    public List<Job> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Job entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Job> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Job> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Job> findAll(Pageable pageable) {
        return null;
    }
}
