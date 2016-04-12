package com.sam_chordas.android.stockhawk.app.busevents.events;

/**
 * Created by android4 on 4/8/16.
 */
public class EventUpdateData {
    private final int result;

    public EventUpdateData(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
