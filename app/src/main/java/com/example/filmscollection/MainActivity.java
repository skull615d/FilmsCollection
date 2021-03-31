package com.example.filmscollection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton_1 = findViewById(R.id.B_1);
        Button mButton_2 = findViewById(R.id.B_2);
        Button mButton_3 = findViewById(R.id.B_3);
        Button mButton_4 = findViewById(R.id.B_4);

        mButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView mName_1 = findViewById(R.id.name_1);
                mName_1.setTextColor(Color.WHITE);
                setContentView(R.layout.activity_main2);
            }
        });
        mButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView mName_2 = findViewById(R.id.name_2);
                mName_2.setTextColor(Color.WHITE);
            }
        });
        mButton_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView mName_3 = findViewById(R.id.name_3);
                mName_3.setTextColor(Color.WHITE);
            }
        });
        mButton_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView mName_4 = findViewById(R.id.name_4);
                mName_4.setTextColor(Color.WHITE);
            }
        });
    }




}