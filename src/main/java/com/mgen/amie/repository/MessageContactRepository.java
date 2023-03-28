package com.mgen.amie.repository;

import com.mgen.amie.entity.MessageContactEntity;
import com.mgen.amie.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.font.OpenType;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional(readOnly = true)
public interface MessageContactRepository extends JpaRepository<MessageContactEntity, Integer> {

    List<MessageContactEntity> findByUtilisateurEntity(UtilisateurEntity utilisateurEntity);

    List<MessageContactEntity> findByUtilisateurEntity_IdUtilisateur(int idUtilisateur);

}
