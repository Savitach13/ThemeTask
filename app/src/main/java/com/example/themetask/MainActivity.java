package com.example.themetask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnTheme1,btnTheme2,btnTheme3,btnTheme4;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int selectedTheme = sharedPreferences.getInt("selectedTheme",0);
        setDynamicTheme(selectedTheme);

        setContentView(R.layout.activity_main);

        btnTheme1=findViewById(R.id.btnTheme1);
        btnTheme2=findViewById(R.id.btnTheme2);
        btnTheme3=findViewById(R.id.btnTheme3);
        btnTheme4=findViewById(R.id.btnTheme4);

        btnTheme1.setOnClickListener(this);
        btnTheme2.setOnClickListener(this);
        btnTheme3.setOnClickListener(this);
        btnTheme4.setOnClickListener(this);

    }

    private void setDynamicTheme(int selectedTheme) {
        switch (selectedTheme){
            case 1:
                MainActivity.this.setTheme(R.style.Theme1);
                break;
            case 2:
                MainActivity.this.setTheme(R.style.Theme2);
                break;
            case 3:
                MainActivity.this.setTheme(R.style.Theme3);
                break;
            case 4:
                MainActivity.this.setTheme(R.style.Theme4);
                break;

        }
    }

    @Override
    public void onClick(View view) {
        SharedPreferences.Editor editor= sharedPreferences.edit();
        switch (view.getId()){
            case R.id.btnTheme1:
                editor.putInt("selectedTheme",1);
                break;
            case R.id.btnTheme2:
                editor.putInt("selectedTheme",2);
                break;
            case R.id.btnTheme3:
                editor.putInt("selectedTheme",3);
                break;
            case R.id.btnTheme4:
                editor.putInt("selectedTheme",4);
                break;

        }
        editor.apply();
        startActivity(new Intent(MainActivity.this,MainActivity.class));
        finish();
    }
}