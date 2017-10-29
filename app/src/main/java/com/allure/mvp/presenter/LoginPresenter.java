package com.allure.mvp.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.allure.mvp.LoginView;
import com.allure.mvp.model.UserLoginListener;
import com.allure.mvp.model.UserLoginModel;
import com.allure.mvp.model.UserLoginModelImpl;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class LoginPresenter {

    private LoginView mLoginView;
    private UserLoginModel userLoginModel;
    private Context mContext;

    public LoginPresenter(Context context,LoginView mLoginView) {
        this.mContext=context;
        this.mLoginView=mLoginView;
        userLoginModel=new UserLoginModelImpl();
    }

    public  void login(String userName,String passWord){
        if(TextUtils.isEmpty(userName)||TextUtils.isEmpty(passWord)){
            Toast.makeText(mContext,"请输入你的用户名与密码",Toast.LENGTH_SHORT).show();
        }else {
            mLoginView.showLoading();
            userLoginModel.login(userName, passWord, new UserLoginListener() {
                @Override
                public void loginSuccess() {
                    mLoginView.success();
                    mLoginView.hideLoading();
                }

                @Override
                public void loginFailed() {
                    mLoginView.failed();
                    mLoginView.hideLoading();

                }
            });
        }

    }

    public void clear() {
        mLoginView.clear();

    }
}
