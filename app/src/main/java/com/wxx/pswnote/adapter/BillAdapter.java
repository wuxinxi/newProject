package com.wxx.pswnote.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wxx.pswnote.R;
import com.wxx.pswnote.bean.Spend;
import com.wxx.pswnote.listener.CustomClickListener;
import com.wxx.pswnote.viewholder.BillViewHolder;

import java.util.List;

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


public class BillAdapter extends RecyclerView.Adapter {

    private List<Spend> list;

    public BillAdapter(List<Spend> list) {
        this.list = list;
    }

    private CustomClickListener listener;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spend_income, parent, false);
        return new BillViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Spend spend = list.get(position);
        if (spend == null)
            return;
        BillViewHolder viewHolder = (BillViewHolder) holder;
        bindData(spend, viewHolder.spend_money, viewHolder.income_money, viewHolder.type);

    }

    private void bindData(Spend spend, TextView spend_money, TextView income_money, ImageView type) {
        spend_money.setText(spend.getSpendmoney());
        income_money.setText(spend.getIncomemoney());
    }

    public void setClick(CustomClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
