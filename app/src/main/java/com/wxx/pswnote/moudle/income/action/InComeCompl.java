package com.wxx.pswnote.moudle.income.action;

import com.wxx.pswnote.R;
import com.wxx.pswnote.bean.SpendBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/18 12:20.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class InComeCompl implements InComeModel {
    private static final String TAG = "SpendCompl";

    private static int[] images = {R.mipmap.ic_in_gongzi, R.mipmap.ic_in_jiangjin, R.mipmap.ic_in_fuli,
            R.mipmap.ic_in_touzi, R.mipmap.ic_in_jianzhi, R.mipmap.ic_in_shenghuofei,
            R.mipmap.ic_in_baoxiao, R.mipmap.ic_in_tuikuan, R.mipmap.ic_in_lijin,
            R.mipmap.ic_in_zhuanqian, R.mipmap.ic_hongbao, R.mipmap.ic_in_daikuan,
            R.mipmap.ic_in_yiwaishouru, R.mipmap.ic_in_zujin, R.mipmap.ic_in_zhongjiang,
            R.mipmap.ic_in_lixi, R.mipmap.ic_in_fenhong};

    private static String[] name = {"工资", "奖金", "福利", "投资盈利", "兼职", "生活费", "报销",
            "退款", "礼金", "赚钱", "领红包", "贷款", "意外收入", "租金", "中奖", "利息", "分红"};

    @Override
    public void loadSpendList(loadListener listener) {
        List<SpendBean> list = new ArrayList<SpendBean>();
        for (int i = 0; i < images.length; i++) {
            SpendBean bean = new SpendBean(images[i], name[i]);
            list.add(bean);
        }
        SpendBean b = new SpendBean(R.mipmap.icon_add, "添加");
        list.add(list.size(), b);

        listener.loadSpendList(list);
    }
}
