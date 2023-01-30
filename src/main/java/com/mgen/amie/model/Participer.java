package com.mgen.amie.model;

import com.mgen.amie.composite.idParticiper;

import java.time.LocalDateTime;
import java.util.Objects;

public class Participer {

    private idParticiper id;
    private Utilisateur utilisateur;
    private Evenement evenement;
    private LocalDateTime dateDeRappel;

    public Participer() {
    }

    public Participer(Utilisateur utilisateur,
                      Evenement evenement,
                      LocalDateTime dateDeRappel) {
        this.utilisateur = utilisateur;
        this.evenement = evenement;
        this.dateDeRappel = dateDeRappel;
    }

    public idParticiper getId() {
        return id;
    }

    public void setId(idParticiper id) {
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

    public LocalDateTime getDateDeRappel() {
        return dateDeRappel;
    }

    public void setDateDeRappel(LocalDateTime dateDeRappel) {
        this.dateDeRappel = dateDeRappel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participer that = (Participer) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(utilisateur, that.utilisateur) &&
                Objects.equals(evenement, that.evenement) &&
                Objects.equals(dateDeRappel, that.dateDeRappel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, utilisateur, evenement, dateDeRappel);
    }
}
