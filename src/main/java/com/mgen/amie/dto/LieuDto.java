package com.mgen.amie.dto;

public class LieuDto {

    private int idLieu;
    private String coordoneesGps;
    private String adresse;
    private String ville;
    private String codePostal;
    private String localisation;
    private int places;

    public LieuDto() {
    }

    public LieuDto(int idLieu, String coordoneesGps,
                   String adresse, String ville,
                   String codePostal, String localisation,
                   int places) {
        this.idLieu = idLieu;
        this.coordoneesGps = coordoneesGps;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.localisation = localisation;
        this.places = places;
    }


    public int getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(int idLieu) {
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

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}
