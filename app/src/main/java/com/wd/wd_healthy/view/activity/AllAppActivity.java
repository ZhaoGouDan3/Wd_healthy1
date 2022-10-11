package com.wd.wd_healthy.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.model.adapter.AllAppAdapter;
import com.wd.wd_healthy.model.bean.AppInfo;

import java.util.ArrayList;
import java.util.List;

public class AllAppActivity extends AppCompatActivity {

    private RecyclerView arv;
    List<AppInfo> list=new ArrayList<>();
    List<PackageInfo> list1=new ArrayList<>();
    private AllAppAdapter allAppAdapter;
    private int pp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_app);
        initView();
        list1=getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < list1.size(); i++) {
            PackageInfo packageInfo = list1.get(i);
            AppInfo appInfo = new AppInfo();
            appInfo.appName=packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
            appInfo.packageName=packageInfo.packageName;
            appInfo.versionName=packageInfo.versionName;
            appInfo.versionCode=packageInfo.versionCode;
            appInfo.appIcon=packageInfo.applicationInfo.loadIcon(getPackageManager());
//            if((packageInfo.applicationInfo.flags& ApplicationInfo.FLAG_SYSTEM)==0){
//
//            }else{
//
//            }
            list.add(appInfo);
        }
        allAppAdapter = new AllAppAdapter(list, this);
        allAppAdapter.setOnClick(new AllAppAdapter.OnClick() {
            @Override
            public void onclick(int position) {
//                new AlertDialog.Builder(AllAppActivity.this).
//                        setTitle("警告")
//                        .setMessage("是否卸载此应用?")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        }).
//                        setNegativeButton("取消",null)
//                        .
//                        show();

                       UninstallApk(position);
            }
        });
        arv.setAdapter(allAppAdapter);
        arv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void UninstallApk(int p) {
        String packageName = list.get(p).packageName;
        pp=p;
        Uri packageURI = Uri.parse("package:" + packageName);
        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
        startActivityForResult(uninstallIntent,1);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            Log.d("TAG", "onActivityResult: executed"); //点击确定，为什么打印此行？？
            Log.v("RESULTCODE",resultCode+"");
            Toast.makeText(AllAppActivity.this, resultCode+"", Toast.LENGTH_SHORT).show();
            list.remove(pp);
            allAppAdapter.notifyDataSetChanged();
        }
    }

    private void initView() {
        arv = (RecyclerView) findViewById(R.id.arv);
    }
}