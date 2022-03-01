package org.astlaure.kazoku.passwords.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordDto {
    @NotEmpty
    private String token;

    @NotEmpty
    private String password;
}
