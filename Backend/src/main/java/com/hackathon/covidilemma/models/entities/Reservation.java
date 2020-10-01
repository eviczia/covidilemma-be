package com.hackathon.covidilemma.models.entities;


public class Reservation {

  private Integer duration;

  public Reservation() {
  }

  public Reservation(Integer duration) {
    this.duration = duration;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }
}
