package com.wd.wd_healthy.view.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityFaBuQuanBinding;
import com.wd.wd_healthy.model.adapter.SelectPlotAdapter;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.BzmessageBean;
import com.wd.wd_healthy.model.bean.KsBean;
import com.wd.wd_healthy.model.bean.SendByqBean;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.GlideEngine;
import com.wd.wd_healthy.model.util.HttpUtils;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.model.util.Tools;
import com.wd.wd_healthy.viewModel.SendViewModel;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

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
    private SelectPlotAdapter adapter;
    private ArrayList<String> allSelectList;//所有的图片集合
    private ArrayList<String> categoryLists;//查看图片集合
    private List<LocalMedia> selectList = new ArrayList<>();
    private List<MultipartBody.Part> list=new ArrayList<>();
    @Override
    public int initlayout() {
        return R.layout.activity_fa_bu_quan;
    }

    @Override
    public void initData() {
        if (null == allSelectList) {
            allSelectList = new ArrayList();
        }
        if (null == categoryLists) {
            categoryLists = new ArrayList();
        }
        Tools.requestPermissions(FbActivity.this);
        initAdapter();
        binding.fabuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getLiveData(binding.fabuBiao.getText().toString(),dpid,bz,binding.fabuXiang.getText().toString(),binding.fabuYiyuan.getText().toString(),binding.fabuKaishi.getText().toString(),binding.fabuJieshu.getText().toString(),binding.fabuGoucheng.getText().toString(),hb).observe(FbActivity.this,FbActivity.this);
                for (String s : allSelectList) {
                    File file = new File(s);
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    MultipartBody.Part data = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
                    list.add(data);
                }
                HttpUtils.getInstance()
                        .getApiService()
                        .sendDt(SpUtils.getString("userId"),SpUtils.getString("sessionId"),list)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<SendEmailBean>() {
                            @Override
                            public void accept(SendEmailBean sendEmailBean) throws Exception {

                            }
                        });
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
    private void initAdapter() {
        //最多9张图片
        adapter = new SelectPlotAdapter(this, 9);
        binding.recycler.setLayoutManager(new GridLayoutManager(this, 3));
        adapter.setImageList(allSelectList);
        binding.recycler.setAdapter(adapter);
        adapter.setListener(new SelectPlotAdapter.CallbackListener() {
            @Override
            public void add() {
                //可添加的最大张数=9-当前已选的张数
                int size = 9 - allSelectList.size();
                Tools.galleryPictures(FbActivity.this, size);
            }

            @Override
            public void delete(int position) {
                allSelectList.remove(position);
                categoryLists.remove(position);
                adapter.setImageList(allSelectList);//再set所有集合
            }

            @Override
            public void item(int position, List<String> mList) {
                selectList.clear();
                for (int i = 0; i < allSelectList.size(); i++) {
                    LocalMedia localMedia = new LocalMedia();
                    localMedia.setPath(allSelectList.get(i));
                    selectList.add(localMedia);
                }
                //①、图片选择器自带预览
                PictureSelector.create(FbActivity.this)
                        .themeStyle(R.style.picture_default_style)
                        .isNotPreviewDownload(true)//是否显示保存弹框
                        .imageEngine(GlideEngine.createGlideEngine()) // 选择器展示不出图片则添加
                        .openExternalPreview(position, selectList);
                //②:自定义布局预览
                //Tools.startPhotoViewActivity(MainActivity.this, categoryLists, position);
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            // 结果回调
            List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
            showSelectPic(selectList);
        }
    }
    private void showSelectPic(List<LocalMedia> result) {
        for (int i = 0; i < result.size(); i++) {
            String path;
            //判断是否10.0以上
            if (Build.VERSION.SDK_INT >= 29) {
                path = result.get(i).getAndroidQToPath();
            } else {
                path = result.get(i).getPath();
            }

            allSelectList.add(path);
            categoryLists.add(path);
            Log.e("FbActivity", "图片链接: " + path);
        }
        adapter.setImageList(allSelectList);
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
