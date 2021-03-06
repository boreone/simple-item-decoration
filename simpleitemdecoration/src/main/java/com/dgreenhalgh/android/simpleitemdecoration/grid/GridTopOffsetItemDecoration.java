package com.dgreenhalgh.android.simpleitemdecoration.grid;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Adds an offset to the top of a RecyclerView with a GridLayoutManager or its
 * subclass.
 */
public class GridTopOffsetItemDecoration extends RecyclerView.ItemDecoration {

    private int mOffsetPx;
    private int mNumColumns;

    /**
     * Sole constructor. Takes in the size of the offset to be added to the top
     * of the RecyclerView.
     *
     * @param offsetPx The size of the offset to be added to the top of the
     *                 RecyclerView in pixels
     * @param numColumns The number of columns in the grid of the RecyclerView
     */
    public GridTopOffsetItemDecoration(int offsetPx, int numColumns) {
        mOffsetPx = offsetPx;
        mNumColumns = numColumns;
    }

    /**
     * Determines the size and the location of the offset to be added to the
     * top of the RecyclerView.
     *
     * @param outRect The {@link Rect} of offsets to be added around the child view
     * @param view The child view to be decorated with an offset
     * @param parent The RecyclerView onto which dividers are being added
     * @param state The current RecyclerView.State of the RecyclerView
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        boolean childIsInTopRow = parent.getChildAdapterPosition(view) < mNumColumns;
        if (childIsInTopRow) {
            outRect.top = mOffsetPx;
        }
    }
}
