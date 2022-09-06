package com.rony.sms.ViewPagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.rony.sms.Fragment.CombineResultFragment;
import com.rony.sms.Fragment.FirstTermFragment;
import com.rony.sms.Fragment.SecondTermFragment;

public class ResultViewPagerAdapter extends FragmentStateAdapter {

    public ResultViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FirstTermFragment();

            case 1:
                return new SecondTermFragment();

            case 2:
                return new CombineResultFragment();

            default:
                return new FirstTermFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
