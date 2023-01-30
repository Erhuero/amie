package com.mgen.amie.entity;

import com.mgen.amie.composite.idContribuer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Contribuer")
@Table(name = "contribuer")
public class ContribuerEntity {

    @EmbeddedId
    private idContribuer id;

    @ManyToOne
    @MapsId("idUtilisateur")
    @JoinColumn(
            name = "utilisateur_id",
            foreignKey = @ForeignKey(
                    name = "contribuer_utilisateur_id_fk"
            )
    )
    private UtilisateurEntity utilisateurEntity;

    @ManyToOne
    @MapsId("idEvenement")
    @JoinColumn(
            name = "evenement_id",
            foreignKey = @ForeignKey(
                    name = "contribuer_evenement_id_fk"
            )
    )
    private EvenementEntity evenementEntity;

    @Column(
            name = "date_demande_contribution",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dateDemandeContribution;

    @Column(
            name = "date_validation_demande_contribution",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dateValidationDemandeContribution;

    @Column(
            name = "date_refus",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dateRefus;

    public ContribuerEntity(idContribuer id,
                            UtilisateurEntity utilisateurEntity,
                            EvenementEntity evenementEntity,
                            LocalDateTime dateDemandeContribution,
                            LocalDateTime dateValidationDemandeContribution,
                            LocalDateTime dateRefus) {
        this.id = id;
        this.utilisateurEntity = utilisateurEntity;
        this.evenementEntity = evenementEntity;
        this.dateDemandeContribution = dateDemandeContribution;
        this.dateValidationDemandeContribution = dateValidationDemandeContribution;
        this.dateRefus = dateRefus;
    }

    public ContribuerEntity(UtilisateurEntity utilisateurEntity,
                            EvenementEntity evenementEntity,
                            LocalDateTime dateDemandeContribution,
                            LocalDateTime dateValidationDemandeContribution,
                            LocalDateTime dateRefus) {
        this.utilisateurEntity = utilisateurEntity;
        this.evenementEntity = evenementEntity;
        this.dateDemandeContribution = dateDemandeContribution;
        this.dateValidationDemandeContribution = dateValidationDemandeContribution;
        this.dateRefus = dateRefus;
    }

    public ContribuerEntity() {
    }

    public idContribuer getId() {
        return id;
    }

    public void setId(idContribuer id) {
        this.id = id;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateurEntity;
    }

    public void setUtilisateur(UtilisateurEntity utilisateurEntity) {
        this.utilisateurEntity = utilisateurEntity;
    }

    public EvenementEntity getEvenement() {
        return evenementEntity;
    }

    public void setEvenement(EvenementEntity evenementEntity) {
        this.evenementEntity = evenementEntity;
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
    public String toString() {
        return "ContribuerEntity{" +
                "id=" + id +
                ", utilisateurEntity=" + utilisateurEntity +
                ", evenementEntity=" + evenementEntity +
                ", dateDemandeContribution=" + dateDemandeContribution +
                ", dateValidationDemandeContribution=" + dateValidationDemandeContribution +
                ", dateRefus=" + dateRefus +
                '}';
    }
}
