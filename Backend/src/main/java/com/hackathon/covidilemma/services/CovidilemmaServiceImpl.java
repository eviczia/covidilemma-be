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

  @Autowired
  public CovidilemmaServiceImpl(PlayerRepository playerRepository, QuestionRepository questionRepository,
                                ScoreRepository scoreRepository) {
    this.playerRepository = playerRepository;
    this.questionRepository = questionRepository;
    this.scoreRepository = scoreRepository;
  }

  public List<Question> getQuestions() {
/*    Question question = new Question(
        "How are you?",
        "Absolutely marvelous, thank you for asking.",
        "Not bad, not bad",
        "Jolly well, how are you?",
        "Splendid!"
    );
    addQuestion(question);*/
    return questionRepository.findAll();
  }

  @Override
  public void addQuestion(Question question) {
    questionRepository.save(question);
  }

  @Override
  public Player addNewPlayer (Player player){
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
