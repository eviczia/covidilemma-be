package com.hackathon.covidilemma.models.entities;

import javax.persistence.*;

@Entity
public class Role {
  @Id
  @Column(unique = true)
  public String name;
  @OneToOne
  public Player player;

  public Role() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

}
