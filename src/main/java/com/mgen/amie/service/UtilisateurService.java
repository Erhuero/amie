package com.mgen.amie.service;

import com.mgen.amie.entity.UtilisateurEntity;
import com.mgen.amie.model.Utilisateur;
import com.mgen.amie.repository.UtilisateurRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        try {
            List<UtilisateurEntity> utilisateursEntities = (List<UtilisateurEntity>) utilisateurRepository.findAll();
            List<Utilisateur> utilisateurs = new ArrayList<>();
            utilisateursEntities.stream().forEach(e -> {
                Utilisateur utilisateur = new Utilisateur();
                BeanUtils.copyProperties(e, utilisateur);
                utilisateurs.add(utilisateur);
            });
            return utilisateurs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}