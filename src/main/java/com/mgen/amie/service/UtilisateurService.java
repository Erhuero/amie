package com.mgen.amie.service;

import com.mgen.amie.dto.RoleDto;
import com.mgen.amie.dto.UtilisateurAjoutDto;
import com.mgen.amie.dto.UtilisateurDto;
import com.mgen.amie.dto.UtilisateurModificationDto;
import com.mgen.amie.entity.AttribuerEntity;
import com.mgen.amie.entity.RoleEntity;
import com.mgen.amie.entity.UtilisateurEntity;
import com.mgen.amie.model.Utilisateur;
import com.mgen.amie.repository.UtilisateurRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    // injection de la dépendance pour le repository
    @Autowired
    private AttribuerRepository attribuerRepository;

    UtilisateurAjoutDto utilisateurAjoutDto;

    public UtilisateurDto getUtilisateurAvecRoles(int idUtilisateur) throws NotFoundException {
        UtilisateurEntity utilisateurEntity =
                utilisateurRepository.findByIdUtilisateur(idUtilisateur)
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé"));

        List<AttribuerEntity> attributions =
                attribuerRepository.findAllByUtilisateurEntity_IdUtilisateur(idUtilisateur);

        // mapper les entités vers un DTO
        UtilisateurDto utilisateurDto = modelMapper.map(utilisateurEntity, UtilisateurDto.class);
        List<RoleDto> rolesDto = attributions.stream()
                .map(attribution -> modelMapper.map(attribution.getRole(), RoleDto.class))
                .collect(Collectors.toList());
        utilisateurDto.setRoles(rolesDto);

        return utilisateurDto;
    }

    public List<UtilisateurDto> getAllUtilisateursAvecRoles() throws NotFoundException {
        // Récupération de la liste des utilisateurs depuis la base de données
        List<UtilisateurEntity> utilisateurEntityList = utilisateurRepository.findAll();
        // Récupération de la liste des attributions de rôles depuis la base de données
        List<AttribuerEntity> attribuerEntityList = attribuerRepository.findAll();
        // Initialisation d'une liste vide pour stocker les DTO des utilisateurs avec leurs rôles
        List<UtilisateurDto> utilisateurDtoList = new ArrayList<>();

        // Boucle pour chaque utilisateur de la liste
        for (UtilisateurEntity utilisateurEntity : utilisateurEntityList) {
            // Création d'un DTO pour l'utilisateur en cours de la boucle
            UtilisateurDto utilisateurDto = modelMapper.map(utilisateurEntity, UtilisateurDto.class);
            // Initialisation d'une liste vide pour stocker les DTO des rôles associés à l'utilisateur en cours de la boucle
            List<RoleDto> rolesDtoList = new ArrayList<>();

            // Boucle pour chaque attribution de rôle de la liste
            for (AttribuerEntity attribuerEntity : attribuerEntityList) {
                // Si l'id de l'utilisateur de l'attribution est égal à l'id de l'utilisateur en cours de la boucle
                //ou Vérification si l'utilisateur en cours de la boucle a le rôle associé à l'attribution de rôle en cours de la boucle
                if (attribuerEntity.getUtilisateur().getIdUtilisateur() == utilisateurEntity.getIdUtilisateur()) {
                    // Ajouter le rôle de l'attribution à la liste des rôles de l'utilisateur en cours de la boucle
                    // Ajout du DTO du rôle associé à l'utilisateur en cours de la boucle dans la liste de DTO des rôles associés
                    rolesDtoList.add(modelMapper.map(attribuerEntity.getRole(), RoleDto.class));
                }
            }
            // Ajout de la liste de DTO des rôles associés à l'utilisateur
            // en cours de la boucle dans le DTO de l'utilisateur en cours de la boucle
            utilisateurDto.setRoles(rolesDtoList);
            // Ajout du DTO de l'utilisateur en cours de la boucle dans la liste de DTO des utilisateurs avec leurs rôles
            utilisateurDtoList.add(utilisateurDto);
        }
        // Retour de la liste de DTO des utilisateurs avec leurs rôles
        return utilisateurDtoList;
    }

    // @Transactional : toutes les opérations de base de données effectuées
    // dans cette méthode seront soit toutes validées,
    // soit toutes annulées en cas d'erreur.
    @Transactional
    public void assignerRoleAUtilisateur(int idUtilisateur, int idRole) throws NotFoundException {
        // récupérer l'utilisateur associé à l'id d'utilisateur
        //utilisateurRepository et roleRepository sont des objets injectés via l'injection de dépendances de Spring
        UtilisateurEntity utilisateur = utilisateurRepository.findByIdUtilisateur(idUtilisateur)
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé"));

        // récupérer le rôle associé à l'id de rôle
        RoleEntity role = roleRepository.findById(idRole)
                .orElseThrow(() -> new NotFoundException("Rôle non trouvé"));

        // créer une nouvelle entité AttribuerEntity
        AttribuerEntity attribution = new AttribuerEntity();
        attribution.setUtilisateur(utilisateur);// associer l'utilisateur à l'attribution
        attribution.setRole(role);// associer le rôle à l'attribution
        attribution.setDateAttribution(LocalDateTime.now());// définir la date d'attribution de l'attribution

        // sauvegarder l'entité AttribuerEntity dans la base de données
        attribuerRepository.save(attribution);
    }

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

    public UtilisateurEntity addUtilisateur(UtilisateurAjoutDto utilisateurAjoutDto) throws NotFoundException {
        UtilisateurEntity utilisateur = new UtilisateurEntity();

        utilisateur.setNom(utilisateurAjoutDto.getNom());
        utilisateur.setPrenom(utilisateurAjoutDto.getPrenom());
        utilisateur.setMail(utilisateurAjoutDto.getMail());
        utilisateur.setMotDePasse(utilisateurAjoutDto.getMotDePasse());
        utilisateur.setDateDerniereInitialisationMotDePasse(LocalDateTime.now());
        utilisateur.setDateDerniereConnexion(LocalDateTime.now());
        utilisateurRepository.save(utilisateur);
        return utilisateur;
    }

    public String updateUtilisateur(int idUtilisateur, UtilisateurModificationDto utilisateur) throws NotFoundException {
        // utilise l'interface CrudRepository de Spring Data pour chercher un utilisateur avec l'ID donné dans la base de données.
        // La méthode findById renvoie un objet Optional qui peut contenir
        // l'utilisateur si celui-ci existe, ou être vide si l'utilisateur n'existe pas
        Optional<UtilisateurEntity> optionalUtilisateurEntity = utilisateurRepository.findById(idUtilisateur);

        if(optionalUtilisateurEntity.isPresent()) {
            //extrait l'objet UtilisateurEntity contenu dans l'objet Optional
            // retourné par la méthode findById du repository de l'utilisateur
            UtilisateurEntity utilisateurEntity = optionalUtilisateurEntity.get();
            utilisateurEntity.setMail(utilisateur.getMail());
            utilisateurEntity.setNom(utilisateur.getNom());
            utilisateurEntity.setPrenom(utilisateur.getPrenom());
            utilisateurEntity.setMotDePasse(utilisateur.getMotDePasse());
            utilisateurEntity.setDateDerniereInitialisationMotDePasse(LocalDateTime.now());
            utilisateurEntity.setDateDerniereConnexion(LocalDateTime.now());
            utilisateurRepository.save(utilisateurEntity);
            return "Utilisateur modifié avec succès";
        } else {
            return "Utilisateur n'existe pas";
        }
    }

    public String deleteUtilisateur(int idUtilisateur) {
        try {
            Optional<UtilisateurEntity> optionalUtilisateurEntity =
                    utilisateurRepository.findById(idUtilisateur);
            if(optionalUtilisateurEntity.isPresent()) {
                UtilisateurEntity utilisateurEntity =
                        optionalUtilisateurEntity.get();
                utilisateurRepository.delete(utilisateurEntity);
                return "Utilisateur supprimé avec succès";
            } else {
                return "Utilisateur n'existe pas";
            }
        } catch (Exception e) {
            return "Erreur de suppression: " + e.getMessage();
        }
    }
}