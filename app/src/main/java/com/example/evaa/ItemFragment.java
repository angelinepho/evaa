package com.example.evaa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

public class ItemFragment extends Fragment {

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnHelp;
    private TextView image_name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item, container, false);

        btnAdd = rootView.findViewById(R.id.btnAdd);
        btnHelp = rootView.findViewById(R.id.btnHelp);
        mDatabaseHelper = new DatabaseHelper(getActivity());
        image_name = rootView.findViewById(R.id.image_name);

        Bundle bundle = getArguments();
        getIncomingBundle(rootView, bundle);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
                builder.setMessage(image_name.getText().toString() + " will be added to your environment log. Continue?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String name = image_name.getText().toString();
                                String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                                AddData(name, date);
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

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
                builder.setMessage("Read below to find eco-friendly alternatives and proper disposal methods. Log an item to clean your environment screen.");
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

    public void AddData(String name, String date) {
        boolean insertData = mDatabaseHelper.addData(name, date);

        if (insertData) {
            Toasty.success(getActivity(), "Log Success", Toast.LENGTH_SHORT, true).show();
        } else {
            Toasty.error(getActivity(), "Log Error", Toast.LENGTH_SHORT, true).show();
        }
    }

    private void getIncomingBundle(View rootView, Bundle bundle){
        Integer imageUrl = bundle.getInt("image_url", 0);
        String imageName = bundle.getString("image_name");
        String imageAlternative = bundle.getString("image_alternative");
        String imageDisposal = bundle.getString("image_disposal");

        setImage(rootView, imageUrl, imageName, imageAlternative, imageDisposal);
    }

    private void setImage(View rootView, Integer imageUrl, String imageName, String imageAlternative, String imageDisposal) {
        TextView name = rootView.findViewById(R.id.image_name);
        name.setText(imageName);

        ImageView image = rootView.findViewById(R.id.image);
        image.setImageResource(imageUrl);

        TextView alternative = rootView.findViewById(R.id.image_alternative);
        alternative.setText(imageAlternative);

        TextView disposal = rootView.findViewById(R.id.image_disposal);
        disposal.setText(imageDisposal);
    }

}
