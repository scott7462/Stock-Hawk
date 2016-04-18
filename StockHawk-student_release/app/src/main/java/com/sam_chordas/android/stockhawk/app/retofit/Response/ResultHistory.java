package com.sam_chordas.android.stockhawk.app.retofit.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sam_chordas.android.stockhawk.app.model.Quote;
import com.sam_chordas.android.stockhawk.app.model.QuoteHistory;

import java.util.ArrayList;

/**
 * Created by android4 on 4/6/16.
 */
public class ResultHistory {

    @SerializedName("quote")
    @Expose
    private ArrayList<QuoteHistory> quote;

    public ArrayList<QuoteHistory> getQuote() {
        return quote;
    }

    public void setQuote(ArrayList<QuoteHistory> quote) {
        this.quote = quote;
    }
}
