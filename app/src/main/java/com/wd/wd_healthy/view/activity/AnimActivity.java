package com.wd.wd_healthy.view.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.wd_healthy.R;

public class AnimActivity extends AppCompatActivity {

    private Button top;
    private ImageView dropdown;
    private Button down;
    private boolean isvis=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        initView();
        dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isvis){
                    Animation animation1 = AnimationUtils.loadAnimation(AnimActivity.this,R.anim.up);
                    top.startAnimation(animation1);
                    animation1.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            top.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    Animation animation2 = AnimationUtils.loadAnimation(AnimActivity.this,R.anim.down);
                    down.startAnimation(animation2);
                    animation2.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            down.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }else{
                    Animation animation1 =new TranslateAnimation(0,0,-100,0);
                    animation1.setDuration(2000);
                    top.startAnimation(animation1);
                    animation1.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            top.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    Animation animation2 = new TranslateAnimation(0,0,100,0);
                    animation2.setDuration(2000);
                    down.startAnimation(animation2);

                    animation2.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            down.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
                isvis=!isvis;
            }
        });
    }

    private void initView() {
        top = (Button) findViewById(R.id.top);
        dropdown = (ImageView) findViewById(R.id.dropdown);
        down = (Button) findViewById(R.id.down);
    }
}