package com.rony.sms.Fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rony.sms.Adapter.CostAdapter;
import com.rony.sms.Api.RetrofitClient;
import com.rony.sms.Model.CostModel;
import com.rony.sms.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewNoticeFragment extends Fragment {

    View view;
    List<CostModel> costModelList;
    RecyclerView recyclerView;
    CostAdapter costAdapter;
    AppCompatButton tryAgainButton;

    ShimmerFrameLayout shimmerFrameLayout;
    FloatingActionButton addCostFb;
    EditText reasonEditText, amountEditText;
    AppCompatButton saveButton;

    String reason, amount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_new_notice, container, false);


        addCostFb = view.findViewById(R.id.addCostFb);
        shimmerFrameLayout = view.findViewById(R.id.shimmer);
        shimmerFrameLayout.startShimmer();


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        costModelList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getCost();

        addCostFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addCost();
            }
        });

        return  view;
    }

    private void getCost() {
        RetrofitClient.getRetrofitClient().getCost().enqueue(new Callback<List<CostModel>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<List<CostModel>> call, Response<List<CostModel>> response) {
                if (response.isSuccessful()){
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);

                    costModelList = response.body();
                    costAdapter = new CostAdapter(getContext(), costModelList);
                    recyclerView.setAdapter(costAdapter);
                    System.out.println(response.body());
                    Toast.makeText(getContext(), "List is is " + costModelList.size() , Toast.LENGTH_SHORT).show();
                }

                costAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<CostModel>> call, Throwable t) {
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
                //tryAgainButton.setVisibility(View.VISIBLE);
            }
        });
    }

    private void addCost() {

        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.add_cost_layout);
        dialog.show();

        reasonEditText = dialog.findViewById(R.id.reasonEditText);
        amountEditText = dialog.findViewById(R.id.amountEditText);
        saveButton = dialog.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reason = reasonEditText.getText().toString().trim();
                amount = amountEditText.getText().toString().trim();

                if (!reason.isEmpty() && !amount.isEmpty()){

                    RetrofitClient.getRetrofitClient().addCost(reason, amount).enqueue(new Callback<CostModel>() {
                        @Override
                        public void onResponse(Call<CostModel> call, Response<CostModel> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(getActivity(), "Cost Added", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }

                        @Override
                        public void onFailure(Call<CostModel> call, Throwable t) {

                        }
                    });
                }

            }
        });

    }


}