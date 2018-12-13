package com.example.key.a1123;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new splashhandler(), 3000);
    }

    private class splashhandler implements Runnable {
        public void run() {
            startActivity(new Intent(getApplication(), Tutorial1.class));
            Splash.this.finish();
        }
    }

    public void onBackPressed() {

    }
}
