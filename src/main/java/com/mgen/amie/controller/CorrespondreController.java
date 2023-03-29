package com.mgen.amie.controller;


import com.mgen.amie.entity.CorrespondreEntity;
import com.mgen.amie.model.Correspondre;
import com.mgen.amie.service.CorrespondreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/correspondre/")
public class CorrespondreController {

    @Autowired
    CorrespondreService correspondreService;

    @ApiOperation(value = "Obtenir la liste des correspondances", notes = "Obtenir toutes les correspondances enregistrées dans la base de données")
    @RequestMapping(value = "getallcorrespondances", method = RequestMethod.GET)
    public List<Correspondre> getAllCorrespondances() {
        return correspondreService.getAllCorrespondances();
    }

    @ApiOperation(value = "Ajouter une correspondance", notes = "Ajouter une correspondance dans la base de données")
    @RequestMapping(value = "addcorrespondre", method = RequestMethod.POST)
    public String addCorrespondre(@RequestBody CorrespondreEntity correspondre) {
        return correspondreService.addCorrespondre(correspondre);
    }

    @ApiOperation(value = "Mettre à jour une correspondance", notes = "Mettre à jour une correspondance dans la base de données")
    @RequestMapping(value = "updatecorrespondre", method = RequestMethod.PUT)
    public String updateCorrespondre(@Valid @RequestBody CorrespondreEntity correspondre) {
        return correspondreService.updateCorrespondre(correspondre);
    }

    @ApiOperation(value = "Supprimer une correspondance", notes = "Supprimer une correspondance dans la base de données")
    @RequestMapping(value = "deletecorrespondre", method = RequestMethod.DELETE)
    public String deleteCorrespondre(@RequestBody CorrespondreEntity correspondre) {
        return correspondreService.deleteCorrespondre(correspondre);
    }

}