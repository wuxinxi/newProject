package com.wxx.pswnote.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.wxx.pswnote.R;
import com.wxx.pswnote.ui.fragment.InComeFragment;
import com.wxx.pswnote.ui.fragment.SpendFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Tangren_ on 2016/12/18 09:45.
 * 邮箱：wu_tangren@163.com
 * TODO:收入支出
 */

public class AddActivity extends AppCompatActivity {
    @InjectView(R.id.tabLayout)
    TabLayout tabLayout;
    @InjectView(R.id.viewPage)
    ViewPager viewPage;
    @InjectView(R.id.back)
    LinearLayout back;


    private String items[] = new String[]{"支出", "收入"};

    private static String KEY_DATE = "date";

    public static void start(Context context, String date) {
        Intent intent = new Intent(context, AddActivity.class);
        intent.putExtra(KEY_DATE, date);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {

        String date = getIntent().getStringExtra(KEY_DATE);
        viewPage.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new SpendFragment(date);
                } else {
                    return new InComeFragment(date);
                }


            }

            @Override
            public CharSequence getPageTitle(int position) {
                return items[position];
            }

            @Override
            public int getCount() {
                return items.length;
            }
        });
        tabLayout.setupWithViewPager(viewPage);
    }


    @OnClick(R.id.back)
    public void onClick() {
        finish();
    }
}
