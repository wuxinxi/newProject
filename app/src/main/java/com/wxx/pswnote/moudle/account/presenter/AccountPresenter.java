package com.wxx.pswnote.moudle.account.presenter;

import com.wxx.pswnote.base.BasePresenter;
import com.wxx.pswnote.bean.Spend;
import com.wxx.pswnote.moudle.account.action.AccountCompl;
import com.wxx.pswnote.moudle.account.action.IAccountModel;
import com.wxx.pswnote.moudle.account.view.IAccountView;

import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/24 0024.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class AccountPresenter extends BasePresenter<IAccountView> {

    private IAccountView view;
    private IAccountModel model = new AccountCompl();

    public AccountPresenter(IAccountView view) {
        this.view = view;
    }

    public void fetchSpendAccount() {
        if (model != null) {
            model.loadSpendList(new IAccountModel.loadListener() {
                @Override
                public void loadSpendList(List<Spend> spends) {
                    if (view != null) {
                        view.showList(spends);
                    }
                }

                @Override
                public void loadFail() {
                    view.showFail();
                }
            });
        }
    }
}
