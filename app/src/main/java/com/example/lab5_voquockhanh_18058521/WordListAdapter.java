package com.example.lab5_voquockhanh_18058521;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {


    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        /**
         * @param itemView
         * @param adapter
         */
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            wordItemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String element = mWordList.get(position);
            mWordList.set(position, "Click " + element);
            mAdapter.notifyDataSetChanged();
        }
    }

    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    /**
     * @param context
     * @param mWordList
     */
    public WordListAdapter(Context context, LinkedList<String> mWordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


}
