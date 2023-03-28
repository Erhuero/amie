package com.mgen.amie.controller;

import com.mgen.amie.dto.MessageContactDto;
import com.mgen.amie.service.MessageContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/messagecontactcontroller/")
@Api(description = "Gestion des messages")
public class MessageContactController {

    @Autowired
    MessageContactService messageContactService;

    @ApiOperation(value = "Créer un message à destination d'un contact", notes = "Permet de créer un message à destination d'un contact")
    @RequestMapping(value = "createmessagecontact/{idUtilisateur}", method = RequestMethod.POST)
    public ResponseEntity<MessageContactDto> createMessageContact(
            @PathVariable("idUtilisateur") int idUtilisateur,
            @RequestBody MessageContactDto messageContactDto) throws NotFoundException {
        MessageContactDto savedMessageDto = messageContactService.redigerMessage(idUtilisateur, messageContactDto);
        return ResponseEntity.ok(savedMessageDto);
    }

    @ApiOperation(value = "Recuperer tous les messages à destinations d'un contact", notes = "Permet de recuperer tous les messages à destinations d'un contact")
    @RequestMapping(value = "getallmessagescontact/{idUtilisateur}", method = RequestMethod.GET)
    public List<MessageContactDto> getMessageContactByUser(@PathVariable("idUtilisateur") int idUtilisateur) throws NotFoundException {
        return messageContactService.getMessagesByUtilisateurId(idUtilisateur);
    }

    @ApiOperation(value ="Supprimer un message", notes = "Permet de supprimer un message par l'identifiant de l'utilisateur")
    @RequestMapping(value = "deletemessagecontact/{idMessageContact}", method = RequestMethod.DELETE)
    public void deleteMessageContact(@PathVariable("idMessageContact") int idMessageContact) throws NotFoundException {
        messageContactService.deleteMessageByIdUtilisateur(idMessageContact);
    }

}
