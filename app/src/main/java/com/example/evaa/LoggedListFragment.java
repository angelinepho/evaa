package com.example.evaa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class LoggedListFragment extends Fragment {

    ImageButton btnExit;
    DatabaseHelper myDB;
    ListView listView;
    ArrayList<Item> itemList;
    Item item;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_logged_list, container, false);

        btnExit = rootView.findViewById(R.id.btnExit);
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


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List fragments = getActivity().getSupportFragmentManager().getFragments();
                Fragment fragment = new EnvironmentFragment();
                Fragment currentFragment = (Fragment) fragments.get(fragments.size() - 1);
                FragmentManager manager = currentFragment.getFragmentManager();

                manager.beginTransaction().setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
                        .replace(R.id.fragment_container, fragment).commit();
            }
        });

        return rootView;
    }
}