package com.sam_chordas.android.stockhawk.app.retofit;


import com.sam_chordas.android.stockhawk.app.retofit.Response.ResponseQuote;
import com.sam_chordas.android.stockhawk.app.retofit.Response.ResponseQuoteHistory;
import com.sam_chordas.android.stockhawk.app.retofit.Response.ResponseQuotes;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

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
public interface ApiService {

    @GET("yql")
    Call<ResponseQuote> getQuote(@Query("q") String q);


    @GET("yql")
    Call<ResponseQuotes> getQuotes(@Query("q") String q);


    @GET("yql")
    Call<ResponseQuoteHistory> getQuoteHistory(@Query("q") String q);
}
