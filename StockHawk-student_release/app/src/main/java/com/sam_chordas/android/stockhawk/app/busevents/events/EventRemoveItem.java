package com.sam_chordas.android.stockhawk.app.busevents.events;

/**
 * Created by scott7462 on 4/17/16.
 */
public class EventRemoveItem {
    private int position;

    public EventRemoveItem(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
