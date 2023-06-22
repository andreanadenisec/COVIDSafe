package com.cadelina.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Date;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Locale;

public class Detail extends AppCompatActivity
{
    private EditText detailET;
    private TextView dateTV, timeTV, count;
    int hour, minute;
    private Button deleteButton;
    private HistoryDetail selectedDetail;

    AlertDialog.Builder builder;

    //private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        builder = new AlertDialog.Builder(this);

        //overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
        getSupportActionBar().hide();
        initWidgets();

        checkForEditNote();

        //time = LocalTime.now();
        dateTV.setText(" " + CalendarUtils.formattedDate(CalendarUtils.selectedDate) + "        ");
        timeTV = findViewById(R.id.timeTV);

        count = findViewById(R.id.count);
        detailET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = detailET.getText().toString();
                int number = input.length();
                count.setText(""+(int)number);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Alert! ")
                        .setMessage("Are you sure you want to delete this note?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                delete();
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });
    }

    private void initWidgets()
    {
        detailET = findViewById(R.id.detailET);
        dateTV = findViewById(R.id.dateTV);
        timeTV = findViewById(R.id.timeTV);
        deleteButton = findViewById(R.id.deleteButton);
    }

    private void checkForEditNote() {
        Intent previousIntent = getIntent();

        int passedDetailID = previousIntent.getIntExtra(HistoryDetail.NOTE_EDIT_EXTRA, -1);
        selectedDetail = HistoryDetail.getDetailForID(passedDetailID);

        if (selectedDetail != null) {
            detailET.setText(selectedDetail.getDetailDate());
            timeTV.setText(selectedDetail.getDetailTime());
            dateTV.setText(selectedDetail.getTitleDate());
        }
        else {
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }

    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                String AM_PM ;
                if(selectedHour < 12) {
                    AM_PM = "AM";
                } else {
                    AM_PM = "PM";
                }

                hour = selectedHour;
                minute = selectedMinute;
                timeTV.setText(String.format(Locale.getDefault(),"%02d:%02d", hour, minute) + AM_PM);
            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, false);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    public void saveDetail(View view) {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        String titledate =  (CalendarUtils.formattedDate(CalendarUtils.selectedDate) + "-" + timeTV.getText());
        String detailDate = String.valueOf(detailET.getText());
        String detailtime = String.valueOf(timeTV.getText());

        if (selectedDetail == null) {
            int id = HistoryDetail.historyArrayList.size();
            HistoryDetail newhistoryDetail = new HistoryDetail(id, titledate, detailDate, detailtime);
            HistoryDetail.historyArrayList.add(newhistoryDetail);
            sqLiteManager.addNoteToDatabase(newhistoryDetail);
        } else {
            selectedDetail.setDetailDate(detailDate);
            selectedDetail.setTitleDate(titledate);
            selectedDetail.setDetailTime(detailtime);
            sqLiteManager.updateNoteInDB(selectedDetail);
        }
        finish();
    }

    public void deleteDetail(View view) {
        selectedDetail.setDeleted(new Date());
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.updateNoteInDB(selectedDetail);
        finish();
    }

    private void delete(){
        selectedDetail.setDeleted(new Date());
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.updateNoteInDB(selectedDetail);
        finish();
    }
}