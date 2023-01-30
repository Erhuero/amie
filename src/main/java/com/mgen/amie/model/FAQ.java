package com.mgen.amie.model;

import java.util.Objects;

public class FAQ {

    private Long idFAQ;
    private String question;
    private String description;
    private Utilisateur utilisateur;

    public FAQ() {
    }

    public FAQ(String question,
               String description,
               Utilisateur utilisateur) {
        this.question = question;
        this.description = description;
        this.utilisateur = utilisateur;
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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FAQ faq = (FAQ) o;
        return Objects.equals(idFAQ, faq.idFAQ) &&
                Objects.equals(question, faq.question) &&
                Objects.equals(description, faq.description) &&
                Objects.equals(utilisateur, faq.utilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                idFAQ,
                question,
                description,
                utilisateur);
    }
}
