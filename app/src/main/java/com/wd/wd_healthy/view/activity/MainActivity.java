package com.wd.wd_healthy.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityMainBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.viewModel.KongViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<KongViewModel, ActivityMainBinding>{

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                if(i>0){
                    binding.ds.setText(i+"S");
                    i--;
                    sendEmptyMessageDelayed(1,1000);
                }else{
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    finish();
                }
            }
        }
    };
    private List<View> list=new ArrayList<>();
    private int i=3;
    @Override
    public int initlayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        if(!SpUtils.getBoolean("first")){
            binding.linear.setVisibility(View.VISIBLE);
            binding.startPage.setVisibility(View.GONE);
            binding.ds.setVisibility(View.GONE);
            LayoutInflater layoutInflater = getLayoutInflater();
            View view1 = layoutInflater.inflate(R.layout.start1, null);
            View view2 = layoutInflater.inflate(R.layout.start2, null);
            View view3 = layoutInflater.inflate(R.layout.start3, null);
            View view4 = layoutInflater.inflate(R.layout.start4, null);
            View view5 = layoutInflater.inflate(R.layout.start5, null);
            list.add(view1);
            list.add(view2);
            list.add(view3);
            list.add(view4);
            list.add(view5);
            Button join_now = view5.findViewById(R.id.join_now);
            join_now.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    SpUtils.putBoolean("first",true);
                    finish();
                }
            });
            binding.startVp.setAdapter(new PagerAdapter() {
                @Override
                public int getCount() {
                    return list.size();
                }

                @Override
                public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                    return view==object;
                }

                @NonNull
                @Override
                public Object instantiateItem(@NonNull ViewGroup container, int position) {
                    container.addView(list.get(position));
                    return list.get(position);
                }

                @Override
                public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                    container.removeView((View) object);

                }
            });

            binding.startTab.setupWithViewPager(binding.startVp);
        }else{
            binding.ds.setVisibility(View.VISIBLE);
            binding.startPage.setVisibility(View.VISIBLE);
            handler.sendEmptyMessage(1);
        }

    }

    @Override
    public void onChanged(Object o) {

    }
}