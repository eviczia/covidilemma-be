package com.hackathon.covidilemma.controllers;

import com.hackathon.covidilemma.models.entities.Reservation;
import com.hackathon.covidilemma.services.LedLightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {

  private LedLightService ledLightService;

  @Autowired
  public LedController(LedLightService ledLightService) {
    this.ledLightService = ledLightService;
  }

  @PostMapping("/leds")
  public ResponseEntity lightUp() {
    ledLightService.controllLeds();
    return ResponseEntity.ok().build();
  }

  @PostMapping("/stop")
  public ResponseEntity stop() {
    ledLightService.stop();
    return ResponseEntity.ok().build();
  }

  @PostMapping("/lock")
  public ResponseEntity lock(@RequestBody Reservation reservation) {
    ledLightService.lock(reservation);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/unlock")
  public ResponseEntity unlock() {
    ledLightService.unlock();
    return ResponseEntity.ok().build();
  }
}
