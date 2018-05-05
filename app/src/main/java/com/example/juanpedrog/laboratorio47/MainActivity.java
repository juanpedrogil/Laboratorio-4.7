package com.example.juanpedrog.laboratorio47;

import android.animation.ObjectAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ImageView face;
    private Button bounce,acelerate,cycle,decelerate;
    private ConstraintLayout canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvas = findViewById(R.id.canvas);
        face = findViewById(R.id.imageView_face);
        bounce = findViewById(R.id.button_bounce);
        acelerate = findViewById(R.id.button_acelerateInterpolator);
        cycle = findViewById(R.id.button_cycleInterpolator);
        decelerate = findViewById(R.id.button_decelerateInterpolator);

        bounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int screenHeight = canvas.getHeight();
                int targetY = screenHeight;
                ObjectAnimator animator = ObjectAnimator.ofFloat(
                        face, "y", targetY, 0)
                        .setDuration(1000);
                animator.setInterpolator(new BounceInterpolator());
                animator.start();
            }
        });

        acelerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int screenHeight = canvas.getHeight();
                int targetY = screenHeight ;

                ObjectAnimator animator = ObjectAnimator.ofFloat(
                        face, "y", targetY, 0)
                        .setDuration(2000);
                animator.setInterpolator(new AccelerateInterpolator());
                animator.start();
            }
        });

        cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int screenHeight = canvas.getHeight();
                int targetY = screenHeight - face.getHeight();

                ObjectAnimator animator = ObjectAnimator.ofFloat(
                        face, "y", targetY, 0)
                        .setDuration(5000);
                animator.setInterpolator(new CycleInterpolator(5));
                animator.start();
            }
        });

        decelerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int screenHeight = canvas.getHeight();
                int targetY = screenHeight - face.getHeight();

                ObjectAnimator animator = ObjectAnimator.ofFloat(
                        face, "y", targetY, 0)
                        .setDuration(2000);
                animator.setInterpolator(new DecelerateInterpolator());
                animator.start();
            }
        });

    }
}
