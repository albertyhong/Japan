package com.example.yunsuphong.japan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import android.widget.Toast;

public class JapanView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);	//no jagged edges
    //Paint paint = new Paint();

    public JapanView(Context context) {
        //Set it up so that JapanView does more than just the View class
        super(context);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);	//vs. STROKE

        /*
        //Drop shadow
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            //Draw the JapanView without using hardware acceleration,
            //because hardware acceleration would prevent the shadow
            //from being drawn.
            setLayerType(LAYER_TYPE_SOFTWARE, paint);
        }
        paint.setShadowLayer(2f, 10f, 20f, Color.GRAY);
        */
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*
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
        */

        int width = getWidth();
        int height = getHeight();
        float radius = .3f * Math.min(width, height);

        /*
        canvas.drawColor(Color.WHITE);	//background
        canvas.drawCircle(width / 2f, height / 2f, radius, paint);
        canvas.translate(width / 2f, height / 2f);
        */

        //Color gradient
        int[] colors = {
                Color.RED,
                0xFFFF8000,	//There was no Color.ORANGE.
                Color.YELLOW,
                Color.GREEN,
                Color.BLUE
        };

        float[] positions = {	//These are the default positions.
                0f / (colors.length - 1),
                1f / (colors.length - 1),
                2f / (colors.length - 1),
                3f / (colors.length - 1),
                4f / (colors.length - 1)
        };

        LinearGradient linearGradient = new LinearGradient(
                -radius, 0f,	//starting point
                radius, 0f,	//ending point
                colors,
                positions,
                Shader.TileMode.CLAMP //vs. Shader.TileMode.REPEAT, etc.
        );

        paint.setShader(linearGradient);


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
