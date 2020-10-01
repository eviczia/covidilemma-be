package com.hackathon.covidilemma.services;

import com.hackathon.covidilemma.models.dtos.LedConfig;
import com.hackathon.covidilemma.models.entities.Reservation;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class LedLightService {

  private LedService ledService;

  public void controllLeds() {
    int lockDuration = 5;
    String counter = "{\"controller\":{\"controllerType\":\"Timer\",\"controllerDescriptor\":{\"initialActions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":0,\"length\":20,\"headColor\":{\"r\":0,\"g\":255,\"b\":0},\"headIntensity\":1}}],\"timerActions\":[{\"initialDelay\":1000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":20,\"length\":40,\"headColor\":{\"r\":0,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":2000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":40,\"length\":60,\"headColor\":{\"r\":0,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":3000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":60,\"length\":80,\"headColor\":{\"r\":255,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":3000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":60,\"length\":80,\"headColor\":{\"r\":255,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":4000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":80,\"length\":100,\"headColor\":{\"r\":255,\"g\":140,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":5000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":100,\"length\":120,\"headColor\":{\"r\":255,\"g\":0,\"b\":0},\"headIntensity\":1}}]}]}}}";

    buildRetrofit();
    lock(lockDuration);
    lightUp((new LedConfig(counter)));
  }

  private void buildRetrofit() {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://covidilemma.free.beeceptor.com/")
//        .baseUrl("http://backend.bassboost.hu/hackathon/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build();
    ledService = retrofit.create(LedService.class);
  }

  public void lock(int duration) {

    Call<Reservation> callSync = ledService.lock(duration);
    try {
      callSync.execute();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void lightUp(LedConfig ledConfig) {
    Call<LedConfig> callSync = ledService.turnLedsOn(ledConfig);
    try {
      callSync.execute();
    } catch (Exception ex) {
      System.err.println();
    }
  }

  public void end() {
    stop();
    unlock();
  }

  public void stop() {
    Call<LedConfig> callSync = ledService.stop();
    try {
      callSync.execute();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void unlock() {
    Call<LedConfig> callSync = ledService.unlock();
    try {
      callSync.execute();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
