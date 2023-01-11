package com.mgen.amie.entity;

import com.mgen.amie.composite.idParticiper;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Participer")
@Table(name = "participer")
public class ParticiperEntity {

    @EmbeddedId
    private idParticiper id;

    @ManyToOne
    @MapsId("idUtilisateur")
    @JoinColumn(
            name = "utilisateur_id",
            foreignKey = @ForeignKey(
                    name = "participer_utilisateur_id_fk"
            )
    )
    private UtilisateurEntity utilisateurEntity;

    @ManyToOne
    @MapsId("idEvenement")
    @JoinColumn(
            name = "evenement_id",
            foreignKey = @ForeignKey(
                    name = "participer_evenement_id_fk"
            )
    )
    private EvenementEntity evenementEntity;

    @Column(
            name = "date_de_rappel",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dateDeRappel;

    public ParticiperEntity(idParticiper id,
                            UtilisateurEntity utilisateurEntity,
                            EvenementEntity evenementEntity,
                            LocalDateTime dateDeRappel) {
        this.id = id;
        this.utilisateurEntity = utilisateurEntity;
        this.evenementEntity = evenementEntity;
        this.dateDeRappel = dateDeRappel;
    }

    public ParticiperEntity(UtilisateurEntity utilisateurEntity,
                            EvenementEntity evenementEntity,
                            LocalDateTime dateDeRappel) {
        this.utilisateurEntity = utilisateurEntity;
        this.evenementEntity = evenementEntity;
        this.dateDeRappel = dateDeRappel;
    }

    public ParticiperEntity() {
    }

    public idParticiper getId() {
        return id;
    }

    public void setId(idParticiper id) {
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

    public LocalDateTime getDateDeRappel() {
        return dateDeRappel;
    }

    public void setDateDeRappel(LocalDateTime dateDeRappel) {
        this.dateDeRappel = dateDeRappel;
    }

    @Override
    public String toString() {
        return "ParticiperEntity{" +
                "id=" + id +
                ", utilisateurEntity=" + utilisateurEntity +
                ", evenementEntity=" + evenementEntity +
                ", dateDeRappel=" + dateDeRappel +
                '}';
    }
}
