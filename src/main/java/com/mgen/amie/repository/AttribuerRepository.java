package com.mgen.amie.repository;

import com.mgen.amie.composite.IdAttribuer;
import com.mgen.amie.entity.AttribuerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttribuerRepository extends JpaRepository<AttribuerEntity, Integer> {

    public boolean existsById(IdAttribuer id);

    List<AttribuerEntity> findAllByUtilisateurEntity_IdUtilisateur(int idUtilisateur);

}
