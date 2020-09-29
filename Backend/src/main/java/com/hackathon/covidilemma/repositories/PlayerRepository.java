package com.hackathon.covidilemma.repositories;

import com.hackathon.covidilemma.models.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

  Optional<Player> findByUsername(String username);

}
