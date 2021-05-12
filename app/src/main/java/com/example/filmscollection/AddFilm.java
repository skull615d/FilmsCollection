package com.example.filmscollection;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddFilm extends AppCompatActivity {
    private static final String TAG = "MyApp";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_film);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button addFilm = findViewById(R.id.addFilmButton);
        addFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText mName = findViewById(R.id.content_name);
                EditText mDiscr = findViewById(R.id.EdText_addDesc);
                Intent mAnswerIntent = new Intent();
                mAnswerIntent.putExtra("Name",mName.getText().toString());
                mAnswerIntent.putExtra("Discr", mDiscr.getText().toString());
                setResult(RESULT_OK,mAnswerIntent);
                finish();
            }
        });
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        Log.d(TAG,"Back");
        return true;
    }
}
