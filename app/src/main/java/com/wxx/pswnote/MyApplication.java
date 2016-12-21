package com.wxx.pswnote;

import android.app.Application;

import com.socks.library.KLog;
import com.wxx.pswnote.database.DBCore;

/**
 * 作者：Tangren_ on 2016/12/16 23:45.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class MyApplication extends Application {

    public static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        DBCore.init(this);
        DBCore.enableQueryBuilderLog();//开启log
        KLog.init(BuildConfig.DEBUG);//开源库log

    }

    public synchronized static MyApplication getInstance() {
        if (instance == null)
            instance = new MyApplication();
        return instance;
    }
}
