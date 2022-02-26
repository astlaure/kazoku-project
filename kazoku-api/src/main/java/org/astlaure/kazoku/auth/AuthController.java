package org.astlaure.kazoku.auth;

import org.astlaure.kazoku.auth.models.ProfileDto;
import org.astlaure.kazoku.users.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/profile")
    public ResponseEntity<ProfileDto> getProfile(Authentication authentication) {
        var user = (User) authentication.getPrincipal();
        return ResponseEntity.status(200).body(ProfileDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .username(user.getUsername())
                        .role(user.getRole())
                .build());
    }
}
