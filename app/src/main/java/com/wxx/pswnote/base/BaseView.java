package com.wxx.pswnote.base;

/**
 * Created by Tangren on 2016/12/6 0006
 * Email:wu_tangren@163.com
 * TODO:用一句话概括
 */

public interface BaseView {
    void showLoading();

    void dismissLoading();

    BasePresenter getPresenter();
}
