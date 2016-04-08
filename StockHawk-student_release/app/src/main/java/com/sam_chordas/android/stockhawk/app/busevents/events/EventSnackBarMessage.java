package com.sam_chordas.android.stockhawk.app.busevents.events;

import android.view.View;

import java.util.EventListener;

/**
 * Created by kogiandroiddavid on 2/24/15.
 */
public class EventSnackBarMessage {
    private String text;
    private String actionLabel;
    private String mCancelText;
    private View recycledView;
    private View.OnClickListener onActionListener;
    private View.OnAttachStateChangeListener dissmisListener;
    private EventListener eventListener;

    public EventSnackBarMessage() {
    }

    public EventSnackBarMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public String getmCancelText() {
        return mCancelText;
    }

    public void setmCancelText(String mCancelText) {
        this.mCancelText = mCancelText;
    }

    public View.OnClickListener getOnActionListener() {
        return onActionListener;
    }

    public void setOnActionListener(View.OnClickListener onActionListener) {
        this.onActionListener = onActionListener;
    }

    public EventListener getEventListener() {
        return eventListener;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public interface OnActionListener {
        public void onActionClicked();
    }

    public View.OnAttachStateChangeListener getDissmisListener() {
        return dissmisListener;
    }

    public void setDissmisListener(View.OnAttachStateChangeListener dissmisListener) {
        this.dissmisListener = dissmisListener;
    }
}
