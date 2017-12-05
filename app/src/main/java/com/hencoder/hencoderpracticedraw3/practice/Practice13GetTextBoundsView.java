package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice13GetTextBoundsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String[] texts = new String[]{"A", "a", "J", "j", "Â", "â"};
    int top = 200;
    int bottom = 400;

    int[] yOffset = new int[]{0, 0, 0, 0, 0, 0};
    private Rect textBounds;
//    private Paint.FontMetrics fontMetrics;

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);

        textBounds = new Rect();


//        fontMetrics = paint2.getFontMetrics();

//        Log.d("offset", String.format("top = %f, bottom = %f", fontMetrics.top, fontMetrics.bottom));


    }

    public Practice13GetTextBoundsView(Context context) {
        super(context);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

//        int offset = (top + bottom) / 2;

        for (int i = 0; i < texts.length; i++) {
            paint2.getTextBounds(texts[i], 0, texts[i].length(), textBounds);
            // 注意！！！！这里
            yOffset[i] = -(textBounds.bottom + textBounds.top) / 2;

//            textBounds.top += offset;
//            textBounds.bottom += offset;
//            textBounds.left += 100 * (i + 1);
//            textBounds.right += 100 * (i + 1);
//            canvas.drawRect(textBounds, paint1);

//            canvas.drawCircle(100 * (i + 1), offset, 3, paint1);

//            Log.d("offset", String.format("top = %d, bottom = %d, left = %d, right = %d", textBounds.top, textBounds.bottom, textBounds.left, textBounds.right));
        }

        int middle = (top + bottom) / 2;

//        paint1.setStrokeWidth(1);
//        canvas.drawLine(0, middle, getWidth(), middle, paint1);



//        paint2.getTextBounds("j", 0, 1, textBounds);

//        int yOffset = -(textBounds.top + textBounds.bottom) / 2;
//        canvas.drawText("j", 800, middle + yOffset, paint2);
//
//        canvas.drawLine(0, middle - yOffset, getWidth(), middle - yOffset, paint1);
//        canvas.drawLine(0, middle + textBounds.bottom, getWidth(), middle + textBounds.bottom, paint1);


        canvas.drawText(texts[0], 100, middle + yOffset[0], paint2);
        canvas.drawText(texts[1], 200, middle + yOffset[1], paint2);
        canvas.drawText(texts[2], 300, middle + yOffset[2], paint2);
        canvas.drawText(texts[3], 400, middle + yOffset[3], paint2);
        canvas.drawText(texts[4], 500, middle + yOffset[4], paint2);
        canvas.drawText(texts[5], 600, middle + yOffset[5], paint2);


//        canvas.drawText("j", 300, middle, paint2);


    }
}