package com.example.datetime;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Paint;
import android.icu.text.SimpleDateFormat;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Button dateButton, timeButton;
    TextView dateTextView, timeTextView, timeTextView24h;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateButton = findViewById(R.id.dateButton);
        timeButton = findViewById(R.id.timeButton);
        dateTextView = findViewById(R.id.dateTextView);
        timeTextView = findViewById(R.id.timeTextView);


        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleDateButton();
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleTimeButton();
            }
        });
    }

    private void handleDateButton() {
        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,R.style.DatePickerDialogTheme,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {


                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE, date);
                String dateText = ("Date: ")+DateFormat.format("EEEE, MMM d, yyyy", calendar1).toString();
                dateTextView.setText(dateText);
            }
        }, YEAR, MONTH, DATE);

        datePickerDialog.show();
        Toast.makeText(getApplicationContext(),
                "Please select date",
                Toast.LENGTH_SHORT).show();
    }

    private void handleTimeButton() {
        Calendar calendar = Calendar.getInstance();
        int HOUR = calendar.get(Calendar.HOUR_OF_DAY);
        int MINUTE = calendar.get(Calendar.MINUTE);
        boolean is24HourFormat = DateFormat.is24HourFormat(this);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,R.style.TimePickerDialogTheme,new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute  ) {

                Log.i(TAG, "onTimeSet:" + hour + minute);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR_OF_DAY, hour);
                calendar1.set(Calendar.MINUTE, minute);
                String dateText = ("Time: ")+DateFormat.format("h:mma", calendar1).toString();
                timeTextView.setText(dateText);

            }
        },
                HOUR, MINUTE, is24HourFormat);
        timePickerDialog.show();
        Toast.makeText(getApplicationContext(),
                "Please select time",
                Toast.LENGTH_SHORT).show();


    }



}


