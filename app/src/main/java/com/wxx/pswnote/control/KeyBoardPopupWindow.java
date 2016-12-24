package com.wxx.pswnote.control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import com.wxx.pswnote.R;

/**
 * 作者：Tangren_ on 2016/12/21 0021.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class KeyBoardPopupWindow extends PopupWindow {

    private Context context;
    private View view;
    private Button num_1, num_2, num_3, num_4, num_5, num_6, num_7, num_8, num_9, num_0, jia, jian, ok, del;

    public KeyBoardPopupWindow(Context context, View.OnClickListener clickListener) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        view = inflater.inflate(R.layout.numkeyboard_view, null);
        num_0 = (Button) view.findViewById(R.id.num_0);
        num_1 = (Button) view.findViewById(R.id.num_1);
        num_2 = (Button) view.findViewById(R.id.num_2);
        num_3 = (Button) view.findViewById(R.id.num_3);
        num_4 = (Button) view.findViewById(R.id.num_4);
        num_5 = (Button) view.findViewById(R.id.num_5);
        num_6 = (Button) view.findViewById(R.id.num_6);
        num_7 = (Button) view.findViewById(R.id.num_7);
        num_8 = (Button) view.findViewById(R.id.num_8);
        num_9 = (Button) view.findViewById(R.id.num_9);
        jia = (Button) view.findViewById(R.id.jia);
        jian = (Button) view.findViewById(R.id.jian);
        ok = (Button) view.findViewById(R.id.ok);
        del = (Button) view.findViewById(R.id.num_del);
        num_0.setOnClickListener(clickListener);
        num_1.setOnClickListener(clickListener);
        num_2.setOnClickListener(clickListener);
        num_3.setOnClickListener(clickListener);
        num_4.setOnClickListener(clickListener);
        num_5.setOnClickListener(clickListener);
        num_6.setOnClickListener(clickListener);
        num_7.setOnClickListener(clickListener);
        num_8.setOnClickListener(clickListener);
        num_9.setOnClickListener(clickListener);
        del.setOnClickListener(clickListener);
        jia.setOnClickListener(clickListener);
        jian.setOnClickListener(clickListener);
        ok.setOnClickListener(clickListener);

        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//        this.setFocusable(true);
        this.setAnimationStyle(R.style.AnimBottom);
        this.setInputMethodMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//        ColorDrawable dw = new ColorDrawable(0xb0000000);
//        this.setBackgroundDrawable(dw);

        this.setFocusable(false);
        view.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = view.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });

    }
}
