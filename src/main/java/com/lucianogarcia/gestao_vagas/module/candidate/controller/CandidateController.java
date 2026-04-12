package com.lucianogarcia.gestao_vagas.module.candidate.controller;

import com.lucianogarcia.gestao_vagas.module.candidate.entity.CandidateEntity;
import com.lucianogarcia.gestao_vagas.module.useCase.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
        @Autowired
        private CreateCandidateUseCase useCase;

//    public CandidateController(CandidateRepository candidateRepository) {
//        this.candidateRepository = candidateRepository;
//    }
    @PostMapping("/")
    public ResponseEntity<Object> create(
            @Valid
            @RequestBody CandidateDTO candidateDTO
    ) {
        CandidateEntity entity = CandidateDTO.toEntity(candidateDTO);
        try {
            CandidateEntity result = useCase.execute(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }


    }
}
