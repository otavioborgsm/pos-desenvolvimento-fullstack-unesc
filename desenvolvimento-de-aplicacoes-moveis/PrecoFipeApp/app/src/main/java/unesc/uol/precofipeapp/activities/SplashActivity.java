package unesc.uol.precofipeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unesc.uol.precofipeapp.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageAutomovel;
    private Animation animation;
    private TextView textBemVindo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageAutomovel = findViewById(R.id.imageAutomovel);
        textBemVindo = findViewById(R.id.textBemVindo);

        animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textBemVindo.setVisibility(View.VISIBLE);

                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    }
                }, 5000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageAutomovel.setAnimation(animation);
        animation.start();
    }
}
