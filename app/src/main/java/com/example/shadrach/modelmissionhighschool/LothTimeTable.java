package com.example.shadrach.modelmissionhighschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LothTimeTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loth_time_table);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loth_time_table, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void savetimetable(View view) {
    }

    public void onea(View view) {
    }

    public void oneb(View view) {
    }

    public void onec(View view) {
    }

    public void twoa(View view) {
    }

    public void twob(View view) {
    }

    public void twoc(View view) {
    }

    public void threea(View view) {
    }

    public void threeb(View view) {
    }

    public void threec(View view) {
    }

    public void foura(View view) {
    }

    public void fourb(View view) {
    }

    public void fourc(View view) {
    }

    public void fivea(View view) {
    }

    public void fiveb(View view) {
    }

    public void fivec(View view) {
    }

    public void sixa(View view) {
    }

    public void sixb(View view) {
    }

    public void sixc(View view) {
    }

    public void sevena(View view) {
    }

    public void sevenb(View view) {
    }

    public void sevenc(View view) {
    }

    public void eighta(View view) {
    }

    public void eightb(View view) {
    }

    public void eightc(View view) {
    }

    public void ninea(View view) {
    }

    public void nineb(View view) {
    }

    public void ninec(View view) {
    }

    public void tena(View view) {
    }

    public void tenb(View view) {
    }

    public void tenc(View view) {
    }
}
