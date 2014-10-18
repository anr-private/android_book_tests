package com.example.art.loggerdevel;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ArtMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_main);
        // Set up the logger
        //L.initialize(LTAG, LOG_FILENAME, MONTH_IS_NUMBER);

        L.i("MAIN: onCreate CALLED");
        if (L.I)L.i("MAIN: onCreate CALLED and (L)OG is on");
    }


    public void btn1Clicked(View v) {

        if (L.V)L.v("MAIN.btn1Clicked -- VERBOSE");
        if (L.D)L.d("MAIN.btn1Clicked -- DEBUG");
        if (L.I)L.i("MAIN.btn1Clicked -- INFO");
        if (L.W)L.w("MAIN.btn1Clicked -- WARNING");
        if (L.E)L.e("MAIN.btn1Clicked -- ERROR");
        _mesg("Logged one each of ERROR, WARNING, INFO, DEBUG, VERBOSE");
    }

    public void btn2Clicked(View v) {

        L.d("MAIN.btn2Clicked ");
        _mesg("Logged a DEBUG mesg");
    }

    public void btn3Clicked(View v) {

        L.d("MAIN.btn3Clicked ");
        _mesg("Logged a DEBUG mesg");
    }

    public void btn4Clicked(View v) {

        L.d("MAIN.btn4Clicked: CLEAR button");
        _mesgClear();
    }

    private void _mesgClear() {

        //TextView tv = (TextView) findViewById(R.id.mesgTv);
        TextView tv = _getMesgTextview();
        if (tv == null) return;
        tv.setText("");
    }

    private void _mesg(String mesg) {

        //TextView tv = (TextView) findViewById(R.id.mesgTv);
        TextView tv = _getMesgTextview();
        if (tv == null) return;

        if (mesg == null) mesg = "";

        String s = tv.getText().toString();
        if (s == null || s.length() == 0) {
            s = mesg;
        } else {
            s += "\n";
            s += mesg;
        }
        tv.setText(s);
    }

    private TextView _getMesgTextview() {

        TextView tv = (TextView) findViewById(R.id.mesgTv);
        if (tv == null) return null;
        return tv;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.art_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
