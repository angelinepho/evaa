package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Environment extends AppCompatActivity {

    private ProgressBar progressBarAnim;
    private ObjectAnimator progressAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.environment_page);
        initializeProgressBar();
        progressAnimator.setDuration(7000);

        progressAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator anim) {
                super.onAnimationEnd(anim);
                Toast.makeText(getBaseContext(), "Completed", Toast.LENGTH_SHORT).show();
                progressBarAnim.setVisibility(View.GONE);
            }
        });

    }

    private void initializeProgressBar() {
        progressBarAnim = findViewById(R.id.progress_horizontal);
        progressAnimator = ObjectAnimator.ofInt(progressBarAnim, "progress", 0, 100);
    }

}