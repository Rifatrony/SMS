package com.rony.sms.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.rony.sms.Activity.Dashboard.StudentDashboardActivity;
import com.rony.sms.R;

public class LoginActivity extends AppCompatActivity {

    EditText idEditText, passwordEditText;
    AppCompatButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setStatusBarColor(Color.parseColor("#38B6FF"));

        initialization();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), StudentDashboardActivity.class));
            }
        });
    }

    private void initialization() {
        idEditText = findViewById(R.id.idEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
    }
}