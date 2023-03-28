package com.mgen.amie.repository;

import com.mgen.amie.entity.TypologieEvenementsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypologieEvenementsRepository extends JpaRepository<TypologieEvenementsEntity, Integer> {


    public boolean existsByLabel(Long label);

    public boolean existsById(int idTypologieEvenements);

}
