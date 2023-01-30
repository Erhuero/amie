package com.mgen.amie.entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Evenement")
@Table(name = "evenement")
public class EvenementEntity {

    @Id
    @SequenceGenerator(
            name = "evenement_sequence",
            sequenceName = "evenement_sequence",
            allocationSize =  1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "evenement_sequence"
    )
    @Column(
            name = "idEvenement",
            updatable = false
    )
    private Long idEvenement;

    @Column(
            name = "label",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String label;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "date_debut",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String date_debut;

    @Column(
            name = "date_fin",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String date_fin;

    @Column(
            name = "date_creation_evenement",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dateCreationEvenement;

    @Column(
            name = "heure_debut",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String heure_debut;

    @Column(
            name = "heure_fin",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String heure_fin;

    @Column(
            name = "lien_replay",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lien_replay;

    @Column(
            name = "lien_ressources",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String lien_ressources;

    @Column(name = "image",
            nullable = true,
            columnDefinition = "BYTEA")
    private byte[] image;

    @ManyToOne
    @JoinColumn(
            name = "lieu_id",
            nullable = false,
            referencedColumnName = "idLieu",
            foreignKey = @ForeignKey(
                    name= "evenement_lieu_fk"
            )
    )

    private LieuEntity lieuEntity;

    public EvenementEntity(String title, String sentence, String date_debut, String date_fin, LocalTime now, String heure_debut, String url, String lien_replay, Object lien_ressources, Object image) {
    }
    public EvenementEntity(String label,
                           String description,
                           String date_debut,
                           String date_fin,
                           LocalDateTime dateCreationEvenement,
                           String heure_debut,
                           String heure_fin,
                           String lien_replay,
                           String lien_ressources,
                           byte[] image) {
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
    }

    public EvenementEntity() {

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

    public LieuEntity getLieu() {
        return lieuEntity;
    }

    public void setLieu(LieuEntity lieuEntity) {
        this.lieuEntity = lieuEntity;
    }

    @Override
    public String toString() {
        return "EvenementEntity{" +
                "idEvenement=" + idEvenement +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", date_debut='" + date_debut + '\'' +
                ", date_fin='" + date_fin + '\'' +
                ", dateCreationEvenement=" + dateCreationEvenement +
                ", heure_debut='" + heure_debut + '\'' +
                ", heure_fin='" + heure_fin + '\'' +
                ", lien_replay='" + lien_replay + '\'' +
                ", lien_ressources='" + lien_ressources + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
