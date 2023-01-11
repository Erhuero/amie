package com.mgen.amie.repository;

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
public interface UtilisateurRepository extends PagingAndSortingRepository<UtilisateurEntity, Long> {
    @Query("SELECT u FROM Utilisateur u WHERE u.mail = ?1")
    Optional<UtilisateurEntity> findUtilisateurByEmail(String mail);

    @Query("SELECT u FROM Utilisateur u WHERE u.nom = ?1")
    List<UtilisateurEntity> selectUtilisateurWhereNomEqual(String nom);

    @Transactional
    @Modifying
    @Query("DELETE FROM Utilisateur u WHERE u.idUtilisateur=?1")
    int deleteUtilisateurByIdUtilisateur(Long idUtilisateur);

}
