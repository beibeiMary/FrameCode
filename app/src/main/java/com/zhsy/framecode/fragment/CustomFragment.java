package com.zhsy.framecode.fragment;

import android.view.View;
import android.widget.ListView;

import com.zhsy.framecode.R;
import com.zhsy.framecode.base.BaseFragment;

/**
 * 作者：Xiaobei Zhang on 2018/11/21 0021 10:55
 * <p>
 * 邮箱：languobeibei@163.com
 * 自定义Fragment
 */
public class CustomFragment extends BaseFragment {
    private static final String TAG = CustomFragment.class.getSimpleName();
    private ListView listview;
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_custom,null);
        listview = view.findViewById(R.id.listview);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();

    }
}
