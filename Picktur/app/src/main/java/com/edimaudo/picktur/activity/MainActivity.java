package com.edimaudo.picktur.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.edimaudo.picktur.R;

public class MainActivity extends AppCompatActivity {
  private Button button;
  private CoordinatorLayout coordinatorLayout;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    coordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_main);
    button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (isNetworkAvailable()){
          Intent rec_intent = new Intent(MainActivity.this, ImageGallery.class);
          startActivity(rec_intent);

        } else {
          Snackbar
                  .make(coordinatorLayout, "No network connection!",Snackbar.LENGTH_LONG)
                  .show();
        }
      }
    });

  }
  //check for internet connectivity
  private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
            = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }
}
