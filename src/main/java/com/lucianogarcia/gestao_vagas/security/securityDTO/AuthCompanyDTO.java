package com.lucianogarcia.gestao_vagas.security.securityDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthCompanyDTO {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}
