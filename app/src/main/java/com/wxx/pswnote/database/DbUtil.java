package com.wxx.pswnote.database;
 /*
******************* Copyright (c) ***********************\
**
**         (c) Copyright  2016 , 唐人
**                  All Rights Reserved
**
**                    By(唐人)
**                www.wuxinxi.github.io
**
**                       _oo0oo_
**                      o8888888o
**                      88" . "88
**                      (| -_- |)
**                      0\  =  /0
**                    ___/`---'\___
**                  .' \\|     |// '.
**                 / \\|||  :  |||// \
**                / _||||| -:- |||||- \
**               |   | \\\  -  /// |   |
**               | \_|  ''\---/''  |_/ |
**               \  .-\__  '-'  ___/-. /
**             ___'. .'  /--.--\  `. .'___
**          ."" '<  `.___\_<|>_/___.' >' "".
**         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
**         \  \ `_.   \_ __\ /__ _/   .-` /  /
**     =====`-.____`.___ \_____/___.-`___.-'=====
**                       `=---='
**
**
**     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
**
**               佛祖保佑         永无BUG
**
**
**                   南无本师释迦牟尼佛
**

**----------------------类信息------------------------
** 版    本: V0.1
**
**Created by Tangren on 2016/12/20 0020.
**Email:wu_tangren@163.com
**TODO:获取表 Helper 的工具类
**
******************* End of Head **********************\
 */


import com.wxx.pswnote.dao.SpendDao;
import com.wxx.pswnote.database.table.bill.SpendHelper;

public class DbUtil {
    private static SpendHelper spendHelper;

    private static SpendDao getDriverDao() {
        return DBCore.getDaoSession().getSpendDao();
    }

    public static SpendHelper getDriverSpendHelper() {
        if (spendHelper == null)
            spendHelper = new SpendHelper(getDriverDao());
        return spendHelper;
    }


}
