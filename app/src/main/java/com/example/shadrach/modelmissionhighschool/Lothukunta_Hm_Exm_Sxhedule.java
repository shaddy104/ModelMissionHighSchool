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

public class Lothukunta_Hm_Exm_Sxhedule extends AppCompatActivity {

    EditText bol_hm_editTxt;
    Firebase bhmref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lothukunta__hm__exm__sxhedule);

        Firebase.setAndroidContext(this);
        bol_hm_editTxt = (EditText)findViewById(R.id.bol_hm_editTxt);
        bhmref = new Firebase("https://resplendent-inferno-1785.firebaseio.com/loth_exam_schedule");
    }

    public void OnClickBolaramSendSchedule(View view){
        String notification = bol_hm_editTxt.getText().toString();
        bhmref.setValue(notification);
        bhmref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(Lothukunta_Hm_Exm_Sxhedule.this,"Schedule updated",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bolaram__hm__exm__sxhedule, menu);
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
