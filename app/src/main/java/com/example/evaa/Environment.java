package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Environment extends AppCompatActivity {

    private ProgressBar progressBarAnim;
    private ObjectAnimator progressAnimator;
    private ImageButton btnLogger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment_page);
        initializeProgressBar();
        btnLogger = findViewById(R.id.btnLogger);

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
    }

    private void initializeProgressBar() {
        progressBarAnim = findViewById(R.id.progressBar);
        progressAnimator = ObjectAnimator.ofInt(progressBarAnim, "progress", 0, 100);
    }

}