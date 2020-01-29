package com.kellydouglass.venmo2.TabsFragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kellydouglass.venmo2.Models.Me;
import com.kellydouglass.venmo2.R;
import com.kellydouglass.venmo2.Utils.TransactionsRecyclerAdapter;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {


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

        RecyclerView rvMe = view.findViewById(R.id.meView);
        rvMe.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        rvMe.setHasFixedSize(true);

        meList.add( new Me("Kelly", "Douglass", 30.50, 4, "/imageLocation"));
        meList.add( new Me("Tabby", "Douglass", 10.75, 23, "/imageLocation"));
        meList.add( new Me("Kitty", "Douglass", 30.50, 4, "/imageLocation"));
        meList.add( new Me("Jaden", "Douglass", 70.75, 23, "/imageLocation"));
        meList.add( new Me("Scout", "Douglass", 54.50, 9, "/imageLocation"));
        meList.add( new Me("Kelly", "Douglass", 30.50, 4, "/imageLocation"));
        meList.add( new Me("Tabby", "Douglass", 10.75, 23, "/imageLocation"));
        meList.add( new Me("Kitty", "Douglass", 30.50, 4, "/imageLocation"));
        meList.add( new Me("Jaden", "Douglass", 70.75, 23, "/imageLocation"));
        meList.add( new Me("Scout", "Douglass", 54.50, 9, "/imageLocation"));



        TransactionsRecyclerAdapter adapter = new TransactionsRecyclerAdapter(meList);

        rvMe.setAdapter(adapter);

        rvMe.setLayoutManager(new LinearLayoutManager((getContext())));


    }


}
