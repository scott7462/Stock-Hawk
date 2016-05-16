package com.sam_chordas.android.stockhawk.app.busevents.events;

import android.view.View;

/**
 * Created by scott7462 on 4/9/16.
 */
public class EventSnackbarMessage {

    private String text;
    private String actionLabel;
    private int textId;
    private int textColor;
    private int actionLabelColor;
    private View.OnClickListener eventListener;
    private Runnable[] onAttachedToWindowRunnable;
    private Runnable[] onDetachedToWindowRunnable;
    private boolean centered;
    private boolean actionDismiss;
    private View view;

    public EventSnackbarMessage(String text, View view) {
        this.text = text;
        this.view = view;
    }

    public EventSnackbarMessage(View view) {
        this.view = view;
    }

    public EventSnackbarMessage(String text) {
        this.text = text;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getText() {
        return this.text;
    }

    public EventSnackbarMessage setText(String text) {
        this.text = text;
        return this;
    }

    public String getActionLabel() {
        return this.actionLabel;
    }

    public EventSnackbarMessage setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
        return this;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getActionLabelColor() {
        return this.actionLabelColor;
    }

    public void setActionLabelColor(int actionLabelColor) {
        this.actionLabelColor = actionLabelColor;
    }

    public int getTextId() {
        return this.textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public View.OnClickListener getEventListener() {
        return this.eventListener;
    }

    public EventSnackbarMessage setEventListener(View.OnClickListener eventListener) {
        this.eventListener = eventListener;
        return this;
    }

    public Runnable[] getOnAttachedToWindowRunnable() {
        return this.onAttachedToWindowRunnable;
    }

    public EventSnackbarMessage setOnAttachedToWindowRunnable(Runnable[] onAttachedToWindowRunnable) {
        this.onAttachedToWindowRunnable = onAttachedToWindowRunnable;
        return this;
    }

    public Runnable[] getOnDetachedToWindowRunnable() {
        return this.onDetachedToWindowRunnable;
    }

    public EventSnackbarMessage setOnDetachedToWindowRunnable(Runnable[] onDetachedToWindowRunnable) {
        this.onDetachedToWindowRunnable = onDetachedToWindowRunnable;
        return this;
    }

    public void setCentered(boolean centered) {
        this.centered = centered;
    }

    public boolean isCentered() {
        return this.centered;
    }

    public void setActionDismiss(boolean actionDismiss) {
        this.actionDismiss = actionDismiss;
    }

    public boolean isActionDismiss() {
        return this.actionDismiss;
    }

}
