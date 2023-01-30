package com.mgen.amie.model;

import com.mgen.amie.composite.idContribuer;
import com.mgen.amie.entity.UtilisateurEntity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Contribuer {

    private idContribuer id;
    private Utilisateur utilisateur;
    private Evenement evenement;
    private LocalDateTime dateDemandeContribution;
    private LocalDateTime dateValidationDemandeContribution;
    private LocalDateTime dateRefus;

    public Contribuer(Utilisateur utilisateur,
                      Evenement evenement,
                      LocalDateTime dateDemandeContribution,
                      LocalDateTime dateValidationDemandeContribution,
                      LocalDateTime dateRefus) {

        this.utilisateur = utilisateur;
        this.evenement = evenement;
        this.dateDemandeContribution = dateDemandeContribution;
        this.dateValidationDemandeContribution = dateValidationDemandeContribution;
        this.dateRefus = dateRefus;
    }

    public idContribuer getId() {
        return id;
    }

    public void setId(idContribuer id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public LocalDateTime getDateDemandeContribution() {
        return dateDemandeContribution;
    }

    public void setDateDemandeContribution(LocalDateTime dateDemandeContribution) {
        this.dateDemandeContribution = dateDemandeContribution;
    }

    public LocalDateTime getDateValidationDemandeContribution() {
        return dateValidationDemandeContribution;
    }

    public void setDateValidationDemandeContribution(LocalDateTime dateValidationDemandeContribution) {
        this.dateValidationDemandeContribution = dateValidationDemandeContribution;
    }

    public LocalDateTime getDateRefus() {
        return dateRefus;
    }

    public void setDateRefus(LocalDateTime dateRefus) {
        this.dateRefus = dateRefus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contribuer that = (Contribuer) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(utilisateur, that.utilisateur) &&
                Objects.equals(evenement, that.evenement) &&
                Objects.equals(dateDemandeContribution, that.dateDemandeContribution) &&
                Objects.equals(dateValidationDemandeContribution, that.dateValidationDemandeContribution) &&
                Objects.equals(dateRefus, that.dateRefus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                utilisateur,
                evenement,
                dateDemandeContribution,
                dateValidationDemandeContribution,
                dateRefus);
    }
}
