package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityMyBodyBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.viewModel.KongViewModel;

public class MyBodyActivity extends BaseActivity<KongViewModel, ActivityMyBodyBinding>{

    @Override
    public int initlayout() {
        return R.layout.activity_my_body;
    }

    @Override
    public void initData() {
        binding.height.setMax(200);
        binding.weight.setMax(120);
        binding.age.setMax(102);
        binding.height.setProgress(SpUtils.getInt("height"));
        binding.weight.setProgress(SpUtils.getInt("weight"));
        binding.age.setProgress(SpUtils.getInt("age"));

        binding.height.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.tvQuota.setText((progress+50)+"cm");
                int quota = progress;
                int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                binding.tvQuota.measure(spec, spec);
                int quotaWidth =  binding.tvQuota.getMeasuredWidth();

                int spec2 = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                binding.tvQuota.measure(spec2, spec2);
                int sbWidth =  binding.height.getMeasuredWidth();
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)  binding.tvQuota.getLayoutParams();
                params.leftMargin = (int) (((double) progress / binding.height.getMax()) * sbWidth - (double) quotaWidth * progress / binding.height.getMax());
                binding.tvQuota.setLayoutParams(params);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        binding.weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.tvQuota2.setText((progress+30)+"kg");
                int quota = progress;
                int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                binding.tvQuota2.measure(spec, spec);
                int quotaWidth =  binding.tvQuota2.getMeasuredWidth();

                int spec2 = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                binding.tvQuota2.measure(spec2, spec2);
                int sbWidth =  binding.weight.getMeasuredWidth();
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)  binding.tvQuota2.getLayoutParams();
                params.leftMargin = (int) (((double) progress / binding.weight.getMax()) * sbWidth - (double) quotaWidth * progress / binding.weight.getMax());
                binding.tvQuota2.setLayoutParams(params);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        binding.age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.tvQuota3.setText((progress+18)+"岁");
                int quota = progress;
                int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                binding.tvQuota3.measure(spec, spec);
                int quotaWidth =  binding.tvQuota3.getMeasuredWidth();

                int spec2 = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                binding.tvQuota3.measure(spec2, spec2);
                int sbWidth =  binding.age.getMeasuredWidth();
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)  binding.tvQuota3.getLayoutParams();
                params.leftMargin = (int) (((double) progress / binding.age.getMax()) * sbWidth - (double) quotaWidth * progress / binding.age.getMax());
                binding.tvQuota3.setLayoutParams(params);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onChanged(Object o) {

    }
}