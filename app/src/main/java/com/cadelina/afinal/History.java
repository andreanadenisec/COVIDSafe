package com.cadelina.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class History extends AppCompatActivity {

    private ListView historyListView;
    private Boolean firstload = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        //overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
        getSupportActionBar().hide();

         if(FirstLoad.firstLoad == true)
        {
            loadFromDBToMemory();
            FirstLoad.firstLoad = false;
        }

        initWidgets();
        setOnClickListener();

        if(firstload == true)
        {
            setNoteAdapter();
            firstload = false;
        }

    }

    private void initWidgets() {
        historyListView = findViewById(R.id.historyLV);
    }

    private void loadFromDBToMemory() {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.populateNoteListArray();
    }

    private void setNoteAdapter() {
        DetailAdapter detailAdapter = new DetailAdapter(getApplicationContext(), HistoryDetail.nonDeletedDetail());
        historyListView.setAdapter(detailAdapter);
    }

    private void setOnClickListener() {
        historyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                HistoryDetail selectedDetail = (HistoryDetail) historyListView.getItemAtPosition(position);
                Intent editDetailIntent = new Intent(getApplicationContext(), Detail.class);
                editDetailIntent.putExtra(HistoryDetail.NOTE_EDIT_EXTRA, selectedDetail.getId());
                startActivity(editDetailIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setNoteAdapter();
    }
}