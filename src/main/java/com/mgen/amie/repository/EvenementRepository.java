package com.mgen.amie.repository;


import com.mgen.amie.entity.EvenementEntity;
import com.mgen.amie.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface EvenementRepository extends PagingAndSortingRepository<EvenementEntity, Long> {
    @Query("SELECT e FROM Evenement e WHERE e.idEvenement = ?1")
    Optional<EvenementEntity> findEvenementEntitiesByIdEvenement(String idEvenement);

    @Transactional
    @Modifying
    @Query("DELETE FROM Evenement e WHERE e.idEvenement = ?1")
    int deleteEvenementByIdEvenement(Long idEvenement);

    int deleteEvenementByIdEvenement(int idEvenement);


    List<EvenementEntity> findAllByUtilisateurEntity(UtilisateurEntity utilisateur);

    List<EvenementEntity> findByUtilisateurEntity(UtilisateurEntity utilisateur);

    Optional<EvenementEntity> findByIdEvenementAndUtilisateurEntity_IdUtilisateur(int idEvenement, int idUtilisateur);

}
