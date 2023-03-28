package com.mgen.amie.repository;

import com.mgen.amie.composite.IdAjouterFavoris;
import com.mgen.amie.entity.AjouterFavorisEntity;
import com.mgen.amie.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface AjouterFavorisRepository extends JpaRepository<AjouterFavorisEntity, Integer> {

    boolean existsById(IdAjouterFavoris id);

    List<AjouterFavorisEntity> findAllByUtilisateurEntity_IdUtilisateur(int idUtilisateur);

    List<AjouterFavorisEntity> findAllByUtilisateurEntity(UtilisateurEntity utilisateurEntity);
}
