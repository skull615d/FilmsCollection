package com.example.filmscollection;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.ArraySet;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    ArrayList<Button> arrButton = new ArrayList<Button>();
    ArrayList<TextView> arrTextView = new ArrayList<TextView>();
    final int SEC_AKT = 0;
    final int ADD_ACT = 1;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        arrButton.add(findViewById(R.id.B_1));
        arrButton.add(findViewById(R.id.B_2));
        arrButton.add(findViewById(R.id.B_3));
        arrButton.add(findViewById(R.id.B_4));

        arrTextView.add(findViewById(R.id.name_1));
        arrTextView.add(findViewById(R.id.name_2));
        arrTextView.add(findViewById(R.id.name_3));
        arrTextView.add(findViewById(R.id.name_4));

        View.OnClickListener push = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i<arrButton.size(); i++)  {
                    if (view.getId() == arrButton.get(i).getId()){
                        for(int y = 0;y < arrTextView.size();y++){
                            arrTextView.get(y).setTextColor(getColor(R.color.my_white));
                        }
                        arrTextView.get(i).setTextColor(getColor(R.color.my_blue));
                        Intent intent = new Intent(view.getContext(),Activity_film.class);
                        intent.putExtra("id",i+1);
                        startActivityForResult(intent,SEC_AKT);
                    }
                }
            }
        };
        for(int i = 0; i<arrButton.size(); i++){
            arrButton.get(i).setOnClickListener(push);
        }
        Log.d(TAG,"Снова включился onCreate");
    }



    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),"OnClick() setting",Toast.LENGTH_SHORT).show();
            Log.d(TAG,"Setting");
            View main_linear = findViewById(R.id.main_linear);
            Snackbar snackbar = Snackbar.make(main_linear, "Hear your setting", Snackbar.LENGTH_SHORT);
            snackbar.show();
            return true;
        }
        if (id == R.id.add_film){
            View main_linear = findViewById(R.id.main_linear);
            //setContentView(R.layout.add_film);
            Intent intent = new Intent(main_linear.getContext(),AddFilm.class);
            startActivityForResult(intent,ADD_ACT);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0){
            if (resultCode == RESULT_CANCELED){
                String Check = data.getStringExtra("CHECKBOX");
                String Comment = data.getStringExtra("COMMENT");

                Log.d(TAG,"Checkbox: "+Check+", Comment: "+Comment);
            }
        }
        if ((requestCode == ADD_ACT) && (resultCode == RESULT_OK)){
            String name = data.getStringExtra("Name");
            String discr = data.getStringExtra("Discr");

            LinearLayout subLinear = findViewById(R.id.subLinear);
            LinearLayout linearLayout = new LinearLayout(this);
            LinearLayout.LayoutParams container_Params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            container_Params.leftMargin= 16;
            TextView tv = new TextView(this);
            tv.setText(name);
            tv.setTextColor(Color.RED);
            linearLayout.addView(tv);
            subLinear.addView(linearLayout);
        }
    }
}
