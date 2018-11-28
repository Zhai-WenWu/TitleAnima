package com.example.xiangha.firstrunning;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class Fl extends FrameLayout {

    private int yDown;
    private int yMove;
    private boolean isIntercept;
    public int in;

    public Fl(@NonNull Context context) {
        super(context);
        View view = inflate(context, R.layout.activity_main, null);
        addView(view);
        AppBarLayout appbar = view.findViewById(R.id.appbar);
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {


            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                in = i;
                Log.i("asdg", "" + in);
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isIntercept = false;
                yDown = y;
                Log.i("ydown", yDown + "");
                break;
            case MotionEvent.ACTION_MOVE:
                yMove = y;
                Log.i("ydownmove", yMove + "");
                if (yMove - yDown > 0 && in == 0) {
                    isIntercept = true;
                } else {
                    isIntercept = false;
                }
                break;
            case MotionEvent.ACTION_UP:

                isIntercept = false;
        }
        return isIntercept;
    }
}
