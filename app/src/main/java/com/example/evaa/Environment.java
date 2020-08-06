package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Environment extends AppCompatActivity {

    private ProgressBar progressBarAnim;
    private ObjectAnimator progressAnimator;
    private ImageButton btnLogger;
    private ImageView background;
    private Integer numLogged;
    private ArrayList<List<Integer>> backgrounds;
    private ImageView ivCongrats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment_page);

        initializeProgressBar();
        btnLogger = findViewById(R.id.btnLogger);
        background = findViewById(R.id.background);
        ivCongrats = findViewById(R.id.ivCongrats);

        final DatabaseHelper databaseHelper = new DatabaseHelper(Environment.this);
        numLogged = databaseHelper.getData().size();

        progressAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator anim) {
                super.onAnimationEnd(anim);
                Toast.makeText(getBaseContext(), "Completed", Toast.LENGTH_SHORT).show();
                progressBarAnim.setVisibility(View.GONE);
            }
        });
        btnLogger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Environment.this,
                        LoggedList.class);
                startActivity(intent);

            }
        });

        constructBackground();
        setBackground();
        setProgressBar();
    }

    public void initializeProgressBar() {
        progressBarAnim = findViewById(R.id.progressBar);
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
        Integer currentBackground = backgrounds.get(numLogged%19).get(0);
        background.setImageResource(currentBackground);
    }

    public void setProgressBar() {
        Integer percentProgress = backgrounds.get(numLogged%19).get(1);
        if (percentProgress == 100) {
            ivCongrats.setVisibility(View.VISIBLE);
        } else {
            ivCongrats.setVisibility(View.GONE);
        }
        progressBarAnim.setProgress(Math.round(percentProgress));
    }

}