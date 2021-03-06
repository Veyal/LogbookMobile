package com.example.logbookmobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Username;
    EditText Password;
    EditText ClockIn;
    EditText ClockOut;
    EditText Activity;
    EditText Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Password = findViewById(R.id.password);
        Username = findViewById(R.id.username);
        ClockIn = findViewById(R.id.clock_in);
        ClockOut = findViewById(R.id.clock_out);
        Activity = findViewById(R.id.activity);
        Description = findViewById(R.id.description);
        initText();

        FloatingActionButton GOB = findViewById(R.id.GOB);
        GOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                String clock_in = ClockIn.getText().toString();
                String clock_out = ClockOut.getText().toString();
                String activity = Activity.getText().toString();
                String description = Description.getText().toString();

                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                intent.putExtra("clock_in",clock_in);
                intent.putExtra("clock_out",clock_out);
                intent.putExtra("activity",activity);
                intent.putExtra("description",description);
                startActivity(intent);
            }
        });

        Button option = findViewById(R.id.Option);
        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetDefaultActivity.class);
                startActivity(intent);
            }
        });
    }
    public void initText(){
        SharedPreferences shared_preferences = getSharedPreferences("settings",0);
        Username.setText(shared_preferences.getString("username",""));
        Password.setText(shared_preferences.getString("password",""));
        ClockIn.setText(shared_preferences.getString("clock_in",""));
        ClockOut.setText(shared_preferences.getString("clock_out",""));
        Activity.setText(shared_preferences.getString("activity",""));
        Description.setText(shared_preferences.getString("description",""));
    }
}