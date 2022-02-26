package org.astlaure.kazoku.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.astlaure.kazoku.auth.models.ProfileDto;
import org.astlaure.kazoku.users.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var user = (User) authentication.getPrincipal();
        var content = objectMapper.writeValueAsString(ProfileDto.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .role(user.getRole())
                .build());
        response.getWriter().write(content);
        response.setStatus(200);
    }
}
