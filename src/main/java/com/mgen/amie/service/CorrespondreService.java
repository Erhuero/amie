package com.mgen.amie.service;

import com.mgen.amie.entity.CorrespondreEntity;
import com.mgen.amie.model.Correspondre;
import com.mgen.amie.repository.CorrespondreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorrespondreService {

    @Autowired
    private CorrespondreRepository correspondreRepository;

    public List<Correspondre> getAllCorrespondances(){
        try{
            List<CorrespondreEntity> correspondreEntities =
                    (List<CorrespondreEntity>) correspondreRepository.findAll();
            List<Correspondre> correspondances = new ArrayList<>();
            correspondreEntities.stream().forEach(c -> {
                Correspondre correspondre = new Correspondre();
                BeanUtils.copyProperties(c, correspondre);
                correspondances.add(correspondre);
            });
            return correspondances;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String addCorrespondre(CorrespondreEntity correspondre) {
        try {
            correspondreRepository.save(correspondre);
            return "Correspondre ajouté avec succès";
        } catch (Exception e) {
            throw e;
        }
    }

    public String updateCorrespondre(CorrespondreEntity correspondre) {
        try {
            if (correspondreRepository.existsById(correspondre.getId())) {
                correspondreRepository.save(correspondre);
                return "Correspondre mis à jour";
            } else {
                return "Correspondre n'existe pas";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String deleteCorrespondre(CorrespondreEntity correspondre) {
        try {
            if (correspondreRepository.existsById(correspondre.getId())){
                correspondreRepository.delete(correspondre);
                return "Correspondre supprimé avec succès";
            } else {
                return "Correspondre n'existe pas";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
