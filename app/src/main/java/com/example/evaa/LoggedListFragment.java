package com.example.evaa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class LoggedListFragment extends Fragment {

    private ImageButton btnExit;
    private ListView listLogged;
    private List<String> displayList = new ArrayList();
    private ArrayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_logged_list, container, false);

        btnExit = rootView.findViewById(R.id.btnExit);
        listLogged = (ListView) rootView.findViewById(R.id.listLogged);

        final DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        displayList = databaseHelper.getData();

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, displayList);
        listLogged.setAdapter(adapter);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.deleteAll();
//                Intent intent = new Intent(LoggedList.this,
//                        Environment.class);
//                startActivity(intent);
            }
        });

        return rootView;
    }
}