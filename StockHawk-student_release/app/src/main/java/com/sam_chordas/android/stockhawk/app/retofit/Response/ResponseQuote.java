package com.sam_chordas.android.stockhawk.app.retofit.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by android4 on 4/6/16.
 */
public class ResponseQuote {

    @SerializedName("Query")
    @Expose
    private Query Query;

    @SerializedName("results")
    @Expose
    private Result result;

    /**
     * @return The Query
     */
    public Query getQuery() {
        return Query;
    }

    /**
     * @param Query The Query
     */
    public void setQuery(Query Query) {
        this.Query = Query;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
