package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Insert extends AppCompatActivity {

    private LinearLayout layout001, layout002, layout003, layout004, layout005;
    private View icon_001, icon_002, icon_003, icon_004;
    private ImageButton switch01, switch02, switch03, switch04;
    private ImageButton star100, star101, star102;
    private ImageButton back, done, down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_insert);
        getContentViews();

        switch01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchLayout(layout002, icon_001, true);
            }
        });
        switch02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchLayout(layout003, icon_002, true);
            }
        });
        switch03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchLayout(layout004, icon_003, true);
            }
        });
        switch04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchLayout(layout005, icon_004, true);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchLayout(layout001, icon_001, false);
            }
        });
        star100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchLayout(layout001, icon_001, false);
            }
        });
        star101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchLayout(layout001, icon_001, false);
            }
        });
        star102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchLayout(layout001, icon_001, false);
            }
        });

    }

    private void SwitchLayout(LinearLayout userOption, View highlight, boolean miniView) {
        layout001.setVisibility(View.GONE);
        layout002.setVisibility(View.GONE);
        layout003.setVisibility(View.GONE);
        layout004.setVisibility(View.GONE);
        layout005.setVisibility(View.GONE);
        icon_001.setVisibility(View.INVISIBLE);
        icon_002.setVisibility(View.INVISIBLE);
        icon_003.setVisibility(View.INVISIBLE);
        icon_004.setVisibility(View.INVISIBLE);

        if (miniView){
            star100.setVisibility(View.VISIBLE);
            star101.setVisibility(View.VISIBLE);
            star102.setVisibility(View.VISIBLE);
            down.setVisibility(View.VISIBLE);
            highlight.setVisibility(View.VISIBLE);
        } else {
            star100.setVisibility(View.INVISIBLE);
            star101.setVisibility(View.INVISIBLE);
            star102.setVisibility(View.INVISIBLE);
            down.setVisibility(View.INVISIBLE);
        }

        userOption.setVisibility(View.VISIBLE);
    }

    private void getContentViews() {
        layout001 = findViewById(R.id.A00_Layout001);
        layout002 = findViewById(R.id.A00_Layout002);
        layout003 = findViewById(R.id.A00_Layout003);
        layout004 = findViewById(R.id.A00_Layout004);
        layout005 = findViewById(R.id.A00_Layout005);
        switch01 = findViewById(R.id.A00Switch001);
        switch02 = findViewById(R.id.A00Switch002);
        switch03 = findViewById(R.id.A00Switch003);
        switch04 = findViewById(R.id.A00Switch004);
        star100 = findViewById(R.id.A00_Star100);
        star101 = findViewById(R.id.A00_Star101);
        star102 = findViewById(R.id.A00_Star102);
        icon_001 = findViewById(R.id.A00_Icon_001);
        icon_002 = findViewById(R.id.A00_Icon_002);
        icon_003 = findViewById(R.id.A00_Icon_003);
        icon_004 = findViewById(R.id.A00_Icon_004);
        down = findViewById(R.id.A00_Down);
        back = findViewById(R.id.A00_Back);
        done = findViewById(R.id.A00_Done);
    }
}