package com.sam_chordas.android.stockhawk.app.retofit.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by android4 on 4/6/16.
 */
public class ResponseQuotes {

    @SerializedName("query")
    @Expose
    private Queries queries;

    /**
     * @return The query
     */
    public Queries getQuery() {
        return queries;
    }

    /**
     * @param queries The query
     */
    public void setQuery(Queries queries) {
        this.queries = queries;
    }

}
