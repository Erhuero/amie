package com.mgen.amie.dto;

import com.mgen.amie.entity.MessageContactEntity;
import com.mgen.amie.entity.UtilisateurEntity;

public class GestionMessageContactDto {

    private String objet;
    private String description;
    private UtilisateurEntity utilisateurEntity;
    private UtilisateurEntity destinataire;

    public GestionMessageContactDto() {
    }

    public GestionMessageContactDto(String objet,
                                    String description,
                                    UtilisateurEntity sender,
                                    UtilisateurEntity receiver) {
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UtilisateurEntity getUtilisateurEntity() {
        return utilisateurEntity;
    }

    public void setUtilisateurEntity(UtilisateurEntity utilisateurEntity) {
        this.utilisateurEntity = utilisateurEntity;
    }

    public UtilisateurEntity getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(UtilisateurEntity destinataire) {
        this.destinataire = destinataire;
    }
}
