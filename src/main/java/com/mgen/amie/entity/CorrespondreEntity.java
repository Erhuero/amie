package com.mgen.amie.entity;

import com.mgen.amie.composite.IdCorrespondre;

import javax.persistence.*;

@Entity(name = "Correspondre")
@Table(name = "correspondre")
public class CorrespondreEntity {

    @EmbeddedId
    private IdCorrespondre id;

    @ManyToOne
    @MapsId("idEvenement")
    @JoinColumn(
            name = "evenement_id",
            foreignKey = @ForeignKey(
                    name = "correspondre_evenement_id_fk"
            )
    )
    private EvenementEntity evenementEntity;

    @ManyToOne
    @MapsId("idTypologieEvenements")
    @JoinColumn(
            name = "typologie_evenements_id",
            foreignKey = @ForeignKey(
                    name = "correspondre_typologie_evenements_id_fk"
            )
    )
    private TypologieEvenementsEntity typologieevenements;

    public CorrespondreEntity() {
    }

    public CorrespondreEntity(EvenementEntity evenementEntity, TypologieEvenementsEntity typologieevenements) {
        this.evenementEntity = evenementEntity;
        this.typologieevenements = typologieevenements;
    }

    public IdCorrespondre getId() {
        return id;
    }

    public void setId(IdCorrespondre id) {
        this.id = id;
    }

    public EvenementEntity getEvenement() {
        return evenementEntity;
    }

    public void setEvenement(EvenementEntity evenementEntity) {
        this.evenementEntity = evenementEntity;
    }

    public TypologieEvenementsEntity getTypologieevenements() {
        return typologieevenements;
    }

    public void setTypologieevenements(TypologieEvenementsEntity typologieevenements) {
        this.typologieevenements = typologieevenements;
    }
}
