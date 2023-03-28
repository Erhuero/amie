package com.mgen.amie.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AjouterFavorisDto {

    private EvenementCompletDto evenement;
    private UtilisateurAvecRoleDto utilisateur;
    private LocalDateTime dateAjout;
    private List<RoleDto> roles;

    public AjouterFavorisDto() {
    }

    public AjouterFavorisDto(EvenementCompletDto evenement,
                             UtilisateurAvecRoleDto utilisateur,
                             LocalDateTime dateAjout) {
        this.evenement = evenement;
        this.utilisateur = utilisateur;
        this.dateAjout = dateAjout;
    }

    public EvenementCompletDto getEvenement() {
        return evenement;
    }

    public void setEvenement(EvenementCompletDto evenement) {
        this.evenement = evenement;
    }

    public UtilisateurAvecRoleDto getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurAvecRoleDto utilisateur) {
        this.utilisateur = utilisateur;
    }

    public LocalDateTime getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDateTime dateAjout) {
        this.dateAjout = dateAjout;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }
}
