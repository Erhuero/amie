package com.mgen.amie.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
            name = "idLieu"
    )
    private Long idLieu;

    @Column(
            name = "coordonees_gps",
            columnDefinition = "TEXT"
    )
    private String coordoneesGps;

    @Column(
            name = "adresse",
            columnDefinition = "TEXT"
    )
    private String adresse;

    @Column(
            name = "ville",
            columnDefinition = "TEXT"
    )
    private String ville;

    @Column(
            name = "code_postal",
            columnDefinition = "TEXT"
    )
    private String codePostal;

    @Column(
            name = "localisation",
            columnDefinition = "TEXT"
    )
    private String localisation;

    @Column(
            name = "places",
            columnDefinition = "INTEGER"
    )
    private int places;

    @OneToMany(
            mappedBy = "lieuEntity",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<EvenementEntity> evenements = new ArrayList<>();

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
