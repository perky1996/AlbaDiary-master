package com.example.key.a1123;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemoFragment extends Fragment {

    private View view;

    private ListView listView;

    public static MemoFragment newInstance(){
        return new MemoFragment();
    }


    public MemoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_memo, container, false);
        listView = (ListView) view.findViewById(R.id.memoListView);
        FloatingActionButton fb = view.findViewById(R.id.memoAddButton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, MemoWriteFragment.newInstance()).addToBackStack(null).commit();
            }
        });
        return view;
    }


}
