package com.mgen.amie.controller;

import com.mgen.amie.dto.*;
import com.mgen.amie.entity.EvenementEntity;

import com.mgen.amie.repository.EvenementRepository;
import com.mgen.amie.repository.LieuRepository;
import com.mgen.amie.repository.UtilisateurRepository;
import com.mgen.amie.request.EvenementRequest;
import com.mgen.amie.service.EvenementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/evenement/")
@Api(description = "Gestion des événements")
public class EvenementController {

    private final EvenementService evenementService;
    private final LieuRepository lieuRepository;
    private final EvenementRepository evenementRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public EvenementController(EvenementService evenementService,
                               LieuRepository lieuRepository,
                               EvenementRepository evenementRepository,
                               UtilisateurRepository utilisateurRepository) {
        this.evenementService = evenementService;
        this.lieuRepository = lieuRepository;
        this.evenementRepository = evenementRepository;
    }

    @ApiOperation(value = "Obtenir la liste des événements", notes = "Obtenir tous les événements enregistrés dans la base de données")
    @RequestMapping(value = "getallevenements", method = RequestMethod.GET)
    public List<EvenementCompletDto> getAllEvenements() {
        return evenementService.getAllEvenements();
    }


    @ApiOperation(value = "Ajouter en favoris", notes = "Ajouter un evenement en favoris")
    @RequestMapping(value ="ajouterfavoris/{idUtilisateur}/{idEvenement}" , method = RequestMethod.POST)
    public ResponseEntity<String> ajouterEnFavoris(@PathVariable("idUtilisateur") int idUtilisateur,
                                                   @PathVariable("idEvenement") int idEvenement) throws NotFoundException{
        evenementService.ajouterEvenementFavoris(idUtilisateur, idEvenement);
        return ResponseEntity.ok("Ajout evenement en favoris réussi");
    }

    @ApiOperation(value = "Visualiser les favoris d'un utilisateur", notes = "Visualiser les favoris d'un utilisateur en fonction de son id")
    @GetMapping(value = "getfavoris/{idUtilisateur}")
    public ResponseEntity<List<AjouterFavorisDto>> getFavorisAvecId(@PathVariable int idUtilisateur) {
        try {
            List<AjouterFavorisDto> favoris = evenementService.getEvenementsFavorisParUtilisateur(idUtilisateur);
            return ResponseEntity.ok(favoris);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @ApiOperation(value = "Obtenir les événements d'un utilisateur", notes = "Obtenir la liste des événements créés par un utilisateur avec l'ID renseigné")
    @RequestMapping(value = "{idUtilisateur}", method = RequestMethod.GET)
    public ResponseEntity<EvenementCompletDto> getEvenementsById(@PathVariable int idUtilisateur) {
        try {
            EvenementCompletDto evenement = evenementService.getEvenementsByIdUtilisateur(idUtilisateur);
            return ResponseEntity.ok(evenement);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Ajouter un événement", notes = "Ajouter un événement dans la base de données")
    @RequestMapping(value = "createevenement/{idUtilisateur}/{idLieu}", method = RequestMethod.POST)
    public EvenementEntity createEvenement(@PathVariable int idUtilisateur, @PathVariable int idLieu, @RequestBody EvenementRequest evenementRequest) {
        return evenementService.createEvenementById(idUtilisateur, idLieu, evenementRequest);
    }

    @ApiOperation(value = "Modifier un événement", notes = "Modifier un événement dans la base de données en fonction de son ID et de l'ID de l'utilisateur")
    @RequestMapping(value = "/{idUtilisateur}/{idEvenement}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEvenement(
            @PathVariable int idUtilisateur,
            @PathVariable int idEvenement,
            @RequestBody EvenementUpdateDto evenementUpdateDto) {
        try {
            // Convertir EvenementUpdateDto en EvenementEntity en utilisant modelMapper
            EvenementEntity evenementEntity = modelMapper.map(evenementUpdateDto, EvenementEntity.class);

            String message = evenementService.updateEvenement(idUtilisateur, idEvenement, evenementUpdateDto);
            return ResponseEntity.ok(message);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Supprimer un événement", notes = "Supprimer un événement dans la base de données")
    @RequestMapping(value = "deleteevenement/{IdEvenement}", method = RequestMethod.DELETE)
    public String deleteEvenement(@PathVariable("IdEvenement") int idEvenement) {
        return evenementService.deleteEvenement(idEvenement);
    }

    @ApiOperation(value = "Attribuer une typologie à un évènement", notes = "Ajouter une typologie à un évènement")
    @RequestMapping(value= "choisirtypologievenement/{idEvenement}/{idTypologieEvenements}", method = RequestMethod.POST)
    public ResponseEntity<String> choisirTypologieEvenement(@PathVariable("idEvenement") int idEvenement,
                                                            @PathVariable("idTypologieEvenements") int idTypologieEvenements) throws NotFoundException{
        evenementService.correspondreTypologieEvenements(idEvenement, idTypologieEvenements);
        return ResponseEntity.ok("Ajout typologie à l'événement réussi");
    }
}