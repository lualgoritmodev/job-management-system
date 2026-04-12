package com.lucianogarcia.gestao_vagas.module.company.job;

import com.lucianogarcia.gestao_vagas.module.company.entity.Job;
import com.lucianogarcia.gestao_vagas.module.useCase.CreateJobUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company/job")
public class JobController {
    @Autowired
    private CreateJobUseCase createJobUseCase;
    @PostMapping("/")
    public ResponseEntity<CreateJobDTO> createJob(@Valid @RequestBody CreateJobDTO job) {
        Job result = this.createJobUseCase.execute(job.toEntity());

        return ResponseEntity.status(HttpStatus.CREATED).body(CreateJobDTO.fromEntity(result));
    }

}
