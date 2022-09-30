package com.wd.wd_healthy.view.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.kd.easybarrage.Barrage;
import com.kd.easybarrage.BarrageView;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.VideofragBinding;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.base.BaseFragment2;
import com.wd.wd_healthy.model.bean.DmBean;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.bean.VideoBean;
import com.wd.wd_healthy.model.util.BitmapUtils;

import com.wd.wd_healthy.model.util.DensityUtil;
import com.wd.wd_healthy.model.util.DpTools;

import com.wd.wd_healthy.model.util.ScrollCalculatorHelper;
import com.wd.wd_healthy.viewModel.VideoViewModel;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某
 * @date 2022/9/24
 */
public class VideoFrag extends BaseFragment<VideoViewModel, VideofragBinding> {
    private int videoId;

    private int id=1;

    public VideoFrag(int videoId) {
        this.videoId = videoId;
    }
    private boolean isContent=false;
    private boolean issc=false;
    private boolean isdm=false;
    private List<Barrage> list=new ArrayList<>();
    private BarrageView bar;

    @Override
    public int initlayout() {
        return R.layout.videofrag;
    }

    @Override
    public void initData() {
        viewModel.getVideolivedata(videoId,1,5).observe(this,this);
        bar= binding.bar;

    }

    @Override
    protected void stopLoad() {
        super.stopLoad();
        GSYVideoManager.releaseAllVideos();
        bar.destroy();
    }


    @Override
    public void onChanged(Object o) {
        if(o instanceof VideoBean){
            VideoBean bean= (VideoBean) o;

            LinearLayoutManager manager = new LinearLayoutManager(getActivity());
            binding.vdrv.setAdapter(new CommonAdapter<VideoBean.ResultBean>(getContext(),R.layout.videoitem,bean.getResult()){
                @Override
                protected void convert(ViewHolder holder, VideoBean.ResultBean resultBean, int position) {
                    id=resultBean.getId();

                    StandardGSYVideoPlayer player = holder.getView(R.id.player);
                    player.setUp(resultBean.getShearUrl(),true,"");
                    ImageView vddm = holder.getView(R.id.vddm);
                    //////////////////////////////////弹幕
                    initdm(id);
                    vddm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(!isdm){
                                binding.bar.setVisibility(View.GONE);
                            }else{
                                binding.bar.setVisibility(View.VISIBLE);
                            }
                            isdm=!isdm;
                        }
                    });
                    //
                    if(position==0){
                        player.startPlayLogic();
                    }
                    ImageView sc = holder.getView(R.id.vdsc);

                    if (resultBean.getWhetherCollection()!=2){
                        sc.setImageResource(R.drawable.common_button_collection_small_s);
                        issc=true;
                    }else{
                        sc.setImageResource(R.drawable.common_button_collection_small_n);
                        issc=false;
                    }
                    sc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(issc){
                                sc.setImageResource(R.drawable.common_button_collection_small_n);
                                resultBean.setWhetherCollection(2);
                                viewModel.getDeleteVd(resultBean.getId()).observe(getActivity(), new Observer<SendEmailBean>() {
                                    @Override
                                    public void onChanged(SendEmailBean sendEmailBean) {

                                        Toast.makeText(getActivity(),sendEmailBean.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                sc.setImageResource(R.drawable.common_button_collection_small_s);
                                resultBean.setWhetherCollection(1);
                                sc(resultBean.getId());
                            }
                            issc=!issc;

                        }
                    });


                    LinearLayout relativeLayout=holder.getView(R.id.re2);
                    relativeLayout.setBackgroundColor(Color.WHITE);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,3.0f);

                    EditText editText = new EditText(getActivity());
                    editText.setLayoutParams(lp);
                    editText.setHint("请输入评论");
                    editText.setId(24);
                    relativeLayout.addView(editText);

                    lp=new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1.0f);

                    Button button = new Button(getActivity());
                    button.setText("发送");
                    button.setBackground(null);
                    relativeLayout.addView(button,lp);

                    holder.getView(R.id.vdpl).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(isContent){
                                relativeLayout.setVisibility(View.GONE);
                            }else{
                                relativeLayout.setVisibility(View.VISIBLE);
                            }
                            isContent=!isContent;

                        }
                    });
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(!editText.getText().toString().equals("")){
                                viewModel.getSendDmData(bean.getResult().get(position).getId(),editText.getText().toString()).observe(getActivity(), new Observer<SendEmailBean>() {
                                    @Override
                                    public void onChanged(SendEmailBean sendEmailBean) {
                                        Toast.makeText(getContext(), sendEmailBean.getMessage(), Toast.LENGTH_SHORT).show();
                                        if(sendEmailBean.getStatus().equals("0000")){
                                            editText.setText("");
                                        }
                                    }
                                });
                            }else{
                                Toast.makeText(getContext(), "不能为空", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            });
            binding.vdrv.setLayoutManager(new LinearLayoutManager(getContext()));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            ScrollCalculatorHelper scrollCalculatorHelper=new ScrollCalculatorHelper(
                    R.id.player,displayMetrics.heightPixels/2- DpTools.dip2px(getActivity(),180),
                    displayMetrics.heightPixels/2+DpTools.dip2px(getActivity(),180));
            binding.vdrv.setOnFlingListener(null);
            PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
            pagerSnapHelper.attachToRecyclerView(binding.vdrv);


            binding.vdrv.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    scrollCalculatorHelper.onScrollStateChanged(recyclerView, newState);

                }

                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    int firstVisibleItemPosition = manager.findFirstVisibleItemPosition();
                    int lastVisibleItemPosition = manager.findLastVisibleItemPosition();
                    scrollCalculatorHelper.onScroll(recyclerView,firstVisibleItemPosition,lastVisibleItemPosition,1);

                }
            });
        }else if(o instanceof SendEmailBean){
            SendEmailBean bean= (SendEmailBean) o;
            showToast(bean.getMessage());
        }else if(o instanceof DmBean){
            DmBean bean= (DmBean) o;
            for (DmBean.ResultBean resultBean : bean.getResult()) {
               list.add(new Barrage(resultBean.getContent(),R.color.style_color,false));
            }
            bar.setBarrages(list);

        }
    }

    private void initdm(int id) {
        viewModel.getDm(id).observe(this,this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        GSYVideoManager.releaseAllVideos();
    }

    private void sc(int videoId){
        viewModel.getScVd(videoId).observe(this,this);
    }
    private void delete(int videoId){
        viewModel.getDeleteVd(videoId).observe(this,this);
    }



    @Override
    public void onPause() {
        super.onPause();

        GSYVideoManager.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        GSYVideoManager.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();


    }



}
