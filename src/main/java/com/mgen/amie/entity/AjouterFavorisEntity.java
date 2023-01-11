package com.mgen.amie.entity;
import com.mgen.amie.composite.IdAjouterFavoris;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "AjouterFavoris")
@Table(name = "ajouterfavoris")
public class AjouterFavorisEntity {

    @EmbeddedId
    private IdAjouterFavoris id;

    @ManyToOne
    @MapsId("idUtilisateur")
    @JoinColumn(
            name = "utilisateur_id",
            foreignKey = @ForeignKey(
                    name = "ajouter_favoris_utilisateur_id_fk"
            )
    )
    private UtilisateurEntity utilisateurEntity;

    @ManyToOne
    @MapsId("idEvenement")
    @JoinColumn(
            name = "evenement_id",
            foreignKey = @ForeignKey(
                    name = "ajouter_favoris_evenement_id_fk"
            )
    )
    private EvenementEntity evenementEntity;

    @Column(
            name = "date_ajout",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dateAjout;

    public AjouterFavorisEntity(IdAjouterFavoris id,
                                UtilisateurEntity utilisateurEntity,
                                EvenementEntity evenementEntity,
                                LocalDateTime dateAjout) {
        this.id = id;
        this.utilisateurEntity = utilisateurEntity;
        this.evenementEntity = evenementEntity;
        this.dateAjout = dateAjout;
    }

    public AjouterFavorisEntity(UtilisateurEntity utilisateurEntity,
                                EvenementEntity evenementEntity,
                                LocalDateTime dateAjout) {
        this.utilisateurEntity = utilisateurEntity;
        this.evenementEntity = evenementEntity;
        this.dateAjout = dateAjout;
    }

    public AjouterFavorisEntity() {
    }

    public IdAjouterFavoris getId() {
        return id;
    }

    public void setId(IdAjouterFavoris id) {
        this.id = id;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateurEntity;
    }

    public void setUtilisateur(UtilisateurEntity utilisateurEntity) {
        this.utilisateurEntity = utilisateurEntity;
    }

    public EvenementEntity getEvenement() {
        return evenementEntity;
    }

    public void setEvenement(EvenementEntity evenementEntity) {
        this.evenementEntity = evenementEntity;
    }

    public LocalDateTime getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDateTime dateAjout) {
        this.dateAjout = dateAjout;
    }

    @Override
    public String toString() {
        return "AjouterFavorisEntity{" +
                "id=" + id +
                ", utilisateurEntity=" + utilisateurEntity +
                ", evenementEntity=" + evenementEntity +
                ", dateAjout=" + dateAjout +
                '}';
    }
}
