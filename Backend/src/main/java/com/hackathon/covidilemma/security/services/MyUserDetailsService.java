package com.hackathon.covidilemma.security.services;

import com.hackathon.covidilemma.models.entities.Player;
import com.hackathon.covidilemma.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("my")
public class MyUserDetailsService implements UserDetailsService {

  private PlayerRepository playerRepository;

  @Autowired
  public MyUserDetailsService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Player> user = playerRepository.findByUsername(username);

    if (!user.isPresent()) {
      throw new UsernameNotFoundException("Invalid username and password!");
    } else {
      return user.get();
    }
  }
}
