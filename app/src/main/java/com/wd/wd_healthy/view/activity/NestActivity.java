package com.wd.wd_healthy.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.wd_healthy.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NestActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest);
        initView();
        List<String> list=new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add("item"+i);
        }
        rv.setAdapter(new CommonAdapter<String>(this,R.layout.nestitem,list) {

            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                TextView textView = holder.getView(R.id.item_item);
                textView.setText(s);
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
    }
}