package com.wxx.pswnote.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wxx.pswnote.R;
import com.wxx.pswnote.adapter.SpendAdapter;
import com.wxx.pswnote.base.BaseFragment;
import com.wxx.pswnote.bean.SpendBean;
import com.wxx.pswnote.control.KeyBoardPopupWindow;
import com.wxx.pswnote.listener.CustomClickListener;
import com.wxx.pswnote.moudle.sepend.presenter.SpendPresenter;
import com.wxx.pswnote.moudle.sepend.view.ISpendList;
import com.wxx.pswnote.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.wxx.pswnote.R.id.money_layout;

/**
 * 作者：Tangren_ on 2016/12/18 10:05.
 * 邮箱：wu_tangren@163.com
 * TODO:支出
 */

public class SpendFragment extends BaseFragment<ISpendList, SpendPresenter> implements ISpendList,
        CustomClickListener {
    @InjectView(R.id.money_type)
    TextView moneyType;
    @InjectView(R.id.money_text)
    TextView moneyText;
    @InjectView(money_layout)
    LinearLayout moneyLayout;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    private View rootView;

    private SpendAdapter mAdapter;
    private List<SpendBean> list = new ArrayList<SpendBean>();
    private KeyBoardPopupWindow popupWindow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_spend, null);
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
        mAdapter.setClick(this);
        popupWindow = new KeyBoardPopupWindow(getActivity(), clickListener);

        //监听滑动
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                             @Override
                                             public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                                 super.onScrolled(recyclerView, dx, dy);
                                                 popupWindow.dismiss();
                                             }
                                         }

        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    protected SpendPresenter createPresenter() {
        return new SpendPresenter(this);
    }

    @Override
    public void showList(List<SpendBean> spendBeanList) {
        this.list = spendBeanList;
        mAdapter = new SpendAdapter(getActivity(), spendBeanList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showFail() {

    }

    @Override
    public void onItemClick(View view, int postion) {
        if (postion == mAdapter.getItemCount() - 1)
            return;
        Utils.setColor(moneyLayout, postion);
        moneyType.setText(list.get(postion).getType());
        View parent = ((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0);
        popupWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.num_0:
                    break;
                case R.id.num_1:
                    break;
                case R.id.num_2:
                    break;
                case R.id.num_3:
                    break;
                case R.id.num_4:
                    break;
                case R.id.num_5:
                    break;
                case R.id.num_6:
                    break;
                case R.id.num_7:
                    break;
                case R.id.num_8:
                    break;
                case R.id.num_9:
                    break;
                case R.id.jia:
                    break;
                case R.id.jian:
                    break;
                case R.id.num_del:
                    break;
                case R.id.ok:
                    popupWindow.dismiss();
                    break;
            }

        }
    };
}
