package com.wxx.pswnote.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.dsw.calendar.component.MonthView;
import com.dsw.calendar.entity.CalendarInfo;
import com.dsw.calendar.views.ADCircleCalendarView;
import com.wxx.pswnote.R;
import com.wxx.pswnote.bean.Spend;
import com.wxx.pswnote.database.DbUtil;
import com.wxx.pswnote.database.table.bill.SpendHelper;
import com.wxx.pswnote.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Tangren_ on 2016/12/29 0029.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class DateChoseActivity extends AppCompatActivity {

    @InjectView(R.id.circleMonthView)
    ADCircleCalendarView circleMonthView;
    @InjectView(R.id.mtoolbar)
    Toolbar mtoolbar;
    @InjectView(R.id.add)
    LinearLayout add;

    private SpendHelper mHepler;
    private String time = Utils.getDate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datechose);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        setTitle("");
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mHepler = DbUtil.getDriverSpendHelper();
        List<Spend> spenLists = new ArrayList<Spend>();
        List<CalendarInfo> list = new ArrayList<CalendarInfo>();
        spenLists = mHepler.queryAll();
        for (int i = 0; i < spenLists.size(); i++) {
            list.add(new CalendarInfo(Utils.getYear(spenLists.get(i).getDate()),
                    Utils.getMonth(spenLists.get(i).getDate()), Utils.getDay(spenLists.get(i).getDate()), "好心情哦"));
        }

        circleMonthView.setCalendarInfos(list);
        circleMonthView.setDateClick(new MonthView.IDateClick() {

            @Override
            public void onClickOnDate(int year, int month, int day) {
                time = year + "-" + Utils.checkDay(month) + "-" + Utils.checkDay(day);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(0, R.anim.base_slide_right_out);
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.add)
    public void onClick() {
        AddActivity.start(DateChoseActivity.this, time);
        finish();
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }
}
