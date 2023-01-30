package com.mgen.amie.controller;

import com.mgen.amie.model.Utilisateur;
import com.mgen.amie.repository.AuthentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping
public class AuthentificationController {

    @Autowired
    private AuthentificationRepository authentificationRepository;


    @PostMapping(value = "login")
    public Utilisateur Login(@RequestBody Utilisateur utilisateur){
        Utilisateur utilisateurInscrit = authentificationRepository.findByMailAAndMotDePasse(utilisateur.getMail(), utilisateur.getMotDePasse());
        return utilisateurInscrit;
    }


}
