package com.mgen.amie.model;

import com.mgen.amie.composite.IdCorrespondre;

import java.util.Objects;

public class Correspondre {

    private IdCorrespondre id;
    private TypologieEvenements typologieevenements;
    private Correspondre correspondre;

    public Correspondre() {
    }

    public Correspondre(TypologieEvenements typologieevenements,
                        Correspondre correspondre) {
        this.typologieevenements = typologieevenements;
        this.correspondre = correspondre;
    }

    public IdCorrespondre getId() {
        return id;
    }

    public void setId(IdCorrespondre id) {
        this.id = id;
    }

    public TypologieEvenements getTypologieevenements() {
        return typologieevenements;
    }

    public void setTypologieevenements(TypologieEvenements typologieevenements) {
        this.typologieevenements = typologieevenements;
    }

    public Correspondre getCorrespondre() {
        return correspondre;
    }

    public void setCorrespondre(Correspondre correspondre) {
        this.correspondre = correspondre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correspondre that = (Correspondre) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(typologieevenements, that.typologieevenements) &&
                Objects.equals(correspondre, that.correspondre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typologieevenements, correspondre);
    }
}
