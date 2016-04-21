package com.sam_chordas.android.stockhawk.app.busevents.events;

/**
 * Created by android4 on 4/8/16.
 */
public class EventUpdateData {
    private final int result;
    private String tag;

    public EventUpdateData(int result, String tag) {
        this.result = result;
        this.tag = tag;
    }

    public int getResult() {
        return result;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
