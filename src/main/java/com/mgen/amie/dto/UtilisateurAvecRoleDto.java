package com.mgen.amie.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UtilisateurAvecRoleDto {
    private int idUtilisateur;
    private String prenom;
    private String nom;
    private String mail;
    private LocalDateTime dateDerniereInitialisationMotDePasse;
    private LocalDateTime dateDerniereConnexion;
    private AttribuerDto attribuer;
    private List<RoleDto> roles;

    public UtilisateurAvecRoleDto() {
    }
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDateTime getDateDerniereInitialisationMotDePasse() {
        return dateDerniereInitialisationMotDePasse;
    }

    public void setDateDerniereInitialisationMotDePasse(LocalDateTime dateDerniereInitialisationMotDePasse) {
        this.dateDerniereInitialisationMotDePasse = dateDerniereInitialisationMotDePasse;
    }

    public LocalDateTime getDateDerniereConnexion() {
        return dateDerniereConnexion;
    }

    public void setDateDerniereConnexion(LocalDateTime dateDerniereConnexion) {
        this.dateDerniereConnexion = dateDerniereConnexion;
    }

    public AttribuerDto getAttribuer() {
        return attribuer;
    }

    public void setAttribuer(AttribuerDto attribuer) {
        this.attribuer = attribuer;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }
}
