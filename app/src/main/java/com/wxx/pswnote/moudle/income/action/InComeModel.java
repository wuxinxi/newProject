package com.wxx.pswnote.moudle.income.action;

import com.wxx.pswnote.bean.SpendBean;

import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/18 12:15.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public interface InComeModel {
    void loadSpendList(loadListener listener);

    interface loadListener {
        void loadSpendList(List<SpendBean> spendBeanList);

        void loadFail();
    }
}
