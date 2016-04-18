package com.sam_chordas.android.stockhawk.app.utils.decoreitors;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.App;

/**
 * Created by scott7462 on 4/17/16.
 */
public class QuoteItemDecorator extends RecyclerView.ItemDecoration {

    private final int spacing;

    public QuoteItemDecorator() {
        spacing = App.getGlobalContext().getResources().getDimensionPixelSize(R.dimen.default_small_size);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = spacing;
        outRect.right = spacing;
        outRect.top = spacing;
        outRect.bottom = spacing;
    }
}