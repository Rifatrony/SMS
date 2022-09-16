package com.rony.sms.Activity.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.rony.sms.R;
import com.rony.sms.databinding.ActivityParentsDashboardBinding;

public class ParentsDashboardActivity extends AppCompatActivity {

    ActivityParentsDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityParentsDashboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }
}