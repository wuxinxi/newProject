package com.wxx.pswnote.moudle.sepend.view;

import com.wxx.pswnote.bean.SpendBean;

import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/18 12:11.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public interface ISpendList {
    void showList(List<SpendBean> spendBeanList);

    void showFail();
}
