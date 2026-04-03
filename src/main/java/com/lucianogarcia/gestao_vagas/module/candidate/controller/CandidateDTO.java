package com.lucianogarcia.gestao_vagas.module.candidate.controller;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lucianogarcia.gestao_vagas.module.entity.CandidateEntity;
import lombok.Data;

import java.util.UUID;

@Data
@JsonPropertyOrder({ "name", "userName", "email", "description", "password", "curriculum", "idCandidate" })
public class CandidateDTO {
    private UUID idCandidate;
    private String name;
    private String userName;
    private String email;
    private String password;
    private String description;
    private String curriculum;

    public CandidateDTO(){}
    public CandidateDTO(CandidateEntity entity) {
        this.idCandidate = entity.getIdCandidate();
        this.name = entity.getName();
        this.userName = entity.getUserName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.description = entity.getDescription();
        this.curriculum = entity.getCurriculum();
    }

    public static CandidateEntity toEntity(CandidateDTO dto){
        CandidateEntity entity = new CandidateEntity();
        entity.setIdCandidate(dto.getIdCandidate());
        entity.setName(dto.getName());
        entity.setUserName(dto.getUserName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setDescription(dto.getDescription());
        entity.setCurriculum(dto.getCurriculum());

        return entity;
    }
}
