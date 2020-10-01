package com.hackathon.covidilemma.services;

import com.hackathon.covidilemma.models.dtos.Scores;
import com.hackathon.covidilemma.models.entities.Player;
import com.hackathon.covidilemma.models.entities.Question;
import com.hackathon.covidilemma.models.entities.Score;
import com.hackathon.covidilemma.repositories.PlayerRepository;
import com.hackathon.covidilemma.repositories.QuestionRepository;
import com.hackathon.covidilemma.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidilemmaServiceImpl implements CovidilemmaService {

  private PlayerRepository playerRepository;
  private QuestionRepository questionRepository;
  private ScoreRepository scoreRepository;
  private LedLightService ledLightService;

  @Autowired
  public CovidilemmaServiceImpl(PlayerRepository playerRepository, QuestionRepository questionRepository,
                                ScoreRepository scoreRepository, LedLightService ledLightService) {
    this.playerRepository = playerRepository;
    this.questionRepository = questionRepository;
    this.scoreRepository = scoreRepository;
    this.ledLightService = ledLightService;
  }

  public List<Question> getQuestions() {
    ledLightService.controllLeds();
    return questionRepository.findAll();
  }

  @Override
  public void addQuestion(Question question) {
    questionRepository.save(question);
  }

  @Override
  public Player addNewPlayer(Player player) {
    if (player.getUsername().isEmpty()) {
      player.setUsername("Anonymus");
    }
    return playerRepository.save(player);
  }

  @Override
  public Score saveScore(Score score) {
    return scoreRepository.save(score);
  }

  @Override
  public Scores listScores() {
    return new Scores(scoreRepository.findAll());
  }

}
