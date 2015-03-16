package co.kr.app.bangbanggokgok.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.login.LoginActivity;


public class IntroActivity extends Activity {
    ImageView intro_img;
    Handler mHandler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            intro_img.setVisibility(View.GONE);
            goToLogin();

        }
    };

    private void goToLogin() {
        finish();
        Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e("CHECK", "111onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        intro_img = (ImageView) findViewById(R.id.Img_intro);
        intro_img.setImageResource(R.drawable.img_loading);
        Animation alpahAnim = AnimationUtils.loadAnimation(IntroActivity.this, R.anim.alpha);
        intro_img.startAnimation(alpahAnim);
        mHandler.postDelayed(r, 2000);
    }
}