package com.emedinaa.buttonanimation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 25/11/15.
 */
public class AnimationButton extends Button
{
    private List<Animation> mAnimationBuffer = new ArrayList<Animation>();;
    private boolean mIsAnimating;
    private boolean up=false;

    public AnimationButton(Context context)
    {
        super(context);

    }

    public AnimationButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);

    }

    public AnimationButton(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            up=false;
            generateAnimation(1, 0.80f);
            triggerNextAnimation();

        }
        else if (event.getAction() == MotionEvent.ACTION_CANCEL || event.getAction() == MotionEvent.ACTION_UP)
        {
            up=true;
            generateAnimation(0.80f, 1);
            triggerNextAnimation();

        }
        return super.onTouchEvent(event);
    }

    private void generateAnimation(float from, float to)
    {
       //ScaleAnimation scaleAnimation = new ScaleAnimation(from, to, from, to);
        ScaleAnimation scaleAnimation = new ScaleAnimation(from, to, from, to, Animation.RELATIVE_TO_SELF, (float)0.5, Animation.RELATIVE_TO_SELF, (float)0.5);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(80);

        scaleAnimation.setAnimationListener(new ScaleAnimation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationRepeat(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                mIsAnimating = false;
                triggerNextAnimation();
                if(up)performClick();
            }
        });

        mAnimationBuffer.add(scaleAnimation);
    }

    private void triggerNextAnimation()
    {
        if (mAnimationBuffer.size() > 0 && !mIsAnimating)
        {
            mIsAnimating = true;
            Animation currAnimation = mAnimationBuffer.get(0);
            mAnimationBuffer.remove(0);

            startAnimation(currAnimation);
        }
    }

}