package com.example.shadrach.modelmissionhighschool;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import  android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Shadrach on 05-03-2016.
 */
public class MyFragment extends Fragment {

    public static MyFragment newInstance(){
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    public MyFragment(){

    }
    Button Clickme;
    EditText editText_username,editText_password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.my_fragment,container,false);
        editText_username = (EditText) rootView.findViewById(R.id.editText);
        editText_password = (EditText) rootView.findViewById(R.id.editText2);
        Clickme = (Button) rootView.findViewById(R.id.button);

        Clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View rootView) {
                if((editText_username.getText().toString().equals("lothukunta"))&&(editText_password.getText().toString().equals("lothukunta"))){
                    Intent intent = new Intent(getActivity(),LothukuntaHM.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(),"Access Granted only for Lothukunta branch HEAD MISTRESS",Toast.LENGTH_LONG).show();

                }
                else if((editText_username.getText().toString().equals("bolaram"))&&(editText_password.getText().toString().equals("bolaram"))){
                    Intent intent = new Intent(getActivity(),BolaramHM.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(),"Access Granted only for bolaram branch HEAD MISTRESS",Toast.LENGTH_LONG).show();
                }
                else if((editText_username.getText().toString().equals("majeedpur"))&&(editText_password.getText().toString().equals("majeedpur"))){
                    Intent intent = new Intent(getActivity(),majeedpurHM.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(),"Access Granted only for Majeedpur branch HEAD MISTRESS",Toast.LENGTH_LONG).show();
                }
                else if((editText_username.getText().toString().equals("director"))&&(editText_password.getText().toString().equals("director"))){
                    Intent intent = new Intent(getActivity(),Director.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(),"Access Granted only for Director or principal",Toast.LENGTH_LONG).show();
                }

                else {
                    Toast.makeText(getActivity(),"Access Denied",Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootView;
    }




}
