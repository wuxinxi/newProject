package com.wxx.pswnote.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

/**
 * 作者：Tangren_ on 2016/12/17 20:55.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class ImageTextView extends TextView {

    private Drawable[] drawables;

    public ImageTextView(Context context) {
        super(context);
        init();
    }


    public ImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        drawables = getCompoundDrawables();
    }


    @Override
    protected void onDraw(Canvas canvas) {

        if (null != drawables) {
            Drawable drawableLeft = drawables[0];
            Drawable drawableRight = drawables[2];
            //文字宽度
            float textWidth = getPaint().measureText(getText().toString());
            if (null != drawableLeft) {
                setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
                //内容区域
                float contentWidth = textWidth + getCompoundDrawablePadding() + drawableLeft.getIntrinsicWidth();
                //向X轴的正方向平移
                canvas.translate((getWidth() - contentWidth) / 2, 0);
            }
            if (null != drawableRight) {
                //xml中不必设置Gravity，右边图片必须要设置Graviey为End，否则translate后文字看不到
                setGravity(Gravity.END | Gravity.CENTER_VERTICAL);
                float contentWidth = textWidth + getCompoundDrawablePadding() + drawableRight.getIntrinsicWidth();
                //向X轴的负方向平移
                canvas.translate(-(getWidth() - contentWidth) / 2, 0);
            }
        }

        super.onDraw(canvas);
    }
}
