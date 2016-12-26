package com.wxx.pswnote.moudle.income.action;

import com.wxx.pswnote.R;
import com.wxx.pswnote.bean.SpendBean;
import com.wxx.pswnote.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/18 12:20.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class InComeCompl implements InComeModel {
    private static final String TAG = "SpendCompl";

    @Override
    public void loadSpendList(loadListener listener) {
        List<SpendBean> list = new ArrayList<SpendBean>();
        for (int i = 0; i < Utils.inComeImages.length; i++) {
            SpendBean bean = new SpendBean(Utils.inComeImages[i], Utils.iComeName[i]);
            list.add(bean);
        }
        SpendBean b = new SpendBean(R.mipmap.icon_add, "添加");
        list.add(list.size(), b);

        listener.loadSpendList(list);
    }
}
