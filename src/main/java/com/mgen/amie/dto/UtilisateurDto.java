package com.mgen.amie.dto;


import java.util.List;

public class UtilisateurDto {
    private int idUtilisateur;
    private String nom;
    private String prenom;
    private String mail;
    private List<RoleDto> roles;

    public UtilisateurDto() {
    }

    public UtilisateurDto(int idUtilisateur,
                          String nom,
                          String prenom,
                          String mail,
                          List<RoleDto> roles) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.roles = roles;
    }

    public UtilisateurDto(int idUtilisateur, String nom, String prenom, String mail) {
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }


}
