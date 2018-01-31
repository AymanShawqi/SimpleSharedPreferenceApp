package com.networkapp.android.sharedpreferenceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEditText;
    private TextView mDataTxt;
    private SharedPreferences shrd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveBtn;
        Button loadBtn;
        mEditText=(EditText)findViewById(R.id.edit_txt);
        mDataTxt=(TextView)findViewById(R.id.data);
        saveBtn=(Button)findViewById(R.id.save);
        loadBtn=(Button)findViewById(R.id.load);
        shrd=getSharedPreferences("savefile", Context.MODE_PRIVATE);
        saveBtn.setOnClickListener(this);
        loadBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.save:
                saveData();
                break;
            case R.id.load:
                loadData();
                break;
        }
    }

    private void saveData(){
        SharedPreferences.Editor editor=shrd.edit();
        editor.putString("data",mEditText.getText().toString());
        editor.apply();
    }

    private void loadData(){
        String output=shrd.getString("data","No Data here");
        mDataTxt.setText(output);
    }
}
