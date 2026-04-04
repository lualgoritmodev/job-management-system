package com.lucianogarcia.gestao_vagas.module.useCase;

import com.lucianogarcia.gestao_vagas.exception.UserFoundException;
import com.lucianogarcia.gestao_vagas.module.candidate.controller.CandidateDTO;
import com.lucianogarcia.gestao_vagas.module.entity.CandidateEntity;
import com.lucianogarcia.gestao_vagas.module.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {

        Optional<CandidateEntity> existingCandidate = candidateRepository
                .findByuserNameOrEmail(candidateEntity.getUserName(),
                        candidateEntity.getEmail());

        if(existingCandidate.isPresent()) {
            throw new UserFoundException();
        }

        return this.candidateRepository.save(candidateEntity);
    }

}
