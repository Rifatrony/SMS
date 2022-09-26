package com.rony.sms.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rony.sms.Model.CostModel;
import com.rony.sms.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CostAdapter extends RecyclerView.Adapter<CostAdapter.CostViewHolder> {

    Context context;
    List<CostModel> costModelList;

    String fullDate;
    String date, month, year;

    public CostAdapter(Context context, List<CostModel> costModelList) {
        this.context = context;
        this.costModelList = costModelList;
    }

    @NonNull
    @Override
    public CostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notice_layout, parent, false);
        return new CostViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CostViewHolder holder, int position) {
        CostModel model = costModelList.get(position);
        holder.noticeTitleTextView.setText(model.reason);
        holder.noticeDateTextView.setText(model.today);
        holder.noticeDescriptionTextView.setText(String.valueOf(model.amount));

        fullDate = model.getDate().toString();

        if (fullDate.isEmpty()){
            date = fullDate.substring(8,10);
            month = fullDate.substring(4,7);
            year = fullDate.substring(30,34);
            System.out.println("Year is "+year);
            System.out.println("Month is "+month);
            System.out.println("Date is "+date);
            holder.dateTextView.setText(date +" "+ month);
            holder.monthTextView.setText(year);
        }

        holder.cardView.setCardBackgroundColor(holder.itemView.getResources().getColor(getRandomColor(), null));

    }

    private int getRandomColor() {

        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.card1);
        colorCode.add(R.color.card2);
        colorCode.add(R.color.card4);
        colorCode.add(R.color.card6);
        colorCode.add(R.color.salmon);
        colorCode.add(R.color.deepKoamaru);
        colorCode.add(R.color.green);

        Random randomColor = new Random();

        int number = randomColor.nextInt(colorCode.size());
        return colorCode.get(number);

    }

    @Override
    public int getItemCount() {
        return costModelList.size();
    }

    public class CostViewHolder extends RecyclerView.ViewHolder {

        TextView noticeTitleTextView, noticeDateTextView, noticeDescriptionTextView, dateTextView, monthTextView;
        CardView cardView;

        public CostViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);

            noticeTitleTextView = itemView.findViewById(R.id.noticeTitleTextView);
            noticeDateTextView = itemView.findViewById(R.id.noticeDateTextView);
            noticeDescriptionTextView = itemView.findViewById(R.id.noticeDescriptionTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            monthTextView = itemView.findViewById(R.id.monthTextView);

        }
    }

}
