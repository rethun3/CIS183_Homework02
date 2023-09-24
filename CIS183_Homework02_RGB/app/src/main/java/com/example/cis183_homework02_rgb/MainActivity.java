package com.example.cis183_homework02_rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_j_red = findViewById(R.id.txt_v_red);
        txt_j_green = findViewById(R.id.txt_v_green);
        txt_j_blue = findViewById(R.id.txt_v_blue);
        sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        txt_j_hex = findViewById(R.id.txt_v_hex);
        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
    }
}