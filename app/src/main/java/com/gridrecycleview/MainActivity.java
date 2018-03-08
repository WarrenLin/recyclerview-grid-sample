package com.gridrecycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        setupListDemoModel();
    }

    private void setupListDemoModel(){
        DemoModel[] demoModels = {
            new DemoModel("Vertical Grid RecyclerView", "A simple vertical grid recyclerview to display", VerticalActivity.class),
            new DemoModel("Horizontal Grid RecyclerView", "A simple horizontal grid recyclerview to display", HorizontalActivity.class),
            new DemoModel("Vertical With Divider", "Vertical grid recyclerview each item that has the same spacing.", VerticalWithDividerActivity.class),
            new DemoModel("Horizontal With Divider", "Horizontal grid recyclerview each item that has the same spacing.", HorizontalWithDividerActivity.class),
            new DemoModel("Vertical Combine Span", "Set different span size to display.", VerticalCombineSpanActivity.class),
            new DemoModel("Horizontal Combine Span", "Set different span size to display.", HorizontalCombineSpanActivity.class)
        };

        DemoAdapter demoAdapter = new DemoAdapter(demoModels);
        mRecyclerView.setAdapter(demoAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private static class DemoModel {
        String title;
        String description;
        Class activityClass;

        public DemoModel(String title, String description, Class activityClass) {
            this.title = title;
            this.description = description;
            this.activityClass = activityClass;
        }
    }

    class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder>{

        private final DemoModel[] demoModels;

        public DemoAdapter(DemoModel[] demoModels) {
            this.demoModels = demoModels;
        }

        @Override
        public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View v = inflater.inflate(R.layout.module_list_item, parent, false);
            return new DemoViewHolder(v);
        }

        @Override
        public void onBindViewHolder(DemoViewHolder holder, int position) {
            final DemoModel demoModel = demoModels[position];
            holder.titleTextView.setText(demoModel.title);
            holder.descriptionTextView.setText(demoModel.description);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), demoModel.activityClass);
                    intent.putExtra("title", demoModel.title);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return demoModels.length;
        }

        class DemoViewHolder extends RecyclerView.ViewHolder {
            TextView titleTextView;
            TextView descriptionTextView;

            public DemoViewHolder(View v) {
                super(v);
                titleTextView = v.findViewById(R.id.titleTextView);
                descriptionTextView = v.findViewById(R.id.descriptionTextView);
            }
        }
    }
}
