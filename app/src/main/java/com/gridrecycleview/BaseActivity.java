package com.gridrecycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * Created by Warren on 2018/3/7.
 */

public class BaseActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_base_recyclerview);
        recyclerView = findViewById(R.id.recycler_view);
        String title = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public ArrayList<MockObject> generateMockData(int count){
        ArrayList<MockObject> mockObjects = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            mockObjects.add(new MockObject(String.valueOf(i)));
        }
        return mockObjects;
    }
}
