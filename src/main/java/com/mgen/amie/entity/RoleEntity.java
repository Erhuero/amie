package com.mgen.amie.entity;

import javax.persistence.Entity;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Role")
@Table(name = "role")
public class RoleEntity {

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "role_sequence"
    )
    @Column(
            name = "idRole",
            updatable = false
    )
    private Long idRole;

    @Column(
            name = "libelle",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String libelle;

    public RoleEntity() {
    }

    public RoleEntity(String libelle) {
        this.libelle = libelle;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "idRole=" + idRole +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
