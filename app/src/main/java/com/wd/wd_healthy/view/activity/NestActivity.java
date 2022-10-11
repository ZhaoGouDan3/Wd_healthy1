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

                        .setHeight(ViewGroup.LayoutParams.MATCH_PARENT)//设置高，这里使用match_parent，就是与item的高相同

                        .setWidth(70);//设置宽

                swipeRightMenu.addMenuItem(deleteItem);//设置右边的侧滑
                swipeLeftMenu.addMenuItem(deleteItem);
            }
        });

        rv.setSwipeMenuItemClickListener(new SwipeMenuItemClickListener() {

            @Override
                public void onItemClick(SwipeMenuBridge menuBridge) {

                menuBridge.closeMenu();
                int direction = menuBridge.getDirection(); //左侧还是右侧菜单。0是左，右是1，暂时没有用到

                int adapterPosition = menuBridge.getAdapterPosition(); //RecyclerView的Item的position。

                int menuPosition = menuBridge.getPosition(); //菜单在RecyclerView的Item中的Position。

                list.remove(adapterPosition);
                rv.getAdapter().notifyDataSetChanged();
            }

        });



        rv.setSwipeItemClickListener(new SwipeItemClickListener() {

            @Override
                public void onItemClick(View itemView, int position) {

                Toast.makeText(NestActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();

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