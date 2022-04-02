package com.example.drawable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));
    }
    private class CustomView extends View {
        public CustomView(Context context) {
            super(context);
        }
        protected void onDraw(Canvas canvas) {
            int width = getWidth();
            int height = getHeight();
            ShapeDrawable rect= new ShapeDrawable(new RectShape());
            rect.setBounds(width/6, height/9,
                    width*5/6, height*2/9);
            rect.getPaint().setColor(Color.rgb(96,96,96));
            rect.draw(canvas);
            GradientDrawable circle = (GradientDrawable)
                    getResources().getDrawable(R.drawable.circle);
            circle.setBounds(width/4, height*6/9, width*3/4, height*8/9);
            circle.draw(canvas);
            BitmapDrawable bmp = (BitmapDrawable)
                    getResources().getDrawable(R.drawable.icon_128);
            int bmpWidth = bmp.getIntrinsicWidth();
            int bmpHeight = bmp.getIntrinsicHeight();
            bmp.setBounds((width - bmpWidth)/2, 500,
                    (width + bmpWidth)/2,500 + bmpHeight);
            bmp.draw(canvas);
            Paint textPaint = new Paint();
            textPaint.setColor(Color.RED);
            textPaint.setTextSize(80);
            textPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("BMI", 500, 300,
                    textPaint);
        }
    }
}