package com.example.shadrach.modelmissionhighschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class BolaramExamSchedule extends AppCompatActivity {

    TextView bolaram_exm_txt;
    Firebase bref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolaram_exam_schedule);

        Firebase.setAndroidContext(this);

        bolaram_exm_txt = (TextView)findViewById(R.id.bolaram_exm_txt);
        bref = new Firebase("https://resplendent-inferno-1785.firebaseio.com/bolaram_exam_schedule");
        bref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String SuperData1 = (String) dataSnapshot.getValue();
                bolaram_exm_txt.setText(SuperData1);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(BolaramExamSchedule.this, "no net connection", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bolaram_exam_schedule, menu);
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
