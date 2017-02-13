package com.example.shadrach.modelmissionhighschool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    //TextView mmhs_news_txt;
    //Firebase mmhs_ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

       // Firebase.setAndroidContext(this);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

       //mmhs_news_txt = (TextView)findViewById(R.id.mmhs_news_txt);
        //mmhs_ref = new Firebase("https://resplendent-inferno-1785.firebaseio.com/mmhs_news_data");
        //mmhs_ref.addValueEventListener(new ValueEventListener() {
           // @Override
            //public void onDataChange(DataSnapshot dataSnapshot) {
              //  String SuperData = (String)dataSnapshot.getValue();
              //  mmhs_news_txt.setText(SuperData);
            //}

            //@Override
            //public void onCancelled(FirebaseError firebaseError) {

            //}
        //});

    }

    public void OnClickLothukunta(View view){
        Intent intent = new Intent(this,LothukuntaBranch.class);
        startActivity(intent);
    }

    public void OnClickBolaram(View view){
        Intent intent = new Intent(this,Bolarambranch.class);
        startActivity(intent);
    }

    public void OnClickMajeedpur(View view){
        Intent intent = new Intent(this,MajeedpurBranch.class);
        startActivity(intent);
    }

    public void OnClickTenthResults(View view){
        Intent intent = new Intent(this,TenthResults.class);
        startActivity(intent);
    }

    public void OnClickAdmissions(View view){
        Intent intent = new Intent(this,AdmissionDetails.class);
        startActivity(intent);
    }

    public void AluminiClub(View view){
        Intent intent = new Intent(this,AlumniClub.class);
        startActivity(intent);
    }

    public void ContactuS(View view){
        Intent intent = new Intent(this,ContactUs.class);
        startActivity(intent);
    }

    public void OnClickSchoolNewsButton(View view) {
        Intent intent = new Intent(this,SchoolNews.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.developer) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            switch (position) {
                case 0:
                    return PlaceholderFragment.newInstance(position + 1);
                case 1:
                    return MyFragment.newInstance();
                case 2:
                    return LeftFragment.newInstance();

            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */


}
