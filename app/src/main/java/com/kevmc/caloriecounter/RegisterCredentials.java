package com.kevmc.caloriecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterCredentials extends AppCompatActivity {

    private EditText mUsername, mPassword, mRetypePassword;
    private Button mRegisterBtn;

    private SharedPreferenceClass sharedPreferenceClass = new SharedPreferenceClass();
    private String username, password, retypedPassword, savedUsername, savedPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_credentials);

        findViewsByIds();

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = mUsername.getText().toString();
                password = mPassword.getText().toString();
                retypedPassword = mRetypePassword.getText().toString();

                if (!(username.equals("")) && !(password.equals("")) && checkPasswordEquality() == true) {
                    savedUsername = username;
                    savedPassword = password;
                    saveUserCredentials();
                } else {

                    if((username.equals("")) ||  (password.equals("")) || retypedPassword.equals("")){
                        registerProblemToast();
                        resetFields();
                    }else if(checkPasswordEquality() == false){
                        passwordMismatchToast();
                        mPassword.setText("");
                        mRetypePassword.setText("");
                    }
                }
            }
        });
    }

    private void registerProblemToast() {
        Toast.makeText(this, "Fields cannot be null and password must match. Try again.", Toast.LENGTH_LONG).show();
    }

    private void passwordMismatchToast(){
        Toast.makeText(this, "Passwords must match.  Try again.", Toast.LENGTH_SHORT).show();
    }

    private boolean checkPasswordEquality() {

        if (password.equals(retypedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    private void saveUserCredentials() {

        sharedPreferenceClass.saveSharedPrefUsername(this, savedUsername);
        sharedPreferenceClass.saveSharedPrefPassword(this, savedPassword);

        accountCreatedToast();

        Intent register_personal_details = new Intent(RegisterCredentials.this, RegisterPersonalDetails.class);
        register_personal_details.putExtra("username", username);
        startActivity(register_personal_details);
    }

    private void accountCreatedToast() {
        Toast.makeText(this, "Account successfully created.", Toast.LENGTH_SHORT).show();
    }

    private void resetFields() {
        mUsername.setText("");
        mPassword.setText("");
        mRetypePassword.setText("");
    }

    private void findViewsByIds() {
        mUsername = findViewById(R.id.register_cred_username_et);
        mPassword = findViewById(R.id.register_cred_password_et);
        mRetypePassword = findViewById(R.id.register_cred_retype_pass_et);
        mRegisterBtn = findViewById(R.id.register_cred_btn);
    }
}
