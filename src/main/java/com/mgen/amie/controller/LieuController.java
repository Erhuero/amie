package com.mgen.amie.controller;

import com.mgen.amie.dto.LieuGestionDto;
import com.mgen.amie.entity.LieuEntity;
import com.mgen.amie.model.Lieu;
import com.mgen.amie.service.LieuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api/lieu/")
@Api(description = "Gestion des lieux ou se déroulent les évènements")
public class LieuController {

    @Autowired
    LieuService lieuService;

    @ApiOperation(value = "Obtenir la liste des lieux", notes = "Obtenir tous les lieux enregistrés dans la base de données")
    @RequestMapping(value = "getalllieux", method = RequestMethod.GET)
    public List<Lieu> getAllLieux() {return lieuService.getAllLieux();}

    @ApiOperation(value = "Ajouter un lieu", notes = "Ajouter un lieu dans la base de données")
    @RequestMapping(value = "addlieu", method = RequestMethod.POST)
    public String addLieu(@RequestBody LieuGestionDto lieuGestionDto) {
        return lieuService.addLieu(lieuGestionDto);}

    @ApiOperation(value = "Mettre à jour un lieu", notes = "Mettre à jour un lieu dans la base de données")
    @RequestMapping(value = "updatelieu/{idLieu}", method = RequestMethod.PUT)
    public String updateLieu(
            @PathVariable ("idLieu") int idLieu,
            @RequestBody LieuGestionDto lieuGestionDto){
        return lieuService.updateLieu(idLieu, lieuGestionDto);
    }

    @ApiOperation(value = "Supprimer un lieu", notes = "Supprimer un lieu dans la base de données")
    @RequestMapping(value = "deletelieu/{idLieu}", method = RequestMethod.DELETE)
    public String deleteLieu(@PathVariable ("idLieu") int idLieu) {
        return lieuService.deleteLieu(idLieu);}
}
