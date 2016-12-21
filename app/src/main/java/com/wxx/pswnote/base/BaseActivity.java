package com.wxx.pswnote.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.wxx.pswnote.R;

/**
 * Created by Tangren on 2016/12/6 0006
 * Email:wu_tangren@163.com
 * TODO:用一句话概括
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mPresneter;

    protected abstract T createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          /*创建Presenter*/
        mPresneter = createPresenter();

        /*内存泄漏 ， 关联View*/
        mPresneter.attachView((V) this);
    }


    public void showLoading() {
//        mPbLoading.show();
        Toast.makeText(this, "正在请求……", Toast.LENGTH_SHORT).show();
    }

    public void dismissLoading() {
        Toast.makeText(this, "请求结束……", Toast.LENGTH_SHORT).show();
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
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }

    protected void statActivityFromRight(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }

    protected void finishFromRight() {
        finish();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }


}
