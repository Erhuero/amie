package com.mgen.amie.composite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IdCorrespondre implements Serializable {

    @Column(name = "evenement_id")
    private Long idEvenement;

    @Column(name = "typologie_evenement_id")
    private Long idTypologieEvenement;

    public IdCorrespondre(Long idEvenement, Long idTypologieEvenement) {
        this.idEvenement = idEvenement;
        this.idTypologieEvenement = idTypologieEvenement;
    }

    public IdCorrespondre() {
    }

    public Long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Long idEvenement) {
        this.idEvenement = idEvenement;
    }

    public Long getIdTypologieEvenement() {
        return idTypologieEvenement;
    }

    public void setIdTypologieEvenement(Long idTypologieEvenement) {
        this.idTypologieEvenement = idTypologieEvenement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdCorrespondre that = (IdCorrespondre) o;
        return Objects.equals(idEvenement, that.idEvenement) && Objects.equals(idTypologieEvenement, that.idTypologieEvenement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvenement, idTypologieEvenement);
    }
}
