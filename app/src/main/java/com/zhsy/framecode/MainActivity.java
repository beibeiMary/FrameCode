package com.zhsy.framecode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.zhsy.framecode.base.BaseFragment;
import com.zhsy.framecode.fragment.CommonFrameFragment;
import com.zhsy.framecode.fragment.CustomFragment;
import com.zhsy.framecode.fragment.OtherFragment;
import com.zhsy.framecode.fragment.ThridPartyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Xiaobei Zhang on 2018/11/20 0020 16:23
 * <p>
 * 邮箱：languobeibei@163.com
 * 主页面
 */
public class MainActivity extends FragmentActivity{
    private RadioGroup radioGroup;
    private List<BaseFragment> mBaseFragment;

    /**
     *选择的Fragment对应的位置
     */
    private int position;

    /**
     *
     * 上次切换的fragment
     */
    private Fragment mContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       initview();
       initFragment();
       setListener();
    }

    private void setListener() {
        radioGroup.setOnCheckedChangeListener(new MyOncheckedChangeListener());
        radioGroup.check(R.id.rb_common_frame);
    }
    class MyOncheckedChangeListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                case R.id.rb_common_frame:
                    position = 0;
                    break;
                case R.id.rb_another_frame:
                    position = 1;
                    break;
                case R.id.rb_byself_frame:
                    position = 2;
                    break;
                case R.id.rb_other_frame:
                    position = 3;
                    break;
                    default:
                        position = 0;
                        break;
            }
            BaseFragment fragment = getFragment(position);
//            switchFragment(fragment);
            switchFragment(mContent,fragment);
        }
    }

//    private void switchFragment(BaseFragment fragment) {
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction transaction =fm.beginTransaction();
//        transaction.replace(R.id.fl_content,fragment);
//        transaction.commit();
//    }

    /**
     * 避免来回重新创建fragment
     * @param fromfragment 刚显示的fragment，马上要隐藏
     * @param toFragment  马上要切换到的fragment
     */
    private void switchFragment(Fragment fromfragment, Fragment toFragment) {
       if (fromfragment!=toFragment){
            mContent = toFragment;
           FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (!toFragment.isAdded()){
                //tofragment没有被添加，fromfragment隐藏，添加tofragment
                if (fromfragment!=null){
                    ft.hide(fromfragment);
                }
                if (toFragment!=null){
                    ft.add(R.id.fl_content,toFragment).commit();
                }
            }else {
                //tofragment已经被添加，fromfragment隐藏，显示tofragment
                if (fromfragment!=null){
                    ft.hide(fromfragment);
                }
                if (toFragment!=null){
                    ft.show(toFragment).commit();
                }
            }
       }
    }
    /**
     * 根据位置得到对应的Fragment
     * @param position
     * @return
     */
    private BaseFragment getFragment(int position) {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }

    private void initview() {
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.rg_main);

    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new CommonFrameFragment());
        mBaseFragment.add(new ThridPartyFragment());
        mBaseFragment.add(new CustomFragment());
        mBaseFragment.add(new OtherFragment());
    }
}
