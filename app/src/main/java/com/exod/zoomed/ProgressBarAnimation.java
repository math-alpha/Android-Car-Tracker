package com.exod.zoomed;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

public class ProgressBarAnimation extends Animation {

    Context context;
    private float start;
    private float end;
    private ProgressBar progressBar;

    public ProgressBarAnimation(Context context, ProgressBar progressBar, float start, float end){
        this.context  = context;
        this.progressBar = progressBar;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float val = start + (end - start) * interpolatedTime;
        progressBar.setProgress((int)val);
    }
}
