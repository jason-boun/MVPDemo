package com.allure.mvp.newmvp;

import com.allure.mvp.base.BaseModel;
import com.allure.mvp.base.BasePresenter;
import com.allure.mvp.base.BaseView;
import com.allure.mvp.model.UserLoginListener;

import rx.Observable;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class LoginContract {

    interface Model extends BaseModel {
        void login(String userName, String passWord, UserLoginListener userLoginListener);
        Observable<String> rxLogin(String userName,String passWord);
    }

    interface View extends BaseView {
        void success();

        void failed();

        void clear();
    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        abstract void login(String userName, String passWord);
        abstract  void rxLogin(String userName, String passWord);
        abstract void clear();
    }
}
