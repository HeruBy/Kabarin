package com.example.heruby.kabarin;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2Fragment;

public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntro2Fragment.newInstance("WELCOME TO KABARIN",
                "Kabarin merupakan aplikasi semacam reminder yang digunakan untuk mengingatkan anda agar event atau acara penting anda tidak terlewatkan",
                R.drawable.ic_slide1,
                Color.parseColor("#FF6F00")));
        addSlide(AppIntro2Fragment.newInstance("NOTES",
                "Catat event atau acara penting anda disini",
                R.drawable.ic_slide2,
                Color.parseColor("#FF7F00")));
        addSlide(AppIntro2Fragment.newInstance("CALENDAR",
                "setting kalender untuk mengingatkan event atau acara penting anda",
                R.drawable.ic_slide4,
                Color.parseColor("#ff8f00")));
        addSlide(AppIntro2Fragment.newInstance("NOTIFICATION",
                "notifikasi akan muncul ketika event atau acara anda akan dimulai",
                R.drawable.ic_slide3,
                Color.parseColor("#ff9f00")));

        showStatusBar(false);

    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    public void onSlideChanged() {
    }
}
