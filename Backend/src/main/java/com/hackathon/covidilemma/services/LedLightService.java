package com.hackathon.covidilemma.services;

import com.hackathon.covidilemma.models.entities.LedConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Service
public class LedLightService {

  private RetrofitServiceGenerator retrofitServiceGenerator;

  @Autowired
  public LedLightService(RetrofitServiceGenerator retrofitServiceGenerator) {
    this.retrofitServiceGenerator = retrofitServiceGenerator;
  }

  public void controllLeds(LedConfig ledConfig) {
    LedService ledService = retrofitServiceGenerator.createService(LedService.class);

    Call<LedConfig> callAsync = ledService.turnLedsOn(ledConfig);
    callAsync.enqueue(new Callback<LedConfig>() {
      @Override
      public void onResponse(Call<LedConfig> call, Response<LedConfig> response) {
        LedConfig ledConfig = response.body();
      }

      @Override
      public void onFailure(Call<LedConfig> call, Throwable t) {
        System.err.println();
      }
    });
  }
}
