package com.wxx.pswnote.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.wxx.pswnote.R;
import com.wxx.pswnote.ui.fragment.AccountFragment;
import com.wxx.pswnote.ui.fragment.CapitalFragment;
import com.wxx.pswnote.ui.fragment.MoreFragment;
import com.wxx.pswnote.ui.fragment.ReportFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    @InjectView(R.id.content_parent_layout)
    FrameLayout contentParentLayout;
    @InjectView(R.id.navigationBar)
    BottomNavigationBar navigationBar;

    private AccountFragment accountFragment;
    private MoreFragment moreFragment;
    private ReportFragment reportFragment;
    private CapitalFragment capitalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        intView();

    }

    private void intView() {

        navigationBar.setAutoHideEnabled(true);
        navigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        navigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
        navigationBar.setActiveColor(R.color.colorSelected);
        navigationBar.setInActiveColor(R.color.colorInselect);

        //标记
        BadgeItem badge = new BadgeItem().setText("2")
                .setBorderColor(R.color.colorPrimary)
                .setBorderWidth(2);

        //Tabs
        BottomNavigationItem accountItem = new BottomNavigationItem(R.mipmap.ico_account, "记账");
        BottomNavigationItem reprotItem = new BottomNavigationItem(R.mipmap.icon_report, "报表");
        BottomNavigationItem capitalItem = new BottomNavigationItem(R.mipmap.icon_capital, "资金");
        BottomNavigationItem moreItem = new BottomNavigationItem(R.mipmap.icon_more, "更多");


        navigationBar.addItem(accountItem).addItem(reprotItem).addItem(capitalItem).addItem(moreItem);
        navigationBar.setFirstSelectedPosition(0);
        navigationBar.initialise();
        navigationBar.setTabSelectedListener(this);
        setDefaultFrag();

    }

    private void setDefaultFrag() {
        if (accountFragment == null)
            accountFragment = new AccountFragment();
        addFrag(accountFragment);
        getSupportFragmentManager().beginTransaction().show(accountFragment).commit();
    }

    private void addFrag(Fragment frag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (frag != null && !frag.isAdded())
            transaction.add(R.id.content_parent_layout, frag);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        hideAllFrag();
        switch (position) {
            case 0:
                if (accountFragment == null)
                    accountFragment = new AccountFragment();
                addFrag(accountFragment);
                getSupportFragmentManager().beginTransaction().show(accountFragment).commit();
                break;
            case 1:
                if (reportFragment == null)
                    reportFragment = new ReportFragment();
                addFrag(reportFragment);
                getSupportFragmentManager().beginTransaction().show(reportFragment).commit();
                break;
            case 2:
                if (capitalFragment == null)
                    capitalFragment = new CapitalFragment();
                addFrag(capitalFragment);
                getSupportFragmentManager().beginTransaction().show(capitalFragment).commit();
                break;
            case 3:
                if (moreFragment == null)
                    moreFragment = new MoreFragment();
                addFrag(moreFragment);
                getSupportFragmentManager().beginTransaction().show(moreFragment).commit();
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    private void hideAllFrag() {
        hideFrag(accountFragment);
        hideFrag(reportFragment);
        hideFrag(capitalFragment);
        hideFrag(moreFragment);
    }

    private void hideFrag(Fragment frag) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        if (frag != null && frag.isAdded())
            t.hide(frag);
        t.commit();
    }


}
