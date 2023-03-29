package com.mgen.amie.dto;

public class RoleDto {

    private int idRole;
    private String libelle;

    public RoleDto() {
    }

    public RoleDto(int idRole, String libelle) {
        this.idRole = idRole;
        this.libelle = libelle;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
