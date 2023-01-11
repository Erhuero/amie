package com.mgen.amie.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "FAQ")
@Table(name = "faq")
public class FAQEntity {

    @Id
    @SequenceGenerator(
            name = "faq_sequence",
            sequenceName = "faq_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "faq_sequence"
    )
    @Column(
            name = "idFAQ",
            updatable = false
    )
    private Long idFAQ;

    @Column(
            name = "question",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String question;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @ManyToOne
    @JoinColumn(
            name = "utilisateur_id",
            nullable = false,
            referencedColumnName = "idUtilisateur",
            foreignKey = @ForeignKey(
                    name = "utilisateur_FAQ_fk"
            )
    )
    private UtilisateurEntity utilisateurEntity;

    public FAQEntity() {
    }

    public FAQEntity(String question,
                     String description,
                     UtilisateurEntity utilisateurEntity) {
        this.question = question;
        this.description = description;
        this.utilisateurEntity = utilisateurEntity;
    }

    public Long getIdFAQ() {
        return idFAQ;
    }

    public void setIdFAQ(Long idFAQ) {
        this.idFAQ = idFAQ;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateurEntity;
    }

    public void setUtilisateur(UtilisateurEntity utilisateurEntity) {
        this.utilisateurEntity = utilisateurEntity;
    }

    @Override
    public String toString() {
        return "FAQEntity{" +
                "idFAQ=" + idFAQ +
                ", question='" + question + '\'' +
                ", description='" + description + '\'' +
                ", utilisateurEntity=" + utilisateurEntity +
                '}';
    }
}
