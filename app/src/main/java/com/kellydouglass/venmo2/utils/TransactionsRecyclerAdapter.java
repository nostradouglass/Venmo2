package com.kellydouglass.venmo2.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kellydouglass.venmo2.models.Me;
import com.kellydouglass.venmo2.R;

import java.util.List;

public class TransactionsRecyclerAdapter extends RecyclerView.Adapter<TransactionsRecyclerAdapter.ViewHolder> {

    private List<Me> meList;

    public TransactionsRecyclerAdapter(List<Me> me) {
        meList = me;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.transactions_row_item, parent, false);


        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Me currentMeItem = meList.get(position);

        TextView textView = holder.youPaidText;

        String youPaidFull = "You Paid " + currentMeItem.getPaidTo() ;


        holder.youPaidText.setText(youPaidFull);
        holder.amountText.setText("$" + currentMeItem.getAmountPaid() );
        holder.transactionTypeText.setText(currentMeItem.getPaymentText());
    }

    @Override
    public int getItemCount() {
        return meList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public Button messageButton;

        private ImageView userImage;
        private TextView youPaidText;
        private TextView amountText;
        private TextView daysText;
        private ImageView transferTypeImage;
        private TextView transactionTypeText;
        private ImageView heartImage;
        private ImageView messageImage;




        public ViewHolder(View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.userImage);
            youPaidText = itemView.findViewById(R.id.youPaidText);
            amountText = itemView.findViewById(R.id.amountText);
            daysText = itemView.findViewById(R.id.daysText);
            transferTypeImage = itemView.findViewById(R.id.transferTypeImage);
            transactionTypeText = itemView.findViewById(R.id.transactionTypeText);
            heartImage = itemView.findViewById(R.id.heartImage);
            messageImage = itemView.findViewById(R.id.messageImage);


        }
    }

}
