package com.wxx.pswnote.moudle.account.action;

import com.socks.library.KLog;
import com.wxx.pswnote.database.DbUtil;
import com.wxx.pswnote.database.table.bill.SpendHelper;

/**
 * 作者：Tangren_ on 2016/12/24 0024.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class AccountCompl implements IAccountModel {

    @Override
    public void loadSpendList(loadListener listener) {
        SpendHelper helper = DbUtil.getDriverSpendHelper();
        listener.loadSpendList(helper.queryAll());
        KLog.d(helper.queryAll().toString());
    }
}
