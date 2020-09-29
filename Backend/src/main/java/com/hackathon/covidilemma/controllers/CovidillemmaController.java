package com.hackathon.covidilemma.controllers;

import com.hackathon.covidilemma.models.dtos.NewPlayer;
import com.hackathon.covidilemma.services.CovidilemmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidillemmaController {

  private CovidilemmaService covidilemmaService;

  @Autowired
  public CovidillemmaController(CovidilemmaService covidilemmaService) {
    this.covidilemmaService = covidilemmaService;
  }

  @PostMapping("/login")
  public ResponseEntity addNewPlayer(@RequestBody NewPlayer name) {
    covidilemmaService.addNewPlayer(name.getName());
    return ResponseEntity.ok().build();
  }

}
