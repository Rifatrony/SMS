package com.rony.sms.ViewPagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.rony.sms.Fragment.AllNoticeFragment;
import com.rony.sms.Fragment.NewNoticeFragment;

public class NoticeViewPagerAdapter extends FragmentStateAdapter {
    public NoticeViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new NewNoticeFragment();

            case 1:
                return new AllNoticeFragment();

            default:
                return new NewNoticeFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
