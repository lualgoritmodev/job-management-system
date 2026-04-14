package com.lucianogarcia.gestao_vagas.module.company.job;

import com.lucianogarcia.gestao_vagas.module.company.entity.Job;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobDTO {
    @NotBlank
    private String description;

    @NotBlank
    private String level;

    @NotBlank
    private String benefits;

    @NotNull
    private UUID companyId;

    public Job toEntity() {
        return new Job(
                null,
                this.description,
                this.level,
                this.benefits,
                null,
                this.companyId,
                null
        );
    }

    public static CreateJobDTO fromEntity(Job job) {
        return new CreateJobDTO(
                job.getDescription(),
                job.getLevel(),
                job.getBenefits(),
                job.getCompanyId()
        );
    }
}
