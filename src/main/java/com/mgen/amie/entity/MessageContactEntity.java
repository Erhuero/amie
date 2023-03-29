package com.mgen.amie.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "MessageContact")
@Table(name = "messagecontact")
public class MessageContactEntity {

    @Id
    @SequenceGenerator(
            name = "message_contact",
            sequenceName =  "message_contact_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "message_contact_sequence"
    )
    @Column(
            name = "idMessageContact",
            updatable = false
    )
    private Long idMessageContact;

    @Column(
            name = "objet",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String objet;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name= "date_redaction",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dateRedaction;

    @ManyToOne
    @JoinColumn(
            name = "utilisateur_id",
            nullable = false,
            referencedColumnName = "idUtilisateur",
            foreignKey = @ForeignKey(
                    name = "utilisateur_message_contact_fk"
            )
    )
    private UtilisateurEntity utilisateurEntity;

    /*
    //ceci est une tentative de faire une relation bidirectionnelle entre messagecontact et utilisateur
    //pour le destinataire mais c'est une evolution
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "idUtilisateurDestinataire",
            referencedColumnName = "idUtilisateur",
            foreignKey = @ForeignKey(
                    name = "utilisateur_message_contact_destinataire_fk"
            )
    )
    private UtilisateurEntity destinataire;
*/

    public MessageContactEntity() {
    }

    public MessageContactEntity(String objet,
                                String description,
                                LocalDateTime dateRedaction) {
        this.objet = objet;
        this.description = description;
        this.dateRedaction = dateRedaction;
    }

    public Long getIdMessageContact() {
        return idMessageContact;
    }

    public void setIdMessageContact(Long idMessageContact) {
        this.idMessageContact = idMessageContact;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateRedaction() {
        return dateRedaction;
    }

    public void setDateRedaction(LocalDateTime dateRedaction) {
        this.dateRedaction = dateRedaction;
    }

    @Override
    public String toString() {
        return "MessageContactEntity{" +
                "idMessageContact=" + idMessageContact +
                ", objet='" + objet + '\'' +
                ", description='" + description + '\'' +
                ", dateRedaction=" + dateRedaction +
                '}';
    }

    public UtilisateurEntity getUtilisateurEntity() {
        return utilisateurEntity;
    }

    public void setUtilisateurEntity(UtilisateurEntity utilisateurEntity) {
        this.utilisateurEntity = utilisateurEntity;
    }

}
