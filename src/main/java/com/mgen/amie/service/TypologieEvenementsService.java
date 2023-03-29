package com.mgen.amie.service;

import com.mgen.amie.entity.TypologieEvenementsEntity;
import com.mgen.amie.model.TypologieEvenements;
import com.mgen.amie.repository.TypologieEvenementsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TypologieEvenementsService {
    private static final Logger log = LoggerFactory.getLogger(TypologieEvenementsService.class);

    @Autowired
    private TypologieEvenementsRepository typologieEvenementsRepository;

    public List<TypologieEvenements> getAllTypologieEvenements() {
        try {
            List<TypologieEvenementsEntity> typologieEvenements =
                    typologieEvenementsRepository.findAll();
            List<TypologieEvenements> customTypologieEvenements = new ArrayList<>();
            typologieEvenements.stream().forEach(t -> {
                TypologieEvenements typologieEvenement = new TypologieEvenements();
                BeanUtils.copyProperties(t, typologieEvenement);
                customTypologieEvenements.add(typologieEvenement);
            });
            return customTypologieEvenements;
        } catch (Exception e) {
            log.error("Erreur de récupération de roles : ", e);
            return Collections.emptyList();
        }
    }

    public String addTypologieEvenements(TypologieEvenementsEntity typologieEvenements) {
        try {
            if (!typologieEvenementsRepository.existsById(
                    Math.toIntExact(typologieEvenements.getIdTypologieEvenements()))
                    || typologieEvenementsRepository.existsByLabel(typologieEvenements.getLabel())) {
                typologieEvenementsRepository.save(typologieEvenements);
                return "Typologie ajoutée";
            } else {
                return "Erreur de ajout: ";
            }
        }catch (Exception e) {
            throw e;
        }
    }

    public String updateTypologieEvenements(TypologieEvenementsEntity typologieEvenements) {
        try {
            if (typologieEvenementsRepository.existsById(
                    Math.toIntExact(typologieEvenements.getIdTypologieEvenements()))) {
                typologieEvenementsRepository.save(typologieEvenements);
                return "Typologie modifiée";
            } else {
                return "Erreur de modification: ";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String deleteTypologieEvenements(TypologieEvenementsEntity typologieEvenements) {
        try {
            if (typologieEvenementsRepository.existsById(
                    Math.toIntExact(typologieEvenements.getIdTypologieEvenements()))
                    || typologieEvenementsRepository.existsByLabel(typologieEvenements.getLabel())) {
                typologieEvenementsRepository.save(typologieEvenements);
                return "Typologie supprimée";
            } else {
                return "Erreur de suppression, typologie n'existe pas";
            }
        }catch (Exception e) {
            throw e;
        }
    }
}