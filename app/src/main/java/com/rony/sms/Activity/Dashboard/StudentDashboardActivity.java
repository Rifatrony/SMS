package com.rony.sms.Activity.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.rony.sms.Activity.NoticeActivity;
import com.rony.sms.Activity.ResultActivity;
import com.rony.sms.R;
import com.rony.sms.databinding.ActivityStudentDashboardBinding;

public class StudentDashboardActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityStudentDashboardBinding binding;

    ImageView imageMenu;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    CardView resultCardView, noticeCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStudentDashboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        initialization();
        setListener();

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        /*binding.routineCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StudentDashboardActivity.this, "Routine Clicked", Toast.LENGTH_SHORT).show();
            }
        });*/

        navigationView.setItemIconTintList(null);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);

                switch (id){
                    case R.id.profile:

                        Toast.makeText(StudentDashboardActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.notice:
                        startActivity(new Intent(getApplicationContext(), NoticeActivity.class));
                        break;

                    case R.id.result:
                        startActivity(new Intent(getApplicationContext(), ResultActivity.class));
                        break;

                    default:
                        return true;
                }
                return true;
            }
        });

    }

    private void initialization(){
        drawerLayout = findViewById(R.id.drawerLayout);
        imageMenu = findViewById(R.id.imageMenu);
        navigationView = findViewById(R.id.navigationView);

        resultCardView = findViewById(R.id.resultCardView);
        noticeCardView = findViewById(R.id.noticeCardView);
    }

    private void setListener(){
        resultCardView.setOnClickListener(this);
        noticeCardView.setOnClickListener(this);
        binding.routineCardView.setOnClickListener(this);
        binding.accountCardView.setOnClickListener(this);
        binding.calenderCardView.setOnClickListener(this);
        binding.booksCardView.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.routineCardView:
                Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.resultCardView:
                startActivity(new Intent(getApplicationContext(), ResultActivity.class));
                break;

            case R.id.accountCardView:
                Toast.makeText(this, "Account Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.noticeCardView:
                startActivity(new Intent(getApplicationContext(), NoticeActivity.class));
                break;

            case R.id.booksCardView:
                Toast.makeText(this, "Books Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.calenderCardView:
                Toast.makeText(this, "Calender Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}