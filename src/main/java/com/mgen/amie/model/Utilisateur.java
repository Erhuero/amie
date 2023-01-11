package com.mgen.amie.model;

import java.time.LocalDateTime;

public class Utilisateur {

    private Long idUtilisateur;

    private String prenom;

    private String nom;

    private String mail;

    private String motDePasse;

    private LocalDateTime dateDerniereInitialisationMotDePasse;

    public Utilisateur() {
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public LocalDateTime getDateDerniereInitialisationMotDePasse() {
        return dateDerniereInitialisationMotDePasse;
    }

    public void setDateDerniereInitialisationMotDePasse(LocalDateTime dateDerniereInitialisationMotDePasse) {
        this.dateDerniereInitialisationMotDePasse = dateDerniereInitialisationMotDePasse;
    }
}
