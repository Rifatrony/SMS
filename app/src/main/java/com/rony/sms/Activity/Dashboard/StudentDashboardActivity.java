package com.rony.sms.Activity.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.rony.sms.R;

public class StudentDashboardActivity extends AppCompatActivity {

    ImageView imageMenu;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        drawerLayout = findViewById(R.id.drawerLayout);
        imageMenu = findViewById(R.id.imageMenu);
        navigationView = findViewById(R.id.navigationView);

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setItemIconTintList(null);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);

                switch (id){
                    case R.id.profile:

                        Toast.makeText(StudentDashboardActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.notice:
                        Toast.makeText(StudentDashboardActivity.this, "Notice", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        return true;
                }
                return true;
            }
        });

    }
}