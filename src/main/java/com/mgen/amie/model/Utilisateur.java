package com.mgen.amie.model;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(idUtilisateur, that.idUtilisateur) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(motDePasse, that.motDePasse) &&
                Objects.equals(dateDerniereInitialisationMotDePasse, that.dateDerniereInitialisationMotDePasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                idUtilisateur,
                prenom,
                nom,
                mail,
                motDePasse,
                dateDerniereInitialisationMotDePasse);
    }
}
