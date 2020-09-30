package com.hackathon.covidilemma.controllers;

import com.hackathon.covidilemma.models.entities.Player;
import com.hackathon.covidilemma.models.entities.Score;
import com.hackathon.covidilemma.services.CovidilemmaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidillemmaController {

  private CovidilemmaServiceImpl covidilemmaService;

  @Autowired
  public CovidillemmaController(CovidilemmaServiceImpl covidilemmaService) {
    this.covidilemmaService = covidilemmaService;
  }

  @GetMapping("/quiz")
  public ResponseEntity getQuestions() {
   return ResponseEntity.status(200).body(covidilemmaService.getQuestions());
  }

  @PostMapping("/login")
  public ResponseEntity addNewPlayer(@RequestBody Player player) {
    return ResponseEntity.status(200).body(covidilemmaService.addNewPlayer(player));
  }

  @PostMapping("/score")
  public ResponseEntity saveScore(@RequestBody Score score) {
    return ResponseEntity.status(200).body(covidilemmaService.saveScore(score));
  }

  @GetMapping("/scores")
  public ResponseEntity showScores() {
    return ResponseEntity.status(200).body(covidilemmaService.listScores());
  }
}
