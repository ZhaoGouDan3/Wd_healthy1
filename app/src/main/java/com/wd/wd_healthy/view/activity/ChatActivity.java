package com.wd.wd_healthy.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityChatBinding;
import com.wd.wd_healthy.model.adapter.ChatAdapter;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.WenZhenBean;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.model.util.VoiceUtils;
import com.wd.wd_healthy.viewModel.ChatViewModel;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;

public class ChatActivity extends BaseActivity<ChatViewModel, ActivityChatBinding>{
    private String userName;
    private String appkey="c7f6a1d56cb8da740fd18bfa";
    private Message message;
    private List<Message> list;
    private ChatAdapter adapter;
    private List<Integer> list1=new ArrayList<>();
    private List<String> list2=new ArrayList<>();
    private boolean flag=false;
    private File file;
    private Map<String,Integer> map=new HashMap<>();
    private boolean isopen=false;

    private boolean isPop = true;
    private VoiceUtils voiceUtils = new VoiceUtils("/sdcard/Music/shanglenianjideren.mp3");
    private int timeint = 0;
    private PopupWindow window;
    private String title;
    private TextView yyTimes;
    private ImageView yypic;
    private TextView titles;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull android.os.Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                timeint++;
                yyTimes.setText(timeint+"");
                sendEmptyMessageDelayed(1,1000);
            }
        }
    };
    private String path;
    @Override
    public int initlayout() {
        return R.layout.activity_chat;
    }

    @Override
    public void initData() {
        viewModel.getLiveData().observe(this,this);
        initBQ();

        binding.chatBq.setAdapter(new CommonAdapter<Integer>(ChatActivity.this,R.layout.bqitem,list1){

            @Override
            protected void convert(ViewHolder holder, Integer integer, int position) {
                Glide.with(ChatActivity.this).load(list1.get(position)).into((ImageView) holder.getView(R.id.bqimg));
                holder.getView(R.id.bqimg).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        binding.sended.setText(list2.get(position));
                        try {
                            //获取表情图片文件名
                            Field field = R.drawable.class.getDeclaredField(list2.get(position));
                            int resourceId = Integer.parseInt(field.get(null).toString());
                            // 在android中要显示图片信息，必须使用Bitmap位图的对象来装载.
                            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
                            Matrix matrix = new Matrix();
                            matrix.postScale(0.2f,0.2f); //长和宽放大缩小的比例
                            Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
                             //要让图片替代指定的文字就要用ImageSpan
                            ImageSpan imageSpan = new ImageSpan(ChatActivity.this, resizeBmp);
                            SpannableString spannableString = new SpannableString(list2.get(position));//face就是图片的前缀名
                            spannableString.setSpan(imageSpan, 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            binding.sended.append(spannableString);
                        }catch ( Exception e) {

                        }
                    }
                });
            }
        });
        binding.chatBq.setLayoutManager(new GridLayoutManager(ChatActivity.this,6));
        binding.bq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    binding.chatBq.setVisibility(View.VISIBLE);
                    binding.chatRv.scrollToPosition(list.size()-1);
                    binding.chatRv.smoothScrollToPosition(list.size()-1);
                }else{
                    binding.chatBq.setVisibility(View.GONE);
                }
                flag=!flag;
            }
        });
        binding.tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });

        binding.yySend.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        binding.yySend.setText("录音中");
                        timeint = 0;
                        title = "向上取消";
                        popWindow();
                        voiceUtils.startRecord();
                        handler.sendEmptyMessageDelayed(1,1000);
                        break;
                    case MotionEvent.ACTION_UP:
                        handler.removeCallbacksAndMessages(null);
                        long jgTime = event.getEventTime() - event.getDownTime();
                        int sc = (int) jgTime / 1000;
                        if(isPop){
                            if(sc>2){
                                Toast.makeText(ChatActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                                path = voiceUtils.stopRecord();
                                voicemassage(userName);
                            }else{
                                Toast.makeText(ChatActivity.this, "发送时长太短", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            isPop = true;
                        }
                        window.dismiss();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if(event.getY()<-100){
                            title = "松开取消";
                            yypic.setImageResource(R.mipmap.chehui);
                            binding.sended.setText(title);
                            isPop = false;
                            voiceUtils.cancelRecord();
                        }
                        break;
                }
                return true;
            }
        });
        binding.voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isopen){
                    binding.sended.setVisibility(View.INVISIBLE);
                    binding.yySend.setVisibility(View.VISIBLE);
                }else{
                    binding.sended.setVisibility(View.VISIBLE);
                    binding.yySend.setVisibility(View.GONE);
                }
                isopen=!isopen;
            }
        });
    }
    private void voicemassage(String userName) {
        File file = new File(path);
        Toast.makeText(ChatActivity.this,file.getName(), Toast.LENGTH_SHORT).show();
        try {
            message = JMessageClient.createSingleVoiceMessage("3Hytfn2824506709", appkey, file, timeint);
            JMessageClient.sendMessage(message);
            list.add(message);
            binding.chatRv.getAdapter().notifyDataSetChanged();
            binding.chatRv.scrollToPosition(list.size()-1);
            binding.chatRv.smoothScrollToPosition(list.size()-1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void popWindow() {
        View viewPop = LayoutInflater.from(this).inflate(R.layout.yuyin, null, false);
        yyTimes = viewPop.findViewById(R.id.yyTimes);
        yypic = viewPop.findViewById(R.id.yypic);
        titles = viewPop.findViewById(R.id.titles);
        window = new PopupWindow(viewPop, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        window.showAtLocation(viewPop, Gravity.CENTER,0,0);
        viewPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK){
            file=new File("data/data/com.wd.wd_healthy/tp.png");
            try {
                if(!file.exists()){
                    file.createNewFile();
                }
                ContentResolver contentResolver = getContentResolver();
                InputStream inputStream = contentResolver.openInputStream(data.getData());
                BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(file));
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                bitmap.compress(Bitmap.CompressFormat.JPEG,50,outputStream);
                outputStream.flush();
                outputStream.close();
                Message message = JMessageClient.createSingleImageMessage("3Hytfn2824506709", appkey, file);
                JMessageClient.sendMessage(message);
                list.add(message);
                adapter.notifyDataSetChanged();
                binding.chatRv.scrollToPosition(list.size()-1);
                binding.chatRv.smoothScrollToPosition(list.size()-1);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private void initBQ(){


        map.put("emo_01",R.drawable.emo_01);
        map.put("emo_02",R.drawable.emo_02);
        map.put("emo_19",R.drawable.emo_19);
        map.put("emo_04",R.drawable.emo_04);
        map.put("emo_05",R.drawable.emo_05);
        map.put("emo_06",R.drawable.emo_06);
        map.put("emo_07",R.drawable.emo_07);
        map.put("emo_08",R.drawable.emo_08);
        map.put("emo_09",R.drawable.emo_09);
        map.put("emo_10",R.drawable.emo_10);
        map.put("emo_11",R.drawable.emo_11);
        map.put("emo_12",R.drawable.emo_12);
        map.put("emo_13",R.drawable.emo_13);
        map.put("emo_14",R.drawable.emo_14);
        map.put("emo_15",R.drawable.emo_15);
        map.put("emo_16",R.drawable.emo_16);
        map.put("emo_17",R.drawable.emo_17);
        map.put("emo_18",R.drawable.emo_18);
        for (Integer value : map.values()) {
            list1.add(value);
        }
        for (String s : map.keySet()) {
            list2.add(s);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        JMessageClient.registerEventReceiver(this,200);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JMessageClient.unRegisterEventReceiver(this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof WenZhenBean){
            WenZhenBean bean= (WenZhenBean) o;
            binding.wxName.setText(bean.getResult().getDoctorName());
            SpUtils.putString("docimg",bean.getResult().getImagePic());
            userName=bean.getResult().getUserName();
            Conversation.createSingleConversation("3Hytfn2824506709",appkey);
            Conversation conversation = JMessageClient.getSingleConversation("3Hytfn2824506709", appkey);

            if(conversation!=null){
                list = conversation.getAllMessage();
            }
            if(adapter==null){
                adapter=new ChatAdapter(list,ChatActivity.this);
                adapter.setMap(map);
            }
            binding.chatRv.setAdapter(adapter);
            binding.chatRv.setLayoutManager(new LinearLayoutManager(ChatActivity.this));
            binding.chatRv.getAdapter().notifyDataSetChanged();
            binding.chatRv.scrollToPosition(list.size()-1);
            binding.chatRv.smoothScrollToPosition(list.size()-1);

            sendMessage(userName);
        }
    }

    private void sendMessage(String userName) {
        binding.fs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.sended.getText().toString().length()>0){
                    Message message = JMessageClient.createSingleTextMessage("3Hytfn2824506709", appkey, binding.sended.getText().toString());
                    JMessageClient.sendMessage(message);
                    list.add(message);
                    adapter.notifyDataSetChanged();
                    binding.chatRv.scrollToPosition(list.size()-1);
                    binding.chatRv.smoothScrollToPosition(list.size()-1);
                    binding.sended.setText("");
                }else{
                    Toast.makeText(ChatActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event) {
        Message newMessage = event.getMessage();//获取此次离线期间会话收到的新消息列表
        list.add(newMessage);
        binding.chatRv.getAdapter().notifyDataSetChanged();
        binding.chatRv.scrollToPosition(list.size()-1);
        binding.chatRv.smoothScrollToPosition(list.size()-1);
    }
}