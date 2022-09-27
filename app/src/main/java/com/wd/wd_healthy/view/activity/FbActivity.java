package com.wd.wd_healthy.view.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityFaBuQuanBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.BzmessageBean;
import com.wd.wd_healthy.model.bean.KsBean;
import com.wd.wd_healthy.model.bean.SendByqBean;
import com.wd.wd_healthy.viewModel.SendViewModel;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.activity</p>
 *
 * @author 赵某某
 * @date 2022/9/21
 */
public class FbActivity extends BaseActivity<SendViewModel, ActivityFaBuQuanBinding> {

    DateFormat format= DateFormat.getDateTimeInstance();
    Calendar calendar= Calendar.getInstance(Locale.CHINA);
    List<String> list1=new ArrayList<>();
    List<String> list2=new ArrayList<>();
    private int id=0;
    private int hb=0;
    private int dpid;
    private String bz;
    @Override
    public int initlayout() {
        return R.layout.activity_fa_bu_quan;
    }

    @Override
    public void initData() {
        binding.fabuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getLiveData(binding.fabuBiao.getText().toString(),dpid,bz,binding.fabuXiang.getText().toString(),binding.fabuYiyuan.getText().toString(),binding.fabuKaishi.getText().toString(),binding.fabuJieshu.getText().toString(),binding.fabuGoucheng.getText().toString(),hb).observe(FbActivity.this,FbActivity.this);
            }
        });
        binding.fabuKaishiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(FbActivity.this,  2, binding.fabuKaishi, calendar);;
            }
        });
        binding.fabuJieshuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(FbActivity.this,  2, binding.fabuJieshu, calendar);;
            }
        });
        viewModel.getKslivedata().observe(this,this);
        list2.add("请选择主要病症");
        binding.kaiguan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    binding.faXuan.setVisibility(View.VISIBLE);
                }else{
                    binding.faXuan.setVisibility(View.GONE);
                }
            }
        });
        binding.fabuRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.fabu_rb1:
                        hb=10;
                        break;
                    case R.id.fabu_rb2:
                        hb=20;
                        break;
                    case R.id.fabu_rb3:
                        hb=30;
                        break;
                }
            }
        });

    }
    public static void showDatePickerDialog(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作
                tv.setText( year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof KsBean){
            KsBean bean= (KsBean) o;
            list1.add("请选择就诊科室");
            for (int i = 0; i < bean.getResult().size(); i++) {
                list1.add(bean.getResult().get(i).getDepartmentName());
            }
            binding.nice1.attachDataSource(list1);
            binding.nice1.addOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position!=0){
                        dpid=bean.getResult().get(position-1).getId();
                        viewModel.getBzmessageBeanMediatorLiveData(bean.getResult().get(position-1).getId()).observe(FbActivity.this,FbActivity.this);
                    }
                }
            });
        }else if(o instanceof BzmessageBean){
            BzmessageBean bean= (BzmessageBean) o;
            list2.clear();
            list2.add("请选择主要病症");
            for (int i = 0; i < bean.getResult().size(); i++) {
                list2.add(bean.getResult().get(i).getName());
            }
            binding.nice2.attachDataSource(list2);
            binding.nice2.addOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position!=0){
                        bz=bean.getResult().get(position-1).getName();
                    }
                }
            });
        }else if(o instanceof SendByqBean){
            SendByqBean bean= (SendByqBean) o;
            Toast.makeText(FbActivity.this,bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
