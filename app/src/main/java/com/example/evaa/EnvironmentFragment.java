package com.example.evaa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import es.dmoral.toasty.Toasty;

public class EnvironmentFragment extends Fragment {

    private ProgressBar progressBarAnim;
    private ObjectAnimator progressAnimator;
    private Button btnLogger;
    private ImageView background;
    private Integer numLogged = 0;
    private ArrayList<List<Integer>> backgrounds;
    private ImageView ivCongrats;
    private Integer currentBackground;
    private Integer percentProgress = 0;

    @SuppressLint("LongLogTag")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_environment, container, false);

        initializeProgressBar(rootView);
        btnLogger = rootView.findViewById(R.id.btnLogger);
        background = rootView.findViewById(R.id.background);
        ivCongrats = rootView.findViewById(R.id.ivCongrats);

        final DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        Cursor data = databaseHelper.getListContents();

        while (data.moveToNext()) {
            numLogged++;
        }

        progressAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator anim) {
                super.onAnimationEnd(anim);
                Toasty.success(getActivity(), "Good Karma", Toast.LENGTH_SHORT, true).show();
                initializeProgressBar(rootView);
            }
        });
        btnLogger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List fragments = getActivity().getSupportFragmentManager().getFragments();
                Fragment mFragment = (Fragment) fragments.get(fragments.size() - 1);

                Fragment fragment = new LoggedListFragment();
                FragmentManager manager = mFragment.getFragmentManager();
                manager.beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                        .replace(R.id.fragment_container, fragment).commit();
            }
        });

        constructBackground();
        setBackground();
        setProgressBar();
        Log.i("Current Percentage Progress", String.valueOf(percentProgress));

        return rootView;
    }

    public void initializeProgressBar(View rootView) {
        progressBarAnim = rootView.findViewById(R.id.progressBar);
        progressAnimator = ObjectAnimator.ofInt(progressBarAnim, "progress", 0, 100);
    }

    public void constructBackground() {
        final List<Integer> e1 = Arrays.asList(R.drawable.park_1, 0);
        final List<Integer> e2 = Arrays.asList(R.drawable.park_2, 20);
        final List<Integer> e3 = Arrays.asList(R.drawable.park_3, 40);
        final List<Integer> e4 = Arrays.asList(R.drawable.park_4, 60);
        final List<Integer> e5 = Arrays.asList(R.drawable.park_5, 80);
        final List<Integer> e6 = Arrays.asList(R.drawable.park_6, 100);
        final List<Integer> e7 = Arrays.asList(R.drawable.desert_1, 0);
        final List<Integer> e8 = Arrays.asList(R.drawable.desert_2, 20);
        final List<Integer> e9 = Arrays.asList(R.drawable.desert_3, 40);
        final List<Integer> e10 = Arrays.asList(R.drawable.desert_4, 60);
        final List<Integer> e11 = Arrays.asList(R.drawable.desert_5, 80);
        final List<Integer> e12 = Arrays.asList(R.drawable.desert_6, 100);
        final List<Integer> e13 = Arrays.asList(R.drawable.beach_1, 0);
        final List<Integer> e14 = Arrays.asList(R.drawable.beach_2, 16);
        final List<Integer> e15 = Arrays.asList(R.drawable.beach_3, 33);
        final List<Integer> e16 = Arrays.asList(R.drawable.beach_4, 50);
        final List<Integer> e17 = Arrays.asList(R.drawable.beach_5, 66);
        final List<Integer> e18 = Arrays.asList(R.drawable.beach_6, 83);
        final List<Integer> e19 = Arrays.asList(R.drawable.beach_7, 100);

        backgrounds = new ArrayList<List<Integer> >() {
            {
                add(e1);
                add(e2);
                add(e3);
                add(e4);
                add(e5);
                add(e6);
                add(e7);
                add(e8);
                add(e9);
                add(e10);
                add(e11);
                add(e12);
                add(e13);
                add(e14);
                add(e15);
                add(e16);
                add(e17);
                add(e18);
                add(e19);
            }
        };
    }

    public void setBackground() {
        currentBackground = backgrounds.get(numLogged%19).get(0);
        background.setImageResource(currentBackground);
    }

    public void setProgressBar() {
        percentProgress = backgrounds.get(numLogged%19).get(1);
        progressBarAnim.setProgress(percentProgress);
        if (percentProgress == 100) {
            ivCongrats.setVisibility(View.VISIBLE);
        } else {
            ivCongrats.setVisibility(View.GONE);
        }
    }

}