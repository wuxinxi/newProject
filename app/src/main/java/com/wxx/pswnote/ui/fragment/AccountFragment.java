package com.wxx.pswnote.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wxx.pswnote.R;
import com.wxx.pswnote.adapter.BillAdapter;
import com.wxx.pswnote.base.BaseFragment;
import com.wxx.pswnote.bean.Spend;
import com.wxx.pswnote.listener.CustomClickListener;
import com.wxx.pswnote.moudle.account.presenter.AccountPresenter;
import com.wxx.pswnote.moudle.account.view.IAccountView;
import com.wxx.pswnote.ui.activity.AddActivity;
import com.wxx.pswnote.ui.activity.DateChoseActivity;
import com.wxx.pswnote.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Tangren_ on 2016/12/16.
 */

public class AccountFragment extends BaseFragment<IAccountView, AccountPresenter> implements CustomClickListener, IAccountView {
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

        return rootView;
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        mPresneter.fetchSpendAccount();
    }

//
//    private List getList() {
//        for (int i = 0; i < 5; i++) {
//            Spend spend = new Spend();
//            spend.setDate("2016-12-19");
//            spend.setIcon(i);
//            spend.setSpendmoney("22" + i);
//            spend.setSpendtype("交通");
//            list.add(spend);
//        }
//        for (int i = 0; i < 5; i++) {
//            Spend spend = new Spend();
//            spend.setDate("2016-12-19");
//            spend.setIcon(i);
//            spend.setIncomemoney("22" + i);
//            spend.setIncometype("娱乐");
//            list.add(spend);
//        }
//        for (int i = 0; i < 5; i++) {
//            Spend spend = new Spend();
//            spend.setDate("2016-12-20");
//            spend.setIcon(i);
//            spend.setSpendtype("餐饮");
//            spend.setSpendmoney("1" + i);
//            list.add(spend);
//        }
//
//
//        return list;
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.add, R.id.add_2, R.id.chose_date})
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), AddActivity.class);
        intent.putExtra("date", Utils.getDate());
        switch (view.getId()) {
            case R.id.add:
                startActivityForResult(intent, 0);
                break;
            case R.id.add_2:
                startActivityForResult(intent, 0);
                break;
            case R.id.chose_date:
                Intent intent2 = new Intent(getActivity(), DateChoseActivity.class);
                startActivityForResult(intent2, 0);
                break;
        }
    }

    @Override
    public void onItemClick(View view, int postion) {
        Toast.makeText(getActivity(), postion + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTypeClick(View view, int postion) {
        Toast.makeText(getActivity(), "TYPE", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
//            list.clear();
            mPresneter.fetchSpendAccount();
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected AccountPresenter createPresenter() {
        return new AccountPresenter(this);
    }

    @Override
    public void showList(List<Spend> spends) {
        mAdapter = new BillAdapter(spends);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setClick(this);
    }

    @Override
    public void showFail() {

    }

}
