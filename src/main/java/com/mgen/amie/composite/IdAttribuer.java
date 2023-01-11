package com.mgen.amie.composite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IdAttribuer implements Serializable {

    @Column(name = "role_id")
    private Long idRole;

    @Column(name = "utilisateur_id")
    private Long idUtilisateur;

    public IdAttribuer(Long idRole, Long idUtilisateur) {
        this.idRole = idRole;
        this.idUtilisateur = idUtilisateur;
    }

    public IdAttribuer() {
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdAttribuer that = (IdAttribuer) o;
        return Objects.equals(idRole, that.idRole) && Objects.equals(idUtilisateur, that.idUtilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, idUtilisateur);
    }
}
