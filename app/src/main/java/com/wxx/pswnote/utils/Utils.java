package com.wxx.pswnote.utils;

import android.widget.LinearLayout;

import com.wxx.pswnote.R;

/**
 * 作者：Tangren_ on 2016/12/21 0021.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class Utils {

    private static final int[] colors = {R.color.canyin, R.color.yanjiucha, R.color.jiaotong,
            R.color.gouwu, R.color.yule, R.color.touzikunsun, R.color.huafei, R.color.zhufang,
            R.color.shuidianmei, R.color.shuiguo, R.color.lingshi, R.color.fuzhuang, R.color.hongbao,
            R.color.mrmf, R.color.shufai, R.color.hufupin, R.color.dianying, R.color.yiyao,
            R.color.jianshen, R.color.jiaoshui, R.color.jiaoyu, R.color.jiudian, R.color.lvyou,
            R.color.weixiu,R.color.qita};

    public static void setColor(LinearLayout linearLayout, int postion) {
        linearLayout.setBackgroundResource(colors[postion]);
    }
}
