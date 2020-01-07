package com.kellydouglass.venmo2;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.kellydouglass.venmo2.TabsFragments.FriendsFragment;
import com.kellydouglass.venmo2.TabsFragments.MeFragment;
import com.kellydouglass.venmo2.TabsFragments.PublicFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabsFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;

    FriendsFragment friendsFragment;
    MeFragment meFragment;
    PublicFragment publicFragment;

    public TabsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tabs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

        friendsFragment = new FriendsFragment();
        meFragment = new MeFragment();
        publicFragment = new PublicFragment();

        MyPageAdapter myPageAdapter = new MyPageAdapter(getActivity(), getChildFragmentManager());

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(myPageAdapter);

    }

    class MyPageAdapter extends FragmentPagerAdapter {

        Context ctxt=null;

        String[] fragmentNames = {"ME", "FRIENDS", "PUBLIC"};

        public MyPageAdapter(Context ctxt, FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return meFragment;
                case 1:
                    return friendsFragment;
                case 2:
                    return publicFragment;
            }

            return null;
        }

        @Override
        public int getCount() {
            return fragmentNames.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentNames[position];
        }
    }
}
