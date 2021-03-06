package com.wxx.pswnote.utils;

import android.widget.LinearLayout;

import com.wxx.pswnote.R;
import com.wxx.pswnote.bean.Spend;
import com.wxx.pswnote.database.DbUtil;
import com.wxx.pswnote.database.table.bill.SpendHelper;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/21 0021.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class Utils {

    private static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    private static SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
    private static SimpleDateFormat sdfDay = new SimpleDateFormat("dd");

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


    public static int[] inComeImages = {R.mipmap.ic_in_gongzi, R.mipmap.ic_in_jiangjin, R.mipmap.ic_in_fuli,
            R.mipmap.ic_in_touzi, R.mipmap.ic_in_jianzhi, R.mipmap.ic_in_shenghuofei,
            R.mipmap.ic_in_baoxiao, R.mipmap.ic_in_tuikuan, R.mipmap.ic_in_lijin,
            R.mipmap.ic_in_zhuanqian, R.mipmap.ic_hongbao, R.mipmap.ic_in_daikuan,
            R.mipmap.ic_in_yiwaishouru, R.mipmap.ic_in_zujin, R.mipmap.ic_in_zhongjiang,
            R.mipmap.ic_in_lixi, R.mipmap.ic_in_fenhong};

    public static String[] iComeName = {"工资", "奖金", "福利", "投资盈利", "兼职", "生活费", "报销",
            "退款", "礼金", "赚钱", "领红包", "贷款", "意外收入", "租金", "中奖", "利息", "分红"};


    public static void setColor(LinearLayout linearLayout, int postion) {
        linearLayout.setBackgroundResource(colors[postion]);
    }

    public static String getDate() {
        return sdfDate.format(date);
    }

    public static String getTime() {
        return sdfTime.format(date);
    }

    //得到年份
    public static int getYear(String date) {
        String dateString = null;
        try {
            Date d = sdfDate.parse(date);
            dateString = sdfYear.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(dateString);
    }

    //    //得到月份
    public static int getMonth(String date) {
        String dateString = null;
        try {
            Date d = sdfDate.parse(date);
            dateString = sdfMonth.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(dateString);

    }

    //得到那一天
    public static int getDay(String date) {
        String dateString = null;
        try {
            Date d = sdfDate.parse(date);
            dateString = sdfDay.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(dateString);
    }

    private static DecimalFormat format = new DecimalFormat("#00");

    public static String checkDay(int day) {
        return format.format(day);
    }

    private static SpendHelper helper = DbUtil.getDriverSpendHelper();
    private static List<Spend> list = new ArrayList<Spend>();


}
