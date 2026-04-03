package com.lucianogarcia.gestao_vagas.module.candidate.controller;

import com.lucianogarcia.gestao_vagas.exception.UserFoundException;
import com.lucianogarcia.gestao_vagas.module.entity.CandidateEntity;
import com.lucianogarcia.gestao_vagas.module.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

//    public CandidateController(CandidateRepository candidateRepository) {
//        this.candidateRepository = candidateRepository;
//    }
    @PostMapping("/")
    public CandidateDTO create(
            @Valid
            @RequestBody CandidateDTO candidateDTO
    ) {
         CandidateEntity entity =  CandidateDTO.toEntity(candidateDTO);

         Optional<CandidateEntity> existingCandidate = this.candidateRepository
                  .findByuserNameOrEmail(entity.getUserName(),
                          entity.getEmail());

          if(existingCandidate.isPresent()) {
              throw new UserFoundException();
          }

          CandidateEntity saved = this.candidateRepository.save(entity);
          return new CandidateDTO(saved);
    }
}
