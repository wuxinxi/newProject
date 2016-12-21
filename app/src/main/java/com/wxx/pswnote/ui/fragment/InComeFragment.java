package com.wxx.pswnote.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wxx.pswnote.R;
import com.wxx.pswnote.adapter.SpendAdapter;
import com.wxx.pswnote.base.BaseFragment;
import com.wxx.pswnote.bean.SpendBean;
import com.wxx.pswnote.moudle.income.presenter.InComePresenter;
import com.wxx.pswnote.moudle.income.view.InComeList;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：Tangren_ on 2016/12/18 10:06.
 * 邮箱：wu_tangren@163.com
 * TODO:收入
 */

public class InComeFragment extends BaseFragment<InComeList, InComePresenter> implements InComeList {
    @InjectView(R.id.money_type)
    TextView moneyType;
    @InjectView(R.id.money_text)
    TextView moneyText;
    @InjectView(R.id.money_layout)
    LinearLayout moneyLayout;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    private View rootView;

    private SpendAdapter mAdapter;
    private List<SpendBean> list = new ArrayList<SpendBean>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_income, null);
            ButterKnife.inject(this, rootView);
            initView();
        }

        ViewGroup group = (ViewGroup) rootView.getParent();
        if (group != null)
            group.removeView(rootView);
        return rootView;
    }

    private void initView() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 5);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        mPresneter.fetchList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    protected InComePresenter createPresenter() {
        return new InComePresenter(this);
    }

    @Override
    public void showList(List<SpendBean> spendBeanList) {
        mAdapter = new SpendAdapter(getActivity(), spendBeanList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showFail() {

    }
}
