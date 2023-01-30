package com.mgen.amie.model;

import java.util.Objects;

public class Lieu {

    private Long idLieu;

    private String coordoneesGps;

    private String adresse;

    private String ville;

    private String codePostal;

    private String localisation;

    public Lieu() {
    }

    public Lieu(String coordoneesGps,
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lieu lieu = (Lieu) o;
        return Objects.equals(idLieu, lieu.idLieu)
                && Objects.equals(coordoneesGps, lieu.coordoneesGps) &&
                Objects.equals(adresse, lieu.adresse) &&
                Objects.equals(ville, lieu.ville) && Objects.equals(codePostal, lieu.codePostal) &&
                Objects.equals(localisation, lieu.localisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                idLieu,
                coordoneesGps,
                adresse,
                ville,
                codePostal,
                localisation);
    }
}
