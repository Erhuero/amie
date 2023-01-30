package com.mgen.amie.model;

import java.util.Objects;

public class TypologieEvenements {

    private Long idTypologieEvenements;
    private Long label;

    public TypologieEvenements() {
    }

    public TypologieEvenements(Long label) {
        this.label = label;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypologieEvenements that = (TypologieEvenements) o;
        return Objects.equals(idTypologieEvenements, that.idTypologieEvenements)
                && Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypologieEvenements, label);
    }
}
