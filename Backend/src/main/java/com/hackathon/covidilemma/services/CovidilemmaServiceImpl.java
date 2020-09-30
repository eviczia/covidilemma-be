package com.hackathon.covidilemma.services;

import com.hackathon.covidilemma.models.entities.Player;
import com.hackathon.covidilemma.models.entities.Question;
import com.hackathon.covidilemma.repositories.PlayerRepository;
import com.hackathon.covidilemma.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidilemmaServiceImpl implements CovidilemmaService {

  private PlayerRepository playerRepository;
  private QuestionRepository questionRepository;

  @Autowired
  public CovidilemmaServiceImpl(PlayerRepository playerRepository, QuestionRepository questionRepository) {
    this.playerRepository = playerRepository;
    this.questionRepository = questionRepository;
  }

  public List<Question> getQuestions() {
    Question question = new Question(
        "How are you?",
        "Absolutely marvelous, thank you for asking.",
        "Not bad, not bad",
        "Jolly well, how are you?",
        "Splendid!"
        );
    addQuestion(question);
   return questionRepository.findAll();
  }

  @Override
  public void addQuestion(Question question) {
    questionRepository.save(question);
  }

  @Override
  public void addNewPlayer(Player player) {
    playerRepository.save(player);
  }
}
