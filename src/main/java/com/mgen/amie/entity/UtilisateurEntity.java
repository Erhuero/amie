package com.mgen.amie.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Utilisateur")
@Table(
        name = "utilisateur",
        uniqueConstraints = {
                @UniqueConstraint(name = "utilisateur_mail_unique",
                        columnNames = "mail")
        }
)
public class UtilisateurEntity {

    @Id
    @SequenceGenerator(
            name = "utilisateur_sequence",
            sequenceName = "utilisateur_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "utilisateur_sequence"
    )
    @Column(
            name = "idUtilisateur",
            updatable = false
    )
    private Long idUtilisateur;

    @Column(
            name= "prenom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String prenom;

    @Column(
            name= "nom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nom;

    @Column(
            name= "mail",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String mail;

    @Column(
            name= "mot_de_passe",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String motDePasse;

    @Column(
            name= "date_derniere_initialisation_mot_de_passe",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dateDerniereInitialisationMotDePasse;

    @Column(
            name= "date_derniere_connexion",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dateDerniereConnexion;

    @OneToMany(
            mappedBy = "utilisateurEntity",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<MessageContactEntity> messagesContact = new ArrayList<>();

    public UtilisateurEntity() {
    }

    public UtilisateurEntity(String prenom, String nom, String mail, String motDePasse) {
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.motDePasse = motDePasse;
    }

    public UtilisateurEntity(String prenom,
                             String nom,
                             String mail,
                             String motDePasse,
                             LocalDateTime dateDerniereInitialisationMotDePasse,
                             LocalDateTime dateDerniereConnexion) {

        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.dateDerniereInitialisationMotDePasse = dateDerniereInitialisationMotDePasse;
        this.dateDerniereConnexion = dateDerniereConnexion;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public LocalDateTime getDateDerniereInitialisationMotDePasse() {
        return dateDerniereInitialisationMotDePasse;
    }

    public void setDateDerniereInitialisationMotDePasse(LocalDateTime dateDerniereInitialisationMotDePasse) {
        this.dateDerniereInitialisationMotDePasse = dateDerniereInitialisationMotDePasse;
    }

    public LocalDateTime getDateDerniereConnexion() {
        return dateDerniereConnexion;
    }

    public void setDateDerniereConnexion(LocalDateTime dateDerniereConnexion) {
        this.dateDerniereConnexion = dateDerniereConnexion;
    }

    @Override
    public String toString() {
        return "UtilisateurEntity{" +
                "idUtilisateur=" + idUtilisateur +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", mail='" + mail + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", dateDerniereInitialisationMotDePasse=" + dateDerniereInitialisationMotDePasse +
                ", dateDerniereConnexion=" + dateDerniereConnexion +
                '}';
    }
}
