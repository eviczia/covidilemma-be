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
    String counter = "{\"controller\":{\"controllerType\":\"Timer\",\"controllerDescriptor\":{\"initialActions\":[],\"timerActions\":[{\"initialDelay\":0,\"repetitionDelay\":100000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":10,\"length\":20,\"headColor\":{\"r\":0,\"g\":255,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]},{\"initialDelay\":1000,\"repetitionDelay\":100000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":20,\"length\":30,\"headColor\":{\"r\":30,\"g\":255,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]},{\"initialDelay\":2000,\"repetitionDelay\":100000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":30,\"length\":40,\"headColor\":{\"r\":102,\"g\":255,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]},{\"initialDelay\":3000,\"repetitionDelay\":100000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":40,\"length\":50,\"headColor\":{\"r\":174,\"g\":255,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]},{\"initialDelay\":4000,\"repetitionDelay\":100000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":50,\"length\":60,\"headColor\":{\"r\":204,\"g\":255,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]},{\"initialDelay\":5000,\"repetitionDelay\":100000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":60,\"length\":70,\"headColor\":{\"r\":255,\"g\":255,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]},{\"initialDelay\":6000,\"repetitionDelay\":100000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":70,\"length\":80,\"headColor\":{\"r\":255,\"g\":204,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]},{\"initialDelay\":7000,\"repetitionDelay\":1000000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":80,\"length\":90,\"headColor\":{\"r\":255,\"g\":145,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]},{\"initialDelay\":8000,\"repetitionDelay\":1000000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":90,\"length\":100,\"headColor\":{\"r\":255,\"g\":115,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]},{\"initialDelay\":9000,\"repetitionDelay\":10000000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":100,\"length\":110,\"headColor\":{\"r\":255,\"g\":77,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]},{\"initialDelay\":10000,\"repetitionDelay\":10000000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":110,\"length\":120,\"headColor\":{\"r\":255,\"g\":42,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]},{\"initialDelay\":11000,\"repetitionDelay\":10000000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":120,\"length\":120,\"headColor\":{\"r\":255,\"g\":0,\"b\":0},\"headIntensity\":1,\"priority\":0,\"transforms\":[]}}]}]}}}";
    buildRetrofit();
    lock(lockDuration);
    lightUp((new LedConfig(counter)));
  }

  private void buildRetrofit() {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://backend.bassboost.hu/hackathon/")
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
