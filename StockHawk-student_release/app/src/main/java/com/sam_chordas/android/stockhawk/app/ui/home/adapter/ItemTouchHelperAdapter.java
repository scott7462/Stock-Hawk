package com.sam_chordas.android.stockhawk.app.ui.home.adapter;

/**
 * Created by scott7462 on 4/17/16.
 */
public interface ItemTouchHelperAdapter {
    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
