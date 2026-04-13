package com.lucianogarcia.gestao_vagas.module.useCase;

import com.lucianogarcia.gestao_vagas.exception.UserFoundException;
import com.lucianogarcia.gestao_vagas.module.company.entity.Company;
import com.lucianogarcia.gestao_vagas.module.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Company execute(Company companyEntity) {
        this.companyRepository.findByUserNameOrEmailCompany(
                companyEntity.getUserName(),
                        companyEntity.getEmailCompany())
                .ifPresent((user) -> {
                     throw new UserFoundException();
                });
        companyEntity.setPassword(
                passwordEncoder.encode(companyEntity.getPassword())
        );
            return this.companyRepository.save(companyEntity);
    }
}
