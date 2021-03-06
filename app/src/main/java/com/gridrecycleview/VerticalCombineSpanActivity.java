package com.gridrecycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.gridrecycleview.adapter.RecyclerViewAdapter;

/**
 * Created by Warren on 2018/3/7.
 */

public class VerticalCombineSpanActivity extends BaseActivity {
    private final int CONST_MOCK_COUNT = 35;
    private final int CONST_SPAN_COUNT = 4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, CONST_SPAN_COUNT);
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(generateMockData(CONST_MOCK_COUNT));
        recyclerView.setAdapter(adapter);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position%(CONST_SPAN_COUNT+1) == 0) {
                    return CONST_SPAN_COUNT;
                }
                return 1;
            }
        });
    }
}
