package com.lucianogarcia.gestao_vagas.module.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idJob;
    @NotBlank
    private String description;
    @NotBlank
    private String level;
    @NotBlank
    private String benefits;
}
