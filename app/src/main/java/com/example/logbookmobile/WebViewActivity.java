package com.example.logbookmobile;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends Activity {
    boolean tried = false;
    boolean logged_in = false;
    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        final String username = intent.getStringExtra("username");
        final String password = intent.getStringExtra("password");
        Log.i("username",username);
        Log.i("password",password);
        final String clock_in = intent.getStringExtra("clock_in");
        final String clock_out = intent.getStringExtra("clock_out");
        final String activity = intent.getStringExtra("activity");
        final String description = intent.getStringExtra("description");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://industry.socs.binus.ac.id/learning-plan/auth/login");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if (tried == false) {
                    tried = true;
                    logged_in = true;
                    super.onPageFinished(view, url);

                    final String js = "javascript:" +
                            "document.getElementsByName('password')[0].value = '" + password + "';" +
                            "document.getElementsByName('username')[0].value = '" + username + "';" +
                            "document.getElementsByClassName('ui fluid large primary button')[0].click()";

                    if (Build.VERSION.SDK_INT >= 19) {
                        view.evaluateJavascript(js, new ValueCallback<String>() {
                            @Override
                            public void onReceiveValue(String s) {

                            }
                        });
                    } else {
                        view.loadUrl(js);
                    }
                }
                if(logged_in==true){
                    super.onPageFinished(view, url);

                    final String js = "javascript:" +
                            "document.getElementsByName('clock-in')[0].value = '" + clock_in + "';" +
                            "document.getElementsByName('clock-out')[0].value = '" + clock_out + "';" +
                            "document.getElementsByName('activity')[0].value = '" + activity + "';" +
                            "document.getElementsByName('description')[0].value = '" + description + "'";

                    if (Build.VERSION.SDK_INT >= 19) {
                        view.evaluateJavascript(js, new ValueCallback<String>() {
                            @Override
                            public void onReceiveValue(String s) {

                            }
                        });
                    } else {
                        view.loadUrl(js);
                    }
                }
            }

        });
    }
}
