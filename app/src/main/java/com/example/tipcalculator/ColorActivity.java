package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        initGroupColorChange();
        initColorActivity();
    }

    private void initColorActivity() {
        SharedPreferences sharedPref = getSharedPreferences( "MyContactListPreferences", Context.MODE_PRIVATE);
        int colorHolder = sharedPref.getInt("colorGroup",  0xFF00FF00);
        int colorHolder2 = sharedPref.getInt( "colorGroup", 0xFF00FF00);
        int colorHolder3 = sharedPref.getInt( "colorGroup", 0xFFFF0000);
        RadioButton rdBlue = findViewById(R.id.blueButton);
        RadioButton rbGreen = findViewById(R.id.greenButton);
        RadioButton rbRed = findViewById(R.id.redButton);
        RadioButton rbYellow = findViewById(R.id.yellowButton);
        if (colorHolder == 0xFF00FF00) {
            rbGreen.setChecked(true);
        } else if (colorHolder2 == 0xFF0000FF) {
            rdBlue.setChecked(true);
        } else if (colorHolder3 == 0xFFFF0000) {
            rbRed.setChecked(true);
        } else {
            rbYellow.setChecked(true);
        }
    }

    private void initGroupColorChange(){
        RadioGroup rgcc = findViewById(R.id.colorGroup);
        RadioButton rbBlue = findViewById(R.id.blueButton);
        RadioButton rbGreen = findViewById(R.id.greenButton);
        RadioButton rbRed = findViewById(R.id.redButton);
        RadioButton rbYellow = findViewById(R.id.yellowButton);
        rgcc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbBlue.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorGroup", 0XFF0000FF);
                    editor.apply();
                } else if (rbGreen.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorGroup", 0XFF00FF00);
                    editor.apply();

                } else if (rbRed.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorGroup", 0XFFFF0000);
                    editor.apply();

                } else if (rbYellow.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorGroup", 0XFFFFFF00);
                    editor.apply();
                }
            }
        });
    }


}
