package com.ks.mygenie;

import android.app.Activity;

import com.badoo.mobile.util.WeakHandler;
import com.daimajia.androidanimations.library.Techniques;
import com.ks.mygenie.ssplash.ChangeActivityHelper;
import com.ks.mygenie.ssplash.Constants;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {

			/* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.colorPrimary); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(2000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.mipmap.ic_launcher); //or any other drawable
        configSplash.setAnimLogoSplashDuration(2000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.Wobble); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


        //Customize Path
//        configSplash.setPathSplash(Constants.DROID_LOGO); //set path String
//        configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
//        configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
//        configSplash.setAnimPathStrokeDrawingDuration(3000);
//        configSplash.setPathSplashStrokeSize(3); //I advise value be <5
//        configSplash.setPathSplashStrokeColor(R.color.accent); //any color you want form colors.xml
//        configSplash.setAnimPathFillingDuration(3000);
//        configSplash.setPathSplashFillColor(R.color.Wheat); //path object filling color


        //Customize Title
        configSplash.setTitleSplash(getResources().getString(R.string.app_name));
        configSplash.setTitleTextColor(R.color.color_white);
        configSplash.setTitleTextSize(30f); //float value
        configSplash.setAnimTitleDuration(2000);
        configSplash.setAnimTitleTechnique(Techniques.DropOut);
//        Wobble DropOut FadeInDown
        configSplash.setTitleFont("fonts/Roboto-Bold.ttf"); //provide string to your font located in assets/fonts/

    }

    @Override
    public void animationsFinished() {
        //wait 5 sec and then go back to MainActivity
        final Activity a = this;
        WeakHandler handler = new WeakHandler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ChangeActivityHelper.changeActivity(a, MainActivity.class, true);
            }
        }, Constants.SPLASH_DELAY);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ChangeActivityHelper.changeActivity(this, MainActivity.class, true);
    }
}
