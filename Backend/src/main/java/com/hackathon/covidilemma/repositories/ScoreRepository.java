package com.hackathon.covidilemma.repositories;

import com.hackathon.covidilemma.models.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
