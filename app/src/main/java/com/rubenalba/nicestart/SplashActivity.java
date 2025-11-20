package com.rubenalba.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.rubenalba.nicestart.databinding.ActivityLoginBinding;
import com.rubenalba.nicestart.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.blink);
        binding.ivSplashLogo.startAnimation(myAnim);

        Glide.with(this)
                .load("https://wallpapers.com/images/hd/dark-ocean-938-x-1668-wallpaper-9q07z71hrfl8k5ty.jpg")
                .centerCrop()
                .into(binding.ivSplashBackground);

        openMain();
    }

    private void openMain() {
        Handler handler = new Handler(android.os.Looper.getMainLooper());
        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                }, 5000
        );
    }
}