package org.example.ticketsystem.Controller;

import org.example.ticketsystem.Entity.Login;
import org.example.ticketsystem.Service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/loginStart")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerStart(@RequestParam String email, @RequestParam String password) {
        try {
            Login newLogin = loginService.RegisterService(email, password);

            return ResponseEntity.ok(Map.of(
                    "message", "User registered successfully!",
                    "email", newLogin.getEmail()
            ));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
