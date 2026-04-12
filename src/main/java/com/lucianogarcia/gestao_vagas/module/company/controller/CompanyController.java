package com.lucianogarcia.gestao_vagas.module.company.controller;

import com.lucianogarcia.gestao_vagas.module.company.entity.Company;
import com.lucianogarcia.gestao_vagas.module.useCase.CreateCompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CreateCompanyUseCase companyUseCase;
    @PostMapping("/")
    public ResponseEntity<Object> createCompany(@RequestBody Company company) {
        try {
            Company result = this.companyUseCase.execute(company);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
