package com.lucianogarcia.gestao_vagas.module.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCompany;
    @NotBlank
    private String userName;
    @NotBlank
    private String emailCompany;
    @NotBlank
    private String password;
    @NotBlank
    private String webSite;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @CreationTimestamp
    private LocalDateTime createAt;
}
