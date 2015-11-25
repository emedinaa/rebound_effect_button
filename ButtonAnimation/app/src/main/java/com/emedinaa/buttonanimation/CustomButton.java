package com.emedinaa.buttonanimation;

import android.animation.Animator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;


/**
 * Created by emedinaa on 25/11/15.
 */


public class CustomButton extends Button
{
    private static final String TAG = "CustomButton";
    private ObjectAnimator downAnimUp = null;
    private ObjectAnimator downAnimDown = null;
    private DecelerateInterpolator decelerator;
    private AccelerateDecelerateInterpolator ace_decelerator;
    private boolean animation=false;


    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        app();
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        app();
    }

    public CustomButton(Context context) {
        super(context);
        app();
    }

    private void app()
    {
        decelerator= new DecelerateInterpolator();
        ace_decelerator= new AccelerateDecelerateInterpolator();

        setOnTouchListener(mTouchListener);
    }

    private OnTouchListener mTouchListener=new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    Log.v(TAG, "UP");

                        downAnimUp = ObjectAnimator.ofPropertyValuesHolder(CustomButton.this, PropertyValuesHolder.ofFloat("scaleX", 1.0f),
                                PropertyValuesHolder.ofFloat("scaleY", 1.0f));
                        downAnimUp.setDuration(100);
                        downAnimUp.setInterpolator(ace_decelerator);
                        downAnimUp.addListener(listenerUp);
                        downAnimUp.start();

                    break;
                case MotionEvent.ACTION_DOWN:
                    Log.v(TAG, "DOWN "+animation);
                    if(!animation)
                    {
                        downAnimDown = ObjectAnimator.ofPropertyValuesHolder(CustomButton.this, PropertyValuesHolder.ofFloat("scaleX", 0.9f),
                                PropertyValuesHolder.ofFloat("scaleY", 0.9f));
                        downAnimDown.setDuration(100);
                        downAnimDown.setInterpolator(ace_decelerator);
                        downAnimDown.addListener(listener);
                        downAnimDown.start();
                    }
                    break;

                default:
                    break;
            }
            return false;
        }

    };

    private Animator.AnimatorListener listener= new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animator) {
            animation=true;
        }

        @Override
        public void onAnimationEnd(Animator animator) {
            animation=false;
        }

        @Override
        public void onAnimationCancel(Animator animator) {
            animation=false;
        }

        @Override
        public void onAnimationRepeat(Animator animator) {

        }
    };

    private Animator.AnimatorListener listenerUp= new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animator) {
        }

        @Override
        public void onAnimationEnd(Animator animator) {
           performClick();
        }

        @Override
        public void onAnimationCancel(Animator animator) {
        }

        @Override
        public void onAnimationRepeat(Animator animator) {

        }
    };



}