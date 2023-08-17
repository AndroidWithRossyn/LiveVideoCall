package com.appsians.strangers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.appsians.strangers.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.mIvLogo)
    ImageView mIvLogo;
    @BindView(R.id.mIvTitle)
    TextView mIvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        startAnimatons();
    }

    private void startAnimatons() {
        float percent = 200 * 100f / 100;
        TranslateAnimation mSetAnim = new TranslateAnimation(0, 0, -percent, 0);
        mSetAnim.setDuration(1700);
        mSetAnim.setFillAfter(false);
        mSetAnim.setAnimationListener(new MyAnimationListener());

        mIvLogo.startAnimation(mSetAnim);

        TranslateAnimation animation = new TranslateAnimation(0, 0, percent, 0);
        animation.setDuration(1700);
        animation.setFillAfter(false);

        mIvTitle.startAnimation(animation);
    }

    private class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationEnd(Animation animation) {
            mStartAct();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }

    }

    private void mStartAct() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}