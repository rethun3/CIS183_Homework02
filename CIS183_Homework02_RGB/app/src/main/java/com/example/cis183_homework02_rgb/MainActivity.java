package com.example.cis183_homework02_rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_j_red;
    TextView txt_j_green;
    TextView txt_j_blue;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    TextView txt_j_hex;
    Button btn_j_saveColor;
    View view;
    String hex;

    int red = 255;
    int green = 255;
    int blue = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = this.getWindow().getDecorView();

        txt_j_red = findViewById(R.id.txt_v_red);
        txt_j_green = findViewById(R.id.txt_v_green);
        txt_j_blue = findViewById(R.id.txt_v_blue);
        sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        txt_j_hex = findViewById(R.id.txt_v_hex);
        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);


        sb_j_red.setMax(255);
        sb_j_red.setProgress(255);
        sb_j_green.setMax(255);
        sb_j_green.setProgress(255);
        sb_j_blue.setMax(255);
        sb_j_blue.setProgress(255);

        rgbSliderValues();
    }

    public void rgbSliderValues()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                red = i;
                txt_j_red.setText(String.valueOf(i));
                view.setBackgroundColor(Color.rgb(red,green,blue));
                hex = String.format("#%02X%02X%02X",red,green,blue);
                txt_j_hex.setText(hex);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                green = i;
                txt_j_green.setText(String.valueOf(i));
                view.setBackgroundColor(Color.rgb(red,green,blue));
                hex = String.format("#%02X%02X%02X",red,green,blue);
                txt_j_hex.setText(hex);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                blue = i;
                txt_j_blue.setText(String.valueOf(i));
                view.setBackgroundColor(Color.rgb(red,green,blue));
                hex = String.format("#%02X%02X%02X",red,green,blue);
                txt_j_hex.setText(hex);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}