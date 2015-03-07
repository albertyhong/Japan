package com.example.yunsuphong.japan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by yunsuphong on 3/7/15.
 */
public class TouchView extends View {
    private PointF p = new PointF();	//holds 2 floats
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public TouchView(Context context) {
        super(context);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //Put center of circle where finger touched.
                        p.set(event.getX(), event.getY());
                        invalidate();    //call onDraw method of TouchView
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final int width = getWidth();
        final int height = getHeight();
        float radius = .1f * Math.min(width, height);

        canvas.drawColor(Color.WHITE);	//background
        canvas.drawCircle(p.x, p.y, radius, paint);
    }
}
