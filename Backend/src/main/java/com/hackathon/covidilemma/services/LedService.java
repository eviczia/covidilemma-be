package com.hackathon.covidilemma.services;

import com.hackathon.covidilemma.models.dtos.LedConfig;
import com.hackathon.covidilemma.models.entities.Reservation;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LedService {

  final String KEY = "5d31ef37-2484-4075-baa3-14f9c0c90fd2";

  @POST("/send/{KEY}")
  Call<LedConfig> turnLedsOn(@Body LedConfig ledConfig);

  @POST("/stop/{KEY}")
  Call<LedConfig> stop();

  @POST ("/lock/{KEY}")
  Call<LedConfig> lock(@Body Reservation reservation);

  @POST("/unlock/{KEY}")
  Call<LedConfig> unlock();
}
