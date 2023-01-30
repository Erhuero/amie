package com.mgen.amie.model;

import com.mgen.amie.composite.IdAttribuer;

import java.time.LocalDateTime;
import java.util.Objects;

public class Attribuer {

    private IdAttribuer id;
    private Utilisateur utilisateur;
    private Role role;
    private LocalDateTime dateAttribution;

    public Attribuer() {
    }

    public Attribuer(IdAttribuer id,
                     Utilisateur utilisateur,
                     Role role,
                     LocalDateTime dateAttribution) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.role = role;
        this.dateAttribution = dateAttribution;
    }

    public IdAttribuer getId() {
        return id;
    }

    public void setId(IdAttribuer id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(LocalDateTime dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribuer attribuer = (Attribuer) o;
        return Objects.equals(id, attribuer.id) &&
                Objects.equals(utilisateur, attribuer.utilisateur) &&
                Objects.equals(role, attribuer.role) &&
                Objects.equals(dateAttribution, attribuer.dateAttribution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                utilisateur,
                role,
                dateAttribution);
    }
}
