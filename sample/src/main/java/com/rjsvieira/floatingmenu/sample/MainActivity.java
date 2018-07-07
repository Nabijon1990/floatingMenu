package com.rjsvieira.floatingmenu.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.Gravity;
import android.view.ViewGroup;

import rjsv.floatingmenu.animation.enumerators.AnimationType;
import rjsv.floatingmenu.floatingmenubutton.FloatingMenuButton;
import rjsv.floatingmenu.floatingmenubutton.subbutton.FloatingSubButton;

public class MainActivity extends Activity {

    FloatingMenuButton fab_1;
    FloatingMenuButton fab_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    private void initUi(){
        fab_1 = (FloatingMenuButton) findViewById(R.id.fab_1);
        fab_1.setStartAngle(0)
                .setEndAngle(360)
                .setAnimationType(AnimationType.EXPAND)
                .setAnchored(false);
        fab_1.getAnimationHandler()
                .setOpeningAnimationDuration(500)
                .setClosingAnimationDuration(200)
                .setLagBetweenItems(0)
                .setOpeningInterpolator(new FastOutSlowInInterpolator())
                .setClosingInterpolator(new FastOutLinearInInterpolator())
                .shouldFade(true)
                .shouldScale(true)
                .shouldRotate(false)
        ;

        FloatingSubButton fab = new FloatingSubButton(this);
        FloatingSubButton.LayoutParams layoutparams = new FloatingSubButton.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
        fab.setLayoutParams(layoutparams);
        fab.setBackground(getResources().getDrawable(R.drawable.one));
        fab_1.addFloatingSubButton(fab);

        FloatingSubButton fab2 = new FloatingSubButton(this);
        FloatingSubButton.LayoutParams layoutparams2 = new FloatingSubButton.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
        fab.setLayoutParams(layoutparams2);
        fab.setBackground(getResources().getDrawable(R.drawable.one));
        fab_1.addFloatingSubButton(fab2);
        fab_1.hideFloatingSubButton(fab);
        fab_1.hideFloatingSubButton(fab2);

        fab_2 = (FloatingMenuButton) findViewById(R.id.fab_2);
        fab_2.setStartAngle(0)
                .setEndAngle(360)
                .setAnimationType(AnimationType.RADIAL)
                .setAnchored(false);
        fab_2.getAnimationHandler()
                .setOpeningAnimationDuration(500)
                .setClosingAnimationDuration(200)
                .setLagBetweenItems(0)
                .setOpeningInterpolator(new FastOutSlowInInterpolator())
                .setClosingInterpolator(new FastOutLinearInInterpolator())
                .shouldFade(true)
                .shouldScale(true)
                .shouldRotate(false)
        ;

        fab_1.hideFloatingSubButton((FloatingSubButton) findViewById(R.id.fab_2_sub_fab_left_1));
    }
}
