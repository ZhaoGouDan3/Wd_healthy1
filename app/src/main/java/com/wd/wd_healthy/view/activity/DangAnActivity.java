package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityCurrentBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.DangAnBean;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.viewModel.DangAnViewModel;
import com.wd.wd_healthy.viewModel.KongViewModel;

import android.app.DatePickerDialog.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class DangAnActivity extends BaseActivity<DangAnViewModel, ActivityCurrentBinding>{
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");

    private Calendar calendar;
    private TimePickerDialog timePickerDialog;
    int m_year = 2022;
    int m_month = 1;
    int m_day = 1;
    private String st="",et="";
    @Override
    public int initlayout() {
        return R.layout.activity_current;
    }

    @Override
    public void initData() {
        viewModel.getLiveData().observe(this,this);
        calendar=Calendar.getInstance();
        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DangAnActivity.this)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                viewModel.getLiveData1().observe(DangAnActivity.this,DangAnActivity.this);
                            }
                        })
                        .setTitle("警告")
                        .setMessage("请问是否需要删除档案？")
                        .show();
            }
        });
        binding.time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogTwo();
            }
        });
        binding.bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> map =new HashMap<>();
                map.put("diseaseMain",binding.zyzzed.getText().toString());
                map.put("diseaseNow",binding.xbsed.getText().toString());
                map.put("diseaseBefore",binding.jwbsed.getText().toString());
                map.put("treatmentHospitalRecent",binding.yymced.getText().toString());
                map.put("treatmentProcess",binding.zlgced.getText().toString());
                map.put("treatmentStartTime",st);
                map.put("treatmentEndTime",et);
                viewModel.getLiveData2(map).observe(DangAnActivity.this,DangAnActivity.this);
            }
        });
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof DangAnBean){
            DangAnBean bean= (DangAnBean) o;
            if(bean.getMessage().equals("档案为空，快去添加吧！")){
                binding.nda.setVisibility(View.VISIBLE);
                binding.yda.setVisibility(View.GONE);
                SpUtils.putInt("archivesId",0);
                binding.tj.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       visibleView();


                    }
                });
            }else if(!bean.getMessage().equals("请先登陆")){
                binding.nda.setVisibility(View.GONE);
                binding.yda.setVisibility(View.VISIBLE);
                binding.time.setVisibility(View.GONE);
                binding.bc.setVisibility(View.GONE);

                binding.zyzzed.setVisibility(View.GONE);
                binding.xbsed.setVisibility(View.GONE);
                binding.jwbsed.setVisibility(View.GONE);
                binding.yymced.setVisibility(View.GONE);
                binding.zlgced.setVisibility(View.GONE);
                binding.delete.setVisibility(View.VISIBLE);
                binding.bj.setVisibility(View.VISIBLE);
                binding.zyzz.setVisibility(View.VISIBLE);
                binding.xbs.setVisibility(View.VISIBLE);
                binding.jwbs.setVisibility(View.VISIBLE);
                binding.zljl.setVisibility(View.VISIBLE);
                binding.abimg.setText("[相关图片]");
                binding.zyzz.setText(bean.getResult().getDiseaseMain());
                binding.xbs.setText(bean.getResult().getDiseaseNow());
                binding.jwbs.setText(bean.getResult().getDiseaseBefore());
                binding.zljl.setText(bean.getResult().getTreatmentHospitalRecent()+"\t\t\t\t\t\t\t\t\t\t"+sdf.format(bean.getResult().getTreatmentStartTime())+"-"+sdf.format(bean.getResult().getTreatmentEndTime())+"\n\n"+bean.getResult().getTreatmentProcess());
                SpUtils.putInt("archivesId",bean.getResult().getId());
            }else{
                startActivity(new Intent(DangAnActivity.this,LoginActivity.class));
                Toast.makeText(DangAnActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                finish();
            }
        }else if(o instanceof SendEmailBean){
            SendEmailBean bean= (SendEmailBean) o;
            if(bean.getMessage().equals("删除成功")){
                binding.nda.setVisibility(View.VISIBLE);
                binding.tj.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        visibleView();
                    }
                });
                binding.yda.setVisibility(View.GONE);
            }else if(bean.getMessage().equals("档案添加成功")){
                viewModel.getLiveData().observe(this,this);
            }
        }
    }
    private void visibleView(){
        binding.nda.setVisibility(View.GONE);
        binding.yda.setVisibility(View.VISIBLE);
        binding.zyzz.setVisibility(View.GONE);
        binding.xbs.setVisibility(View.GONE);
        binding.jwbs.setVisibility(View.GONE);
        binding.zljl.setVisibility(View.GONE);
        binding.img1.setVisibility(View.GONE);
        binding.zyzzed.setVisibility(View.VISIBLE);
        binding.xbsed.setVisibility(View.VISIBLE);
        binding.jwbsed.setVisibility(View.VISIBLE);
        binding.yymced.setVisibility(View.VISIBLE);
        binding.zlgced.setVisibility(View.VISIBLE);
        binding.delete.setVisibility(View.GONE);
        binding.bj.setVisibility(View.GONE);
        binding.abimg.setText("[添加图片]");
        binding.bc.setVisibility(View.VISIBLE);
        binding.time.setVisibility(View.VISIBLE);

    }
    private void showDailog() {
         DatePickerDialog datePickerDialog;
        datePickerDialog = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //monthOfYear 得到的月份会减1所以我们要加1
                String time = String.valueOf(year) + "　" + String.valueOf(monthOfYear + 1) + "  " + Integer.toString(dayOfMonth);
                Log.d("测试", time);
            }
        },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
        //自动弹出键盘问题解决
        datePickerDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }
    private void showDialogTwo() {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_date, null);
        final DatePicker startTime = (DatePicker) view.findViewById(R.id.st);
        final DatePicker endTime = (DatePicker) view.findViewById(R.id.et);

        startTime.updateDate(startTime.getYear(), startTime.getMonth(), 01);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择时间");
        builder.setView(view);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int month = startTime.getMonth() + 1;
                 st = "" + startTime.getYear() +"-"+ month +"-"+startTime.getDayOfMonth();
                int month1 = endTime.getMonth() + 1;
                 et = "" + endTime.getYear()+"-"+ month1+"-"+ endTime.getDayOfMonth();
                Toast.makeText(DangAnActivity.this,st, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", null);
        AlertDialog dialog = builder.create();
        dialog.show();
        //自动弹出键盘问题解决
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }
    private void showTime() {
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.d("测试", Integer.toString(hourOfDay));
                Log.d("测试", Integer.toString(minute));
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
        timePickerDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

}