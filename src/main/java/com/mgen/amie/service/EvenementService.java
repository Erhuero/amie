package com.mgen.amie.service;

import com.mgen.amie.dto.*;
import com.mgen.amie.entity.*;
import com.mgen.amie.repository.*;
import com.mgen.amie.request.EvenementRequest;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private LieuRepository lieuRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private TypologieEvenementsRepository typologieEvenementsRepository;

    @Autowired
    private CorrespondreRepository correspondreRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AttribuerRepository attribuerRepository;

    @Autowired
    AjouterFavorisRepository ajouterFavorisRepository;


    EvenementUpdateDto evenementUpdateDto;


    /**
     * Ce code prend en entrée l'identifiant d'un utilisateur,
     * utilise ce dernier pour récupérer un événement associé
     * à cet utilisateur et retourne un DTO complet de cet événement.
     */

    public EvenementCompletDto getEvenementsByIdUtilisateur(int idUtilisateur) throws NotFoundException {
        // récupérer l'événement associé à l'utilisateur
        // findByIdEvenementAndUtilisateurEntity_IdUtilisateur(int idEvenement, int idUtilisateur)
        // est une méthode définie dans l'interface EvenementRepository qui permet de récupérer
        // l'entité EvenementEntity correspondant à l'identifiant de l'événement
        // idEvenement et à l'identifiant de l'utilisateur idUtilisateur passé en paramètre.
        EvenementEntity evenementEntity = evenementRepository
                .findByIdEvenementAndUtilisateurEntity_IdUtilisateur(idUtilisateur, idUtilisateur)
                .orElseThrow(() -> new NotFoundException("Événement non trouvé pour cet utilisateur"));

        // mapper l'entité vers un DTO complet
        EvenementCompletDto evenementDto = new EvenementCompletDto();
        BeanUtils.copyProperties(evenementEntity, evenementDto);

        // si l'événement possède un utilisateur associé
        if (evenementEntity.getUtilisateurEntity() != null) {
            // mapper l'utilisateur associé vers un DTO
            UtilisateurDto utilisateurDto = new UtilisateurDto();
            //BeanUtils.copyProperties() est utilisée pour copier les propriétés d'un objet source vers un objet cible
            //(evenementEntity.getUtilisateurEntity()) vers un objet de transfert de données (DTO) appelé utilisateurDto
            BeanUtils.copyProperties(evenementEntity.getUtilisateurEntity(), utilisateurDto);

            // récupérer les attributions pour l'utilisateur et mapper les rôles associés vers des DTO
            List<AttribuerEntity> attributions = attribuerRepository.findAllByUtilisateurEntity_IdUtilisateur(
                    evenementEntity.getUtilisateurEntity().getIdUtilisateur());

            // créer un flux de données à partir de la liste d'attributions
            List<RoleDto> rolesDto = attributions.stream() // pour chaque attribution, mapper le rôle associé vers un DTO de type RoleDto
                    .map(attribution -> modelMapper.map(attribution.getRole(), RoleDto.class))
                    .collect(Collectors.toList());// collecter les DTO RoleDto mappés dans une liste
            // stocker la liste de DTO RoleDto dans l'objet UtilisateurDto
            utilisateurDto.setRoles(rolesDto);
            // stocker l'objet UtilisateurDto dans l'objet EvenementCompletDto
            evenementDto.setUtilisateur(utilisateurDto);
        }

        // mapper l'entité Lieu vers un DTO Lieu
        LieuDto lieuDto = modelMapper.map(evenementEntity.getLieuEntity(), LieuDto.class);
        evenementDto.setLieu(lieuDto);

        // retourner le DTO complet d'événement
        return evenementDto;
    }

    //définit une méthode publique qui renvoie une
    // liste d'objets AjouterFavorisDto et prend en entrée un identifiant d'utilisateur
    public List<AjouterFavorisDto> getEvenementsFavorisParUtilisateur(int idUtilisateur) throws NotFoundException {
        //méthode "findById" est fournie par l'interface JpaRepository et
        // renvoie un objet Optionnel qui peut contenir l'objet si l'identifiant
        // est valide ou un objet vide si l'identifiant ne correspond à aucun utilisateur
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé"));

        // récupère tous les événements favoris pour l'utilisateur en appelant la méthode
        // "findAllByUtilisateurEntity" de l'interface JpaRepository
        List<AjouterFavorisEntity> favoris = ajouterFavorisRepository.findAllByUtilisateurEntity(utilisateurEntity);

        // mapper chaque objet AjouterFavorisEntity dans la liste "favoris" à un objet
        // AjouterFavorisDto correspondant. La méthode "map" est utilisée pour effectuer
        // cette opération en utilisant l'objet ModelMapper
        // qui permet de mapper les propriétés de chaque objet en fonction de leur nom
        List<AjouterFavorisDto> favorisDto = favoris.stream()
                .map(favori -> {
                    AjouterFavorisDto favoriDto = modelMapper.map(favori, AjouterFavorisDto.class);
                    EvenementCompletDto evenementDto = modelMapper.map(favori.getEvenement(), EvenementCompletDto.class);

                    //Cette partie du code vérifie si l'objet EvenementEntity associé à chaque objet
                    // AjouterFavorisEntity a un utilisateur associé. Si c'est le cas, l'objet utilisateur est
                    // mappé sur un objet UtilisateurDto, et la méthode "findAllByUtilisateurEntity_IdUtilisateur"
                    // est utilisée pour récupérer tous les objets AttribuerEntity associés à cet utilisateur
                    if (favori.getEvenement().getUtilisateurEntity() != null) {
                        UtilisateurDto utilisateurDto = modelMapper.map(favori.getEvenement().getUtilisateurEntity(), UtilisateurDto.class);
                        List<AttribuerEntity> attributions = attribuerRepository.findAllByUtilisateurEntity_IdUtilisateur(
                                favori.getEvenement().getUtilisateurEntity().getIdUtilisateur());
                        List<RoleDto> rolesDto = attributions.stream()
                                .map(attribution -> modelMapper.map(attribution.getRole(), RoleDto.class))
                                .collect(Collectors.toList());
                        //objets AttribuerEntity sont mappés sur des objets RoleDto et sont
                        // stockés dans une liste "rolesDto" qui est ensuite ajoutée à l'objet UtilisateurDto.
                        utilisateurDto.setRoles(rolesDto);
                        //l'objet UtilisateurDto est ajouté à l'objet EvenementCompletDto
                        evenementDto.setUtilisateur(utilisateurDto);
                    }

                    favoriDto.setEvenement(evenementDto);
                    favoriDto.setUtilisateur(modelMapper.map(favori.getUtilisateur(), UtilisateurAvecRoleDto.class));
                    return favoriDto;
                })
                .collect(Collectors.toList());

        return favorisDto;
    }

    public List<EvenementCompletDto> getAllEvenements() {
        List<EvenementEntity> evenementsEntities = (List<EvenementEntity>) evenementRepository.findAll();
        List<EvenementCompletDto> evenements = new ArrayList<>();

        for (EvenementEntity evenementEntity : evenementsEntities) {
            EvenementCompletDto evenementDto = new EvenementCompletDto();
            BeanUtils.copyProperties(evenementEntity, evenementDto);

            if (evenementEntity.getUtilisateurEntity() != null) {
                UtilisateurDto utilisateurDto = new UtilisateurDto();
                BeanUtils.copyProperties(evenementEntity.getUtilisateurEntity(), utilisateurDto);

                List<AttribuerEntity> attributions = attribuerRepository.findAllByUtilisateurEntity_IdUtilisateur(
                        evenementEntity.getUtilisateurEntity().getIdUtilisateur());

                List<RoleDto> rolesDto = attributions.stream()
                        .map(attribution -> modelMapper.map(attribution.getRole(), RoleDto.class))
                        .collect(Collectors.toList());
                utilisateurDto.setRoles(rolesDto);
                evenementDto.setUtilisateur(utilisateurDto);
            }

            LieuDto lieuDto = modelMapper.map(evenementEntity.getLieuEntity(), LieuDto.class);
            evenementDto.setLieu(lieuDto);

            evenements.add(evenementDto);
        }
        return evenements;
    }

    @Transactional
    public EvenementEntity createEvenementById(int idUtilisateur,
                                               int idLieu,
                                               EvenementRequest evenementRequest) {

        // Création de l'événement
        EvenementEntity evenement = new EvenementEntity();
        evenement.setLabel(evenementRequest.getLabel());
        evenement.setDescription(evenementRequest.getDescription());
        evenement.setDate_debut(evenementRequest.getDate_debut());
        evenement.setDate_fin(evenementRequest.getDate_fin());
        evenement.setDateCreationEvenement(LocalDateTime.now());
        evenement.setHeure_debut(evenementRequest.getHeure_debut());
        evenement.setHeure_fin(evenementRequest.getHeure_fin());
        evenement.setLien_replay(evenementRequest.getLien_replay());
        evenement.setLien_ressources(evenementRequest.getLien_ressources());
        evenement.setStatut(evenementRequest.getStatut());
        evenement.setImage(evenementRequest.getImage());

        // Récupération et association du lieu à l'événement
        Optional<LieuEntity> optionalLieu = lieuRepository.findById(idLieu);
        if (!optionalLieu.isPresent()) {
            throw new RuntimeException("Le lieu associé à l'événement n'existe pas");
        }
        evenement.setLieuEntity(optionalLieu.get());


        // Récupération et association de l'utilisateur à l'événement
        Optional<UtilisateurEntity> optionalUtilisateur = utilisateurRepository.findById(idUtilisateur);
        if (!optionalUtilisateur.isPresent()) {
            throw new RuntimeException("L'utilisateur n'existe pas");
        }

        evenement.setUtilisateurEntity(optionalUtilisateur.get());

        // Enregistrement de l'événement en base de données
        return evenementRepository.save(evenement);
    }

    @Transactional
    public void ajouterEvenementFavoris(int idUtilisateur, int idEvenement) throws NotFoundException {
        //recuperer l'utilisateur
        UtilisateurEntity utilisateur = utilisateurRepository.findByIdUtilisateur(idUtilisateur)
                .orElseThrow(() -> new NotFoundException("L'utilisateur n'existe pas"));
        //recuperer l'evenement
        EvenementEntity evenement = evenementRepository.findById(idEvenement)
                .orElseThrow(() -> new NotFoundException("L'événement n'existe pas"));

        //Creer une nouvelle entité AjouterFavorisEntity
        AjouterFavorisEntity ajouterFavorisEntity = new AjouterFavorisEntity();
        //associer l'utilisateur à l'ajout d'un favoris
        ajouterFavorisEntity.setUtilisateur(utilisateur);
        //associer le l'evenement à un ajout de favoris
        ajouterFavorisEntity.setEvenement(evenement);
        //definir la date d'ajout d'un favoris
        ajouterFavorisEntity.setDateAjout(LocalDateTime.now());

        //sauvegarde de l'entité AjouterFavorisEntity dans la base de données
        ajouterFavorisRepository.save(ajouterFavorisEntity);
    }

    public String updateEvenement(int idUtilisateur, int idEvenement, EvenementUpdateDto evenementUpdateDto) throws NotFoundException {
        //recuperer l'utilisateur
        UtilisateurEntity utilisateur = utilisateurRepository.findByIdUtilisateur(idUtilisateur)
                .orElseThrow(() -> new NotFoundException("L'utilisateur n'existe pas"));
        //recuperer l'evenement
        EvenementEntity evenement = evenementRepository.findById(idEvenement)
                .orElseThrow(() -> new NotFoundException("L'événement n'existe pas"));
        // Vérifier si l'utilisateur est autorisé à modifier l'événement
        if (utilisateur.getIdUtilisateur() != evenement.getUtilisateurEntity().getIdUtilisateur()) {
            throw new RuntimeException("Vous n'êtes pas autorisé à modifier cet événement");
        }
        // Mettre à jour l'événement avec les champs de EvenementUpdateDto
        evenement.setLabel(evenementUpdateDto.getLabel());
        evenement.setDescription(evenementUpdateDto.getDescription());
        evenement.setDate_debut(evenementUpdateDto.getDate_debut());
        evenement.setDate_fin(evenementUpdateDto.getDate_fin());
        evenement.setHeure_debut(evenementUpdateDto.getHeure_debut());
        evenement.setHeure_fin(evenementUpdateDto.getHeure_fin());
        evenement.setLien_replay(evenementUpdateDto.getLien_replay());
        evenement.setLien_ressources(evenementUpdateDto.getLien_ressources());
        evenement.setImage(evenementUpdateDto.getImage().getBytes());
        evenement.setStatut(evenementUpdateDto.getStatut());

        // Mettre à jour le lieu avec les champs de LieuDto dans EvenementUpdateDto
        LieuDto lieuDto = evenementUpdateDto.getLieu();
        if (lieuDto != null) {
            LieuEntity lieuEntity = evenement.getLieuEntity();
            lieuEntity.setAdresse(lieuDto.getAdresse());
            lieuEntity.setCodePostal(lieuDto.getCodePostal());
            lieuEntity.setCoordoneesGps(lieuDto.getCoordoneesGps());
            lieuEntity.setLocalisation(lieuDto.getLocalisation());
            lieuEntity.setPlaces(lieuDto.getPlaces());
            lieuEntity.setVille(lieuDto.getVille());
        }

        // Sauvegarder l'événement mis à jour
        evenementRepository.save(evenement);
        return "L'événement a été mis à jour avec succès";
    }

    public String deleteEvenement(int idEvenement) {
        try {
            Optional<EvenementEntity> optionalEvenementEntity =
                    evenementRepository.findById(idEvenement);
            if (optionalEvenementEntity.isPresent()) {
                EvenementEntity evenement = optionalEvenementEntity.get();
                evenementRepository.delete(evenement);
                return "Evenement supprimé avec succès";
            } else {
                return "L'événement n'existe pas";
            }
        } catch (Exception e) {
            return "Erreur de suppression: " + e.getMessage();
        }
    }

    @Transactional
    public void correspondreTypologieEvenements(int idTypologieEvenements, int idEvenement) throws NotFoundException {

        TypologieEvenementsEntity typologieEvenement = typologieEvenementsRepository.findById(idTypologieEvenements)
                .orElseThrow(() -> new NotFoundException("La typologie d'événement n'existe pas"));

        EvenementEntity evenement = evenementRepository.findById(idEvenement)
                .orElseThrow(() -> new NotFoundException("L'événement n'existe pas"));

        //créer une nouvelle entité CorrespondreEntity
        CorrespondreEntity correspondreEntity = new CorrespondreEntity();

        //associer la typologie d'événement à l'événement
        correspondreEntity.setEvenement(evenement);
        //associer la typologie à l'evenement
        correspondreEntity.setTypologieEvenements(typologieEvenement);
        //sauvegarder l'entité TypologieEvenementsEvenementEntity dans la base de données
        correspondreRepository.save(correspondreEntity);
    }

}


















