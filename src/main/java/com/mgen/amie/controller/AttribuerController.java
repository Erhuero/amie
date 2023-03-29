package com.mgen.amie.controller;

import com.mgen.amie.entity.AttribuerEntity;
import com.mgen.amie.model.Attribuer;
import com.mgen.amie.service.AttribuerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api/attribuer/")
@Api(description = "Gestion des roles par utilisateur assigné par un administrateur")
public class AttribuerController {

    private final AttribuerService attribuerService;

    @Autowired
    public AttribuerController(AttribuerService attribuerService) {
        this.attribuerService = attribuerService;
    }

    @ApiOperation(value = "Obtenir la liste des roles par utilisateur assigné par un administrateur", notes = "Obtenir tous les roles par utilisateur assigné par un administrateur enregistrés dans la base de données")
    @RequestMapping(value = "getallattribuer", method = RequestMethod.GET)
    public List<Attribuer> getAllAttribuer() {
        return attribuerService.getAllAttributions();
    }

    @ApiOperation(value = "Ajouter un role par utilisateur assigné par un administrateur", notes = "Ajouter un role par utilisateur assigné par un administrateur dans la base de données")
    @RequestMapping(value = "addattribuer", method = RequestMethod.POST)
    public String addAttribuer(@Valid @RequestBody AttribuerEntity attribuer) {
        return attribuerService.addAttribution(attribuer);
    }

    @ApiOperation(value = "Mettre à jour un role par utilisateur assigné par un administrateur", notes = "Mettre à jour un role par utilisateur assigné par un administrateur dans la base de données")
    @RequestMapping(value = "updateattribuer", method = RequestMethod.PUT)
    public String updateAttribuer(@RequestBody AttribuerEntity attribuer) {
        return attribuerService.updateAttribution(attribuer);
    }

    @ApiOperation(value = "Supprimer un role par utilisateur assigné par un administrateur", notes = "Supprimer un role par utilisateur assigné par un administrateur dans la base de données")
    @RequestMapping(value = "deleteattribuer", method = RequestMethod.DELETE)
    public String deleteAttribuer(@RequestBody AttribuerEntity attribuer) {
        return attribuerService.deleteAttribution(attribuer);
    }
}