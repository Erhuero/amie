package com.mgen.amie.dto;

public class MessageContactDto {

    private int idMessageContact;
    private String objet;
    private String description;
    public MessageContactDto() {
    }

    public MessageContactDto(int idMessageContact, String objet, String description) {
        this.idMessageContact = idMessageContact;
        this.objet = objet;
        this.description = description;
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

    public int getIdMessageContact() {
        return idMessageContact;
    }

    public void setIdMessageContact(int idMessageContact) {
        this.idMessageContact = idMessageContact;
    }
}
