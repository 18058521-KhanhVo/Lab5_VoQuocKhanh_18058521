package com.example.lab5_voquockhanh_18058521;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mWordListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);
        }

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mWordListAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mWordListAdapter);

        FloatingActionButton fab=findViewById(R.id.FAB);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int wordListSize=mWordList.size();
        mWordList.addLast("Word"+wordListSize);
        mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
        mRecyclerView.smoothScrollToPosition(wordListSize);
    }
}