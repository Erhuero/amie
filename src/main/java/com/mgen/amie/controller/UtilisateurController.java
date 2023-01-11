package com.mgen.amie.controller;

import com.mgen.amie.entity.EmployeeEntity;
import com.mgen.amie.model.Employee;
import com.mgen.amie.entity.UtilisateurEntity;
import com.mgen.amie.model.Utilisateur;
import com.mgen.amie.repository.UtilisateurRepository;
import com.mgen.amie.service.EmployeeService;
import com.mgen.amie.service.UtilisateurService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping(value = "getallutilisateurs", method = RequestMethod.GET)
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.getAllUtilisateurs();
    }
    
}
