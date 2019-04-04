package com.github.lesincs;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        Intent intent = new Intent();
        intent.putExtra(Constants.EXTRA_KEY,"DATA");
        setResult(Constants.RESULT_CODE,intent);
        finish();
      }
    },3000);
  }
}
