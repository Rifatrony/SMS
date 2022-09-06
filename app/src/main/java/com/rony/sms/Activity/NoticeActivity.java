package com.rony.sms.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.rony.sms.R;
import com.rony.sms.ViewPagerAdapter.NoticeViewPagerAdapter;

public class NoticeActivity extends AppCompatActivity {

    ImageView imageBack;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    NoticeViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        initialization();

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                super.onPageSelected(position);

                tabLayout.getTabAt(position).select();

            }
        });

    }

    private void initialization(){
        viewPager2 = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        imageBack = findViewById(R.id.imageBack);

        viewPagerAdapter = new NoticeViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);

    }
}