package com.hackathon.covidilemma.services;

import com.hackathon.covidilemma.models.dtos.Scores;
import com.hackathon.covidilemma.models.entities.Player;
import com.hackathon.covidilemma.models.entities.Question;
import com.hackathon.covidilemma.models.entities.Score;

import java.util.List;

public interface CovidilemmaService {

  Player addNewPlayer(Player player);

  List<Question> getQuestions();

  Score saveScore(Score result);

  Scores listScores();

}
