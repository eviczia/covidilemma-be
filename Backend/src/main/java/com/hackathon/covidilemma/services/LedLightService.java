package com.hackathon.covidilemma.services;

import com.hackathon.covidilemma.models.dtos.LedConfig;
import com.hackathon.covidilemma.models.entities.Reservation;
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

  public void controllLeds() {
    LedService ledService = retrofitServiceGenerator.createService(LedService.class);
    final LedConfig[] ledConfig = {getCounterConfig()};
    Call<LedConfig> callAsync = ledService.turnLedsOn(ledConfig[0]);
    callAsync.enqueue(new Callback<LedConfig>() {
      @Override
      public void onResponse(Call<LedConfig> call, Response<LedConfig> response) {
        ledConfig[0] = response.body();
      }

      @Override
      public void onFailure(Call<LedConfig> call, Throwable t) {
        System.err.println();
      }
    });
  }

  public void stop() {
    LedService ledService = retrofitServiceGenerator.createService(LedService.class);

    Call<LedConfig> callAsync = ledService.stop();
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

  public void lock(Reservation reservation) {
    LedService ledService = retrofitServiceGenerator.createService(LedService.class);

    Call<LedConfig> callAsync = ledService.lock(reservation);
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
  public void unlock() {
    LedService ledService = retrofitServiceGenerator.createService(LedService.class);

    Call<LedConfig> callAsync = ledService.unlock();
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

  private static final String COUNTER = "{\"controller\":{\"controllerType\":\"Timer\",\"controllerDescriptor\":{\"initialActions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":0,\"length\":20,\"headColor\":{\"r\":0,\"g\":255,\"b\":0},\"headIntensity\":1}}],\"timerActions\":[{\"initialDelay\":1000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":20,\"length\":40,\"headColor\":{\"r\":0,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":2000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":40,\"length\":60,\"headColor\":{\"r\":0,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":3000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":60,\"length\":80,\"headColor\":{\"r\":255,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":3000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":60,\"length\":80,\"headColor\":{\"r\":255,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":4000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":80,\"length\":100,\"headColor\":{\"r\":255,\"g\":140,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":5000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":100,\"length\":120,\"headColor\":{\"r\":255,\"g\":0,\"b\":0},\"headIntensity\":1}}]}]}}}";

  public LedConfig getCounterConfig() {
    return new LedConfig(COUNTER);
  }
}
