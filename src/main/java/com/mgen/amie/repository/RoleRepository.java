package com.mgen.amie.repository;
import com.mgen.amie.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    @Query("SELECT r FROM Role r WHERE r.libelle = ?1")
    List<RoleEntity> selectRoleWhereLibelleEqual(String libelle);

    @Query("SELECT r FROM Role r WHERE r.idRole = ?1")
    public boolean existsByIdRoleAndLibelle(int idRole, String libelle);

    Optional<RoleEntity> findById(int idRole);

}
