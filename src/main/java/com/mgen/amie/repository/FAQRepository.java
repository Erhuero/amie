package com.mgen.amie.repository;


import com.mgen.amie.entity.FAQEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface FAQRepository extends JpaRepository<FAQEntity, Integer> {

    @Query("SELECT f FROM FAQ f WHERE f.question = ?1 AND f.description = ?2")
    public boolean existsByQuestionAndDescription(String question, String description);

    @Query("SELECT f FROM FAQ f WHERE f.idFAQ = ?1")
    public boolean existsByIdFAQ(int idFAQ);

    @Query("SELECT f FROM FAQ f WHERE f.question = ?1")
    public boolean existsByQuestion(String question);

    @Transactional
    @Modifying
    @Query("DELETE FROM FAQ f WHERE f.idFAQ = ?1")
    public int deleteFAQEntitiesByIdFAQ(int idFAQ);

    @Transactional
    @Modifying
    @Query("DELETE FROM FAQ f WHERE f.question = ?1")
    public int deleteFAQEntitiesByQuestion(String question);


}

