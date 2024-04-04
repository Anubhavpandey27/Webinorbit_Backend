package com.alibou.security.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@CrossOrigin("http://127.0.0.1:3000")
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PatchMapping
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/{email}")
    public ResponseEntity<Optional<User>> findByEmail(@PathVariable String email) {

        return ResponseEntity.ok(service.getUserByEmail(email));
    }


}
