package com.allure.mvp.newmvp;

import android.text.TextUtils;
import android.widget.Toast;

import com.allure.mvp.model.UserLoginListener;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class NewLoginPresenter extends LoginContract.Presenter {
    @Override
    void login(String userName, String passWord) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
            Toast.makeText(mContext, "请输入你的用户名和密码", Toast.LENGTH_SHORT).show();
        } else {
            mView.showLoading();
            mModel.login(userName, passWord, new UserLoginListener() {
                @Override
                public void loginSuccess() {
                    mView.success();
                    mView.hideLoading();
                }

                @Override
                public void loginFailed() {
                    mView.failed();
                    mView.hideLoading();
                }
            });
        }

    }

    @Override
    void rxLogin(String userName, String passWord) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
            Toast.makeText(mContext, "请输入你的用户名和密码", Toast.LENGTH_SHORT).show();
        } else {
            mView.showLoading();
           mModel.rxLogin(userName,passWord)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe(new Subscriber<String>() {
                       @Override
                       public void onCompleted() {
                           mView.hideLoading();
                       }

                       @Override
                       public void onError(Throwable e) {
                           mView.hideLoading();

                       }

                       @Override
                       public void onNext(String s) {
                           mView.hideLoading();
                           Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();


                       }
                   });
        }
    }


    @Override
    void clear() {
        mView.clear();
    }
}
