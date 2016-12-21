package com.wxx.pswnote.moudle.sepend.presenter;

import com.wxx.pswnote.base.BasePresenter;
import com.wxx.pswnote.bean.SpendBean;
import com.wxx.pswnote.moudle.sepend.action.SpendCompl;
import com.wxx.pswnote.moudle.sepend.action.SpendModel;
import com.wxx.pswnote.moudle.sepend.view.ISpendList;

import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/18 12:14.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class SpendPresenter extends BasePresenter<ISpendList> {
    private ISpendList spendListView;
    private SpendModel model = new SpendCompl();

    public SpendPresenter(ISpendList spendListView) {
        this.spendListView = spendListView;
    }

    public void fetchList() {
        if (model != null) {
            model.loadSpendList(new SpendModel.loadListener() {
                @Override
                public void loadSpendList(List<SpendBean> spendBeanList) {
                    if (spendListView != null) {
                        spendListView.showList(spendBeanList);
                    }

                }

                @Override
                public void loadFail() {

                }
            });
        }
    }

}
