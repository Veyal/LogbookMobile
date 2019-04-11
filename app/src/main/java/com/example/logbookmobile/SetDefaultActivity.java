package com.example.logbookmobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetDefaultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_default);
        final EditText Username = findViewById(R.id.usernameS);
        final EditText Password = findViewById(R.id.passwordS);
        final EditText Clock_in = findViewById(R.id.clock_inS);
        final EditText Clock_out = findViewById(R.id.clock_outS);
        final EditText Activity = findViewById(R.id.activityS);
        final EditText Description = findViewById(R.id.descriptionS);

        Button save = findViewById(R.id.Save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mySettings = getSharedPreferences("settings",0);
                SharedPreferences.Editor editor = mySettings.edit();

                String username = Username.getText().toString();
                String password = Password.getText().toString();
                String clock_in = Clock_in.getText().toString();
                String clock_out = Clock_out.getText().toString();
                String activity = Activity.getText().toString();
                String description = Description.getText().toString();

                editor.putString("username",username);
                editor.putString("password",password);
                editor.putString("clock_in",clock_in);
                editor.putString("clock_out",clock_out);
                editor.putString("activity",activity);
                editor.putString("description",description);
                editor.commit();

                Intent intent = new Intent(SetDefaultActivity.this, MainActivity.class);
                startActivity(intent);


            }
        });
    }
}
