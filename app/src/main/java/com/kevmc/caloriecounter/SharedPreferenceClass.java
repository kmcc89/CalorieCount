package com.kevmc.caloriecounter;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevmc on 02/07/2018.
 */

public class SharedPreferenceClass {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String USER_DETAILS_PREFS_NAME = "USER_DETAILS_PREF";
    public static final String USER_DETAILS_PREFS_KEY = "USER_PREFS_KEY";

    public static final String USER_CRED_PREF_NAME = "USER_CRED_PREF";
    public static final String USER_CRED_PREF_KEY = "USER_CRED_KEY";

    public static final String PASS_CRED_PREF_NAME = "PASS_CRED_PREF";
    public static final String PASS_CRED_PREF_KEY = "PASS_CRED_KEY";

    public static final String DETAILS_PREF_NAME = "USER_NAME";
    public static final String DETAILS_PREF_NAME_KEY = "USER_NAME_KEY";

    public static final String DETAILS_PREF_AGE = "USER_AGE";
    public static final String DETAILS_PREF_AGE_KEY = "USER_AGE_KEY";

    public static final String DETAILS_PREF_HEIGHT = "USER_HEIGHT";
    public static final String DETAILS_PREF_HEIGHT_KEY = "USER_HEIGHT_KEY";

    public static final String DETAILS_PREF_WEIGHT = "USER_WEIGHT";
    public static final String DETAILS_PREF_WEIGHT_KEY = "USER_WEIGHT_KEY";

    public static final String DETAILS_PREF_GENDER = "USER_GENDER";
    public static final String DETAILS_PREF_GENDER_KEY = "USER_GENDER_KEY";

    public static final String DETAILS_PREF_ACTIVITY_LEVEL = "USER_ACTIVITY_LEVEL";
    public static final String DETAILS_PREF_ACTIVITY_LEVEL_KEY = "USER_ACTIVITY_LEVEL_KEY";



    public SharedPreferenceClass(){
        super();
    }

    public void saveUser(Context context, String text){

        mSharedPreferences = context.getSharedPreferences(USER_DETAILS_PREFS_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        editor.putString(USER_DETAILS_PREFS_KEY, text);

        editor.commit();
    }

    public String getUserObject(Context context){

        String text;

        mSharedPreferences = context.getSharedPreferences(USER_DETAILS_PREFS_NAME, Context.MODE_PRIVATE);

        text = mSharedPreferences.getString(USER_DETAILS_PREFS_KEY, null);

        return text;
    }

    public void saveSharedPrefUsername (Context context, String username){

        mSharedPreferences = context.getSharedPreferences(USER_CRED_PREF_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        editor.putString(USER_CRED_PREF_KEY, username);

        editor.commit();
    }

    public String getSharedPrefUsername(Context context){

        //Type type = new TypeToken<List<UserLoginCredentials>>(){}.getType();

        mSharedPreferences = context.getSharedPreferences(USER_CRED_PREF_NAME, Context.MODE_PRIVATE);


        String usernameString = mSharedPreferences.getString(USER_CRED_PREF_KEY, "");

        //ArrayList<UserLoginCredentials> userLoginCredentialsList  = gson.fromJson(text, type);

        return usernameString;
    }

    public void saveSharedPrefPassword(Context context, String password){


        mSharedPreferences = context.getSharedPreferences(PASS_CRED_PREF_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        editor.putString(PASS_CRED_PREF_KEY, password);

        editor.commit();
    }

    public String getSharedPrefPassword(Context context){

        mSharedPreferences = context.getSharedPreferences(PASS_CRED_PREF_NAME, Context.MODE_PRIVATE);

        String passwordString = mSharedPreferences.getString(PASS_CRED_PREF_KEY, "");

        return passwordString;
    }

    public void saveSharedPrefName(Context context, String name){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putString(DETAILS_PREF_NAME_KEY, name);
        editor.commit();
    }

    public String getSharedPrefName(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_NAME, Context.MODE_PRIVATE);
        String name = mSharedPreferences.getString(DETAILS_PREF_NAME_KEY, "");
        return name;
    }

    public void saveSharedPrefAge(Context context, int age){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_AGE, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putInt(DETAILS_PREF_AGE_KEY, age);
        editor.commit();
    }

    public int getSharedPrefAge(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_AGE, Context.MODE_PRIVATE);
        int age = mSharedPreferences.getInt(DETAILS_PREF_AGE_KEY, 0);
        return age;
    }

    public void saveSharedPrefHeight(Context context, float height){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_HEIGHT, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putFloat(DETAILS_PREF_HEIGHT_KEY, height);
        editor.commit();
    }

    public float getSharedPrefHeight(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_HEIGHT, Context.MODE_PRIVATE);
        float height = mSharedPreferences.getFloat(DETAILS_PREF_HEIGHT_KEY, 0);
        return height;
    }

    public void saveSharedPrefWeight(Context context, float weight){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_WEIGHT, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putFloat(DETAILS_PREF_WEIGHT_KEY, weight);
        editor.commit();
    }

    public float getSharedPrefWeight(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_WEIGHT, Context.MODE_PRIVATE);
        float weight = mSharedPreferences.getFloat(DETAILS_PREF_WEIGHT_KEY, 0);
        return weight;
    }

    public void saveSharedPrefGender(Context context, boolean isMale){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_GENDER, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putBoolean(DETAILS_PREF_GENDER_KEY, isMale);
        editor.commit();
    }

    public boolean getSharedPrefGender(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_GENDER, Context.MODE_PRIVATE);
        boolean isMale = mSharedPreferences.getBoolean(DETAILS_PREF_GENDER_KEY, true);
        return isMale;
    }

    public void saveSharedPrefActivityLevel(Context context, int activityLevel){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_ACTIVITY_LEVEL, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putInt(DETAILS_PREF_ACTIVITY_LEVEL_KEY, activityLevel);
        editor.commit();
    }

    public int getSharedPrefActivityLevel(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_ACTIVITY_LEVEL, Context.MODE_PRIVATE);
        int activityLevel = mSharedPreferences.getInt(DETAILS_PREF_ACTIVITY_LEVEL_KEY, 1);
        return activityLevel;
    }


}
