package com.allure.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.allure.mvp.util.MVPUtil;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public abstract class BaseActivity<T extends BasePresenter,E extends BaseModel>  extends AppCompatActivity {

    public Context activity;
    public T mPresenter;
    public E mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        activity=this;
        mPresenter= MVPUtil.getT(this,0);
        mModel= MVPUtil.getT(this,1);

        if(null!=mPresenter){
            mPresenter.mContext=this;
        }
        initView();
        initListener();
        initPresenter();
    }

    protected abstract void initPresenter();

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract int initLayout();
}
