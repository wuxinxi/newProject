package com.wxx.pswnote.moudle.sepend.action;

import com.wxx.pswnote.R;
import com.wxx.pswnote.bean.SpendBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/18 12:20.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class SpendCompl implements SpendModel {
    private static final String TAG = "SpendCompl";

    private static int[] images = {R.mipmap.icon_canyin, R.mipmap.ic_yanjiucha, R.mipmap.ic_jiaotong,
            R.mipmap.ic_gouwu, R.mipmap.ic_yule, R.mipmap.ic_kuisun, R.mipmap.ic_huafei,
            R.mipmap.ic_zhufang, R.mipmap.ic_shuidianmei, R.mipmap.ic_shuiguo, R.mipmap.ic_lingshi,
            R.mipmap.ic_yifu, R.mipmap.ic_hongbao, R.mipmap.ic_mrmf, R.mipmap.ic_shucai, R.mipmap.ic_hufu,
            R.mipmap.ic_dianying, R.mipmap.ic_yiyao, R.mipmap.ic_jianshen,
            R.mipmap.ic_jiaoshui, R.mipmap.ic_jiaoyu , R.mipmap.ic_jiudian, R.mipmap.ic_lvxing, R.mipmap.ic_weixiu, R.mipmap.ic_qita};

    private static String[] name = {"餐饮", "烟酒茶", "交通", "购物", "娱乐", "投资亏损", "话费",
            "住房", "水电煤", "水果", "零食", "服饰", "红包","美容美发", "蔬菜", "护肤品", "电影", "医药","健身","交税","教育","酒店","旅游","维修", "其他"};

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
