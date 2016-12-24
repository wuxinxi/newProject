package com.wxx.pswnote.moudle.account.action;

import com.wxx.pswnote.bean.Spend;

import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/24 0024.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public interface IAccountModel {
    void loadSpendList(loadListener listener);

    interface loadListener {
        void loadSpendList(List<Spend> spends);

        void loadFail();
    }
}
