package com.hackathon.covidilemma.services;

import com.hackathon.covidilemma.models.entities.Question;

import java.util.List;

public interface CovidilemmaService {

  void addNewPlayer(String name);
  List<Question> getQuestions();

}
