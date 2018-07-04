package com.kevmc.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RegisterPersonalDetails extends AppCompatActivity {

    Activity context = this;

    private SharedPreferenceClass sharedPreferenceClass;

    private TextView welcomeMessage;

    private EditText mName, mAge, mHeight, mWeight, mActivityLevel;
    private RadioButton genderRadioBtn;
    private Button registerDetailsBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_personal_details);

        findViewsByIds();

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        if(bd != null){
            String username = bd.getString("username");
            welcomeMessage.setText("Welcome "+username);
        }

        registerDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mName.getText().toString().equals("") || mAge.getText().toString().equals("") || mHeight.getText().toString().equals("") || mWeight.getText().toString().equals("") || mActivityLevel.getText().toString().equals("")){
                    resetFields();
                    fieldsCantBeBlankToast();

                }else{

                    String name = mName.getText().toString();
                    int age = Integer.valueOf(mAge.getText().toString());
                    float userHeight = Float.valueOf(mHeight.getText().toString());
                    float userWeight = Float.valueOf(mWeight.getText().toString());
                    boolean isMale = Boolean.valueOf(genderRadioBtn.isChecked());
                    int activityLevel = Integer.valueOf(mActivityLevel.getText().toString());

                    //User userToReg = new User(name, age, userHeight, userWeight, isMale, activityLevel);

//                    gson = new GsonBuilder().create();
                    sharedPreferenceClass = new SharedPreferenceClass();
                    
//
//                    String jsonString = gson.toJson(userToReg);
//
//                    sharedPreferenceClass.saveUser(context, jsonString);

                    personalDetailsRegistered();

                    Intent home_page = new Intent(RegisterPersonalDetails.this, HomePage.class);
                    startActivity(home_page);
                }


            }
        });


    }

    private void personalDetailsRegistered() {
        Toast.makeText(this, "Personal Details Successfully Registered", Toast.LENGTH_SHORT).show();
    }

    private void resetFields(){
        mName.setText("");
        mAge.setText("");
        mHeight.setText("");
        mWeight.setText("");
        mActivityLevel.setText("");
    }
    private void fieldsCantBeBlankToast() {
        Toast.makeText(this, "Fields cannot be blank. Enter details again.", Toast.LENGTH_SHORT).show();
    }

    private void findViewsByIds() {
        welcomeMessage = findViewById(R.id.register_personal_details_welcome_tv);
        mName = findViewById(R.id.user_register_name_et);
        mAge = findViewById(R.id.user_register_age_et);
        mHeight = findViewById(R.id.user_register_height_et);
        mWeight = findViewById(R.id.user_register_weight_et);
        mActivityLevel = findViewById(R.id.user_register_activity_level_et);
        genderRadioBtn = findViewById(R.id.user_male_radio_btn);
        registerDetailsBtn = findViewById(R.id.user_register_button);
    }
}
