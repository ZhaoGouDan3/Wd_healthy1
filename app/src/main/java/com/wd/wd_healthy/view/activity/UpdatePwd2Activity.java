package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityUpdatePwd2Binding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.RsaCoder;
import com.wd.wd_healthy.viewModel.UpdatePwdViewModel2;

public class UpdatePwd2Activity extends BaseActivity<UpdatePwdViewModel2, ActivityUpdatePwd2Binding>{

    @Override
    public int initlayout() {
        return R.layout.activity_update_pwd2;
    }

    @Override
    public void initData() {
        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.pwd1.getText().toString().equals(binding.pwd2.getText().toString())){
                    try {
                        String s1 = RsaCoder.encryptByPublicKey(binding.ypwd.getText().toString());
                        String s = RsaCoder.encryptByPublicKey(binding.pwd1.getText().toString());
                        viewModel.getLiveData(s1,s).observe(UpdatePwd2Activity.this,UpdatePwd2Activity.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(UpdatePwd2Activity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof SendEmailBean){
            SendEmailBean bean= (SendEmailBean) o;
            if(bean.getMessage().equals("修改成功")){
                finish();
            }
        }
    }
}