package com.example.evaa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;


import es.dmoral.toasty.Toasty;

public class HelpFragment extends Fragment {

    String message;
    EditText etMessage;
    Button btnSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_help, container, false);

        etMessage = rootView.findViewById(R.id.etMessage);
        btnSubmit = rootView.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = etMessage.getText().toString();
                if (message .matches("")) {
                    Toasty.normal(getActivity(), "No Message").show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
                    builder.setMessage("Your message:\n\n" + message + "\n\nThank you for your input!")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {}
                            });
                    final AlertDialog alert = builder.create();
                    alert.show();

                    TextView textView = (TextView) alert.findViewById(android.R.id.message);
                    Typeface typeFace = ResourcesCompat.getFont(getActivity(), R.font.cgothic);
                    textView.setTypeface(typeFace);
                    textView.setPadding(25,30,25,30);
                    textView.setTextSize(18);
                }
            }
        });

        return rootView;
    }
}
