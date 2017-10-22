package com.ks.mygenie;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.ParallaxPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

/**
 * Created by DOLPHIN on 12-Oct-17.
 */

public class TutorialsActivity extends WelcomeActivity {

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultTitleTypefacePath("Montserrat-Bold.ttf")
                .defaultHeaderTypefacePath("Montserrat-Bold.ttf")

                .page(new BasicPage(R.drawable.image,
                        "Welcome",
                        "An Android library for onboarding, instructional screens, and more")
                        .background(R.color.lightblue100)
                )

                .page(new BasicPage(R.drawable.image,
                        "Simple to use",
                        "Add a welcome screen to your app with only a few lines of code.")
                        .background(R.color.lightblue300)
                )

                .page(new ParallaxPage(R.layout.parallax_example,
                        "Easy parallax",
                        "Supply a layout and parallax effects will automatically be applied")
                        .lastParallaxFactor(2f)
                        .background(R.color.lightblue500)
                )

                .page(new BasicPage(R.drawable.image,
                        "Customizable",
                        "All elements of the welcome screen can be customized easily.")
                        .background(R.color.lightblue700)
                )

                .swipeToDismiss(true)
                .exitAnimation(android.R.anim.fade_out)
                .build();
    }

    public static String welcomeKey() {
        return "WelcomeScreen";
    }
}
