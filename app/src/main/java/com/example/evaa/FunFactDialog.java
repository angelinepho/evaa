package com.example.evaa;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatDialogFragment;

public class FunFactDialog extends AppCompatDialogFragment {
    TextView fact;
    private Random randomized;
    private List<String> factList = new ArrayList<String>(){
        {
            add("Not all types of glass bottles and jars are recyclable. The acceptance of glass in recycling programs varies by jurisdiction.");
            add("A cotton shopping bag must be used at least 131 times to have less impact on the environment than single-use bags.");
            add("Many kinds of toothpaste contain small plastic beads which may lodge in the gums, are likely harmful to the environment, and are included in toothpaste for decorative purposes only.");
            add("Recycling arrows on a container does not mean it is definitely recyclable. Many plastics cannot be recycled into new products. Check with your local program guidelines.");
            add("Chewing gum is made from polymers which are synthetic plastics that do not biodegrade. 80–90% of chewing gum is not disposed of properly and it’s the second most common form of litter after cigarette butts.");
        }
    };


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null);

        builder.setView(view)
                .setTitle("Here's a random fact!")
                .setPositiveButton("X", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Closes dialog
                    }
                });
        fact = view.findViewById(R.id.fact);
        randomizeFact();
        return builder.create();
    }

    public void randomizeFact() {
        // Hardcoded for now, need to implement Firebase integration
        randomized = new Random();
        int index = randomized.nextInt(factList.size());
        fact.setText(factList.get(index));
    }

}
