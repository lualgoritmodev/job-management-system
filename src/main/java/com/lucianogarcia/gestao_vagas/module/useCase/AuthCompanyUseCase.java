package com.lucianogarcia.gestao_vagas.module.useCase;

import com.lucianogarcia.gestao_vagas.module.company.entity.Company;
import com.lucianogarcia.gestao_vagas.module.repository.CompanyRepository;
import com.lucianogarcia.gestao_vagas.security.securityDTO.AuthCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Company execute(AuthCompanyDTO authCompanyDTO) {
        var company = this.companyRepository.findByUserName(authCompanyDTO.getUserName())
                .orElseThrow(() -> new BadCredentialsException("Login ou senha inválidos"));

        var passwordMatches = this.passwordEncoder.matches(
                authCompanyDTO.getPassword(),
                company.getPassword()
        );

        if (!passwordMatches) {
            throw new BadCredentialsException("Login ou senha inválidos");

        return company;
    }
}
