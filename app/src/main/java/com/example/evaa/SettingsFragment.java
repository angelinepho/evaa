package com.example.evaa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class SettingsFragment extends Fragment {

    Button btnCredits, btnTutorial, btnClearData;
    public static final String sharedPrefs = "sharedPrefs";
    public static final String TUTORIAL = "false";
    private Boolean tutorialStarted;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        btnCredits = rootView.findViewById(R.id.btnCredits);
        btnTutorial = rootView.findViewById(R.id.btnTutorial);
        btnClearData = rootView.findViewById(R.id.btnClearData);

        btnCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List fragments = getActivity().getSupportFragmentManager().getFragments();
                Fragment mFragment = (Fragment) fragments.get(fragments.size() - 1);

                Fragment fragment = new CreditFragment();
                FragmentManager manager = mFragment.getFragmentManager();
                manager.beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                        .replace(R.id.fragment_container, fragment).commit();

            }
        });

        btnTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();



            }
        });

        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(getActivity());
                db.deleteAll();
            }
        });

        saveData();
        return rootView;
    }

    public void saveData() {
        SharedPreferences sp = getContext().getSharedPreferences(sharedPrefs, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(TUTORIAL, true);
    }

    public void loadData() {
        SharedPreferences sp = getContext().getSharedPreferences(sharedPrefs, MODE_PRIVATE);
        tutorialStarted = sp.getBoolean(TUTORIAL, false);   //default value
    }
}
