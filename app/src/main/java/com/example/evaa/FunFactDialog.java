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
            add("The average person generates over 4 pounds of trash every day and about 1.5 tons of solid waster per year.");
            add("The EPA estimates that 75% of the American waste stream is recyclable, but we only recycle about 30% of it.");
            add("We generate 21.5 million tons of food waster each year. If we composted that food, it would reduce the same amount of greenhouse gas as taking 2 million cars off the road.");
            add("Recycling one aluminum can saves enough energy to listen to a full album on your iPod. Recycling 100 cans could light your bedroom for two whole weeks.");
            add("Over 87% of Americans have access to curbside or drop-off paper recycling programs.");
            add("New York City residents throw out enough garbage each day to fill the entire Empire State Building.");
            add("Packaging represents about 65% of household trash.");
            add("Only 4% of the world's children live in the US, but Americans buy (and throw away) 40% of the world's toys.");
            add("If one-forth of the food currently lost or waster globally could be saved, it would be enough to feed roughly 870 million people.");
            add("Annually, more than 14 billion pounds of garbage is dumped into the world's ocean (mainly marine life toxic plastic).");
            add("The Great Pacific Garbage Patch, or Pacific trash vortex, is a collection of marine debris in the North Pacific Ocean. According to some estimates the patch can be as large as twice the size of the US and would take 67 ships one year to clean up less than 1% of the garbage mass.");
            add("Almost half of all seabirds species, 22% of cetaceans, all sea turtles species, and a growing list of fish species have been documented with plastic found in or around their bodies.");
            add("Every year, over 50 million tons of electronic waste (i.e. cell phones, computers, TVs, etc.) is created.");
            add("Annually, Americans throw out old phones containing over $60 million in gold and/or silver.");
        }
    };


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null);

        builder.setView(view).setTitle("Fun Fact");
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
