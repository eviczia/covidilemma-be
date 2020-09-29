package com.hackathon.covidilemma.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String question;
  private String rightAnswer;
  private List<String> wrongAnswers;
  @ManyToOne
  private Game game;

  public Question() {
  }

  public Question(String question, String rightAnswer, List<String> wrongAnswers) {
    this.question = question;
    this.rightAnswer = rightAnswer;
    this.wrongAnswers = wrongAnswers;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getRightAnswer() {
    return rightAnswer;
  }

  public void setRightAnswer(String rightAnswer) {
    this.rightAnswer = rightAnswer;
  }

  public List<String> getWrongAnswers() {
    return wrongAnswers;
  }

  public void setWrongAnswers(List<String> wrongAnswers) {
    this.wrongAnswers = wrongAnswers;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}
