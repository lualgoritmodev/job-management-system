package com.lucianogarcia.gestao_vagas.module.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCompany;
    @NotBlank
    private String userName;
    @NotBlank
    @Email
    private String emailCompany;
    @NotBlank
    private String password;
    @NotBlank
    private String webSite;
    @NotBlank
    private String name;
    @NotBlank
    @NotBlank
    private String description;
    @CreationTimestamp
    private LocalDateTime createAt;
}
