package com.mgen.amie.dto;

import com.mgen.amie.entity.LieuEntity;
import com.mgen.amie.model.Lieu;
import com.mgen.amie.model.Utilisateur;

import java.time.LocalDateTime;

public class EvenementUpdateDto {

    private String date_debut;
    private String date_fin;
    private String description;
    private String heure_debut;
    private String heure_fin;
    private String image;
    private String label;
    private String lien_replay;
    private String lien_ressources;
    private String statut;
    private LieuDto lieu;

    public EvenementUpdateDto() {
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(String heure_debut) {
        this.heure_debut = heure_debut;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLien_replay() {
        return lien_replay;
    }

    public void setLien_replay(String lien_replay) {
        this.lien_replay = lien_replay;
    }

    public String getLien_ressources() {
        return lien_ressources;
    }

    public void setLien_ressources(String lien_ressources) {
        this.lien_ressources = lien_ressources;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LieuDto getLieu() {
        return lieu;
    }

    public void setLieu(LieuDto lieu) {
        this.lieu = lieu;
    }
}
