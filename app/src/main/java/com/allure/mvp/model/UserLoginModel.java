package com.allure.mvp.model;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */
public interface UserLoginModel {
     void login(String userName,String passWord,UserLoginListener userLoginListener);
}
