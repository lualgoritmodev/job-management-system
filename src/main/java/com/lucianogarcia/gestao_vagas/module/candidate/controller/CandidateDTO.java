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
    public CandidateDTO fromDTO(CandidateEntity entity) {
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setIdCandidate(entity.getIdCandidate());
        candidateDTO.setName(entity.getName());
        candidateDTO.setName(entity.getUserName());
        candidateDTO.setName(entity.getEmail());
        candidateDTO.setName(entity.getPassword());
        candidateDTO.setName(entity.getDescription());
        candidateDTO.setName(entity.getCurriculum());
        return candidateDTO;
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
