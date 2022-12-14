package com.wd.wd_healthy.view.activity;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.model.adapter.MyAdapter;
import com.wd.wd_healthy.model.util.SlideRecyclerView;
import com.yanzhenjie.recyclerview.swipe.SwipeItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NestActivity extends AppCompatActivity {

    private SwipeMenuRecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest);
        initView();
        List<String> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add("item"+i);
        }

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setSwipeMenuCreator(new SwipeMenuCreator() {
            @Override
            public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
                SwipeMenuItem deleteItem= new SwipeMenuItem(NestActivity.this)

                        .setImage(R.drawable.common_icon_girl_n)

                        .setHeight(ViewGroup.LayoutParams.MATCH_PARENT)//????????????????????????match_parent????????????item????????????

                        .setWidth(70);//?????????

                swipeRightMenu.addMenuItem(deleteItem);//?????????????????????
                swipeLeftMenu.addMenuItem(deleteItem);
            }
        });

        rv.setSwipeMenuItemClickListener(new SwipeMenuItemClickListener() {

            @Override
                public void onItemClick(SwipeMenuBridge menuBridge) {

                menuBridge.closeMenu();
                int direction = menuBridge.getDirection(); //???????????????????????????0???????????????1?????????????????????

                int adapterPosition = menuBridge.getAdapterPosition(); //RecyclerView???Item???position???

                int menuPosition = menuBridge.getPosition(); //?????????RecyclerView???Item??????Position???

                list.remove(adapterPosition);
                rv.getAdapter().notifyDataSetChanged();
            }

        });



        rv.setSwipeItemClickListener(new SwipeItemClickListener() {

            @Override
                public void onItemClick(View itemView, int position) {

                Toast.makeText(NestActivity.this, "?????????"+position, Toast.LENGTH_SHORT).show();

            }

        });
        rv.setAdapter(new MyAdapter(list,NestActivity.this));








        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Log.e("TAG", "densityDpi: " + displayMetrics.densityDpi);
        Log.e("TAG", "density: " + displayMetrics.density);
        Log.e("TAG", "widthPixels: " + displayMetrics.widthPixels);
        Log.e("TAG", "heightPixels: " + displayMetrics.heightPixels);

    }



        private void initView() {
            rv = (SwipeMenuRecyclerView) findViewById(R.id.rv);
        }

}