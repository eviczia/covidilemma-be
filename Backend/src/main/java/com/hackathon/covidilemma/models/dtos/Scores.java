package com.hackathon.covidilemma.models.dtos;

import com.hackathon.covidilemma.models.entities.Score;

import java.util.List;

public class Scores {

  private List<Score> results;

  public Scores() {
  }

  public Scores(List<Score> results) {
    this.results = results;
  }

  public List<Score> getResults() {
    return results;
  }

  public void setResults(List<Score> results) {
    this.results = results;
  }

}
