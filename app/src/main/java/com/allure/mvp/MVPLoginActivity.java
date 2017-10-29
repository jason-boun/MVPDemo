package com.allure.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.allure.mvp.presenter.LoginPresenter;

public class MVPLoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private EditText editUserName;
    private EditText editPassWord;
    private AppCompatButton btnLogin;
    private AppCompatButton btnClear;

    private ProgressDialog progressDialog;
    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initListener() {
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    private void initView() {
        loginPresenter = new LoginPresenter(this, this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("登录中,请稍后");
        progressDialog.setCancelable(false);

        editUserName = (EditText) findViewById(R.id.edit_account);
        editPassWord = (EditText) findViewById(R.id.edit_pwd);
        btnLogin = (AppCompatButton) findViewById(R.id.btn_login);
        btnClear = (AppCompatButton) findViewById(R.id.btn_clear);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                loginPresenter.login(editUserName.getText().toString(), editPassWord.getText().toString());
                break;
            case R.id.btn_clear:
//                editUserName.setText("");
//                editPassWord.setText("");
                loginPresenter.clear();

                break;
        }
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
    public void success() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failed() {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void clear() {
        editUserName.setText("");
        editPassWord.setText("");
    }
}
