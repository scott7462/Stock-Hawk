package com.sam_chordas.android.stockhawk.app.busevents;

public final class BusProvider {
    private static final UIBus BUS = new UIBus();

    public static UIBus getInstance() {
        return BUS;
    }

    private BusProvider() {
    }
}