package com.mgen.amie.controller;

import com.mgen.amie.entity.TypologieEvenementsEntity;
import com.mgen.amie.model.TypologieEvenements;
import com.mgen.amie.service.TypologieEvenementsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/typologieevenement/")
@Api(description = "Gestion des typologies d'événements")
public class TypologieEvenementController {

    @Autowired
    TypologieEvenementsService typologieEvenementService;

    @ApiOperation(value = "Obtenir la liste des typologies d'événements", notes = "Obtenir toutes les typologies d'événements enregistrées dans la base de données")
    @RequestMapping(value = "getalltypologieevenements", method = RequestMethod.GET)
    public List<TypologieEvenements> getAllTypologieEvenements() {
        return typologieEvenementService.getAllTypologieEvenements();
    }

    @ApiOperation(value = "Ajouter une typologie d'événement", notes = "Ajouter une typologie d'événement dans la base de données")
    @RequestMapping(value = "addtypologieevenement", method = RequestMethod.POST)
    public String addTypologieEvenement(@Valid @RequestBody TypologieEvenementsEntity typologieEvenement) {
        return typologieEvenementService.addTypologieEvenements(typologieEvenement);
    }

    @ApiOperation(value = "Mettre à jour une typologie d'événement", notes = "Mettre à jour une typologie d'événement dans la base de données")
    @RequestMapping(value = "updatetypologieevenement", method = RequestMethod.PUT)
    public String updateTypologieEvenement(@Valid @RequestBody TypologieEvenementsEntity typologieEvenement) {
        return typologieEvenementService.updateTypologieEvenements(typologieEvenement);
    }

    @ApiOperation(value = "Supprimer une typologie d'événement", notes = "Supprimer une typologie d'événement dans la base de données")
    @RequestMapping(value = "deletetypologieevenement", method = RequestMethod.DELETE)
    public String deleteTypologieEvenement(@Valid @RequestBody TypologieEvenementsEntity typologieEvenement) {
        return typologieEvenementService.deleteTypologieEvenements(typologieEvenement);
    }
}

