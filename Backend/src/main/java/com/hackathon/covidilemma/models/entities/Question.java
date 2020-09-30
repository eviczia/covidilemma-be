package com.hackathon.covidilemma.models.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String question;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Answer> answers;

  public Question() {
  }

  public Question(String question) {
    this.question = question;
    answers = new ArrayList<>();
  }

  public Question(String question, String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
    this(question);
    setAnswers(new ArrayList<>(Arrays.asList(
        new Answer(rightAnswer, true),
        new Answer(wrongAnswer1, false),
        new Answer(wrongAnswer2, false),
        new Answer(wrongAnswer3, false)
    )));
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

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

  public void addAnswer(Answer answer) {
    answers.add(answer);
  }

}
