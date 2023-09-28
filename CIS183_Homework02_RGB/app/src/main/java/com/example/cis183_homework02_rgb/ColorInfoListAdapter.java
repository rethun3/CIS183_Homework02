package com.example.cis183_homework02_rgb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorInfoListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listOfColors;

    public ColorInfoListAdapter(Context c, ArrayList<ColorInfo> ci)
    {
        context = c;
        listOfColors = ci;
    }

    @Override
    public int getCount() {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflator.inflate(R.layout.custom_cell, null);
        }

        TextView red = view.findViewById(R.id.tv_v_red);
        TextView green = view.findViewById(R.id.tv_v_green);
        TextView blue = view.findViewById(R.id.tv_v_blue);
        TextView hex = view.findViewById(R.id.tv_v_hex);

        ColorInfo color = listOfColors.get(i);

        red.setText("Red: " + color.getRed());
        green.setText("Green: " + color.getGreen());
        blue.setText("Blue: " + color.getBlue());
        hex.setText("Hex: " + color.getHex());
        //change cell color
        view.setBackgroundColor(Color.rgb(Integer.parseInt(color.getRed()),Integer.parseInt(color.getGreen()),Integer.parseInt(color.getBlue())));

        if(Integer.parseInt(color.getRed()) <= 100 && Integer.parseInt(color.getGreen()) <= 100 && Integer.parseInt(color.getBlue()) <= 100)
        {
            red.setTextColor(Color.parseColor("#FFFFFF"));
            green.setTextColor(Color.parseColor("#FFFFFF"));
            blue.setTextColor(Color.parseColor("#FFFFFF"));
            hex.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if(Integer.parseInt(color.getRed()) >= 100 && Integer.parseInt(color.getGreen()) >= 100 && Integer.parseInt(color.getBlue()) >= 100)
        {
            red.setTextColor(Color.parseColor("#000000"));
            green.setTextColor(Color.parseColor("#000000"));
            blue.setTextColor(Color.parseColor("#000000"));
            hex.setTextColor(Color.parseColor("#000000"));
        }

        return view;
    }
}
