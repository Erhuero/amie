package com.mgen.amie.repository;

import com.mgen.amie.composite.IdCorrespondre;
import com.mgen.amie.entity.CorrespondreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface CorrespondreRepository extends JpaRepository<CorrespondreEntity, Integer> {

    public boolean existsById(IdCorrespondre id);

}