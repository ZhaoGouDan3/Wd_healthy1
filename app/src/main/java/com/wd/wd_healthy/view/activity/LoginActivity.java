package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityLoginBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.LoginBean;
import com.wd.wd_healthy.model.util.RsaCoder;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.viewModel.KongViewModel;

import java.util.List;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.callback.RequestCallback;
import cn.jpush.im.android.api.model.DeviceInfo;
import cn.jpush.im.api.BasicCallback;

public class LoginActivity extends BaseActivity<KongViewModel, ActivityLoginBinding>{
    private boolean ishide=false;
    @Override
    public int initlayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initData() {
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s = RsaCoder.encryptByPublicKey(binding.pwd.getText().toString());
                    viewModel.getLiveData(binding.email.getText().toString(),s).observe(LoginActivity.this,LoginActivity.this);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        binding.wjmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,LosePwdActivity.class));
            }
        });
        binding.pwdhide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ishide) {
                    //设置EditText文本为可见的
                    binding.pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    Toast.makeText(LoginActivity.this, "显示", Toast.LENGTH_SHORT).show();
                } else {
                    //设置EditText文本为隐藏的
                    binding.pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    Toast.makeText(LoginActivity.this, "隐藏", Toast.LENGTH_SHORT).show();
                }
                ishide = !ishide;
                binding.pwd.postInvalidate();
                //切换后将EditText光标置于末尾
                CharSequence charSequence =  binding.pwd.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
            }
        });
        binding.ljzc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof LoginBean){
            LoginBean loginBean= (LoginBean) o;
            if(loginBean.getStatus().equals("0000")){
                SpUtils.putString("userId",loginBean.getResult().getUserId()+"");
                SpUtils.putString("sessionId",loginBean.getResult().getSessionId());
                SpUtils.putString("tx",loginBean.getResult().getHeadPic());
                SpUtils.putString("nickname",loginBean.getResult().getNickName());
                SpUtils.putString("email",loginBean.getResult().getEmail());
                SpUtils.putInt("sexy",loginBean.getResult().getSex());
                SpUtils.putInt("height",loginBean.getResult().getHeight());
                SpUtils.putInt("weight",loginBean.getResult().getWeight());
                SpUtils.putInt("age",loginBean.getResult().getAge());
                SpUtils.putString("userName",loginBean.getResult().getUserName()+"");
                SpUtils.putBoolean("login",true);
                Log.v("userName",loginBean.getResult().getUserName());
                try {
                    String s1 = RsaCoder.MD5(RsaCoder.decryptByPublicKey(loginBean.getResult().getJiGuangPwd()));
                    JMessageClient.login(loginBean.getResult().getUserName(), s1, new RequestCallback<List<DeviceInfo>>() {
                        @Override
                        public void gotResult(int i, String s, List<DeviceInfo> deviceInfos) {
                            if(i==0){
                                Toast.makeText(LoginActivity.this, "极光登录成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(LoginActivity.this, "极光登录失败", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}