package com.mgen.amie.service;

import com.mgen.amie.dto.LieuGestionDto;
import com.mgen.amie.entity.LieuEntity;
import com.mgen.amie.model.Lieu;
import com.mgen.amie.repository.LieuRepository;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LieuService {

    @Autowired
    LieuRepository lieuRepository;

    public List<Lieu> getAllLieux() {
        try{
            List<LieuEntity> lieuxEntities = (
                    List<LieuEntity>) lieuRepository.findAll();
            List<Lieu> lieux = new ArrayList<>();
            lieuxEntities.stream().forEach(l -> {
                Lieu lieu = new Lieu();
                BeanUtils.copyProperties(l, lieu);
                lieux.add(lieu);
            });
            return lieux;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String addLieu(LieuGestionDto lieuGestionDto) {
        LieuEntity lieu = new LieuEntity();
        try {
            if (!lieuRepository.existsById(lieu.getIdLieu())) {
                lieu.setAdresse(lieuGestionDto.getAdresse());
                lieu.setVille(lieuGestionDto.getVille());
                lieu.setCodePostal(lieuGestionDto.getCodePostal());
                lieu.setLocalisation(lieuGestionDto.getLocalisation());
                lieu.setPlaces(lieuGestionDto.getPlaces());
                lieu.setCoordoneesGps(lieuGestionDto.getCoordoneesGps());
                lieuRepository.save(lieu);
                return "Lieu ajouté";
            } else {
                return "Le lieu est déjà enregistré ";
            }
        } catch (Exception e) {
            return "Erreur de ajout: " + e.getMessage();
        }
    }

    public String updateLieu(int idLieu, LieuGestionDto lieuGestionDto){

        Optional<LieuEntity> optionalLieuEntity = lieuRepository.findById(idLieu);

        if(optionalLieuEntity.isPresent()) {
            LieuEntity lieuEntity = optionalLieuEntity.get();
            lieuEntity.setAdresse(lieuGestionDto.getAdresse());
            lieuEntity.setVille(lieuGestionDto.getVille());
            lieuEntity.setCodePostal(lieuGestionDto.getCodePostal());
            lieuEntity.setLocalisation(lieuGestionDto.getLocalisation());
            lieuEntity. setPlaces(lieuGestionDto.getPlaces());
            lieuEntity.setCoordoneesGps(lieuGestionDto.getCoordoneesGps());

            lieuRepository.save(lieuEntity);
            return "Le lieu est mis à jour";
        } else {
            return "Le lieu n'existe pas";
        }
    }

    public String deleteLieu(int idLieu) {
        try {
            Optional<LieuEntity> optionalLieuEntity = lieuRepository.findById(idLieu);
            if (optionalLieuEntity.isPresent()) {
                LieuEntity lieuEntity = optionalLieuEntity.get();
                lieuRepository.delete(lieuEntity);
                return "Lieu supprimé";
            } else {
                return "Ce lieu n'existe pas";
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
