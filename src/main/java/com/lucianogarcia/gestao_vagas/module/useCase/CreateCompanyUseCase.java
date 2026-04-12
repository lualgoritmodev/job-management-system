package com.lucianogarcia.gestao_vagas.module.useCase;

import com.lucianogarcia.gestao_vagas.exception.UserFoundException;
import com.lucianogarcia.gestao_vagas.module.company.entity.Company;
import com.lucianogarcia.gestao_vagas.module.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;
    public Company execute(Company companyEntity) {
        this.companyRepository.findByUserNameOrEmailCompany(
                companyEntity.getUserName(),
                        companyEntity.getEmailCompany())
                .ifPresent((user) -> {
                     throw new UserFoundException();
                });

            return this.companyRepository.save(companyEntity);
    }
}
