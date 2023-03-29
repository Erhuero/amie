package com.mgen.amie.service;

import com.mgen.amie.dto.MessageContactDto;
import com.mgen.amie.entity.MessageContactEntity;
import com.mgen.amie.entity.UtilisateurEntity;
import com.mgen.amie.repository.MessageContactRepository;
import com.mgen.amie.repository.UtilisateurRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageContactService {

    @Autowired
    private MessageContactRepository messageContactRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public MessageContactDto redigerMessage(int idUtilisateur, MessageContactDto messageDto) {
        // Créer une nouvelle entité MessageContactEntity à partir du MessageContactDto
        MessageContactEntity messageEntity = new MessageContactEntity();
        messageEntity.setObjet(messageDto.getObjet());
        messageEntity.setDescription(messageDto.getDescription());

        // Récupérer l'entité utilisateur correspondante à partir de l'ID de l'expéditeur
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'ID " + idUtilisateur));

        // Définir l'expéditeur, le destinataire et la date de rédaction pour le message
        messageEntity.setUtilisateurEntity(utilisateurEntity);
        messageEntity.setObjet(messageDto.getObjet());
        messageEntity.setDescription(messageDto.getDescription());
        messageEntity.setDateRedaction(LocalDateTime.now());

        // Enregistrer le message
        MessageContactEntity savedMessageContact = messageContactRepository.save(messageEntity);

        // Créer un nouveau MessageContactDto à partir des champs d'objet de l'entité MessageContactEntity
        MessageContactDto savedMessageDto = new MessageContactDto();
        BeanUtils.copyProperties(savedMessageContact, savedMessageDto);

        return savedMessageDto;
    }


    /*
    @Transactional
    public MessageContactDto redigerMessage(int idUtilisateur, int idUtilisateurDestinataire, MessageContactDto messageDto) {
        // Créer une nouvelle entité MessageContactEntity à partir du MessageContactDto
        MessageContactEntity messageEntity = new MessageContactEntity();
        messageEntity.setObjet(messageDto.getObjet());
        messageEntity.setDescription(messageDto.getDescription());

        // Récupérer les entités utilisateur correspondantes à partir de l'ID de l'expéditeur et du destinataire
        UtilisateurEntity expediteurEntity = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'ID " + idUtilisateur));
        UtilisateurEntity destinataireEntity = utilisateurRepository.findById(idUtilisateurDestinataire)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'ID " + idUtilisateurDestinataire));

        // Définir l'expéditeur, le destinataire et la date de rédaction pour le message
        messageEntity.setUtilisateurEntity(expediteurEntity);
        messageEntity.setDestinataire(destinataireEntity);
        messageEntity.setDateRedaction(LocalDateTime.now());

        // Enregistrer le message
        MessageContactEntity savedMessageContact = messageContactRepository.save(messageEntity);

        // Créer un nouveau MessageContactDto à partir des champs d'objet et de description de l'entité enregistrée
        MessageContactDto savedMessageDto = new MessageContactDto(savedMessageContact.getObjet(), savedMessageContact.getDescription());

        return savedMessageDto;
    }
     */

    @Transactional
    public List<MessageContactDto> getMessagesByUtilisateurId(int idUtilisateur) {
        List<MessageContactEntity> messageContactEntities = messageContactRepository.findByUtilisateurEntity_IdUtilisateur(idUtilisateur);
        List<MessageContactDto> messageContactDTOs = new ArrayList<>();
        for (MessageContactEntity messageContactEntity : messageContactEntities) {
            if (messageContactEntity.getUtilisateurEntity().getIdUtilisateur() == idUtilisateur) {
                MessageContactDto messageContactDTO = new MessageContactDto();
                BeanUtils.copyProperties(messageContactEntity, messageContactDTO);
                messageContactDTOs.add(messageContactDTO);
            }
        }
        return messageContactDTOs;
    }

    public String deleteMessageByIdUtilisateur(int idMessageContact){
        try {
            Optional<MessageContactEntity> optionalMessageContactEntity =
                    messageContactRepository.findById(idMessageContact);
            if(optionalMessageContactEntity.isPresent()){
                MessageContactEntity messageContactEntity =
                        optionalMessageContactEntity.get();
                messageContactRepository.delete(messageContactEntity);
            }
            return "Message supprimé";
        } catch (Exception e) {
            return "Erreur de suppression : " + e.getMessage();
        }

    }

    /**
     *Supprime un message de la base de données
     * si l'utilisateur est l'expéditeur ou le destinataire
     * Marquer quel utilisateur a supprimé et supprime le message si les deux utilisateurs l'ont supprimé
     * @param idUtilisateur
     * @return
     */
    /*
    public String deleteMessageContact(int idMessageContact, int idUtilisateur) {
        try {
            Optional<MessageContactEntity> messageContact = messageContactRepository.findById(idMessageContact);
            if (messageContact.isPresent()) {
                MessageContactEntity message = messageContact.get();
                String supprimePar = message.getSupprimePar();
                if (supprimePar == null) {
                    supprimePar = "";
                }
                supprimePar += (supprimePar.isEmpty() ? "" : ",") + idUtilisateur;
                message.setSupprimePar(supprimePar);
                int numberOfUsers = supprimePar.split(",").length;
                if (numberOfUsers == 2) {
                    messageContactRepository.delete(message);
                    return "Message supprimé";
                } else {
                    messageContactRepository.save(message);
                    return "Message marqué comme supprimé";
                }
            } else {
                return "Le message n'existe pas";
            }
        } catch (Exception e) {
            return "Erreur de suppression : " + e.getMessage();
        }
    }

     */

}
