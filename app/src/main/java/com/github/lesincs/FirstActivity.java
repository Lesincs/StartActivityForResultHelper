package com.github.lesincs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

  Button btGo;

  private final String TAG = getClass().getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_first);

    btGo  = findViewById(R.id.bt);

    btGo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
        StartActivityForResultHelper.startActivityForResult(FirstActivity.this, intent, new ActivityResultCallback() {
          @Override
          public void onResult(int resultCode, Intent intent) {
            Log.d(TAG,"resultCode = " + resultCode );
            Log.d(TAG,"data = " + intent.getStringExtra(Constants.EXTRA_KEY));
          }
        });
      }
    });


  }
}
