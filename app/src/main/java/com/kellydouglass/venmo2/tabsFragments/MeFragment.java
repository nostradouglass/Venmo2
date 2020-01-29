package com.kellydouglass.venmo2.tabsFragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kellydouglass.venmo2.models.Me;
import com.kellydouglass.venmo2.R;
import com.kellydouglass.venmo2.utils.HttpTransactionApi;
import com.kellydouglass.venmo2.utils.TransactionsRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {

    private String TAG = "VENMO2";

    private List<Me> meList;

    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_me, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Me> meList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://venmo-2-server.herokuapp.com/transactions/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HttpTransactionApi httpTransactionApi = retrofit.create(HttpTransactionApi.class);

        Call<List<Me>> call = httpTransactionApi.getMeTransactions();

        call.enqueue(new Callback<List<Me>>() {
            @Override
            public void onResponse(Call<List<Me>> call, Response<List<Me>> response) {

                if (!response.isSuccessful()) {
                    Log.d(TAG, "fail");
                    return;
                } else {
                    Log.d(TAG, "Success");
                    List<Me> meList = response.body();

                    RecyclerView rvMe = view.findViewById(R.id.meView);
                    rvMe.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                    rvMe.setHasFixedSize(true);


                    TransactionsRecyclerAdapter adapter = new TransactionsRecyclerAdapter(meList);

                    rvMe.setAdapter(adapter);

                    rvMe.setLayoutManager(new LinearLayoutManager((getContext())));


                }
            }

            @Override
            public void onFailure(Call<List<Me>> call, Throwable t) {
                Log.d(TAG, "onFailure");
                Log.d(TAG, t.toString());
            }
        });






    }


}
