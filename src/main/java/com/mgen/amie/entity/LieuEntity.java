package com.mgen.amie.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Lieu")
@Table(name = "lieu")
public class LieuEntity {

    @Id
    @SequenceGenerator(
            name = "lieu_sequence",
            sequenceName = "lieu_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "lieu_sequence"
    )
    @Column(
            name = "idLieu",
            updatable = false
    )
    private Long idLieu;

    @Column(
            name = "coordonees_gps",
            updatable = false,
            columnDefinition = "TEXT"
    )
    private String coordoneesGps;

    @Column(
            name = "adresse",
            updatable = false,
            columnDefinition = "TEXT"
    )
    private String adresse;

    @Column(
            name = "ville",
            updatable = false,
            columnDefinition = "TEXT"
    )
    private String ville;

    @Column(
            name = "code_postal",
            updatable = false,
            columnDefinition = "TEXT"
    )
    private String codePostal;

    @Column(
            name = "localisation",
            updatable = false,
            columnDefinition = "TEXT"
    )
    private String localisation;


    public LieuEntity() {
    }

    public LieuEntity(String coordoneesGps,
                      String adresse,
                      String ville,
                      String codePostal,
                      String localisation) {
        this.coordoneesGps = coordoneesGps;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.localisation = localisation;
    }

    public Long getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(Long idLieu) {
        this.idLieu = idLieu;
    }

    public String getCoordoneesGps() {
        return coordoneesGps;
    }

    public void setCoordoneesGps(String coordoneesGps) {
        this.coordoneesGps = coordoneesGps;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public String toString() {
        return "LieuEntity{" +
                "idLieu=" + idLieu +
                ", coordoneesGps='" + coordoneesGps + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", localisation='" + localisation + '\'' +
                '}';
    }
}
