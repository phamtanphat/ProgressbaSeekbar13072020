package com.example.progressbaseekbar13072020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtn;
    TextView mTv;
    ProgressBar mProgress;
    CountDownTimer mCountDownTimer;
    boolean mIsLoading = false;
    int mCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = findViewById(R.id.buttonProgress);
        mProgress = findViewById(R.id.progressbar);
        mTv = findViewById(R.id.textview);

        mProgress.setMax(10);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mIsLoading){
                    showView(mTv);
                    showView(mProgress);
                    mIsLoading = true;
                    mCountDownTimer = new CountDownTimer(10200 , 1000) {
                        @Override
                        public void onTick(long l) {
                            mTv.setText(String.format("Time loading : %ds",l / 1000));
                            mProgress.setProgress(mCount++);
                        }

                        @Override
                        public void onFinish() {
                            hideView(mProgress);
                            hideView(mTv);
                            mIsLoading = false;
                            Toast.makeText(MainActivity.this, "Loading finish", Toast.LENGTH_SHORT).show();
                            mCount = 0;
                        }
                    };
                    mCountDownTimer.start();
                }
            }
        });
    }
    public void showView(View v){
        v.setVisibility(View.VISIBLE);
    }
    public void hideView(View v){
        v.setVisibility(View.INVISIBLE);
    }
}