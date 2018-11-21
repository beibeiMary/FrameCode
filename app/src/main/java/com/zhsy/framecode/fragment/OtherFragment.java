package com.zhsy.framecode.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.zhsy.framecode.base.BaseFragment;

/**
 * 作者：Xiaobei Zhang on 2018/11/21 0021 10:55
 * <p>
 * 邮箱：languobeibei@163.com
 * 其他Fragment
 */
public class OtherFragment extends BaseFragment {
    private static final String TAG = OtherFragment.class.getSimpleName();
    private TextView textView;
    @Override
    protected View initView() {
        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLUE);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        textView.setText("其他页面");
    }
}
