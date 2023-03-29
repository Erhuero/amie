package com.mgen.amie.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class MessageContact {

    private int idMessageContact;
    private String objet;
    private String description;
    private LocalDateTime dateRedaction;
    private Utilisateur utilisateur;
    private Utilisateur destinataire;
    private int supprimerPar;

    public MessageContact() {
    }

    public MessageContact(int idMessageContact, String objet, String description, LocalDateTime dateRedaction, Utilisateur utilisateur, Utilisateur destinataire, int supprimerPar) {
        this.idMessageContact = idMessageContact;
        this.objet = objet;
        this.description = description;
        this.dateRedaction = dateRedaction;
        this.utilisateur = utilisateur;
        this.destinataire = destinataire;
        this.supprimerPar = supprimerPar;
    }

    public int getIdMessageContact() {
        return idMessageContact;
    }

    public void setIdMessageContact(int idMessageContact) {
        this.idMessageContact = idMessageContact;
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

    public LocalDateTime getDateRedaction() {
        return dateRedaction;
    }

    public void setDateRedaction(LocalDateTime dateRedaction) {
        this.dateRedaction = dateRedaction;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageContact that = (MessageContact) o;
        return Objects.equals(idMessageContact, that.idMessageContact) &&
                Objects.equals(objet, that.objet) &&
                Objects.equals(description, that.description) &&
                Objects.equals(dateRedaction, that.dateRedaction) &&
                Objects.equals(utilisateur, that.utilisateur);
    }

    public Utilisateur getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Utilisateur destinataire) {
        this.destinataire = destinataire;
    }

    public int getSupprimerPar() {
        return supprimerPar;
    }

    public void setSupprimerPar(int supprimerPar) {
        this.supprimerPar = supprimerPar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                idMessageContact,
                objet,
                description,
                dateRedaction,
                utilisateur);
    }
}
