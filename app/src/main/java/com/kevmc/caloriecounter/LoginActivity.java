package com.kevmc.caloriecounter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //used to store checkbox and user login details if checked
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    //string to be passed to next activity so we load the correct user profile from shared prefs
    private String sharedPrefUsername;

    //elements of the activity layout page
    private EditText mUsername, mPassword;
    private Button mSignInBtn, mRegisterBtn;
    private CheckBox mRememberDetails;

    //object of class we created to save and load objects from shared prefs
    private static SharedPreferenceClass sharedPreferenceClass = new SharedPreferenceClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final String savedUsername = sharedPreferenceClass.getSharedPrefUsername(this);
        final String savedPassword = sharedPreferenceClass.getSharedPrefPassword(this);

        findViewsByIds();

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkRememberLoginDetails();

        mSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (savedUsername.equals("")) {
                    noUserRegisteredToast();
                    mUsername.setText("");
                    mPassword.setText("");

                } else {

                    String loginAttemptUsername = mUsername.getText().toString();
                    String loginAttemptPassword = mPassword.getText().toString();


                    if (savedUsername.equals(loginAttemptUsername)) {

                        if (savedPassword.equals(loginAttemptPassword)) {

                            sharedPrefUsername = loginAttemptUsername;

                            loginSuccessful();

                            Intent home_page = new Intent(LoginActivity.this, HomePage.class);
                            home_page.putExtra("username", sharedPrefUsername);
                            startActivity(home_page);

                        } else {
                            mPassword.setText("");
                            passwordIncorrectToast();
                        }

                    } else {
                        mUsername.setText("");
                        mPassword.setText("");
                        userNameNotFoundToast();
                    }

                }

                if (mRememberDetails.isChecked()) {
                    mEditor.putString(getString(R.string.store_checkbox), "True");
                    mEditor.commit();

                    String name = mUsername.getText().toString();
                    mEditor.putString(getString(R.string.store_username), name);
                    mEditor.commit();

                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.store_password), password);
                    mEditor.commit();

                } else {
                    //if user does not want to save
                    mEditor.putString(getString(R.string.store_checkbox), "False");
                    mEditor.commit();


                    mEditor.putString(getString(R.string.store_username), "");
                    mEditor.commit();


                    mEditor.putString(getString(R.string.store_password), "");
                    mEditor.commit();
                }

            }
        });//SIGN IN BTN ON CLICK LISTENER

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register_credentials = new Intent(LoginActivity.this, RegisterCredentials.class);
                startActivity(register_credentials);

            }
        });//REGISTER BTN ON CLICK LISTENER
    }//ON CREATE METHOD

    private void noUserRegisteredToast() {
        Toast.makeText(this, "No users are registered.  Please register to use the app.", Toast.LENGTH_SHORT).show();
    }

    private void userNameNotFoundToast() {
        Toast.makeText(this, "Username not found. Try again.", Toast.LENGTH_SHORT).show();
    }

    private void passwordIncorrectToast() {
        Toast.makeText(this, "Incorrect password for this user. Try again.", Toast.LENGTH_SHORT).show();
    }

    private void loginSuccessful() {
        Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show();
    }

    private void findViewsByIds() {

        mUsername = findViewById(R.id.login_username_et);
        mPassword = findViewById(R.id.login_password_et);
        mSignInBtn = findViewById(R.id.login_sign_in_btn);
        mRegisterBtn = findViewById(R.id.login_register_btn);
        mRememberDetails = findViewById(R.id.login_checkbox);
    }

    private void checkRememberLoginDetails() {

        String checkbox = mPreferences.getString(getString(R.string.store_checkbox), "False");
        String username = mPreferences.getString(getString(R.string.store_username), "");
        String password = mPreferences.getString(getString(R.string.store_password), "");

        mUsername.setText(username);
        mPassword.setText(password);

        if (checkbox.equals("True")) {
            mRememberDetails.setChecked(true);
        } else {
            mRememberDetails.setChecked(false);
        }
    }
}
