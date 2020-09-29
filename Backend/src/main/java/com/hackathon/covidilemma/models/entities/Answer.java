package com.hackathon.covidilemma.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String answer;
  private boolean isCorrect;

  public Answer() {
  }

  public Answer(String answer, boolean isCorrect) {
    this.answer = answer;
    this.isCorrect = isCorrect;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public boolean isCorrect() {
    return isCorrect;
  }

  public void setCorrect(boolean correct) {
    isCorrect = correct;
  }

}
