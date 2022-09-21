package com.rony.sms.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rony.sms.Model.NoticeModel;
import com.rony.sms.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    Context context;
    List<NoticeModel> noticeModelList;

    public NoticeAdapter(Context context, List<NoticeModel> noticeModelList) {
        this.context = context;
        this.noticeModelList = noticeModelList;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notice_layout, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        NoticeModel model = noticeModelList.get(position);
        holder.noticeTitleTextView.setText(model.getTitle());
        holder.dateTextView.setText(model.getDate());
        holder.monthTextView.setText(model.getMonth());
        holder.noticeDateTextView.setText(model.getFullDate());
        holder.noticeDescriptionTextView.setText(model.getDescription());

        holder.cardView.setCardBackgroundColor(holder.view.getResources().getColor(getRandomColor(), null));

    }

    private int getRandomColor() {

        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.card1);
        colorCode.add(R.color.card2);
        colorCode.add(R.color.card3);
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
        return noticeModelList.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {

        TextView noticeTitleTextView, noticeDateTextView, noticeDescriptionTextView, dateTextView, monthTextView;
        CardView cardView;
        View view;

        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            noticeTitleTextView = itemView.findViewById(R.id.noticeTitleTextView);
            noticeDateTextView = itemView.findViewById(R.id.noticeDateTextView);
            noticeDescriptionTextView = itemView.findViewById(R.id.noticeDescriptionTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            monthTextView = itemView.findViewById(R.id.monthTextView);

            view =itemView;

        }
    }

}
