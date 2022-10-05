package com.example.datetime;

import android.content.Intent;
import android.icu.text.TimeZoneFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WelcomeActivity extends AppCompatActivity {
    private Button startBtn;
    TextView month, day, year, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        month = findViewById(R.id.month);
        day = findViewById(R.id.day);
        year = findViewById(R.id.year);
        time = findViewById(R.id.time);

        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);

     //   time.setText(currentTime.toString());

        String[] splitDate = formattedDate.split(",");

        Log.d("myLOG", currentTime.toString());
        Log.d("myLOG", formattedDate);
        Log.d("myLOG", splitDate[0].trim());
        Log.d("myLOG", splitDate[1].trim());

        month.setText(splitDate[1]);
        day.setText(splitDate[0]);
        year.setText(splitDate[2]);


        Log.d("myLOG", splitDate[2].trim());


        startBtn=findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
            }
        });
    }
}