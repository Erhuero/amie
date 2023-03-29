package com.mgen.amie.dto;

import java.time.LocalDateTime;
import java.util.List;

public class EvenementCompletDto {

    private int idEvenement;
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
    private LocalDateTime dateValider;
    private String statut;
    private LieuDto lieu;
    private UtilisateurDto utilisateur;

    public EvenementCompletDto() {
    }

    public EvenementCompletDto(int idEvenement,
                               String label,
                               String description,
                               String date_debut, String date_fin,
                               LocalDateTime dateCreationEvenement,
                               String heure_debut, String heure_fin,
                               String lien_replay,
                               String lien_ressources, byte[] image,
                               LocalDateTime dateValider,
                               String statut, LieuDto lieu,
                               UtilisateurDto utilisateur) {
        this.idEvenement = idEvenement;
        this.label = label;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.dateCreationEvenement = dateCreationEvenement;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.lien_replay = lien_replay;
        this.lien_ressources = lien_ressources;
        this.image = image;
        this.dateValider = dateValider;
        this.statut = statut;
        this.lieu = lieu;
        this.utilisateur = utilisateur;
    }

    public EvenementCompletDto(UtilisateurDto utilisateurDto, List<EvenementDto> evenementsDto) {
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
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

    public LocalDateTime getDateValider() {
        return dateValider;
    }

    public void setDateValider(LocalDateTime dateValider) {
        this.dateValider = dateValider;
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

    public UtilisateurDto getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurDto utilisateur) {
        this.utilisateur = utilisateur;
    }


    public void setEvenements(List<AjouterFavorisDto> ajoutsDto) {
    }

    public void setEvenement(EvenementDto evenementDto) {
    }
}
