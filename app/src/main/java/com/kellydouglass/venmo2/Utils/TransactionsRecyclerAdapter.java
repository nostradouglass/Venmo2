package com.kellydouglass.venmo2.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kellydouglass.venmo2.Models.Me;
import com.kellydouglass.venmo2.R;

import java.util.List;

public class TransactionsRecyclerAdapter extends RecyclerView.Adapter<TransactionsRecyclerAdapter.ViewHolder> {

    private List<Me> mMe;

    public TransactionsRecyclerAdapter(List<Me> me) {
        mMe = me;
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

        Me currentMeItem = mMe.get(position);

        TextView textView = holder.youPaidText;

        String youPaidFull = "You Paid " + currentMeItem.getFirstName() + " " + currentMeItem.getLastName();

        String amountinString = String.valueOf(currentMeItem.getAmount());

        holder.youPaidText.setText(youPaidFull);
        holder.amountText.setText("$" + amountinString);

    }

    @Override
    public int getItemCount() {
        return mMe.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public Button messageButton;

        public ImageView userImage;
        public TextView youPaidText;
        public TextView amountText;
        public TextView daysText;
        public ImageView transferTypeImage;
        public TextView transactionTypeText;
        public ImageView heartImage;
        public ImageView messageImage;




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
