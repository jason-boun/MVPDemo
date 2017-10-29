package com.allure.mvp.newmvp;

import android.app.ProgressDialog;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.allure.mvp.R;
import com.allure.mvp.base.BaseActivity;

/**
 * 作者：luomin
 * 邮箱：asddavid@163.com
 */

public class NewMVPLoginActivity extends BaseActivity<NewLoginPresenter, NewLoginModel> implements View.OnClickListener, LoginContract.View {

    private EditText editUserName;
    private EditText editPassWord;
    private AppCompatButton btnLogin;
    private AppCompatButton btnClear;

    private ProgressDialog progressDialog;

    @Override
    protected void initPresenter() {
        mPresenter.setViewAndModel(this, mModel);
    }

    @Override
    protected void initListener() {
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("登录中,请稍后");
        progressDialog.setCancelable(false);

        editUserName = (EditText) findViewById(R.id.edit_account);
        editPassWord = (EditText) findViewById(R.id.edit_pwd);
        btnLogin = (AppCompatButton) findViewById(R.id.btn_login);
        btnClear = (AppCompatButton) findViewById(R.id.btn_clear);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void success() {
        Toast.makeText(NewMVPLoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void failed() {
        Toast.makeText(NewMVPLoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void clear() {
        editUserName.setText("");
        editPassWord.setText("");

    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mPresenter.rxLogin(editUserName.getText().toString(), editPassWord.getText().toString());
//                mPresenter.login(editUserName.getText().toString(), editPassWord.getText().toString());
                break;
            case R.id.btn_clear:
                mPresenter.clear();
                break;
        }
    }
}
