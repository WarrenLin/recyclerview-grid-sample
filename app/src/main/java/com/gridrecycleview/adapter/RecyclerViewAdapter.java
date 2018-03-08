package com.gridrecycleview.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gridrecycleview.MockObject;
import com.gridrecycleview.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Warren on 2018/3/7.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder>{

    private final ArrayList<MockObject> mockObjects;

    public RecyclerViewAdapter(ArrayList<MockObject> mockObjects) {
        this.mockObjects = mockObjects;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final MockObject mockObject = mockObjects.get(position);
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.frameLayout.setBackgroundColor(color);
        holder.title.setText(mockObject.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), mockObject.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mockObjects != null) {
            return mockObjects.size();
        }
        return 0;
    }

    class Holder extends RecyclerView.ViewHolder{
        FrameLayout frameLayout;
        TextView title;

        public Holder(View itemView) {
            super(itemView);
            frameLayout = itemView.findViewById(R.id.fl_container);
            title = itemView.findViewById(R.id.tv_title);
        }
    }
}
