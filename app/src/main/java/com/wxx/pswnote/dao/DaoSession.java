package com.wxx.pswnote.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.wxx.pswnote.bean.Spend;

import com.wxx.pswnote.dao.SpendDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig spendDaoConfig;

    private final SpendDao spendDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        spendDaoConfig = daoConfigMap.get(SpendDao.class).clone();
        spendDaoConfig.initIdentityScope(type);

        spendDao = new SpendDao(spendDaoConfig, this);

        registerDao(Spend.class, spendDao);
    }
    
    public void clear() {
        spendDaoConfig.clearIdentityScope();
    }

    public SpendDao getSpendDao() {
        return spendDao;
    }

}
