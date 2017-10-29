package com.allure.mvp;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */
public interface LoginView {
    void showLoading();
    void hideLoading();
    void success();
    void failed();
    void clear();
}
