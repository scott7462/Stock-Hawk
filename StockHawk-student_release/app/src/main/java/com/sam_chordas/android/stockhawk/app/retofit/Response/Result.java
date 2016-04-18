package com.sam_chordas.android.stockhawk.app.retofit.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sam_chordas.android.stockhawk.app.model.Quote;

/**
 * Created by android4 on 4/6/16.
 */
public class Result {

    @SerializedName("quote")
    @Expose
    private Quote quote;

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}