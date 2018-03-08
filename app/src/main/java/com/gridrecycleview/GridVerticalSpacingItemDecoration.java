package com.gridrecycleview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Warren on 2018/3/7.
 */

public class GridVerticalSpacingItemDecoration extends RecyclerView.ItemDecoration{

    private final int spacingInPx;
    private final int spanCount;

    public GridVerticalSpacingItemDecoration(int spacingInPx, int spanCount) {
        this.spacingInPx = spacingInPx;
        this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = spacingInPx;
        outRect.right = spacingInPx;
        outRect.top = spacingInPx;
        outRect.bottom = spacingInPx;

        int totalCount = state.getItemCount();
        int totalRow = totalCount/spanCount + 1;

        int itemPosition = parent.getChildAdapterPosition(view);
        int itemRow = itemPosition/spanCount + 1;

        if (itemRow != totalRow) {    //last row keep bottom padding.
            outRect.bottom = 0;
        }

        if (itemPosition % spanCount == (spanCount - 1)) {  //last column padding right.
            outRect.right = spacingInPx;
        }
        else{
            outRect.right = 0;
        }
    }
}
