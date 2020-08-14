package com.example.evaa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class SettingsFragment extends Fragment {

    Button btnCredits, btnTutorial, btnClearData;

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
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
                builder.setMessage("This action will re-enable the Tutorial. Continue?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                SharedPreferences sp = getActivity().getSharedPreferences("settings", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sp.edit();
                                editor.putBoolean("helpLaunch", true);
                                editor.putBoolean("itemLaunch", true);
                                editor.putBoolean("envLaunch", true);
                                editor.apply();

                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                startActivity(intent);
                                getActivity().overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_left);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                final AlertDialog alert = builder.create();
                alert.show();

                TextView textView = (TextView) alert.findViewById(android.R.id.message);
                Typeface typeFace = ResourcesCompat.getFont(getActivity(), R.font.cgothic);
                textView.setTypeface(typeFace);
                textView.setPadding(25,30,25,30);
                textView.setTextSize(18);
            }
        });

        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
                builder.setMessage("This action will clear all saved data and reset any progress in your Environment. Continue?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                DatabaseHelper db = new DatabaseHelper(getActivity());
                                db.deleteAll();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                final AlertDialog alert = builder.create();
                alert.show();

                TextView textView = (TextView) alert.findViewById(android.R.id.message);
                Typeface typeFace = ResourcesCompat.getFont(getActivity(), R.font.cgothic);
                textView.setTypeface(typeFace);
                textView.setPadding(25,30,25,30);
                textView.setTextSize(18);
            }
        });

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
