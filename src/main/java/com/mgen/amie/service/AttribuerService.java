package com.mgen.amie.service;


import com.mgen.amie.entity.AttribuerEntity;
import com.mgen.amie.model.Attribuer;
import com.mgen.amie.repository.AttribuerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttribuerService {

    @Autowired
    AttribuerRepository attribuerRepository;

    public List<Attribuer> getAllAttributions() {
        try {
            List<AttribuerEntity> attributions = attribuerRepository.findAll();
            List<Attribuer> customAttributions = new ArrayList<>();
            attributions.stream().forEach(a -> {
                Attribuer attribuer = new Attribuer();
                BeanUtils.copyProperties(a, attribuer);
                customAttributions.add(attribuer);
            });
            return customAttributions;
        } catch (Exception e) {
            throw e;
        }
    }

    public String addAttribution(AttribuerEntity attribuer) {
        try {
            if (!attribuerRepository.existsById(attribuer.getId())) {
                attribuerRepository.save(attribuer);
                return "Attribution ajoutée avec succès";
            } else {
                return "Cette attribution existe déjà";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String updateAttribution(AttribuerEntity attribuer) {
        try {
            if (attribuerRepository.existsById(attribuer.getId())) {
                attribuerRepository.save(attribuer);
                return "Attribuer mis à jour";
            } else {
                return "Attribuer n'existe pas";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String deleteAttribution(AttribuerEntity attribuer) {
        try {
            if (attribuerRepository.existsById(attribuer.getId())) {
                attribuerRepository.delete(attribuer);
                return "Attribuer supprimé";
            } else {
                return "Attribuer n'existe pas";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}