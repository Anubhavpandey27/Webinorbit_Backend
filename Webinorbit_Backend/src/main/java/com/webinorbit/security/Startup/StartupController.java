package com.webinorbit.security.Startup;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/startups")
@RequiredArgsConstructor
public class StartupController {

    private final StartupService startupService;

    @PostMapping("/register")
    public ResponseEntity<String> registerStartup(@RequestBody Startup startup) {
        startupService.registerStartup(startup);
        String jsonResponse = "{\"status\":\"Startup registered successfully\"}";
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/json").body(jsonResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Startup>> getAllStartups() {
        List<Startup> startups = startupService.getAllStartups();
        return ResponseEntity.ok(startups);
    }

    @GetMapping("/{startupId}")
    public ResponseEntity<Startup> getStartupById(@PathVariable Long startupId) {
        Startup startup = startupService.getStartupById(startupId);
        return ResponseEntity.ok(startup);
    }

    @PostMapping("/update/{startupId}")
    public ResponseEntity<String> updateStartup(@PathVariable Long startupId, @RequestBody Startup updatedStartup) {
        startupService.updateStartup(startupId, updatedStartup);
        String jsonResponse = "{\"status\":\"Startup details updated successfully\"}";
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/json").body(jsonResponse);
    }

    @DeleteMapping("/delete/{startupId}")
    public ResponseEntity<String> deleteStartup(@PathVariable Long startupId) {
        startupService.deleteStartup(startupId);
        String jsonResponse = "{\"status\":\"Startup deleted successfully\"}";
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/json").body(jsonResponse);
    }
}
