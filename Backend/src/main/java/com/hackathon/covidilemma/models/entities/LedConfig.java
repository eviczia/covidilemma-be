package com.hackathon.covidilemma.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LedConfig {

  @Id
  @JsonIgnore
  private Integer id;
  @JsonIgnore
  private String name;
  private String configText;

  public LedConfig() {
  }

  public LedConfig(String name, String configText) {
    this.name = name;
    this.configText = configText;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getConfigText() {
    return configText;
  }

  public void setConfigText(String configText) {
    this.configText = configText;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
