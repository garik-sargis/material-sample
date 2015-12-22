package com.gs.android.materialsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SampleGridAdapter extends RecyclerView.Adapter<SampleGridAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.text)
        protected TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        public void bind(String text) {
            mTextView.setText(text);
        }
    }

    private final List<String> mData;

    public SampleGridAdapter(List<String> data) {
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_grid, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String dataItem = mData.get(position);
        holder.bind(dataItem);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
