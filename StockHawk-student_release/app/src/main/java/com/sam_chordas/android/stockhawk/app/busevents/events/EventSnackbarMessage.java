package com.sam_chordas.android.stockhawk.app.busevents.events;

import android.view.View;
/**
 * Copyright (C) 2015 The Android Open Source Project
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
