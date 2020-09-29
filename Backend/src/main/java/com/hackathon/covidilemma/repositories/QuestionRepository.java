package com.hackathon.covidilemma.repositories;

import com.hackathon.covidilemma.models.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {


}
