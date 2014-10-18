package com.commonsware.empublite;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

// Kinda odd ...
// Has a progress bar (rotating circle progress indicator)
// as its only widget.
// Has 2 menu items.


public class EmPubLiteActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
      Log.d("EMPUB", "onCreate finished.");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.options, menu);

    return(super.onCreateOptionsMenu(menu));
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
          Log.d("EMPUB", "HOME picked.");
        return(true);
        
      case R.id.about:
          Log.d("EMPUB", "ABOUT picked.");
        return(true);
        
      case R.id.help:
          Log.d("EMPUB", "HELP picked.");
          return(true);
    }
    
    return(super.onOptionsItemSelected(item));
  }
}
