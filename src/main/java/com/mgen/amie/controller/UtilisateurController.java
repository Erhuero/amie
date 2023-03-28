package com.mgen.amie.controller;

import com.mgen.amie.dto.RoleDto;
import com.mgen.amie.dto.UtilisateurAjoutDto;
import com.mgen.amie.dto.UtilisateurDto;
import com.mgen.amie.dto.UtilisateurModificationDto;
import com.mgen.amie.entity.AttribuerEntity;
import com.mgen.amie.entity.UtilisateurEntity;
import com.mgen.amie.model.Utilisateur;
import com.mgen.amie.repository.AttribuerRepository;
import com.mgen.amie.repository.UtilisateurRepository;
import com.mgen.amie.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Autowired
    AttribuerRepository attribuerRepository;


    @Transactional
    @ApiOperation(value = "Attribuer un rôle à un utilisateur", notes = "Attribuer un rôle à un utilisateur")
    @RequestMapping(value = "{idUtilisateur}/{idRole}", method = RequestMethod.POST)
    public ResponseEntity<String> assignerRoleAUtilisateur(@PathVariable("idUtilisateur") int idUtilisateur,
                                                           @PathVariable("idRole") int idRole) throws NotFoundException {
        utilisateurService.assignerRoleAUtilisateur(idUtilisateur, idRole);
        return ResponseEntity.ok("Attribution réussie");
    }

    @ApiOperation(value = "Obtenir la liste des utilisateurs", notes = "Obtenir tous les utilisateurs enregistrés dans la base de données")
    @RequestMapping(value = "getallutilisateurs", method = RequestMethod.GET)
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.getAllUtilisateurs();
    }


    @ApiOperation(value = "Ajouter un utilisateur", notes = "Ajouter un utilisateur dans la base de données")
    @RequestMapping(value = "addutilisateur", method = RequestMethod.POST)
    public UtilisateurEntity ajouterUtilisateur(@RequestBody UtilisateurAjoutDto utilisateurAjoutDto) throws NotFoundException {
            return utilisateurService.addUtilisateur(utilisateurAjoutDto);
    }

    @ApiOperation(value = "Mettre à jour un utilisateur", notes = "Mettre à jour un utilisateur dans la base de données")
    @RequestMapping(value = "updateutilisateur/{idUtilisateur}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUtilisateur(
            @PathVariable int idUtilisateur,
            @RequestBody UtilisateurModificationDto utilisateurModificationDto) {
        try {
            UtilisateurEntity utilisateurEntity = modelMapper.map(utilisateurModificationDto, UtilisateurEntity.class);
            String message = utilisateurService.updateUtilisateur(idUtilisateur, utilisateurModificationDto);
            return ResponseEntity.ok(message);
        }catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
    } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Obtenir la liste des utilisateurs avec leurs rôles", notes = "Obtenir tous les utilisateurs enregistrés dans la base de données avec leurs rôles associés")
    @RequestMapping(value = "getallutilisateursavecroles", method = RequestMethod.GET)
    public List<UtilisateurDto> getAllUtilisateursAvecRoles() throws NotFoundException {
        return utilisateurService.getAllUtilisateursAvecRoles();
    }

    @ApiOperation(value = "Supprimer un utilisateur", notes = "Supprimer un utilisateur dans la base de données")
    @RequestMapping(value = "deleteutilisateur/{idUtilisateur}", method = RequestMethod.DELETE)
    public String deleteUtilisateur(@PathVariable ("idUtilisateur") int idUtilisateur) {
        return utilisateurService.deleteUtilisateur(idUtilisateur);
    }

    @ApiOperation(value = "Obtenir un utilisateur avec ses rôles", notes = "Obtenir un utilisateur avec ses rôles enregistrés dans la base de données")
    @GetMapping("{idUtilisateur}")
    public ResponseEntity<UtilisateurDto> getUtilisateurAvecRoles(@PathVariable int idUtilisateur) {
        try {
            UtilisateurDto utilisateurDto = utilisateurService.getUtilisateurAvecRoles(idUtilisateur);
            return ResponseEntity.ok(utilisateurDto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
