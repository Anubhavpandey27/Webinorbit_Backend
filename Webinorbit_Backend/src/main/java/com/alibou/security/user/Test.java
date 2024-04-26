package com.alibou.security.user;

import com.alibou.security.config.JwtService;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Test {
    String username;
}
