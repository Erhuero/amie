package com.mgen.amie.controller;

import com.mgen.amie.entity.AjouterFavorisEntity;
import com.mgen.amie.model.AjouterFavoris;
import com.mgen.amie.service.AjouterFavorisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(description = "Gestion des favoris")
@RequestMapping("/api/ajouterfavoris/")
public class AjouterFavorisController {

    @Autowired
    AjouterFavorisService ajouterFavorisService;

    @ApiOperation(value = "Obtenir la liste des favoris", notes = "Obtenir tous les favoris enregistrés dans la base de données")
    @RequestMapping(value = "getallfavoris", method = RequestMethod.GET)
    public List<AjouterFavoris> getAllFavoris() {
        return ajouterFavorisService.getAllAjouterFavoris();
    }

    @ApiOperation(value = "Ajouter un favoris", notes = "Ajouter un favoris dans la base de données")
    @RequestMapping(value = "addfavoris", method = RequestMethod.POST)
    public String addFavoris(@Valid @RequestBody AjouterFavorisEntity favoris) {
        return ajouterFavorisService.addFavoris(favoris);
    }

    @ApiOperation(value = "Supprimer un favoris", notes = "Supprimer un favoris dans la base de données")
    @RequestMapping(value = "deletefavoris", method = RequestMethod.DELETE)
    public String deleteFavoris(@Valid @RequestBody AjouterFavorisEntity favoris) {
        return ajouterFavorisService.deleteFavoris(favoris);
    }
}