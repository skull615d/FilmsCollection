package com.example.filmscollection;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_film extends AppCompatActivity {
    private static final String TAG = "MyApp";
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Bundle mArg = getIntent().getExtras();
        int id = mArg.getInt("id");
        ImageView mImage = findViewById(R.id.image);
        TextView mText = findViewById(R.id.film_description);
        TextView mName = findViewById(R.id.film_name);
        String stringShare = null;
        if (id!=0){

            if (id==1){
                mImage.setImageDrawable(getApplicationContext().getDrawable(R.drawable.f_1));
                mText.setText(R.string.text_film_1);
                mName.setText(R.string.film_1);
                stringShare = getResources().getString(R.string.film_1);
                toolbar.setTitle(R.string.film_1);
            }
            if (id==2){
                mImage.setImageDrawable(getApplicationContext().getDrawable(R.drawable.f_2));
                mText.setText(R.string.text_film_2);
                mName.setText(R.string.film_2);
                stringShare = getResources().getString(R.string.film_2);
                toolbar.setTitle(R.string.film_2);
            }
            if (id==3){
                mImage.setImageDrawable(getApplicationContext().getDrawable(R.drawable.f_3));
                mText.setText(R.string.text_film_3);
                mName.setText(R.string.film_3);
                stringShare = getResources().getString(R.string.film_3);
                toolbar.setTitle(R.string.film_3);
            }
            if (id==4){
                mImage.setImageDrawable(getApplicationContext().getDrawable(R.drawable.f_4));
                mText.setText(R.string.text_film_4);
                mName.setText(R.string.film_4);
                stringShare = getResources().getString(R.string.film_4);
                toolbar.setTitle(R.string.film_4);
            }

        }
        ImageButton mShare = findViewById(R.id.share);
        String finalStringShare = stringShare;
        mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, finalStringShare);
                sendIntent.setType("text/plain");

                String title = getResources().getString(R.string.shooser_title);
                Intent shooser = Intent.createChooser(sendIntent,title);
                if (sendIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(shooser);
                }
            }
        });
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {

        CheckBox mCheckBox = findViewById(R.id.like);
        EditText mComment = findViewById(R.id.comment);

        String check = String.valueOf(mCheckBox.isChecked());
        String text = mComment.getText().toString();
        Intent mAnswerIntent = new Intent();

        mAnswerIntent.putExtra("CHECKBOX",check);
        mAnswerIntent.putExtra("COMMENT", text);
        setResult(RESULT_CANCELED,mAnswerIntent);
        finish();
        }

    }

