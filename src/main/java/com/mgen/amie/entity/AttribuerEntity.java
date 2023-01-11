package com.mgen.amie.entity;

import com.mgen.amie.composite.IdAttribuer;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Attribuer")
@Table(name = "attribuer")
public class AttribuerEntity {

    @EmbeddedId
    private IdAttribuer id;

    @ManyToOne
    @MapsId("idUtilisateur")
    @JoinColumn(
            name = "utilisateur_id",
            foreignKey = @ForeignKey(
                    name = "attribuer_utilisateur_id_fk"
            )
    )
    private UtilisateurEntity utilisateurEntity;

    @ManyToOne
    @MapsId("idRole")
    @JoinColumn(
            name = "role_id",
            foreignKey = @ForeignKey(
                    name = "attribuer_role_id_fk"
            )
    )
    private RoleEntity roleEntity;

    @Column(
            name = "date_attribution",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dateAttribution;


    public AttribuerEntity(IdAttribuer id,
                           UtilisateurEntity utilisateurEntity,
                           RoleEntity roleEntity,
                           LocalDateTime dateAttribution) {
        this.id = id;
        this.utilisateurEntity = utilisateurEntity;
        this.roleEntity = roleEntity;
        this.dateAttribution = dateAttribution;
    }

    public AttribuerEntity(UtilisateurEntity utilisateurEntity,
                           RoleEntity roleEntity,
                           LocalDateTime dateAttribution) {
        this.utilisateurEntity = utilisateurEntity;
        this.roleEntity = roleEntity;
        this.dateAttribution = dateAttribution;
    }


    public AttribuerEntity() {
    }

    public IdAttribuer getId() {
        return id;
    }

    public void setId(IdAttribuer id) {
        this.id = id;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateurEntity;
    }

    public void setUtilisateur(UtilisateurEntity utilisateurEntity) {
        this.utilisateurEntity = utilisateurEntity;
    }

    public RoleEntity getRole() {
        return roleEntity;
    }

    public void setRole(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public LocalDateTime getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(LocalDateTime dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    @Override
    public String toString() {
        return "AttribuerEntity{" +
                "id=" + id +
                ", utilisateurEntity=" + utilisateurEntity +
                ", roleEntity=" + roleEntity +
                ", dateAttribution=" + dateAttribution +
                '}';
    }
}
