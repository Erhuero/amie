package com.mgen.amie.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "TypologieEvenements")
@Table(name = "typologieevenements")
public class TypologieEvenementsEntity {

    @Id
    @SequenceGenerator(
            name = "typologie_evenements_sequence",
            sequenceName = "typologie_evenements_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "typologie_evenements_sequence"
    )
    @Column(
            name = "idTypologieEvenements",
            updatable = false
    )
    private Long idTypologieEvenements;

    @Column(
            name = "label",
            updatable = false
    )
    private Long label;

    public TypologieEvenementsEntity(Long label) {
        this.label = label;
    }

    public TypologieEvenementsEntity() {
    }

    public Long getIdTypologieEvenements() {
        return idTypologieEvenements;
    }

    public void setIdTypologieEvenements(Long idTypologieEvenements) {
        this.idTypologieEvenements = idTypologieEvenements;
    }

    public Long getLabel() {
        return label;
    }

    public void setLabel(Long label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "TypologieEvenementsEntity{" +
                "idTypologieEvenements=" + idTypologieEvenements +
                ", label=" + label +
                '}';
    }
}
