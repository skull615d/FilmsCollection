package com.example.filmscollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton_1 = findViewById(R.id.B_1);
        Button mButton_2 = findViewById(R.id.B_2);
        Button mButton_3 = findViewById(R.id.B_3);
        Button mButton_4 = findViewById(R.id.B_4);
        TextView mName_1 = findViewById(R.id.name_1);
        TextView mName_2 = findViewById(R.id.name_2);
        TextView mName_3 = findViewById(R.id.name_3);
        TextView mName_4 = findViewById(R.id.name_4);

        mButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mName_1.setTextColor(Color.WHITE);
                mName_2.setTextColor(Color.BLACK);
                mName_3.setTextColor(Color.BLACK);
                mName_4.setTextColor(Color.BLACK);

                Intent intent = new Intent(view.getContext(),Activity_film.class);
                intent.putExtra("id",1);
                view.getContext().startActivity(intent);
            }
        });
        mButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mName_2.setTextColor(Color.WHITE);
                mName_1.setTextColor(Color.BLACK);
                mName_3.setTextColor(Color.BLACK);
                mName_4.setTextColor(Color.BLACK);

                Intent intent = new Intent(view.getContext(),Activity_film.class);
                intent.putExtra("id",2);
                view.getContext().startActivity(intent);
            }
        });
        mButton_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mName_3.setTextColor(Color.WHITE);
                mName_1.setTextColor(Color.BLACK);
                mName_2.setTextColor(Color.BLACK);
                mName_4.setTextColor(Color.BLACK);

                Intent intent = new Intent(view.getContext(),Activity_film.class);
                intent.putExtra("id",3);
                view.getContext().startActivity(intent);
            }
        });
        mButton_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mName_4.setTextColor(Color.WHITE);
                mName_1.setTextColor(Color.BLACK);
                mName_2.setTextColor(Color.BLACK);
                mName_3.setTextColor(Color.BLACK);

                Intent intent = new Intent(view.getContext(),Activity_film.class);
                intent.putExtra("id",4);
                view.getContext().startActivity(intent);

            }
        });

        Log.d(TAG,"Снова включился onCreate");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String comment = savedInstanceState.getString("Comment");
        Log.d(TAG, "  Comment: " + comment);

    }

    protected void onResume() {
        super.onResume();

            Log.d(TAG, "Включился onResume");

    }


}