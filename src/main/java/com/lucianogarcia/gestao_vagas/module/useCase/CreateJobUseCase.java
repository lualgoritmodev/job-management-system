package com.lucianogarcia.gestao_vagas.module.useCase;

import com.lucianogarcia.gestao_vagas.module.company.entity.Job;
import com.lucianogarcia.gestao_vagas.module.repository.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {
    @Autowired
    private JobRepository jobRepository;
    @Transactional
    public Job execute(Job job) {
        return this.jobRepository.save(job);
    }
}
