package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.huawei.hms.mlplugin.card.icr.cn.MLCnIcrCapture;
import com.huawei.hms.mlplugin.card.icr.cn.MLCnIcrCaptureConfig;
import com.huawei.hms.mlplugin.card.icr.cn.MLCnIcrCaptureFactory;
import com.huawei.hms.mlplugin.card.icr.cn.MLCnIcrCaptureResult;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityRnaBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.RsaCoder;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.viewModel.RnaViewModel;

public class RnaActivity extends BaseActivity<RnaViewModel, ActivityRnaBinding>{
    private boolean flag=false;
    private String name;
    private String sex;
    private String nation;
    private String birthday;
    private String address;
    private String idNum1111;
    @Override
    public int initlayout() {
        return R.layout.activity_rna;
    }

    @Override
    public void initData() {
        binding.zm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=false;
                startCaptureActivity(idCallback,true);
            }
        });
        binding.fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                startCaptureActivity(idCallback,false);
            }
        });
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof SendEmailBean){
            SendEmailBean bean= (SendEmailBean) o;
            Toast.makeText(RnaActivity.this,bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void startCaptureActivity(MLCnIcrCapture.CallBack callback, boolean isFront) {
        MLCnIcrCaptureConfig config = new MLCnIcrCaptureConfig.Factory()
                // 设置识别身份证的正反面。
                // true：正面。
                // false：反面。
                .setFront(isFront)
                .create();
        MLCnIcrCapture icrCapture = MLCnIcrCaptureFactory.getInstance().getIcrCapture(config);
        icrCapture.capture(callback, this);
    }


    private MLCnIcrCapture.CallBack idCallback = new MLCnIcrCapture.CallBack() {



        @Override
        public void onSuccess(MLCnIcrCaptureResult idCardResult){
            // 识别成功处理。
            Toast.makeText(RnaActivity.this,"成功"+idCardResult.idNum, Toast.LENGTH_SHORT).show();
            try {
               if(!flag){
                   name = RsaCoder.encryptByPublicKey(idCardResult.name);
                   sex = RsaCoder.encryptByPublicKey(idCardResult.sex);
                   nation = RsaCoder.encryptByPublicKey(idCardResult.nation);
                   birthday = RsaCoder.encryptByPublicKey(idCardResult.birthday);
                   address = RsaCoder.encryptByPublicKey(idCardResult.address);
                   idNum1111 =idCardResult.idNum;
               }else{
                   String authority= RsaCoder.encryptByPublicKey(idCardResult.authority);
                   viewModel.getLiveData(Integer.parseInt(SpUtils.getString("userId")),name,sex,nation,birthday,address,RsaCoder.encryptByPublicKey(idNum1111),authority).observe(RnaActivity.this,RnaActivity.this);
               }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onCanceled(){
            // 用户取消处理。
            Toast.makeText(RnaActivity.this, "取消", Toast.LENGTH_SHORT).show();
        }
        // 识别不到任何文字信息或识别过程发生系统异常的回调方法。
        // retCode：错误码。
        // bitmap：检测失败的身份证图片。
        @Override
        public void onFailure(int retCode, Bitmap bitmap){
            // 识别异常处理。
        }
        @Override
        public void onDenied(){
            // 相机不支持等场景处理。
        }
    };
}