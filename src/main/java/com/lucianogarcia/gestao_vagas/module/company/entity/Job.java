package com.lucianogarcia.gestao_vagas.module.company.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idJob;
    @NotBlank
    private String description;
    @NotBlank
    private String level;
    @NotBlank
    private String benefits;
    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false, nullable = false)
    private Company company;

    @Column(name = "company_id")
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime creationJob;

}
