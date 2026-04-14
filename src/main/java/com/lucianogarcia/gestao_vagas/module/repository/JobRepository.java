package com.lucianogarcia.gestao_vagas.module.repository;

import com.lucianogarcia.gestao_vagas.module.company.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<Job, UUID> {
}
