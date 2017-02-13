package com.example.shadrach.modelmissionhighschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Majeedpur_Hm_Exm_Schedule extends AppCompatActivity {

    EditText majeed_hm_editTxt;
    Firebase mhmref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majeedpur__hm__exm__schedule);

        Firebase.setAndroidContext(this);
        majeed_hm_editTxt = (EditText)findViewById(R.id.majeedpur_hm_editTxt);
        mhmref = new Firebase("https://resplendent-inferno-1785.firebaseio.com/majeedpur_exam_schedule");
    }

    public void OnClickMajeedpurHMSendSchedule(View view){
        String notification = majeed_hm_editTxt.getText().toString();
        mhmref.setValue(notification);
        mhmref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(Majeedpur_Hm_Exm_Schedule.this, "Schedule updated", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_majeedpur__hm__exm__schedule, menu);
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
}
