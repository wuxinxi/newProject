package com.wxx.pswnote.moudle.income.presenter;

import com.wxx.pswnote.base.BasePresenter;
import com.wxx.pswnote.bean.SpendBean;
import com.wxx.pswnote.moudle.income.action.InComeCompl;
import com.wxx.pswnote.moudle.income.action.InComeModel;
import com.wxx.pswnote.moudle.income.view.InComeList;

import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/18 12:14.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class InComePresenter extends BasePresenter<InComeList> {
    private InComeList inComeListView;
    private InComeModel model = new InComeCompl();

    public InComePresenter(InComeList inComeListView) {
        this.inComeListView = inComeListView;
    }

    public void fetchList() {
        if (model != null) {
            model.loadSpendList(new InComeModel.loadListener() {
                @Override
                public void loadSpendList(List<SpendBean> spendBeanList) {
                    if (inComeListView != null) {
                        inComeListView.showList(spendBeanList);
                    }

                }

                @Override
                public void loadFail() {

                }
            });
        }
    }

}
