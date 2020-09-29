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
 /*   List<Answer> answers = new ArrayList<>()
    Question question = new Question(

        "How do you like this Hackathon?",
        new ArrayList<String>("Oh, it's absolutely marvelous", "It's not bad, I guess", "It sucks"),

        );
    questionRepository.save(, new Game())))
   */ return questionRepository.findAll();
  }

  @Override
  public void addNewPlayer(Player player) {
    playerRepository.save(player);
  }
}
