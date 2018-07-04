package com.kevmc.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class HomePage extends AppCompatActivity {

    private SharedPreferenceClass sharedPreferenceClass;
    private Gson gson;
    private Activity context = this;
    private User user;

    private TextView welcomeTv, calorieAllowanceDisplay;

    private Button accountBtn, calorieCounterBtn, foodBtn, activityBtn, resourcesBtn;

    private String name;
    private int age, activityLevel;
    private float userHeight, userWeight;
    private boolean isMale;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        findViewsByIds();

        sharedPreferenceClass = new SharedPreferenceClass();

        name = sharedPreferenceClass.getSharedPrefName(this);
        age = sharedPreferenceClass.getSharedPrefAge(this);
        userHeight = sharedPreferenceClass.getSharedPrefHeight(this);
        userWeight = sharedPreferenceClass.getSharedPrefWeight(this);
        isMale = sharedPreferenceClass.getSharedPrefGender(this);
        activityLevel = sharedPreferenceClass.getSharedPrefActivityLevel(this);

        user = new User(name, age, userHeight, userWeight, isMale, activityLevel);

        user.calculateBMR();
        user.calculateTEE();

        float userTee = user.getUserTEE();
        String userTeeStr = String.valueOf(userTee);

        welcomeTv.setText(name);
        calorieAllowanceDisplay.setText(userTeeStr);







//        String sharedPrefUser = sharedPreferenceClass.getUserObject(this);
//        gson = new Gson();
//        user = gson.fromJson(sharedPrefUser, User.class);
//
//        user.calculateBMR();
//        user.calculateTEE();
//


//        Intent intent = getIntent();
//        Bundle bd = intent.getExtras();
//
//        if(bd != null){
//            String username = bd.getString("username");
//
//        }
    }

    private void findViewsByIds() {
        welcomeTv = findViewById(R.id.display_name_tv);
        calorieAllowanceDisplay = findViewById(R.id.display_cal_allowance_tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if(id == R.id.home){

            Intent home = new Intent(HomePage.this, HomePage.class);
            startActivity(home);

        }else if(id == R.id.calorie_counter){

            Intent calorie_counter = new Intent(HomePage.this, CalorieCounter.class);
            startActivity(calorie_counter);

        }else if(id == R.id.food){

            Intent food_section = new Intent(HomePage.this, FoodMain.class);
            startActivity(food_section);

        }else if(id == R.id.activities){

            Intent activity_section = new Intent(HomePage.this, ActivitiesMain.class);
            startActivity(activity_section);

        }else if(id == R.id.resources){

            Intent resource_section = new Intent(HomePage.this, ResourcesMain.class);
            startActivity(resource_section);

        }else if(id == R.id.exit){
            finish();
        }

        return super.onOptionsItemSelected(item);

    }


}
