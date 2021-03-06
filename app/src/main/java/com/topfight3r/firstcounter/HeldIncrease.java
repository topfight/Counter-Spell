package com.topfight3r.firstcounter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import static android.os.SystemClock.uptimeMillis;

/**
 * Created by petro_000 on 2017-05-20.
 */

public class HeldIncrease extends Thread{
    public static boolean heldDown = false;
    static long startTime =0;
    int count = 0;
    Context thisContext = null;
    public void myStart(){
        heldDown = true;
    }
    public void kill(){

        heldDown = false;
        startTime = 0;
    }
    public void run(){
        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
        if(startTime <= 0) startTime = uptimeMillis();
        if(uptimeMillis() - startTime > 700){
            decreaseCount(thisContext, 3);
            startTime = uptimeMillis();
        }

    }



    public void increaseCount(View view){
        count ++;
    }

    public void increaseCount(View view, int incr){
        count += incr;
    }
    public void decreaseCount(View view){
        count --;
    }

    public void decreaseCount(Context c, int incr){
        MainActivity.count -= incr;
    }
}
