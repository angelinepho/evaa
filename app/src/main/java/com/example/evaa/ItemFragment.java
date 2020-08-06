package com.example.evaa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class ItemFragment extends Fragment {

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd;
    private TextView image_description;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item, container, false);

        btnAdd = rootView.findViewById(R.id.btnAdd);
        mDatabaseHelper = new DatabaseHelper(getActivity());
        image_description = rootView.findViewById(R.id.image_description);

        Bundle bundle = getArguments();
        getIncomingBundle(rootView, bundle);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = image_description.getText().toString();
                if (name.length() != 0) {
                    AddData(name);
                } else {
                    Toasty.warning(getActivity(), "No Item to Log", Toast.LENGTH_SHORT, true).show();
                }
            }
        });

        return rootView;
    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

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
        TextView name = rootView.findViewById(R.id.image_description);
        name.setText(imageName);

        ImageView image = rootView.findViewById(R.id.image);
        image.setImageResource(imageUrl);

        TextView alternative = rootView.findViewById(R.id.image_alternative);
        alternative.setText(imageAlternative);

        TextView disposal = rootView.findViewById(R.id.image_disposal);
        disposal.setText(imageDisposal);
    }

}
