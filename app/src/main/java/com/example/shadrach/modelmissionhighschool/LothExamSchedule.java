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

public class LothExamSchedule extends AppCompatActivity {

    TextView loth_exm_txt;
    Firebase lref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loth_exam_schedule);

        Firebase.setAndroidContext(this);

        loth_exm_txt = (TextView)findViewById(R.id.loth_exm_txt);
        lref = new Firebase("https://resplendent-inferno-1785.firebaseio.com/loth_exam_schedule");
        lref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String SuperData = (String)dataSnapshot.getValue();
                loth_exm_txt.setText(SuperData);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(LothExamSchedule.this,"no net connection",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loth_exam_schedule, menu);
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
