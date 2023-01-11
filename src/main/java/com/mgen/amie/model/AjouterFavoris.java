package com.mgen.amie.model;

import com.mgen.amie.composite.IdAjouterFavoris;

import java.time.LocalDateTime;

public class AjouterFavoris {

    private IdAjouterFavoris id;
    private Utilisateur utilisateur;
    private Evenement evenement;
    private LocalDateTime dateAjout;

    public AjouterFavoris(IdAjouterFavoris id, Utilisateur utilisateur, Evenement evenement, LocalDateTime dateAjout) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.evenement = evenement;
        this.dateAjout = dateAjout;
    }

    public AjouterFavoris(Utilisateur utilisateur, Evenement evenement, LocalDateTime dateAjout) {
        this.utilisateur = utilisateur;
        this.evenement = evenement;
        this.dateAjout = dateAjout;
    }

    public AjouterFavoris() {
    }

    public IdAjouterFavoris getId() {
        return id;
    }

    public void setId(IdAjouterFavoris id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public LocalDateTime getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDateTime dateAjout) {
        this.dateAjout = dateAjout;
    }

    @Override
    public String toString() {
        return "AjouterFavoris{" +
                "id=" + id +
                ", utilisateur=" + utilisateur +
                ", evenement=" + evenement +
                ", dateAjout=" + dateAjout +
                '}';
    }
}