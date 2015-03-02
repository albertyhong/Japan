package com.example.yunsuphong.japan;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by yunsuphong on 2/28/15.
 */
public class JapanView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);	//no jagged edges

    public JapanView(Context context) {
        //Set it up so that JapanView does more than just the View class
        super(context);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);	//vs. STROKE
        paint.setShadowLayer(2f, 10f, 20f, Color.GRAY);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //decorView occupies the whole screen.
        Window window = ((Activity)getContext()).getWindow();
        View decorView = window.getDecorView();

        //The dimensions of the whole screen, except for the status bar.
        Rect frame = new Rect();
        decorView.getWindowVisibleDisplayFrame(frame);

        //contentView occupies the whole screen,
        //except for the status and action bars.
        View contentView = window.findViewById(Window.ID_ANDROID_CONTENT);

        String string = "status bar height = " + frame.top
                + "\naction bar height = " + (contentView.getTop() - frame.top);

        Toast.makeText(getContext(), string, Toast.LENGTH_LONG).show();

        int width = getWidth();
        int height = getHeight();
        float radius = .3f * Math.min(width, height);

        canvas.drawColor(Color.WHITE);	//background
        canvas.drawCircle(width / 2f, height / 2f, radius, paint);

        canvas.translate(width / 2f, height / 2f);

        //canvas.scale(1f, 2f);
        //canvas.drawCircle(0f, 0f, radius, paint);

        //Triangle
        /*
        Path path = new Path();    //import android.graphics.Path;
        path.moveTo(0f, 0f);       //right angle at origin
        path.lineTo(radius, 0f);   //one leg
        path.lineTo(0f, radius);   //the hypotenuse
        path.close();              //the other leg

        canvas.drawPath(path, paint);
        */

        String s = width + " \u00D7 " + height;
        //How you pop up the toast in a view object instead of an activity object
        Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
    }
}
