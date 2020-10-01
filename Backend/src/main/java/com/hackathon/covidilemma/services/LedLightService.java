package com.hackathon.covidilemma.services;

import com.hackathon.covidilemma.models.dtos.LedConfig;
import com.hackathon.covidilemma.models.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

@Service
public class LedLightService {

  private RetrofitServiceGenerator retrofitServiceGenerator;

  @Autowired
  public LedLightService(RetrofitServiceGenerator retrofitServiceGenerator) {
    this.retrofitServiceGenerator = retrofitServiceGenerator;
  }

  private static final String COUNTER = "{\"controller\":{\"controllerType\":\"Timer\",\"controllerDescriptor\":{\"initialActions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":0,\"length\":20,\"headColor\":{\"r\":0,\"g\":255,\"b\":0},\"headIntensity\":1}}],\"timerActions\":[{\"initialDelay\":1000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":20,\"length\":40,\"headColor\":{\"r\":0,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":2000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":40,\"length\":60,\"headColor\":{\"r\":0,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":3000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":60,\"length\":80,\"headColor\":{\"r\":255,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":3000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":60,\"length\":80,\"headColor\":{\"r\":255,\"g\":255,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":4000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":80,\"length\":100,\"headColor\":{\"r\":255,\"g\":140,\"b\":0},\"headIntensity\":1}}]},{\"initialDelay\":5000,\"actions\":[{\"actionType\":\"CreateSegment\",\"actionDescriptor\":{\"headPosition\":100,\"length\":120,\"headColor\":{\"r\":255,\"g\":0,\"b\":0},\"headIntensity\":1}}]}]}}}";

  public LedConfig getCounterConfig() {
    return new LedConfig(COUNTER);
  }

  public void controllLeds() {
    LedService ledService = RetrofitServiceGenerator.createService(LedService.class);
    LedConfig ledConfig = getCounterConfig();
    Call<LedConfig> callSync = ledService.turnLedsOn(ledConfig);
    try {
      callSync.execute();
    } catch (IOException e) {
      e.printStackTrace();
    }
    /*try {
      Response<LedConfig> response = callSync.execute();
      ledConfig = response.body();
    } catch (IOException e) {
      System.err.println();
    }*/
  }

  public void stop() {
    LedService ledService = RetrofitServiceGenerator.createService(LedService.class);

    Call<LedConfig> callSync = ledService.stop();
    try {
      callSync.execute();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void lock(Reservation reservation) {
    LedService ledService = RetrofitServiceGenerator.createService(LedService.class);

    Call<Reservation> callSync = ledService.lock(reservation);
    try {
      callSync.execute();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
    /*callAsync.enqueue(new Callback<LedConfig>() {
      @Override
      public void onResponse(Call<LedConfig> call, Response<LedConfig> response) {
        LedConfig ledConfig = response.body();
      }

      @Override
      public void onFailure(Call<LedConfig> call, Throwable t) {
        System.err.println();
      }
    });
  }*/
  public void unlock() {
    LedService ledService = RetrofitServiceGenerator.createService(LedService.class);

    Call<LedConfig> callSync = ledService.unlock();
    try {
      callSync.execute();
    } catch (IOException e) {
      e.printStackTrace();
    }
    /*callAsync.enqueue(new Callback<LedConfig>() {
      @Override
      public void onResponse(Call<LedConfig> call, Response<LedConfig> response) {
        LedConfig ledConfig = response.body();
      }

      @Override
      public void onFailure(Call<LedConfig> call, Throwable t) {
        System.err.println();
      }
    });*/
  }


}
