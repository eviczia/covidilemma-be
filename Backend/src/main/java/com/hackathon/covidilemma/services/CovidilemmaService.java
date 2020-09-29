package com.hackathon.covidilemma.services;

import com.hackathon.covidilemma.models.entities.Player;
import com.hackathon.covidilemma.models.entities.Role;
import com.hackathon.covidilemma.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidilemmaService implements CovidilemmaServiceImpl{

  private PlayerRepository playerRepository;

  @Autowired
  public CovidilemmaService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  @Override
  public void addNewPlayer(String name) {
    playerRepository.save(new Player(name));
  }

}
