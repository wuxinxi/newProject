package com.wxx.pswnote.viewholder;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wxx.pswnote.MyApplication;
import com.wxx.pswnote.R;
import com.wxx.pswnote.listener.CustomClickListener;

 /*
******************* Copyright (c) ***********************\
**
**         (c) Copyright  2016 , 唐人
**                  All Rights Reserved
**
**                    By(唐人)
**                www.wuxinxi.github.io
**
**                       _oo0oo_
**                      o8888888o
**                      88" . "88
**                      (| -_- |)
**                      0\  =  /0
**                    ___/`---'\___
**                  .' \\|     |// '.
**                 / \\|||  :  |||// \
**                / _||||| -:- |||||- \
**               |   | \\\  -  /// |   |
**               | \_|  ''\---/''  |_/ |
**               \  .-\__  '-'  ___/-. /
**             ___'. .'  /--.--\  `. .'___
**          ."" '<  `.___\_<|>_/___.' >' "".
**         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
**         \  \ `_.   \_ __\ /__ _/   .-` /  /
**     =====`-.____`.___ \_____/___.-`___.-'=====
**                       `=---='
**
**
**     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
**
**               佛祖保佑         永无BUG
**
**
**                   南无本师释迦牟尼佛
**

**----------------------类信息------------------------
** 版    本: V0.1
**
**Created by Tangren on 2016/12/21 0021.
**Email:wu_tangren@163.com
**TODO:用一句话概括
**
******************* End of Head **********************\
 */


public class BillViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView spend_money;
    public TextView income_money;
    public ImageView type;
    private CustomClickListener listener;

    public BillViewHolder(View itemView, CustomClickListener listener) {
        super(itemView);
        this.listener = listener;
        spend_money = (TextView) itemView.findViewById(R.id.spend_money);
        income_money = (TextView) itemView.findViewById(R.id.income_money);
        type = (ImageView) itemView.findViewById(R.id.type);
        itemView.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        if (listener != null) {
            Log.d("Tag", "----------------");

            listener.onItemClick(v, getAdapterPosition());
        }
    }
}
