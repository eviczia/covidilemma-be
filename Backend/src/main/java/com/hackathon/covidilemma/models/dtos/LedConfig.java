package com.hackathon.covidilemma.models.dtos;

public class LedConfig {

  private String configText;

  public LedConfig() {
  }

  public LedConfig(String configText) {
    this.configText = configText;
  }

  public String getConfigText() {
    return configText;
  }

  public void setConfigText(String configText) {
    this.configText = configText;
  }

}
