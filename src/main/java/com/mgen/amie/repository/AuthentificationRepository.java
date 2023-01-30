package com.mgen.amie.repository;

import com.mgen.amie.entity.UtilisateurEntity;
import com.mgen.amie.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AuthentificationRepository extends JpaRepository<UtilisateurEntity, Long> {

    @Query("SELECT u FROM Utilisateur u WHERE u.mail = ?1 AND u.motDePasse = ?2")
    Utilisateur findByMailAAndMotDePasse(String mail, String mot_de_passe);

}
