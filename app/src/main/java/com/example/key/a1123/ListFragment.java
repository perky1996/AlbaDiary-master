package com.example.key.a1123;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.key.a1123.albaInfo.albaInfo;

import io.realm.Realm;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements View.OnClickListener{

    private View view;

    private ListView listView;

    EditText name;
    EditText sigeup;
    FloatingActionButton listSaveButton;
    ListView log;

    Realm realm;

    public static ListFragment newInstance(){
        return new ListFragment();
    }


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        FloatingActionButton fb = view.findViewById(R.id.listAddButton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, ListWriteFragment.newInstance()).addToBackStack(null).commit();
            }
        });
        name=(EditText)view.findViewById(R.id.editText);
        sigeup=(EditText)view.findViewById(R.id.editText2);
        log=(ListView)view.findViewById(R.id.listView);
        // realm=Realm.getDefaultInstance();
        // listSaveButton.setOnClickListener(this);
        return view;
    }

    public void onClick(View view) {
        writeToDB(name.getText().toString().trim(), Integer.parseInt(sigeup.getText().toString().trim()));
        showdata();
    }

    public void showdata() {
        RealmResults<albaInfo> guests = realm.where(albaInfo.class).equalTo("invited", false).findAll();

        String op = "";
        realm.beginTransaction();
        for(albaInfo guest : guests){
            op+=guest.toString();
        }
    }

    public void writeToDB(String name, int sigeup) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                albaInfo user = bgRealm.createObject(albaInfo.class);
                user.setName(name);
                user.setSigeup(sigeup);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {

                Log.v("Database", "Data Inserted");

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {

                Log.e("Database", error.getMessage());

            }
        });
    }


    protected void onDestory() {
        super.onDestroy();
        realm.close();
    }

}
