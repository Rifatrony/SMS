package com.rony.sms.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rony.sms.Adapter.NoticeAdapter;
import com.rony.sms.Model.NoticeModel;
import com.rony.sms.R;

import java.util.ArrayList;
import java.util.List;

public class AllNoticeFragment extends Fragment {

    View view;

    List<NoticeModel> noticeModelList;
    NoticeAdapter noticeAdapter;
    RecyclerView noticeRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_all_notice, container, false);


        noticeRecyclerView = view.findViewById(R.id.noticeRecyclerView);
        noticeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        noticeRecyclerView.setHasFixedSize(true);

        noticeModelList = new ArrayList<>();
        noticeModelList.add(new NoticeModel("05", "Oct", "05/10/2022", "Vijaya Dashami", "Description"));
        noticeModelList.add(new NoticeModel("09", "Oct", "09/10/2022", "Eid-e-Milad un-Nabi", "Description"));
        noticeModelList.add(new NoticeModel("16", "Dec", "16/12/2022", "Victory Day", "Description"));
        noticeModelList.add(new NoticeModel("25", "Dec", "12/12/2022", "Christmas Day", "Description"));
        noticeModelList.add(new NoticeModel("21", "Feb", "21/01/2023", "Shaheed Day", "Description"));
        noticeModelList.add(new NoticeModel("17", "Mar", "17/03/2022", "Sheikh Mujibur Rahman's Birthday", "Description"));

        noticeAdapter = new NoticeAdapter(getContext(), noticeModelList);
        noticeRecyclerView.setAdapter(noticeAdapter);

        noticeAdapter.notifyDataSetChanged();




        return view;
    }
}