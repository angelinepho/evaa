package com.example.evaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        Intent intent = getIntent();
        String instruction = intent.getStringExtra("instruction");

        if (instruction.equals("search")) {
            navListener.onNavigationItemSelected(bottomNav.getMenu().findItem(R.id.nav_search));
        } else if (instruction.equals("environment")) {
            navListener.onNavigationItemSelected(bottomNav.getMenu().findItem(R.id.nav_environment));
        }

        openDialog();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            item.setChecked(true);

            switch (item.getItemId()) {
                case R.id.nav_home:
                    Intent intent = new Intent(NavActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.nav_search:
                    selectedFragment = new SearchFragment();
                    getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
                            .replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                case R.id.nav_environment:
                    selectedFragment = new EnvironmentFragment();
                    getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                            .replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
            }

            return false;
        }
    };

    @Override
    public void onBackPressed() {
    }

    public void openDialog() {
        FunFactDialog dialog = new FunFactDialog();
        dialog.show(getSupportFragmentManager(), "This is openDialog()");
    }

}