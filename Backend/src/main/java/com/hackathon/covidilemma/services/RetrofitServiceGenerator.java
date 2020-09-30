package com.hackathon.covidilemma.services;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class RetrofitServiceGenerator {

  public RetrofitServiceGenerator() {
  }

  private static Retrofit.Builder builder
      = new Retrofit.Builder()
      .baseUrl("http://backend.bassboost.hu/hackathon/")
      .addConverterFactory(GsonConverterFactory.create());

  private static Retrofit retrofit = builder.build();

  private static OkHttpClient.Builder httpClient
      = new OkHttpClient.Builder();

  public static <S> S createService(Class<S> serviceClass) {
    return retrofit.create(serviceClass);
  }
}

