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
import com.wxx.pswnote.viewholder.BillViewGroupHolder;
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
    private int ITEM_NORMAL = 0;
    private int ITEM_GROUP = 1;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_NORMAL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spend_income, parent, false);
            return new BillViewHolder(view, listener);
        } else if (viewType == ITEM_GROUP) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spend_income_date, parent, false);
            return new BillViewGroupHolder(view, listener);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Spend spend = list.get(position);
        if (spend == null)
            return;
        if (holder instanceof BillViewGroupHolder) {
            bindGroupData(spend, (BillViewGroupHolder) holder);
        } else {
            BillViewHolder viewHolder = (BillViewHolder) holder;
            bindData(spend, viewHolder.spend_money, viewHolder.spend_type, viewHolder.income_money, viewHolder.income_type, viewHolder.type);
        }


    }

    private void bindGroupData(Spend spend, BillViewGroupHolder holder) {
        bindData(spend, holder.spend_money, holder.spend_type, holder.income_money, holder.income_type, holder.type);
        holder.time.setText(spend.getDate());
        holder.countAmount.setText("200");
    }

    private void bindData(Spend spend, TextView spend_money, TextView spend_type, TextView income_money, TextView income_type, ImageView type) {
        spend_money.setText(spend.getSpendmoney());
        spend_type.setText(spend.getSpendtype());
        income_money.setText(spend.getIncomemoney());
        income_type.setText(spend.getIncometype());
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return ITEM_GROUP;
        String currentDate = list.get(position).getDate();
        int index = position - 1;
        boolean isDifferent = !list.get(index).getDate().equals(currentDate);
        return isDifferent ? ITEM_GROUP : ITEM_NORMAL;
    }

    public void setClick(CustomClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
