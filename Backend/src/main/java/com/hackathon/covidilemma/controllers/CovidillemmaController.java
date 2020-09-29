package com.hackathon.covidilemma.controllers;

import com.hackathon.covidilemma.models.dtos.NewPlayer;
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
  public ResponseEntity addNewPlayer(@RequestBody NewPlayer name) {
    covidilemmaService.addNewPlayer(name.getName());
    return ResponseEntity.ok().build();
  }

}
