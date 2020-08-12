package com.example.evaa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    private String fact;
    private Random randomized;
    private List<String> factList = new ArrayList<String>(){
        {
            add("Not all types of glass bottles and jars are recyclable. The acceptance of glass in recycling programs varies by jurisdiction.\n-Waste Management");
            add("A cotton shopping bag must be used at least 131 times to have less impact on the environment than single-use bags.\n-MarketWatch");
            add("Many kinds of toothpaste contain small plastic beads [that] are likely harmful to the environment.\n-DentistryIQ");
            add("Recycling arrows on a container does not mean it is definitely recyclable... Check with your local program guidelines.\n-Waste Management");
            add("Chewing gum is made from polymers which are synthetic plastics that do not biodegrade.\n-CustomMade");
            add("80–90% of chewing gum is not disposed of properly and it’s the second most common form of litter after cigarette butts.\n-CustomMade");
            add("The average person generates over 4 pounds of trash every day and about 1.5 tons of solid waster per year.\n-DoSomething");
            add("The EPA estimates that 75% of the American waste stream is recyclable, but we only recycle about 30% of it.\n-DoSomething");
            add("We generate 21.5 million tons of food waster each year.\n-DoSomething");
            add("If we compost a years worth of food waste, it would reduce the same amount of greenhouse gas as taking 2 million cars off the road.\n-DoSomething");
            add("Recycling one aluminum can saves enough energy to listen to a full album on your iPod.\n-DoSomething");
            add("Recycling 100 cans could light your bedroom for two whole weeks.\n-DoSomething");
            add("Over 87% of Americans have access to curbside or drop-off paper recycling programs.\n-DoSomething");
            add("New York City residents throw out enough garbage each day to fill the entire Empire State Building.\n-Rubicon");
            add("Packaging represents about 65% of household trash.\n-Rubicon");
            add("Only 4% of the world's children live in the US, but Americans buy (and throw away) 40% of the world's toys.\n-Rubicon");
            add("If one-forth of the food currently lost or waster globally could be saved, it would be enough to feed roughly 870 million people.\n-Rubicon");
            add("Annually, more than 14 billion pounds of garbage is dumped into the world's ocean (mainly marine life toxic plastic).\n-Rubicon");
            add("The Great Pacific Garbage Patch is as large as twice the size of the US and would take 67 ships one year to clean up less than 1% of the garbage mass.\n-Rubicon");
            add("Almost half of all seabirds species, all sea turtles species, and a growing list of fish species have been documented with plastic in/around their bodies.\n-Rubicon");
            add("Every year, over 50 million tons of electronic waste (i.e. cell phones, computers, TVs, etc.) is created.\n-Rubicon");
            add("Annually, Americans throw out old phones containing over $60 million in gold and/or silver.\n-Rubicon");
            add("Not all types of glass bottles and jars are recyclable. The acceptance of glass in recycling programs varies by jurisdiction.\n-Waste Management");
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        randomized = new Random();
        int index = randomized.nextInt(factList.size());
        fact = factList.get(index);

        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(6000)
                .withBackgroundResource(R.drawable.ic_backgroundbackground)
                .withAfterLogoText("Fun Fact")
                .withFooterText(String.valueOf(fact))
                .withLogo(R.drawable.ic_ash_from_manufactured_logs_and_pellets);

        myCustomTextViewAnimation(config.getAfterLogoTextView());
        myCustomTextViewAnimation(config.getFooterTextView());
        myCustomLogoAnimation(config.getLogo());

        config.getLogo().setY(-150);
        config.getLogo().setMaxHeight(500);

        config.getAfterLogoTextView().setTextColor(Color.parseColor("#40494F"));
        config.getAfterLogoTextView().setTextSize(24);

        config.getFooterTextView().setY(-200);
        config.getFooterTextView().setTextColor(Color.parseColor("#40494F"));
        config.getFooterTextView().setTextSize(18);
        config.getFooterTextView().setBackgroundResource(R.drawable.custom_textbubble_white_clear);
        config.getFooterTextView().setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        config.getFooterTextView().setMaxWidth(925);
        config.getFooterTextView().setPadding(25,30,25,30);

        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_left);
    }

    private void myCustomLogoAnimation(ImageView logo){
        Animation animation = new AlphaAnimation(0, 1);
        animation.setDuration(1000);
        logo.startAnimation(animation);
    }

    private void myCustomTextViewAnimation(TextView tv){
        Animation animation = new AlphaAnimation(0, 1);
        animation.setDuration(1000);
        tv.startAnimation(animation);
    }
}