package com.sam_chordas.android.stockhawk.app.retofit.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by android4 on 4/6/16.
 */
public class ResponseQuote {

    @SerializedName("query")
    @Expose
    private Query query;

    /**
     * @return The query
     */
    public Query getQuery() {
        return query;
    }

    /**
     * @param Query The query
     */
    public void setQuery(Query Query) {
        this.query = Query;
    }

}
