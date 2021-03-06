package com.wxx.pswnote.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.socks.library.KLog;
import com.wxx.pswnote.R;
import com.wxx.pswnote.adapter.SpendAdapter;
import com.wxx.pswnote.base.BaseFragment;
import com.wxx.pswnote.bean.Spend;
import com.wxx.pswnote.bean.SpendBean;
import com.wxx.pswnote.control.KeyBoardPopupWindow;
import com.wxx.pswnote.database.DbUtil;
import com.wxx.pswnote.database.table.bill.SpendHelper;
import com.wxx.pswnote.listener.CustomClickListener;
import com.wxx.pswnote.moudle.income.presenter.InComePresenter;
import com.wxx.pswnote.moudle.income.view.InComeList;
import com.wxx.pswnote.utils.Utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static android.app.Activity.RESULT_OK;

/**
 * 作者：Tangren_ on 2016/12/18 10:06.
 * 邮箱：wu_tangren@163.com
 * TODO:收入
 */

public class InComeFragment extends BaseFragment<InComeList, InComePresenter> implements InComeList,
        CustomClickListener, GestureDetector.OnGestureListener {
    @InjectView(R.id.money_type)
    TextView moneyType;
    @InjectView(R.id.money_text)
    TextView moneyText;
    @InjectView(R.id.money_layout)
    LinearLayout moneyLayout;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    private View rootView;

    private SpendAdapter mAdapter;
    private List<SpendBean> list = new ArrayList<SpendBean>();
    private KeyBoardPopupWindow popupWindow;
    private static final String TAG = "InComeFragment";
    private GestureDetector detector;
    private StringBuffer stringBuffer = new StringBuffer();
    private View parent;
    private String TYPE = "工资";//默认为工资
    private int postion = 0;//默认工资0

    private SpendHelper spendHelper;

    private String date;

    public InComeFragment(String date) {
        this.date = date;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_income, null);
            ButterKnife.inject(this, rootView);
            initView();
        }

        ViewGroup group = (ViewGroup) rootView.getParent();
        if (group != null)
            group.removeView(rootView);
        return rootView;
    }

    private void initView() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 5);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        mPresneter.fetchList();

        detector = new GestureDetector(getActivity(), this);//手势监听

        popupWindow = new KeyBoardPopupWindow(getActivity(), clickListener);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detector.onTouchEvent(event);
            }
        });

        //监听滑动
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                             @Override
                                             public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                                 super.onScrolled(recyclerView, dx, dy);
                                                 if (popupWindow.isShowing())
                                                     popupWindow.dismiss();
                                             }
                                         }

        );

        spendHelper = DbUtil.getDriverSpendHelper();
    }


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.num_0:
                    input("0");
                    break;
                case R.id.num_1:
                    input("1");
                    break;
                case R.id.num_2:
                    input("2");
                    break;
                case R.id.num_3:
                    input("3");
                    break;
                case R.id.num_4:
                    input("4");
                    break;
                case R.id.num_5:
                    input("5");
                    break;
                case R.id.num_6:
                    input("6");
                    break;
                case R.id.num_7:
                    input("7");
                    break;
                case R.id.num_8:
                    input("8");
                    break;
                case R.id.num_9:
                    input("9");
                    break;
                case R.id.jia:
                    input("+");
                    break;
                case R.id.jian:
                    input("-");
                    break;
                case R.id.num_del:
                    delNum();
                    break;
                case R.id.ok:
                    popupWindow.dismiss();
                    stringBuffer = new StringBuffer(moneyText.getText().toString());
                    if (stringBuffer.toString().endsWith("+") || stringBuffer.toString().endsWith("-")) {
                        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    }
                    jisuan();
                    moneyText.setText(stringBuffer);

                    //保存并退出
//                    Long id, int icon, String spendmoney, String incomemoney,
//                        String spendtype, String incometype, String time, String date
                    Spend spend = new Spend(null, Utils.inComeImages[postion], null, stringBuffer.toString(), null, TYPE, Utils.getTime(), date);
                    spendHelper.save(spend);
                    KLog.d(spend.toString());
                    getActivity().setResult(RESULT_OK, new Intent());
                    getActivity().finish();
                    getActivity().overridePendingTransition(0, R.anim.base_slide_right_out);
                    break;
            }

        }
    };

    private void jisuan() {
        BigDecimal number = null;
        calculateProcess("[\\+\\-]");
    }


    private void calculateProcess(String reg) {
        String content = moneyText.getText().toString();
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(stringBuffer);
        int i = 0;
        while (matcher.find()) {
            String fuhao = matcher.group();
            int index = matcher.end();
            ArrayList<Integer> arrayList = getyunfuNumber(index);
            BigDecimal bigDecimal = getResult(arrayList);
            stringBuffer.replace(arrayList.get(0), arrayList.get(3),
                    bigDecimal.toString());
            matcher = pattern.matcher(stringBuffer);
        }
    }

    private ArrayList<Integer> getyunfuNumber(int index) {
        ArrayList<Integer> postion = new ArrayList<Integer>();
        int start = 0;
        int end = 0;
        String pre_content = stringBuffer.toString().substring(0, index - 1);
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(pre_content);
        while (matcher.find()) {
            String fuhao = matcher.group();
            end = matcher.end();
            start = matcher.start();
        }
        postion.add(start);
        postion.add(end);
        String after_content = stringBuffer.toString().substring(index,
                stringBuffer.length());
        matcher = pattern.matcher(after_content);
        if (matcher.find()) {
            String fuhao = matcher.group();
            end = matcher.end();
            start = matcher.start();
            postion.add(start + index);
            postion.add(end + index);
        }
        return postion;

    }

    private BigDecimal getResult(ArrayList<Integer> array) {
        BigDecimal decimal = null;
        String first = stringBuffer.substring(array.get(0), array.get(1));
        String second = stringBuffer.substring(array.get(2), array.get(3));
        String fuhao = stringBuffer.substring(array.get(1), array.get(2));
        BigDecimal number1 = new BigDecimal(first);
        BigDecimal number2 = new BigDecimal(second);
        KLog.d(number1 + "-------number1----------");
        KLog.d(number2 + "---------number2--------");
        if ("+".equals(fuhao)) {
            decimal = number1.add(number2);
        } else if ("-".equals(fuhao)) {
            decimal = number1.subtract(number2);
            if (decimal.doubleValue() < 0) {
                Toast.makeText(getActivity(), "不能为负数！", Toast.LENGTH_SHORT).show();
                return new BigDecimal("0");
            }
        }

        return decimal;
    }


    private void input(String num) {
        String result = moneyText.getText().toString().trim() + num;
        Log.d(TAG, result);
        if (moneyText.getText().toString().trim().length() == 0) {
            if (num.equals("0") || num.equals("-") || num.equals("+"))
                return;
        } else if (moneyText.getText().toString().trim().contains(".") && num.equals(".")) {
            return;
        } else if (check(moneyText.getText().toString().trim(), num.toCharArray())) {
            return;
        } else if (moneyText.getText().toString().trim().equals("0")) {
            if (num.equals("-") || num.equals("+"))
                return;
            moneyText.setText(num);
            return;
        }
        moneyText.setText(result);
    }

    private static boolean check(String str, char[] ch) {
        if (str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-') {
            if (ch[0] == '+' || ch[0] == '-') {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    private void delNum() {
        String result = moneyText.getText().toString();
        if (result.equals(""))
            return;
        result = result.substring(0, result.length() - 1);
        moneyText.setText(result);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    protected InComePresenter createPresenter() {
        return new InComePresenter(this);
    }

    @Override
    public void showList(List<SpendBean> spendBeanList) {
        this.list = spendBeanList;
        mAdapter = new SpendAdapter(getActivity(), spendBeanList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setClick(this);
    }

    @Override
    public void showFail() {

    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }


    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //向上的手势
        if (distanceY > 0) {
            if (popupWindow.isShowing())
                popupWindow.dismiss();
        } else {
            if (popupWindow.isShowing())
                popupWindow.dismiss();
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public void onItemClick(View view, int postion) {
        if (postion == mAdapter.getItemCount() - 1)
            return;
        Utils.setColor(moneyLayout, postion);
        moneyType.setText(list.get(postion).getType());
        if (parent == null)
            parent = ((ViewGroup) getActivity().findViewById(R.id.recyclerView)).getChildAt(0);
        popupWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        TYPE = list.get(postion).getType();
        this.postion = postion;
    }

    @Override
    public void onTypeClick(View view, int postion) {

    }
}
