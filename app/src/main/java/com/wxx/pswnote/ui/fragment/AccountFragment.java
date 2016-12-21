package com.wxx.pswnote.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wxx.pswnote.R;
import com.wxx.pswnote.adapter.BillAdapter;
import com.wxx.pswnote.bean.Spend;
import com.wxx.pswnote.ui.activity.AddActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Tangren_ on 2016/12/16.
 */

public class AccountFragment extends Fragment {
    @InjectView(R.id.add)
    TextView add;
    @InjectView(R.id.chose_date)
    ImageView choseDate;
    @InjectView(R.id.view)
    View view;
    @InjectView(R.id.income_month)
    TextView incomeMonth;
    @InjectView(R.id.income_money_count)
    TextView incomeMoneyCount;
    @InjectView(R.id.spend_month)
    TextView spendMonth;
    @InjectView(R.id.spend_money_count)
    TextView spendMoneyCount;
    @InjectView(R.id.add_2)
    ImageView add2;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    private View rootView;

    private BillAdapter mAdapter;
    private List<Spend> list = new ArrayList<Spend>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_account, null);
            ButterKnife.inject(this, rootView);
            initView();
        }

        ViewGroup group = (ViewGroup) rootView.getParent();
        if (group != null)
            group.removeView(rootView);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        mAdapter = new BillAdapter(getList());
        recyclerView.setAdapter(mAdapter);

    }


    private List getList() {
        for (int i = 0; i < 10; i++) {
            Spend spend = new Spend();
            spend.setDate("2016");
            spend.setIcon(i);
            spend.setIncomemoney("10" + i);
            spend.setSpendmoney("22" + i);
            list.add(spend);
        }
        return list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.add, R.id.add_2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                startActivity(new Intent(getActivity(), AddActivity.class));
                break;
            case R.id.add_2:
                startActivity(new Intent(getActivity(), AddActivity.class));
                break;
        }
    }
}
