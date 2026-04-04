package com.lucianogarcia.gestao_vagas.module.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Entity(name = "candidatos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCandidate;
    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "\\S+", message = "Não pode ter espaços")
    private String userName;
    @Email(message = "Email incorreto")
    private String email;
    @Size(min = 6, message = "tamanho minimo de 6 letras")
    private String password;
    private String description;
    private String curriculum;
}
