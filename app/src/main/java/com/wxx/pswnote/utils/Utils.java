package com.wxx.pswnote.utils;

import android.widget.LinearLayout;

import com.wxx.pswnote.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：Tangren_ on 2016/12/21 0021.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class Utils {

    private static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Date date = new Date();

    private static final int[] colors = {R.color.canyin, R.color.yanjiucha, R.color.jiaotong,
            R.color.gouwu, R.color.yule, R.color.touzikunsun, R.color.huafei, R.color.zhufang,
            R.color.shuidianmei, R.color.shuiguo, R.color.lingshi, R.color.fuzhuang, R.color.hongbao,
            R.color.mrmf, R.color.shufai, R.color.hufupin, R.color.dianying, R.color.yiyao,
            R.color.jianshen, R.color.jiaoshui, R.color.jiaoyu, R.color.jiudian, R.color.lvyou,
            R.color.weixiu, R.color.qita};

    public static int[] images = {R.mipmap.icon_canyin, R.mipmap.ic_yanjiucha, R.mipmap.ic_jiaotong,
            R.mipmap.ic_gouwu, R.mipmap.ic_yule, R.mipmap.ic_kuisun, R.mipmap.ic_huafei,
            R.mipmap.ic_zhufang, R.mipmap.ic_shuidianmei, R.mipmap.ic_shuiguo, R.mipmap.ic_lingshi,
            R.mipmap.ic_yifu, R.mipmap.ic_hongbao, R.mipmap.ic_mrmf, R.mipmap.ic_shucai, R.mipmap.ic_hufu,
            R.mipmap.ic_dianying, R.mipmap.ic_yiyao, R.mipmap.ic_jianshen,
            R.mipmap.ic_jiaoshui, R.mipmap.ic_jiaoyu, R.mipmap.ic_jiudian, R.mipmap.ic_lvxing, R.mipmap.ic_weixiu, R.mipmap.ic_qita};

    public static String[] name = {"餐饮", "烟酒茶", "交通", "购物", "娱乐", "投资亏损", "话费",
            "住房", "水电煤", "水果", "零食", "服饰", "红包", "美容美发", "蔬菜", "护肤品", "电影", "医药", "健身", "交税", "教育", "酒店", "旅游", "维修", "其他"};


    public static void setColor(LinearLayout linearLayout, int postion) {
        linearLayout.setBackgroundResource(colors[postion]);
    }

    public static String getDate() {
        return sdfDate.format(date);
    }

    public static String getTime() {
        return sdfTime.format(date);
    }
}
