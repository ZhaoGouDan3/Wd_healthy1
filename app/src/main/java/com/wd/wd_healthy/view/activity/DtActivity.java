package com.wd.wd_healthy.view.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.model.adapter.SelectPlotAdapter;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.GlideEngine;
import com.wd.wd_healthy.model.util.HttpUtils;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.model.util.Tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class DtActivity extends AppCompatActivity {
    private static final String TAG = "DtActivity";
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private SelectPlotAdapter adapter;
    private ArrayList<String> allSelectList;//所有的图片集合
    private ArrayList<String> categoryLists;//查看图片集合
    private List<LocalMedia> selectList = new ArrayList<>();
    private List<MultipartBody.Part> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dt);
        ButterKnife.bind(this);
        if (null == allSelectList) {
            allSelectList = new ArrayList();
        }
        if (null == categoryLists) {
            categoryLists = new ArrayList();
        }
        Tools.requestPermissions(DtActivity.this);
        initAdapter();
    }

    private void initAdapter() {
        //最多9张图片
        adapter = new SelectPlotAdapter(this, 9);
        recycler.setLayoutManager(new GridLayoutManager(this, 3));
        adapter.setImageList(allSelectList);
        recycler.setAdapter(adapter);
        adapter.setListener(new SelectPlotAdapter.CallbackListener() {
            @Override
            public void add() {
                //可添加的最大张数=9-当前已选的张数
                int size = 9 - allSelectList.size();
                Tools.galleryPictures(DtActivity.this, size);
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
                PictureSelector.create(DtActivity.this)
                        .themeStyle(R.style.picture_default_style)
                        .isNotPreviewDownload(true)//是否显示保存弹框
                        .imageEngine(GlideEngine.createGlideEngine()) // 选择器展示不出图片则添加
                        .openExternalPreview(position, selectList);
                //②:自定义布局预览
                //Tools.startPhotoViewActivity(MainActivity.this, categoryLists, position);
            }
        });
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
            Log.e(TAG, "图片链接: " + path);
        }
        adapter.setImageList(allSelectList);
    }

    @OnClick({R.id.upload})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.upload:
//                String content = edit.getText().toString();
//                if (TextUtils.isEmpty(content)) {
//                    Toast.makeText(this, "请输入上传内容", Toast.LENGTH_LONG).show();
//                    return;
//                }
//                if (allSelectList.size() == 0) {
//                    Toast.makeText(this, "请选择图片进行上传", Toast.LENGTH_LONG).show();
//                    return;
//                }
//                Log.e(TAG, "内容: " + content);
//                Log.e(TAG, "图片: " + allSelectList.toString());
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

                break;
        }
    }

}