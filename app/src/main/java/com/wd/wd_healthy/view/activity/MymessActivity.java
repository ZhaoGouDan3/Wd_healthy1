package com.wd.wd_healthy.view.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityMymessBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.TxViewModel;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MymessActivity extends BaseActivity<TxViewModel, ActivityMymessBinding>{
    private File file;
    @Override
    public int initlayout() {
        return R.layout.activity_mymess;
    }

    @Override
    public void initData() {
        Glide.with(this).load(SpUtils.getString("tx")).into(binding.messtx);
        binding.nickName.setText(SpUtils.getString("nickname"));
        binding.sexy.setImageResource(SpUtils.getInt("sexy")==1?R.drawable.common_icon_boy_n:R.drawable.common_icon_girl_n);
        binding.messEmail.setText(SpUtils.getString("email"));

        binding.messtx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent,1);
            }
        });
        binding.upname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MymessActivity.this,UpNameActivity.class),2);
            }
        });
        binding.upsexy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MymessActivity.this,UpSexyActivity.class),3);
            }
        });
        binding.messtz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MymessActivity.this,MyBodyActivity.class),3);
            }
        });
        binding.smrz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MymessActivity.this,RnaActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK){
            Toast.makeText(MymessActivity.this, "进入", Toast.LENGTH_SHORT).show();
            ContentResolver contentResolver = getContentResolver();
            file=new File("data/data/com.wd.wd_healthy/tx.png");

            try {
                if(!file.exists()){
                    file.createNewFile();
                }
                InputStream inputStream = contentResolver.openInputStream(data.getData());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                bitmap.compress(Bitmap.CompressFormat.JPEG,50,bufferedOutputStream);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                updatetx();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(resultCode==2&&requestCode==2){
            binding.nickName.setText(data.getStringExtra("name"));
        }else if(requestCode==3&&resultCode==3){
            binding.sexy.setImageResource(data.getIntExtra("sexy",0)==1?R.drawable.common_icon_boy_n:R.drawable.common_icon_girl_n);
        }
    }

    private void updatetx() {
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part data = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
        viewModel.getLiveData(data).observe(this,this);
    }

    @Override
    public void onChanged(Object o) {

    }
}