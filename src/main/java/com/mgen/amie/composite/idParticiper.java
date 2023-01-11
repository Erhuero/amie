package com.mgen.amie.composite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class idParticiper implements Serializable {

    @Column(name = "utilisateur_id")
    private Long idUtilisateur;

    @Column(name = "evenement_id")
    private Long idEvenement;

    public idParticiper() {
    }

    public idParticiper(Long idUtilisateur, Long idEvenement) {
        this.idUtilisateur = idUtilisateur;
        this.idEvenement = idEvenement;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Long idEvenement) {
        this.idEvenement = idEvenement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        idParticiper that = (idParticiper) o;
        return Objects.equals(idUtilisateur, that.idUtilisateur) && Objects.equals(idEvenement, that.idEvenement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtilisateur, idEvenement);
    }
}
