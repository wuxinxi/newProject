package com.wxx.pswnote.moudle.account.view;

import com.wxx.pswnote.base.BasePresenter;
import com.wxx.pswnote.base.BaseView;
import com.wxx.pswnote.bean.Spend;

import java.util.List;

/**
 * 作者：Tangren_ on 2016/12/24 0024.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public interface IAccountView extends BaseView {
    void showList(List<Spend> spends);

    void showFail();

    class General {
        private static IAccountView getDefault() {
            return new IAccountView() {
                @Override
                public void showList(List<Spend> spends) {

                }

                @Override
                public void showFail() {

                }

                @Override
                public void showLoading() {

                }

                @Override
                public void dismissLoading() {

                }

                @Override
                public BasePresenter getPresenter() {
                    return null;
                }
            };
        }
    }
}
