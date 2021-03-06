package com.pits.smbbrowse.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.pits.smbbrowse.R;
import com.pits.smbbrowse.utils.AppGlobals;
import com.pits.smbbrowse.utils.UiHelpers;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mHostEntry;
    private EditText mUsernameEntry;
    private EditText mPasswordEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mHostEntry = (EditText) findViewById(R.id.host_address_entry);
        mUsernameEntry = (EditText) findViewById(R.id.username_entry);
        mPasswordEntry = (EditText) findViewById(R.id.password_entry);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_submit:
                String hostnameFieldText = mHostEntry.getText().toString();
                String usernameFieldText = mUsernameEntry.getText().toString();
                String passwordFieldText = mPasswordEntry.getText().toString();

                if (hostnameFieldText.isEmpty() || usernameFieldText.isEmpty() ||
                        passwordFieldText.isEmpty()) {

                    UiHelpers.showLongToast(
                            getApplicationContext(), "All fields are required to be filled");
                } else {
                    AppGlobals.setSambaHostAddress(hostnameFieldText);
                    AppGlobals.setUsername(usernameFieldText);
                    AppGlobals.setPassword(passwordFieldText);
                    AppGlobals.setIsRunningForTheFirstTime(false);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
        }
    }
}
