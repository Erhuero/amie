package com.mgen.amie.dto;

public class LieuGestionDto {
    private String adresse;
    private String ville;
    private String codePostal;
    private String localisation;
    private int places;
    private String coordoneesGps;

    public LieuGestionDto() {
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

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public String getCoordoneesGps() {
        return coordoneesGps;
    }

    public void setCoordoneesGps(String coordoneesGps) {
        this.coordoneesGps = coordoneesGps;
    }
}
