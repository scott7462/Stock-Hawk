package com.sam_chordas.android.stockhawk.app.retofit.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sam_chordas.android.stockhawk.app.model.Quote;

import java.util.ArrayList;

/**
 * Created by android4 on 4/6/16.
 */
public class Results {

    @SerializedName("quote")
    @Expose
    private ArrayList<Quote> quote;

    public ArrayList<Quote> getQuote() {
        return quote;
    }

    public void setQuote(ArrayList<Quote> quote) {
        this.quote = quote;
    }
}
