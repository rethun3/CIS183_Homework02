package com.example.cis183_homework02_rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //rgb texts---------------------
    TextView txt_j_red;
    TextView txt_j_green;
    TextView txt_j_blue;
    TextView txt_j_hex;
    //sliders ----------------------
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    //regular text for color changes
    TextView j_red;
    TextView j_green;
    TextView j_blue;
    TextView j_hex;
    //------------------------------
    Button btn_j_saveColor;
    ListView lv_j_listOfColors;
    View view;
    String hex;
    ArrayList<ColorInfo> listOfColors;
    ColorInfoListAdapter adapter;

    int red = 255;
    int green = 255;
    int blue = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //code to UI background connection
        view = this.getWindow().getDecorView();

        txt_j_red = findViewById(R.id.txt_v_red);
        txt_j_green = findViewById(R.id.txt_v_green);
        txt_j_blue = findViewById(R.id.txt_v_blue);
        sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        txt_j_hex = findViewById(R.id.txt_v_hex);
        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
        lv_j_listOfColors = findViewById(R.id.lv_v_listOfColors);
        j_red = findViewById(R.id.v_red);
        j_green = findViewById(R.id.v_green);
        j_blue = findViewById(R.id.v_blue);
        j_hex = findViewById(R.id.v_hex);
        //-------slider values--------------

        sb_j_red.setMax(255);
        sb_j_red.setProgress(255);
        sb_j_green.setMax(255);
        sb_j_green.setProgress(255);
        sb_j_blue.setMax(255);
        sb_j_blue.setProgress(255);

        view.setBackgroundColor(Color.rgb(255,255,255));
        changeTextColor();
        listOfColors = new ArrayList<ColorInfo>();

        rgbSliderValues();
        saveColorButtonEventHandler();
        fillListView();
        clickListView();
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
                //creates the hex representation
                hex = String.format("%02X%02X%02X",red,green,blue);
                txt_j_hex.setText(hex);
                changeTextColor();
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
                hex = String.format("%02X%02X%02X",red,green,blue);
                txt_j_hex.setText(hex);
                changeTextColor();
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
                hex = String.format("%02X%02X%02X",red,green,blue);
                txt_j_hex.setText(hex);
                changeTextColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void saveColorButtonEventHandler()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Button Press", "color saved");
                addColor();
                displayListOfColors();
                clearColor();
                adapter.notifyDataSetChanged();
            }
        });
    }
    //adds new cell to arraylist
    public void addColor()
    {
        ColorInfo newColor = new ColorInfo();

        String red = txt_j_red.getText().toString();
        String green = txt_j_green.getText().toString();
        String blue = txt_j_blue.getText().toString();
        String hex = txt_j_hex.getText().toString();

        newColor.setRed(red);
        newColor.setGreen(green);
        newColor.setBlue(blue);
        newColor.setHex(hex);

        listOfColors.add(newColor);
    }
    //returns screen to default color
    public void clearColor()
    {
        sb_j_red.setProgress(255);
        sb_j_green.setProgress(255);
        sb_j_blue.setProgress(255);
    }
    //Logcat use only
    public void displayListOfColors()
    {
        for(int i = 0; i < listOfColors.size(); i++)
        {
            Log.d("Red: ", listOfColors.get(i).getRed().toString());
        }
    }
    //adds new cell to screen
    public void fillListView()
    {
        adapter = new ColorInfoListAdapter(this,listOfColors);
        lv_j_listOfColors.setAdapter(adapter);
    }
    //clickable cell, displays cell color
    public void clickListView()
    {
        lv_j_listOfColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.d("ListView Press", listOfColors.get(i).getRed());

                sb_j_red.setProgress(Integer.parseInt(listOfColors.get(i).getRed()));
                sb_j_green.setProgress(Integer.parseInt(listOfColors.get(i).getGreen()));
                sb_j_blue.setProgress(Integer.parseInt(listOfColors.get(i).getBlue()));
            }
        });
    }

    public void changeTextColor()
    {
        if(sb_j_red.getProgress() <= 100 && sb_j_green.getProgress() <= 100 && sb_j_blue.getProgress() <= 100)
        {
            txt_j_red.setTextColor(Color.parseColor("#FFFFFF"));
            txt_j_green.setTextColor(Color.parseColor("#FFFFFF"));
            txt_j_blue.setTextColor(Color.parseColor("#FFFFFF"));
            txt_j_hex.setTextColor(Color.parseColor("#FFFFFF"));
            j_red.setTextColor(Color.parseColor("#FFFFFF"));
            j_green.setTextColor(Color.parseColor("#FFFFFF"));
            j_blue.setTextColor(Color.parseColor("#FFFFFF"));
            j_hex.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if(sb_j_red.getProgress() >= 100 && sb_j_green.getProgress() >= 100 && sb_j_blue.getProgress() >= 100)
        {
            txt_j_red.setTextColor(Color.parseColor("#000000"));
            txt_j_green.setTextColor(Color.parseColor("#000000"));
            txt_j_blue.setTextColor(Color.parseColor("#000000"));
            txt_j_hex.setTextColor(Color.parseColor("#000000"));
            j_red.setTextColor(Color.parseColor("#000000"));
            j_green.setTextColor(Color.parseColor("#000000"));
            j_blue.setTextColor(Color.parseColor("#000000"));
            j_hex.setTextColor(Color.parseColor("#000000"));
        }
    }
}