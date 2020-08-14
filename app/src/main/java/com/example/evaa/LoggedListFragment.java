package com.example.evaa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class LoggedListFragment extends Fragment {

    DatabaseHelper myDB;
    ListView listView;
    ArrayList<Item> itemList;
    Item item;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_logged_list, container, false);

        listView = (ListView) rootView.findViewById(R.id.listLogged);

        myDB = new DatabaseHelper(getActivity());

        itemList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numRows = data.getCount();
        if (numRows == 0)
        {
            Toasty.normal(getActivity(), "Log Empty").show();
        } else {
            int i = 0;
            while (data.moveToNext()) {
                item = new Item(data.getString(1), data.getString(2));
                itemList.add(i, item);
                i++;
            }
            TwoColumn_ListAdapter adapter = new TwoColumn_ListAdapter(getActivity(), R.layout.list_adapter_view, itemList);
            listView = (ListView) rootView.findViewById(R.id.listLogged);
            listView.setAdapter(adapter);
        }

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

}