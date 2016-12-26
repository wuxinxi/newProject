package com.wxx.pswnote.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.socks.library.KLog;

/**
 * Created by Tangren on 2016/12/6 0006
 * Email:wu_tangren@163.com
 * TODO:用一句话概括
 */

public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {

    protected T mPresneter;

    protected abstract T createPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresneter = createPresenter();
        mPresneter.attachView((V) this);
    }


    public void showLoading() {
//        mPbLoading.show();
        Toast.makeText(getActivity(), "正在请求……", Toast.LENGTH_SHORT).show();
    }

    public void dismissLoading() {
        Toast.makeText(getActivity(), "请求结束……", Toast.LENGTH_SHORT).show();
    }

    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresneter.detachView();
    }

    @Override
    public void onPause() {
        super.onPause();
        KLog.d("BaseFragment--onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        KLog.d("BaseFragment--onStop");
    }
}
