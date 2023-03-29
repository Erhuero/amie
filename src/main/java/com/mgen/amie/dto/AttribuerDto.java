package com.mgen.amie.dto;


import java.time.LocalDateTime;

public class AttribuerDto {

    private RoleDto role;
    private UtilisateurAvecRoleDto utilisateur;
    private LocalDateTime dateAttribution;

    public AttribuerDto() {

    }

    public AttribuerDto(RoleDto role, UtilisateurAvecRoleDto utilisateur, LocalDateTime dateAttribution) {
        this.role = role;
        this.utilisateur = utilisateur;
        this.dateAttribution = dateAttribution;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public UtilisateurAvecRoleDto getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurAvecRoleDto utilisateur) {
        this.utilisateur = utilisateur;
    }

    public LocalDateTime getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(LocalDateTime dateAttribution) {
        this.dateAttribution = dateAttribution;
    }
}

