package com.example.android.hellotoast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

  private TextView mText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hello);

    mText = (TextView) findViewById(R.id.second_hello_text);
    Intent intent = getIntent();
    String message =
            intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    mText.setText(message);
  }
}
