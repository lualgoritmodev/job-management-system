package com.lucianogarcia.gestao_vagas.module.repository;

import com.lucianogarcia.gestao_vagas.module.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> { Optional<CandidateEntity> findByuserNameOrEmail(String userName, String email);
}
