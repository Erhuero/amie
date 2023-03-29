package com.mgen.amie.service;

import com.mgen.amie.dto.*;
import com.mgen.amie.entity.AttribuerEntity;
import com.mgen.amie.entity.FAQEntity;
import com.mgen.amie.entity.UtilisateurEntity;
import com.mgen.amie.repository.AttribuerRepository;
import com.mgen.amie.repository.FAQRepository;
import com.mgen.amie.repository.UtilisateurRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FAQService {

    @Autowired
    private FAQRepository faqRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private AttribuerRepository attribuerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public FAQEntity addFAQ(int idUtilisateur, RedactionFAQDto redactionFAQDto) throws NotFoundException {

        UtilisateurEntity utilisateur = utilisateurRepository.findByIdUtilisateur(idUtilisateur)
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé"));

        FAQEntity faq = new FAQEntity();

        //ajout de la reference a l'utilisateur
        faq.setUtilisateur(utilisateur);
        faq.setQuestion(redactionFAQDto.getQuestion());
        faq.setDescription(redactionFAQDto.getDescription());
        faqRepository.save(faq);
        return faq;
    }

    public List<GestionFaqDto> getAllFAQ() {
        // Récupération de la liste des utilisateurs depuis la base de données
        List<UtilisateurEntity> utilisateurEntityList = utilisateurRepository.findAll();
        // Récupération de la liste des FAQ depuis la base de données
        List<FAQEntity> faqEntities = (List<FAQEntity>) faqRepository.findAll();
        // Initialisation d'une liste vide pour stocker les DTO des FAQ
        List<GestionFaqDto> faqDtos = new ArrayList<>();

        // Boucle pour chaque FAQ de la liste
        for (FAQEntity faqEntity : faqEntities) {

            // Création d'un DTO pour la FAQ en cours de la boucle
            GestionFaqDto faqDto = new GestionFaqDto();
            // Copie des propriétés de l'entity dans le DTO
            BeanUtils.copyProperties(faqEntity, faqDto);

            // Vérification si l'utilisateur associé à la FAQ en cours de la boucle existe
            if (faqEntity.getUtilisateurEntity() != null) {
                // Création d'un DTO pour l'utilisateur associé à la FAQ en cours de la boucle
                UtilisateurDto utilisateurDto = modelMapper.map(faqEntity.getUtilisateurEntity(), UtilisateurDto.class);
                // Récupération de la liste des attributions de rôles de l'utilisateur associé à la FAQ en cours de la boucle
                List<AttribuerEntity> attributions =
                        attribuerRepository.findAllByUtilisateurEntity_IdUtilisateur(
                                faqEntity.getUtilisateurEntity().getIdUtilisateur());

                // Initialisation d'une liste vide pour stocker les DTO des rôles associés à l'utilisateur en cours de la boucle
                List<RoleDto> rolesDto = new ArrayList<>();

                // Boucle pour chaque attribution de rôle de la liste
                for (AttribuerEntity attribution : attributions) {

                    // Création d'un DTO pour le rôle associé à l'attribution en cours de la boucle
                    RoleDto roleDto = new RoleDto();
                    // Copie des propriétés du rôle de l'attribution dans le DTO
                    BeanUtils.copyProperties(attribution.getRole(), roleDto);
                    // Ajout du DTO du rôle associé à l'utilisateur en cours de la boucle dans la liste de DTO des rôles associés
                    rolesDto.add(roleDto);
                }

                // Ajout de la liste de DTO des rôles associés à l'utilisateur en cours de la boucle dans le DTO de l'utilisateur
                utilisateurDto.setRoles(rolesDto);
                // Ajout du DTO de l'utilisateur en cours de la boucle dans la liste de DTO des utilisateurs avec leurs rôles
                faqDto.setUtilisateur(Arrays.asList(utilisateurDto));
            }

            // Ajout de l'idFAQ dans le DTO
            faqDto.setIdFaq(faqEntity.getIdFAQ());
            // Ajout du DTO de la FAQ en cours de la boucle dans la liste de DTO des FAQ
            faqDtos.add(faqDto);
        }
        // Retour de la liste de DTO des FAQ
        return faqDtos;
    }


    public String updateFAQ(int idFAQ, RedactionFAQDto redactionFAQDto) {

        Optional<FAQEntity> optionalFAQEntity = faqRepository.findById(idFAQ);
            if(optionalFAQEntity.isPresent()) {
                FAQEntity faqEntity = optionalFAQEntity.get();
                faqEntity.setQuestion(redactionFAQDto.getQuestion());
                faqEntity.setDescription(redactionFAQDto.getDescription());
                faqRepository.save(faqEntity);
                return "FAQ modifiée avec succès";
            } else {
                return "FAQ non trouvée";
            }
    }

    public String deleteFAQ(int idFAQ) {
        try {
            Optional<FAQEntity> optionalFAQEntity = faqRepository.findById(idFAQ);
            if(optionalFAQEntity.isPresent()) {
                FAQEntity faqEntity = optionalFAQEntity.get();
                faqRepository.delete(faqEntity);
                return "FAQ supprimée avec succès";
            } else {
                return "FAQ non trouvée";
            }
        } catch (Exception e) {
            return "Erreur de suppression: " + e.getMessage();
        }
    }
}
