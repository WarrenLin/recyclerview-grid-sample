package com.gridrecycleview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Warren on 2018/3/7.
 */

public class GridHorizontalSpacingItemDecoration extends RecyclerView.ItemDecoration{

    private final int spacingInPx;
    private final int spanCount;

    public GridHorizontalSpacingItemDecoration(int spacingInPx, int spanCount) {
        this.spacingInPx = spacingInPx;
        this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = spacingInPx;
        outRect.right = spacingInPx;
        outRect.top = spacingInPx;
        outRect.bottom = 0;

        int totalCount = state.getItemCount();
        int totalColumn = totalCount/spanCount;
        if (totalCount%spanCount != 0) {
            totalColumn += 1;
        }

        int itemPosition = parent.getChildAdapterPosition(view);
        int itemRow = itemPosition%spanCount + 1;
        int itemColumn = itemPosition/spanCount;
        if (itemPosition%spanCount != 0) {
            itemColumn += 1;
        }

        if (itemColumn == totalColumn) {
            outRect.right = spacingInPx;
        }
        else{
            outRect.right = 0;
        }
    }
}
