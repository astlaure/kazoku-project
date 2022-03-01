package org.astlaure.kazoku.passwords;

import org.astlaure.kazoku.emails.Email;
import org.astlaure.kazoku.emails.EmailService;
import org.astlaure.kazoku.emails.enums.EmailTemplate;
import org.astlaure.kazoku.passwords.models.ForgotPasswordDto;
import org.astlaure.kazoku.users.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.UUID;

@Service
public class PasswordService {
    private final PasswordResetRepository passwordResetRepository;
    private final UserService userService;
    private final EmailService emailService;

    @Value("${kazoku.mail.from}")
    private String mailFrom;

    public PasswordService(PasswordResetRepository passwordResetRepository, UserService userService, EmailService emailService) {
        this.passwordResetRepository = passwordResetRepository;
        this.userService = userService;
        this.emailService = emailService;
    }

    public void forgotPassword(ForgotPasswordDto forgotPassword) {
        var passwordResetToken = createForgotPasswordToken(forgotPassword);

        var model = new HashMap<String, Object>();
        model.put("resetLink", "http://localhost:4200/reset-password?token=" + passwordResetToken.getToken());

        emailService.sendEmail(Email.builder()
                        .from(mailFrom)
                        .to(forgotPassword.getEmail())
                        .subject("Reset Password")
                        .model(model)
                        .template(EmailTemplate.RESET_PASSWORD)
                .build());
    }

    private PasswordResetToken createForgotPasswordToken(ForgotPasswordDto forgotPassword) {
        var user = userService.findByUsername(forgotPassword.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("The provided username doesn't exist."));

        var passwordResetToken = PasswordResetToken.builder()
                .token(UUID.randomUUID().toString())
                .user(user)
                .expiration(LocalDateTime.now().plus(5, ChronoUnit.MINUTES))
                .build();

        return passwordResetRepository.save(passwordResetToken);
    }
}
