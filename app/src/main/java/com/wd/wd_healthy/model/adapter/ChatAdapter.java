package com.wd.wd_healthy.model.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.LeftBinding;
import com.wd.wd_healthy.databinding.RightBinding;
import com.wd.wd_healthy.model.util.SpUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.content.ImageContent;
import cn.jpush.im.android.api.content.MessageContent;
import cn.jpush.im.android.api.content.TextContent;
import cn.jpush.im.android.api.content.VoiceContent;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.android.api.model.UserInfo;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/22
 */
public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Message> list;
    private Context context;
    private Map<String,Integer> map;
    private MediaPlayer mp;
    private boolean isplayclient= false;
    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public ChatAdapter(List<Message> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==1){
            LeftBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.left,null,false);
            return new ViewHolder1(binding);
        }else{
            RightBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.right,null,false);
            return new ViewHolder2(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder1){
            ViewHolder1 viewHolder1= (ViewHolder1) holder;
            LeftBinding binding= (LeftBinding) viewHolder1.binding;
            Glide.with(context).load(SpUtils.getString("docimg")).into(binding.leftImg);
            switch (list.get(position).getContentType()){
                case text:
                    binding.leftMess.setVisibility(View.VISIBLE);
                    binding.leftTp.setVisibility(View.GONE);
                    binding.leftBq.setVisibility(View.GONE);
                    binding.l1.setVisibility(View.GONE);
                    TextContent content = (TextContent) list.get(position).getContent();
                    if(content.getText().toString().contains("emo_")){
                        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
                            if(content.getText().equals(stringIntegerEntry.getKey())){
                                binding.leftTp.setVisibility(View.GONE);
                                binding.leftMess.setVisibility(View.GONE);
                                binding.leftBq.setVisibility(View.VISIBLE);
                                Glide.with(context).load(stringIntegerEntry.getValue()).into(binding.leftBq);
                            }
                        }
                    }else{
                        binding.leftMess.setVisibility(View.VISIBLE);
                        binding.leftTp.setVisibility(View.GONE);
                        binding.leftBq.setVisibility(View.GONE);
                        binding.leftMess.setText(content.getText().toString());
                    }
                    break;
                case image:
                    binding.leftMess.setVisibility(View.GONE);
                    binding.leftTp.setVisibility(View.VISIBLE);
                    binding.leftBq.setVisibility(View.GONE);
                    binding.l1.setVisibility(View.GONE);
                    ImageContent content1 = (ImageContent) list.get(position).getContent();
                    String path = content1.getLocalThumbnailPath();
                    Bitmap bitmap = BitmapFactory.decodeFile(path);
                    binding.leftTp.setImageBitmap(bitmap);
                case voice:
                    binding.l1.setVisibility(View.VISIBLE);
                    binding.leftBq.setVisibility(View.GONE);
                    binding.leftTp.setVisibility(View.GONE);
                    binding.leftMess.setVisibility(View.GONE);

                    VoiceContent content2 = (VoiceContent) list.get(position).getContent();

                    binding.chatLeftText.setText(content2.getDuration()+"");
                    media(content2);
                    binding.chatLeftYy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(isplayclient){
                                mp.stop();
                                mp.release();
                                isplayclient = false;
                            }else{
                                media(content2);
                                if(mp!=null){
                                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                        @Override
                                        public void onPrepared(MediaPlayer mp) {
                                            mp.start();
                                            isplayclient = true;
                                        }
                                    });
                                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            mp.stop();
                                            mp.release();
                                            mp = null;
                                            isplayclient = false;
                                        }
                                    });
                                }
                            }
                        }
                    });
                    break;
            }
        }else{
            ViewHolder2 viewHolder2= (ViewHolder2) holder;
            RightBinding binding= (RightBinding) viewHolder2.binding;
            Glide.with(context).load(SpUtils.getString("tx")).into(binding.rightImg);
            switch (list.get(position).getContentType()){
                case text:
                    binding.rightMess.setVisibility(View.VISIBLE);
                    binding.rightTp.setVisibility(View.GONE);
                    binding.rightBq.setVisibility(View.GONE);
                    binding.vl.setVisibility(View.GONE);
                    TextContent content = (TextContent) list.get(position).getContent();
                    if(content.getText().toString().contains("emo_")){
                        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
                            if(content.getText().equals(stringIntegerEntry.getKey())){
                                binding.rightTp.setVisibility(View.GONE);
                                binding.rightMess.setVisibility(View.GONE);
                                binding.rightBq.setVisibility(View.VISIBLE);
                                Glide.with(context).load(stringIntegerEntry.getValue()).into(binding.rightBq);
                            }
                        }
                    }else{
                        binding.rightMess.setVisibility(View.VISIBLE);
                        binding.rightTp.setVisibility(View.GONE);
                        binding.rightBq.setVisibility(View.GONE);

                        binding.rightMess.setText(content.getText().toString());
                    }
                    break;
                case image:
                    binding.rightMess.setVisibility(View.GONE);
                    binding.rightTp.setVisibility(View.VISIBLE);
                    binding.rightBq.setVisibility(View.GONE);
                    binding.vl.setVisibility(View.GONE);
                    ImageContent content1 = (ImageContent) list.get(position).getContent();
                    String path = content1.getLocalThumbnailPath();
                    Bitmap bitmap = BitmapFactory.decodeFile(path);
                    binding.rightTp.setImageBitmap(bitmap);
                    break;
                case voice:
                    binding.rightBq.setVisibility(View.GONE);
                    binding.rightTp.setVisibility(View.GONE);
                    binding.rightMess.setVisibility(View.GONE);
                    binding.vl.setVisibility(View.VISIBLE);
                    VoiceContent content2 = (VoiceContent) list.get(position).getContent();
                    binding.chatRightText.setText(content2.getDuration()+"");
                    media(content2);
                    binding.chatRightYy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(isplayclient){
                                mp.stop();
                                mp.release();
                                isplayclient = false;
                            }else{
                                media(content2);
                                if(mp!=null){
                                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                        @Override
                                        public void onPrepared(MediaPlayer mp) {
                                            mp.start();
                                            isplayclient = true;
                                        }
                                    });
                                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            mp.stop();
                                            mp.release();
                                            mp = null;
                                            isplayclient = false;
                                        }
                                    });
                                }
                            }
                        }
                    });

                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        ViewDataBinding binding;
        public ViewHolder1(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder {
        ViewDataBinding binding;
        public ViewHolder2(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    private void media(VoiceContent content2) {
        mp = new MediaPlayer();
        try {
            File file = new File(content2.getLocalPath());
            FileInputStream inputStream = new FileInputStream(file);
            mp.setDataSource(inputStream.getFD());
            mp.prepareAsync();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int getItemViewType(int position) {
        UserInfo myInfo = JMessageClient.getMyInfo();
        long userID = myInfo.getUserID();
        long userID1 = list.get(position).getFromUser().getUserID();
        if(userID1==userID){
            return 2;
        }
        return 1;
    }

}
