package com.example.logbookmobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetDefaultActivity extends AppCompatActivity {

    EditText Username;
    EditText Password;
    EditText ClockIn;
    EditText ClockOut;
    EditText Activity;
    EditText Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_default);
        Username = findViewById(R.id.usernameS);
        Password = findViewById(R.id.passwordS);
        ClockIn = findViewById(R.id.clock_inS);
        ClockOut = findViewById(R.id.clock_outS);
        Activity = findViewById(R.id.activityS);
        Description = findViewById(R.id.descriptionS);

        initText();
        Button save = findViewById(R.id.Save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mySettings = getSharedPreferences("settings", 0);
                SharedPreferences.Editor editor = mySettings.edit();

                String username = Username.getText().toString();
                String password = Password.getText().toString();
                String clock_in = ClockIn.getText().toString();
                String clock_out = ClockOut.getText().toString();
                String activity = Activity.getText().toString();
                String description = Description.getText().toString();

                editor.putString("username", username);
                editor.putString("password", password);
                editor.putString("clock_in", clock_in);
                editor.putString("clock_out", clock_out);
                editor.putString("activity", activity);
                editor.putString("description", description);
                editor.commit();

                Intent intent = new Intent(SetDefaultActivity.this, MainActivity.class);
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
