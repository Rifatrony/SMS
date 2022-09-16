package com.rony.sms.Activity.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rony.sms.databinding.ActivityTeacherDashboardBinding;

public class TeacherDashboardActivity extends AppCompatActivity {

    ActivityTeacherDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTeacherDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}