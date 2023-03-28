package com.mgen.amie.service;

import com.mgen.amie.entity.AjouterFavorisEntity;
import com.mgen.amie.model.AjouterFavoris;
import com.mgen.amie.repository.AjouterFavorisRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AjouterFavorisService {

    @Autowired
    private AjouterFavorisRepository ajouterFavorisRepository;

    public List<AjouterFavoris> getAllAjouterFavoris() {
        try {
            List<AjouterFavorisEntity> ajouterFavorisEntities = (
                    List<AjouterFavorisEntity>) ajouterFavorisRepository.findAll();
            List<AjouterFavoris> ajouterFavoris = new ArrayList<>();
            ajouterFavorisEntities.stream().forEach(e -> {
                AjouterFavoris ajouterFavori = new AjouterFavoris();
                BeanUtils.copyProperties(e, ajouterFavori);
                ajouterFavoris.add(ajouterFavori);
            });
            return ajouterFavoris;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String addFavoris(AjouterFavorisEntity ajouterFavoris) {
        try {
            if (!ajouterFavorisRepository.existsById(ajouterFavoris.getId())) {
                ajouterFavorisRepository.save(ajouterFavoris);
                return "Favori ajouté";
            } else {
                return "Erreur de ajout, favori existe déjà";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String deleteFavoris(AjouterFavorisEntity ajouterFavoris) {
        try {
            if (ajouterFavorisRepository.existsById(ajouterFavoris.getId())) {
                ajouterFavorisRepository.delete(ajouterFavoris);
                return "Favori supprimé";
            } else {
                return "Erreur de suppression, favori n'existe pas";
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
