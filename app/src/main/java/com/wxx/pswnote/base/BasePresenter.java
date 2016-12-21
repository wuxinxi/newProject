package com.wxx.pswnote.base;

import java.lang.ref.WeakReference;

/**
 * Created by Tangren on 2016/12/6 0006
 * Email:wu_tangren@163.com
 * TODO:用一句话概括
 */

public abstract class BasePresenter<T> {

    protected WeakReference<T> mViewRef;

    public void attachView(T view) {

        mViewRef = new WeakReference<T>(view);
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
