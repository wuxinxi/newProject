package com.wxx.pswnote.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wxx.pswnote.R;
import com.wxx.pswnote.customview.CircleImageView;
import com.wxx.pswnote.customview.ImageTextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Tangren_ on 2016/12/17 18:52.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class MoreFragment extends Fragment {
    @InjectView(R.id.imageHead)
    CircleImageView imageHead;
    @InjectView(R.id.userName)
    TextView userName;
    @InjectView(R.id.grade)
    TextView grade;
    @InjectView(R.id.net_sync)
    ImageTextView netSync;
    @InjectView(R.id.sign)
    ImageTextView sign;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.ct_layout)
    CollapsingToolbarLayout ctLayout;
    @InjectView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @InjectView(R.id.remind)
    TextView remind;
    @InjectView(R.id.theme)
    TextView theme;
    @InjectView(R.id.export)
    TextView export;
    @InjectView(R.id.share)
    TextView share;
    @InjectView(R.id.checkUpdate)
    TextView checkUpdate;
    @InjectView(R.id.advice)
    TextView advice;
    @InjectView(R.id.good)
    TextView good;
    @InjectView(R.id.setting)
    TextView setting;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_more, null);
            ButterKnife.inject(this, rootView);
            initView();
        }
        ViewGroup group = (ViewGroup) rootView.getParent();
        if (group != null)
            group.removeView(rootView);
        return rootView;
    }

    private void initView() {
        toolbar.setTitle("更多");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.imageHead, R.id.net_sync, R.id.sign, R.id.remind, R.id.theme, R.id.export,
            R.id.share, R.id.checkUpdate, R.id.advice, R.id.good, R.id.setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageHead:
                Toast.makeText(getActivity(), "imageHead", Toast.LENGTH_SHORT).show();
                break;
            case R.id.net_sync:
                Toast.makeText(getActivity(), "sync", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign:
                Toast.makeText(getActivity(), "sign", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remind:
                Toast.makeText(getActivity(), "remind", Toast.LENGTH_SHORT).show();
                break;
            case R.id.theme:
                Toast.makeText(getActivity(), "theme", Toast.LENGTH_SHORT).show();
                break;
            case R.id.export:
                break;
            case R.id.share:
                break;
            case R.id.checkUpdate:
                break;
            case R.id.advice:
                break;
            case R.id.good:
                break;
            case R.id.setting:
                break;
        }
    }
}
