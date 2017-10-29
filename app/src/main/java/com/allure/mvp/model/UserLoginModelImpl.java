package com.allure.mvp.model;

import android.os.Handler;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class UserLoginModelImpl implements UserLoginModel {
    @Override
    public void login(final String userName, final String passWord, final UserLoginListener userLoginListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if ("jike".equals(userName) && "123".equals(passWord)) {
                    userLoginListener.loginSuccess();

                } else {
                    userLoginListener.loginFailed();
                }
            }
        }, 2000);
    }
}
