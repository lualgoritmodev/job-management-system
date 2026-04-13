package com.lucianogarcia.gestao_vagas.module.repository;

import com.lucianogarcia.gestao_vagas.module.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Optional<Company> findByUserNameOrEmailCompany(String userName, String emailCompany);

    Optional<Company> findByUserName(String userName);
}
