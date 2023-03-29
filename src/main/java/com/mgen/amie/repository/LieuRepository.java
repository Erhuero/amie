package com.mgen.amie.repository;

import com.mgen.amie.entity.LieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LieuRepository extends JpaRepository<LieuEntity, Integer> {

    public boolean existsByIdLieu(int idLieu);
    public boolean existsById(int idLieu);

    Optional<LieuEntity> findByIdLieu(int idLieu);

}
