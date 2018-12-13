package com.example.key.a1123;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {


    private View view;
    private CalendarView calendarView;
    public static CalendarFragment newInstance(){
        return new CalendarFragment();
    }
    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_calendar, container, false);
        calendarView=(CalendarView) view.findViewById(R.id.calendarView);
        return view;
    }

}
