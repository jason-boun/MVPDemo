package com.allure.mvp.newmvp;

import android.os.Handler;
import android.os.SystemClock;

import com.allure.mvp.model.UserLoginListener;

import rx.Observable;
import rx.Subscriber;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class NewLoginModel implements LoginContract.Model {
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

    @Override
    public Observable<String> rxLogin(final String userName, final String passWord) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                SystemClock.sleep(2000);
                if ("jike".equals(userName) && "123".equals(passWord)) {
                    subscriber.onNext("SUCCESS");
                    subscriber.onCompleted();
                } else {
                    subscriber.onNext("FAILED");
                    subscriber.onCompleted();
                }

            }
        });
    }


}
