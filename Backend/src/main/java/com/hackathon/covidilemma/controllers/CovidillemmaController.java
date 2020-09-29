package com.hackathon.covidilemma.controllers;

import com.hackathon.covidilemma.services.CovidilemmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidillemmaController {

  private CovidilemmaService covidilemmaService;

  @Autowired
  public CovidillemmaController(CovidilemmaService covidilemmaService) {
    this.covidilemmaService = covidilemmaService;
  }


}
