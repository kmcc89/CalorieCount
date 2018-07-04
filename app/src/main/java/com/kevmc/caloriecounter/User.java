package com.kevmc.caloriecounter;

/**
 * Created by kevmc on 03/07/2018.
 */

public class User {

    private String firstName;
    private int age;
    private float height;
    private float weight;
    private boolean isMale;
    private int activityLevel;

    private float basalMetabolicRate;
    private float bodyMassIndex;
    private float userTEE;

    public User(String firstName, int age, float height, float weight, boolean isMale, int activityLevel) {
        this.firstName = firstName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.isMale = isMale;
        this.activityLevel = activityLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(boolean male) {
        isMale = male;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public void calculateBMR(){

        //66.5 + (13.75 x weight kg) + (5.003 * height cm) - (6.755 * age years) men
        //655.1 + (9.563 * weight kg) + (1.850 * height cm) - (4.676 * age years) women

        if(isMale == true){

            //formula for male BMR
            basalMetabolicRate = 66.5f + (13.75f * weight) + (5.003f * height) - (6.755f * age);

        }else if(isMale == false){

            //formula for female BMR
            basalMetabolicRate = 655.1f + (9.563f * weight) + (1.850f * height) - (4.676f * age);

        }else{

            basalMetabolicRate = 0;
        }

    }

    public float getBasalMetabolicRate(){
        return basalMetabolicRate;
    }

    public void calculateBMI(){

        float heightInMetres = height/100;

        bodyMassIndex = weight / (heightInMetres * heightInMetres);

    }

    public float getBodyMassIndex(){
        return bodyMassIndex;
    }

    public void calculateTEE(){

        float activityWeight = 0;

        if(activityLevel == 1){
            activityWeight = 1.2f;
        }else if(activityLevel == 2){
            activityWeight = 1.375f;
        }else if(activityLevel == 3){
            activityWeight = 1.55f;
        }else if(activityLevel == 4){
            activityWeight = 1.725f;
        }else if(activityLevel == 5){
            activityWeight = 1.9f;
        }

        userTEE = basalMetabolicRate * activityWeight;
    }

    public float getUserTEE(){
        return userTEE;
    }


}
