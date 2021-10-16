package com.example.diary;

import static android.view.GestureDetector.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Insert extends AppCompatActivity {

    private LinearLayout insertLayout, layout001, layout002, layout003, layout004, layout005, layout006, dummy;
    private View icon_001, icon_002, icon_003, icon_004;
    private TextView option_001, option_002, option_003, option_004;
    private ImageButton switch01, switch02, switch03, switch04;
    private CheckBox star100, star101, star102, star000, star001, star002;
    private ImageButton back, done, down;
    private CheckBox MedicineSwitch;
    private boolean[] meals = {false,false,false,false}, medicine = {false,false,false,false};
    private TextView meals01, meals02, meals03, meals04;
    private TextView medicine01, medicine02, medicine03, medicine04;
    private byte[] drinks = {0,0,0};
    private TextView drinkOption01,drinkOption02,drinkOption03,drinkCount01,drinkCount02,drinkCount03;
    private EditText editText00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_insert);
        getContentViews();

        switch01.setOnClickListener(v -> SwitchLayout(layout002, option_001, icon_001, true));
        switch02.setOnClickListener(v -> SwitchLayout(layout003, option_002, icon_002, true));
        switch03.setOnClickListener(v -> SwitchLayout(layout004, option_003, icon_003, true));
        switch04.setOnClickListener(v -> SwitchLayout(layout005, option_004, icon_004, true));
        down.setOnClickListener(v -> SwitchLayout(layout001, option_001, icon_001, false));
        star100.setOnClickListener(v -> SwitchLayout(layout001, option_001, icon_001, false));
        star101.setOnClickListener(v -> SwitchLayout(layout001, option_001, icon_001, false));
        star102.setOnClickListener(v -> SwitchLayout(layout001, option_001, icon_001, false));
        star000.setOnClickListener(V -> ratingValue(0));
        star001.setOnClickListener(V -> ratingValue(1));
        star002.setOnClickListener(V -> ratingValue(2));
//        MedicineSwitch.setOnClickListener(v -> MedicineSwitchVisisbility());
        meals01.setOnClickListener(v -> MealsSwitchOptions(meals01,0));
        meals02.setOnClickListener(v -> MealsSwitchOptions(meals02,1));
        meals03.setOnClickListener(v -> MealsSwitchOptions(meals03,2));
        meals04.setOnClickListener(v -> MealsSwitchOptions(meals04,3));
        medicine01.setOnClickListener(v -> MedicineSwitchOptions(medicine01,0));
        medicine02.setOnClickListener(v -> MedicineSwitchOptions(medicine02,1));
        medicine03.setOnClickListener(v -> MedicineSwitchOptions(medicine03,2));
        medicine04.setOnClickListener(v -> MedicineSwitchOptions(medicine04,3));
        drinkOption01.setOnClickListener(V -> drinkCounter(drinkCount01, 0, true));
        drinkOption02.setOnClickListener(V -> drinkCounter(drinkCount02, 1, true));
        drinkOption03.setOnClickListener(V -> drinkCounter(drinkCount03, 2, true));
        drinkOption01.setOnLongClickListener(v -> {
            drinkCounter(drinkCount01, 0, false);
            return true;
        });
        drinkOption02.setOnLongClickListener(v -> {
            drinkCounter(drinkCount02, 1, false);
            return true;
        });
        drinkOption03.setOnLongClickListener(v -> {
            drinkCounter(drinkCount03, 2, false);
            return true;
        });
//        editText00.setOnClickListener(V -> popUpEditText());


//        layout002.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
//            public void onSwipeLeft() {
//                SwitchLayout(layout003, option_002, icon_002, true);
//            }
//            public void onSwipeRight() {
//                SwitchLayout(layout005, option_004, icon_004, true);
//            }
//        });
//
//        layout003.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
//            public void onSwipeRight() {
//                SwitchLayout(layout004, option_003, icon_003, true);
//            }
//            public void onSwipeLeft() {
//                SwitchLayout(layout003, option_002, icon_002, true);
//            }
//
//        });

    }

    private void ratingValue(int i) {
        star000.setChecked(true);
        star100.setChecked(true);
        if(i == 1){
            star001.setChecked(true);
            star002.setChecked(false);
            star101.setChecked(true);
            star102.setChecked(false);
        } else if (i == 2){
            star001.setChecked(true);
            star002.setChecked(true);
            star101.setChecked(true);
            star102.setChecked(true);
        } else {
            star001.setChecked(false);
            star002.setChecked(false);
            star101.setChecked(false);
            star102.setChecked(false);
        }
    }

    private void drinkCounter(TextView drinkText, int i, boolean scale) {
        if(scale){
            if(drinks[i] == 99) Snackbar.make(insertLayout, "Maximum limit reached. Long press to reset the count", Snackbar.LENGTH_SHORT).show();
            else drinks[i] += 1;
        } else drinks[i] = 0;
        drinkText.setText(String.valueOf(drinks[i]));
    }

    private void MedicineSwitchOptions(TextView view, int position) {
        if(medicine[position] == false){
            view.setBackgroundResource(R.drawable.border_line_02);
            medicine[position] = true;
        } else {
            view.setBackgroundResource(R.drawable.border_line_01);
            medicine[position] = false;
        }
    }

    private void MealsSwitchOptions(TextView view, int position) {
        if(meals[position] == false){
            view.setBackgroundResource(R.drawable.border_line_02);
            meals[position] = true;
        } else {
            view.setBackgroundResource(R.drawable.border_line_01);
            meals[position] = false;
        }
    }

//    private void MedicineSwitchVisisbility() {
//        layout006.setVisibility(View.INVISIBLE);
//        if(MedicineSwitch.isChecked()) layout006.setVisibility(View.VISIBLE);
//    }

    private void SwitchLayout(LinearLayout userOption, TextView text, View highlight, boolean miniView) {
        layout001.setVisibility(View.GONE);
        layout002.setVisibility(View.GONE);
        layout003.setVisibility(View.GONE);
        layout004.setVisibility(View.GONE);
        layout005.setVisibility(View.GONE);
        icon_001.setVisibility(View.INVISIBLE);
        icon_002.setVisibility(View.INVISIBLE);
        icon_003.setVisibility(View.INVISIBLE);
        icon_004.setVisibility(View.INVISIBLE);
//        option_001.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
//        option_002.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
//        option_003.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
//        option_004.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

        if (miniView){
            star100.setVisibility(View.VISIBLE);
            star101.setVisibility(View.VISIBLE);
            star102.setVisibility(View.VISIBLE);
            down.setVisibility(View.VISIBLE);
            highlight.setVisibility(View.VISIBLE);
            dummy.setVisibility(View.GONE);
        } else {
            star100.setVisibility(View.INVISIBLE);
            star101.setVisibility(View.INVISIBLE);
            star102.setVisibility(View.INVISIBLE);
            down.setVisibility(View.INVISIBLE);
            dummy.setVisibility(View.VISIBLE);
        }

        userOption.setVisibility(View.VISIBLE);
//        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);

    }

    private void getContentViews() {
//        MedicineSwitch = findViewById(R.id.InsertMedicineSwitch);
        medicine01 = findViewById(R.id.InsertMedicine01);
        medicine02 = findViewById(R.id.InsertMedicine02);
        medicine03 = findViewById(R.id.InsertMedicine03);
        medicine04 = findViewById(R.id.InsertMedicine04);
        meals01 = findViewById(R.id.InsertMeals01);
        meals02 = findViewById(R.id.InsertMeals02);
        meals03 = findViewById(R.id.InsertMeals03);
        meals04 = findViewById(R.id.InsertMeals04);
        drinkOption01 = findViewById(R.id.InsertDrink001);
        drinkOption02 = findViewById(R.id.InsertDrink002);
        drinkOption03 = findViewById(R.id.InsertDrink003);
        drinkCount01 = findViewById(R.id.InsertDrinkCount001);
        drinkCount02 = findViewById(R.id.InsertDrinkCount002);
        drinkCount03 = findViewById(R.id.InsertDrinkCount003);
        option_001 = findViewById(R.id.InsertOption01);
        option_002 = findViewById(R.id.InsertOption02);
        option_003 = findViewById(R.id.InsertOption03);
        option_004 = findViewById(R.id.InsertOption04);
        insertLayout = findViewById(R.id.InsertLayout);
        editText00 = findViewById(R.id.InsertEditTextGeneric);
        layout001 = findViewById(R.id.A00_Layout001);
        layout002 = findViewById(R.id.A00_Layout002);
        layout003 = findViewById(R.id.A00_Layout003);
        layout004 = findViewById(R.id.A00_Layout004);
        layout005 = findViewById(R.id.A00_Layout005);
        layout006 = findViewById(R.id.A00_Layout006);
        switch01 = findViewById(R.id.A00Switch001);
        switch02 = findViewById(R.id.A00Switch002);
        switch03 = findViewById(R.id.A00Switch003);
        switch04 = findViewById(R.id.A00Switch004);
        star100 = findViewById(R.id.A00_Star010);
        star101 = findViewById(R.id.A00_Star011);
        star102 = findViewById(R.id.A00_Star012);
        star000 = findViewById(R.id.A00_Star000);
        star001 = findViewById(R.id.A00_Star001);
        star002 = findViewById(R.id.A00_Star002);
        icon_001 = findViewById(R.id.A00_Icon_001);
        icon_002 = findViewById(R.id.A00_Icon_002);
        icon_003 = findViewById(R.id.A00_Icon_003);
        icon_004 = findViewById(R.id.A00_Icon_004);
        dummy = findViewById(R.id.InsertDummyView);
        down = findViewById(R.id.A00_Down);
        back = findViewById(R.id.A00_Back);
        done = findViewById(R.id.A00_Done);
    }

    private void popUpEditText() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Comments");

        final EditText input = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something here on OK

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }
}