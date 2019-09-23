package com.example.myapplication;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CustomGraph extends SurfaceView implements SurfaceHolder.Callback {
    public SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float x, y, m, b;

    public CustomGraph(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        paint = null;

    }

    /* This method will be invoked to draw a circle in canvas. */
    public void draw()
    {
        surfaceHolder = getHolder();

        // Get and lock canvas object from surfaceHolder.
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.BLACK);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the line.
        paint.setColor(Color.BLUE);
        float y0 =  m*0 + b; // Initial Y location, for X = 0
        float y1 =  m*this.getWidth() + b; // for X = width
        canvas.drawLine(0,y0, this.getWidth(), y1, paint);

        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

// Modify these to setM and setB, rather than X and Y
    public void setM(float m) {
        this.m = (float) (0.01 * m);
    }
    public void setB(float b) {
        this.b = (float) (0.01 * b);
    }

}