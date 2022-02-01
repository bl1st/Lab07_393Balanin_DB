package com.example.lab07_393balanin_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//BALANIN 393 LAB 07
    TextView txt_key;
    TextView txt_value;
    DB mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_key = findViewById(R.id.txt_key);
        txt_value = findViewById(R.id.txt_value);
        //create new or open database file "mybase.db" with version 1
        mydb = new DB(this, "mybase.db",null,1);
    }

    public void onButtonInsert_Click(View v) {
        String key = txt_key.getText().toString();
        String value = txt_value.getText().toString();
        mydb.do_insert(key,value);
    }

    public void onButtonUpdate_Click(View v) {
        String key = txt_key.getText().toString();
        String value = txt_value.getText().toString();
        txt_value.setText(mydb.do_update(key,value));
    }

    public void onButtonSelect_Click(View v) {
        String key = txt_key.getText().toString();
        String value = mydb.do_select(key);
        txt_value.setText(value);
    }

    public void onButtonDelete_Click(View v) {
        String key = txt_key.getText().toString();
        txt_value.setText(mydb.do_delete(key));
    }

}