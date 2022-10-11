package com.wd.wd_healthy.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.library.FlowAdapter;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivitySearchBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.RmBean;
import com.wd.wd_healthy.viewModel.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity<SearchViewModel, ActivitySearchBinding>{
    List<String> list=new ArrayList<>();
    @Override
    public int initlayout() {
        return R.layout.activity_search;
    }

    @Override
    public void initData() {
        viewModel.getLiveData().observe(this,this);
        binding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchActivity.this,SouTiaoMainActivity.class).putExtra("tiaoshu",binding.searched2.getText().toString()));
            }
        });
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof RmBean){
            RmBean bean= (RmBean) o;
//            for (int i = 0; i < bean.getResult().size(); i++) {
//                TextView textView = new TextView(SearchActivity.this);
//                textView.setText(bean.getResult().get(i).getName());
//                textView.setBackground(new ColorDrawable(Color.GRAY));
//                textView.setTextColor(Color.BLACK);
//                textView.setMinWidth(32);
//                textView.setMinHeight(26);
//                textView.setPadding(0,10,10,10);
//                textView.setTextSize(12);
//                textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
//                binding.flow.addView(textView);
//            }
            for (int i = 0; i < bean.getResult().size(); i++) {
                list.add(bean.getResult().get(i).getName());
            }

            binding.aflCotent.setAdapter(new FlowAdapter(list) {
                @Override
                public View getView(int i) {
                    View view = View.inflate(SearchActivity.this, R.layout.liushibuju_item, null);
                    TextView auto_tv = view.findViewById(R.id.auto_tv);
                    auto_tv.setText(list.get(i));
                    auto_tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            binding.searched2.setText(list.get(i));
                        }
                    });
                    return view;
                }
            });
        }
    }
}