package com.wxx.pswnote.viewholder;

import android.view.View;
import android.widget.TextView;

import com.wxx.pswnote.R;
import com.wxx.pswnote.listener.CustomClickListener;

/**
 * 作者：Tangren_ on 2016/12/24 0024.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class BillViewGroupHolder extends BillViewHolder {
    public TextView time;
    public TextView countAmount;

    public BillViewGroupHolder(View itemView, CustomClickListener listener) {
        super(itemView, listener);
        time = (TextView) itemView.findViewById(R.id.time);
        countAmount = (TextView) itemView.findViewById(R.id.countAmount);
    }
}
