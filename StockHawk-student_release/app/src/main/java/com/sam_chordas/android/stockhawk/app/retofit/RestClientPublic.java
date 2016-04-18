package com.sam_chordas.android.stockhawk.app.retofit;


import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.App;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Copyright (C) 2015 The Android Open Source Project
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class RestClientPublic {

    private static String BASE_URL;
    private ApiService apiService;
    private PublicService publicService;

    public RestClientPublic(String baseUrl) {
        this.BASE_URL = baseUrl;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();


        this.apiService = retrofit.create(ApiService.class);
        this.publicService = new PublicService(getApiService());
    }

    private ApiService getApiService() {
        return this.apiService;
    }

    public PublicService getPublicService() {
        return this.publicService;
    }

    private OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(interceptor);

        client.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.httpUrl().newBuilder()
                        .addQueryParameter(
                                App.getGlobalContext().getString(R.string.url_query_format),
                                App.getGlobalContext().getString(R.string.url_query_json))
                        .addQueryParameter(
                                App.getGlobalContext().getString(R.string.url_query_diagnostics),
                                App.getGlobalContext().getString(R.string.url_query_diagnostics_value))
                        .addQueryParameter(
                                App.getGlobalContext().getString(R.string.url_query_evn),
                                App.getGlobalContext().getString(R.string.url_query_evn_value))
                        .build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);

            }
        });
        return client;
    }

}
