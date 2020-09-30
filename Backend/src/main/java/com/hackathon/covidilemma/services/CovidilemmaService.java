package com.hackathon.covidilemma.services;

import com.hackathon.covidilemma.models.entities.Player;
import com.hackathon.covidilemma.models.entities.Question;

import java.util.List;

public interface CovidilemmaService {

  void addNewPlayer(Player player);

  List<Question> getQuestions();

  void addQuestion(Question question);
}
