package com.example.key.a1123;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemoWriteFragment extends Fragment {

    private View view;

    private EditText editText;

    public static MemoWriteFragment newInstance() {
        return new MemoWriteFragment();
    }


    public MemoWriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_memo_write, container, false);

    }

}
