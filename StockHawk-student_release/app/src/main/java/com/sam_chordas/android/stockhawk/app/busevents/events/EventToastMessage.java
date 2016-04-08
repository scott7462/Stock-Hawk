package com.sam_chordas.android.stockhawk.app.busevents.events;

/**
 * Created by Julian Cardona on 11/20/14.
 */
public class EventToastMessage {

    private String message;

    public EventToastMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
