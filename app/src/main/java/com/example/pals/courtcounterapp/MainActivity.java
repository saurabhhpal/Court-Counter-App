package com.example.pals.courtcounterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView alphaTV , betaTV, tv_zoom;
    Button alpha3Button, beta3Button , alpha2Button, beta2Button, alpha1Button, beta1Button , resetButton;
    Integer counterAlpha=0;
    Integer countereBeta=0;
    Animation zoomInAlpha, zoomInBeta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_zoom =(TextView) findViewById(R.id.tv_zoom);
        alphaTV = (TextView) findViewById(R.id.alphaTV);
         betaTV = (TextView) findViewById(R.id.betaTV);
        alpha3Button =(Button) findViewById(R.id.alpha3Button);
        beta3Button = (Button) findViewById(R.id.beta3Button);
        alpha2Button = (Button) findViewById(R.id.alpha2Button);
        beta2Button =(Button) findViewById(R.id.beta2Button);
        alpha1Button = (Button)findViewById(R.id.alpha1Button);
        beta1Button = (Button) findViewById(R.id.beta1Button);
        resetButton= (Button) findViewById(R.id.resetButton);

        alpha3Button.setOnClickListener(this);
        beta3Button.setOnClickListener(this);
        alpha2Button.setOnClickListener(this);
        beta2Button.setOnClickListener(this);
        alpha1Button.setOnClickListener(this);
        beta1Button.setOnClickListener(this);
        resetButton.setOnClickListener(this);

        zoomInAlpha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        zoomInBeta = AnimationUtils.loadAnimation(this,R.anim.zoom_out);
        tv_zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }


    @Override
    public void onClick(View view) {
         if (view.getId() == alpha3Button.getId()){
             counterAlpha += 3;
//             String cc = counter.toString();
             //Integer value= (Integer) alpha3Button.getText();
             alphaTV.setText(String.valueOf(counterAlpha));
             tv_zoom.setText(String.valueOf(counterAlpha));
             startAlphaAnimation();
            // beta3Button.setText(Integer.parseInt(betaTV.getText().toString())+3);
         }

         else if(view.getId() == alpha2Button.getId()){
             counterAlpha+=2;
             alphaTV.setText(String.valueOf(counterAlpha));
         }
         else if(view.getId() == alpha1Button.getId()){
             counterAlpha+=1;
             alphaTV.setText(String.valueOf(counterAlpha));
             startAlphaAnimation();
         }

         else if (view.getId() == beta3Button.getId()){
             countereBeta +=3;
             betaTV.setText(String.valueOf(countereBeta));
             startBetaAnimation();
         }
         else if (view.getId() == beta2Button.getId()){
             countereBeta +=2;
             betaTV.setText(String.valueOf(countereBeta));
             startBetaAnimation();
         }
         else if(view.getId() == beta1Button.getId()){
             countereBeta += 1;
             betaTV.setText(String.valueOf(countereBeta));
            startBetaAnimation();
         }
         else if(view.getId() == resetButton.getId()){
             counterAlpha=0;
             countereBeta=0;
             alphaTV.setText("0");
             startAlphaAnimation();
             startBetaAnimation();
             betaTV.setText("0");

         }

    }

    void startAlphaAnimation(){
        alphaTV.setVisibility(View.VISIBLE);
        alphaTV.startAnimation(zoomInAlpha);
    }

    void startBetaAnimation(){
        betaTV.setVisibility(View.VISIBLE);
        betaTV.startAnimation(zoomInBeta);
    }
}
