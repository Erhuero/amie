package com.mgen.amie.model;

import java.time.LocalDateTime;

public class Evenement {

    private Long idEvenement;

    private String label;

    private String description;

    private String date_debut;

    private String date_fin;

    private LocalDateTime dateCreationEvenement;

    private String heure_debut;

    private String heure_fin;

    private String lien_replay;

    private String lien_ressources;

    private byte[] image;


    public Evenement() {
    }

    public Long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Long idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public LocalDateTime getDateCreationEvenement() {
        return dateCreationEvenement;
    }

    public void setDateCreationEvenement(LocalDateTime dateCreationEvenement) {
        this.dateCreationEvenement = dateCreationEvenement;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
