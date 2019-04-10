package com.example.logbookmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button GOB = findViewById(R.id.GOB);
        final EditText Username = findViewById(R.id.username);
        final EditText Password = findViewById(R.id.password);
        final EditText Clock_in = findViewById(R.id.clock_in);
        final EditText Clock_out = findViewById(R.id.clock_out);
        final EditText Activity = findViewById(R.id.activity);
        final EditText Description = findViewById(R.id.description);

        GOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                String clock_in = Clock_in.getText().toString();
                String clock_out = Clock_out.getText().toString();
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
    }
}