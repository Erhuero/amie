package com.mgen.amie.controller;

import com.mgen.amie.dto.GestionFaqDto;
import com.mgen.amie.dto.RedactionFAQDto;
import com.mgen.amie.entity.FAQEntity;
import com.mgen.amie.model.FAQ;
import com.mgen.amie.service.FAQService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api/faq/")
@Api(description = "Gestion des informations FAQ")
public class FAQController {

    @Autowired
    FAQService faqService;

    @ApiOperation(value = "Ajouter une FAQ", notes = "Permet d'ajouter une FAQ avec une question et une description")
    @RequestMapping(value = "addfaq/{idUtilisateur}", method = RequestMethod.POST)
    public ResponseEntity<String> addFAQ(
            @PathVariable ("idUtilisateur") int idUtisateur,
            @RequestBody RedactionFAQDto redactionFAQDto) throws NotFoundException {
         faqService.addFAQ(idUtisateur, redactionFAQDto);
        return ResponseEntity.ok("Ajout FAQ réussi");
    }

    @ApiOperation(value = "Recuperer toutes les FAQ", notes = "Permet de recuperer toutes les FAQ avec une question et une description")
    @RequestMapping(value = "getallfaq", method = RequestMethod.GET)
    public List<GestionFaqDto> getAllFAQ(){
        return faqService.getAllFAQ();
    }

    @ApiOperation(value = "Modifier une FAQ", notes = "Permet de modifier une FAQ avec une question et une description")
    @RequestMapping(value = "updatefaq/{idFAQ}", method = RequestMethod.PUT)
    public String updateFAQ(
            @PathVariable ("idFAQ") int idFAQ,
            @RequestBody RedactionFAQDto redactionFAQDto) {
        return faqService.updateFAQ(idFAQ, redactionFAQDto);
    }

    @ApiOperation(value = "Supprimer une FAQ", notes = "Permet de supprimer une FAQ avec son id")
    @RequestMapping(value = "removefaq/{idFAQ}", method = RequestMethod.DELETE)
    public String deleteFAQ(@PathVariable ("idFAQ") int idFAQ) {
        return faqService.deleteFAQ(idFAQ);
    }

}
