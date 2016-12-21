package com.wxx.pswnote.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wxx.pswnote.MyApplication;
import com.wxx.pswnote.R;
import com.wxx.pswnote.bean.SpendBean;
import com.wxx.pswnote.listener.CustomClickListener;

import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/18 11:35.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class SpendAdapter extends RecyclerView.Adapter {
    private List<SpendBean> spendBeanList;
    private Context context;
    private CustomClickListener listener;

    public SpendAdapter(Context context, List<SpendBean> spendBeanList) {
        this.spendBeanList = spendBeanList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spend, parent, false);
        return new SpendViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SpendBean spendBean = spendBeanList.get(position);
        if (spendBean == null)
            return;
        SpendViewHolder viewHolder = (SpendViewHolder) holder;
        bindData(spendBean, viewHolder.items_type);
    }

    public void setPostion(int postion) {

    }

    private void bindData(SpendBean spendBean, TextView items_type) {
        Drawable drawable = context.getResources().getDrawable(spendBean.getId());
        items_type.setText(spendBean.getType());
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        items_type.setCompoundDrawables(null, drawable, null, null);
    }

    @Override
    public int getItemCount() {
        return spendBeanList.size() == 0 ? 0 : spendBeanList.size();
    }

    public void setClick(CustomClickListener listener) {
        this.listener = listener;
    }

    class SpendViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private int selectItem = -1;

        public TextView items_type;
        private CustomClickListener listener;

        public SpendViewHolder(View itemView, CustomClickListener listener) {
            super(itemView);
            this.listener = listener;
            items_type = (TextView) itemView.findViewById(R.id.items_type);
            itemView.setOnClickListener(this);
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClick(v, getAdapterPosition());
                itemView.setBackground(MyApplication.getInstance().getDrawable(R.drawable.item_ripple));
            }
        }

    }
}
