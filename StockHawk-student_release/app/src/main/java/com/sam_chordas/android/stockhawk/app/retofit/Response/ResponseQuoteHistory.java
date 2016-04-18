package com.sam_chordas.android.stockhawk.app.retofit.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by android4 on 4/6/16.
 */
public class ResponseQuoteHistory {

    @SerializedName("query")
    @Expose
    private QueryHistory query;

    public QueryHistory getQuery() {
        return query;
    }

    public void setQuery(QueryHistory query) {
        this.query = query;
    }
}
