package com.example.shadrach.modelmissionhighschool;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import  android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by Shadrach on 05-03-2016.
 */
public class LeftFragment extends Fragment {

    public static LeftFragment newInstance(){
        LeftFragment fragment = new LeftFragment();
        return fragment;
    }

    public LeftFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.left_fragment,container,false);
        return rootView;
    }
}
