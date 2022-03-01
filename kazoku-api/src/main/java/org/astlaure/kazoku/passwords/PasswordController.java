package org.astlaure.kazoku.passwords;

import org.astlaure.kazoku.passwords.models.ForgotPasswordDto;
import org.astlaure.kazoku.passwords.models.ResetPasswordDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/passwords")
public class PasswordController {
    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/forgot")
    public ResponseEntity<?> postForgotPassword(@Valid @RequestBody ForgotPasswordDto forgotPassword) {
        passwordService.forgotPassword(forgotPassword);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/reset")
    public ResponseEntity<?> postResetPassword(@Valid @RequestBody ResetPasswordDto resetPassword) {
        return ResponseEntity.status(200).build();
    }
}
