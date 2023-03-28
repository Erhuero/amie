package com.mgen.amie.dto;

import java.util.List;

public class GestionFaqDto {

    private int idFaq;
    private String question;
    private String description;
    private List<UtilisateurDto> utilisateur;

    public GestionFaqDto() {
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

    public List<UtilisateurDto> getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(List<UtilisateurDto> utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getIdFaq() {
        return idFaq;
    }

    public void setIdFaq(int idFaq) {
        this.idFaq = idFaq;
    }
}
