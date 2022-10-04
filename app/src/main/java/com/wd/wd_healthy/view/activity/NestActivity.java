package com.wd.wd_healthy.view.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.model.util.SlideRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NestActivity extends AppCompatActivity {

    private SlideRecyclerView rv;

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
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Log.e("TAG", "densityDpi: " + displayMetrics.densityDpi);
        Log.e("TAG", "density: " + displayMetrics.density);
        Log.e("TAG", "widthPixels: " + displayMetrics.widthPixels);
        Log.e("TAG", "heightPixels: " + displayMetrics.heightPixels);

    }
    private static final int INVALID_POSITION = -1; // 触摸到的点不在子View范围内
    private Rect mTouchFrame;   // 子View所在的矩形范围
    public int pointToPosition(int x, int y) {
        int firstPosition = ((LinearLayoutManager) rv.getLayoutManager()).findFirstVisibleItemPosition();
        Rect frame = mTouchFrame;
        if (frame == null) {
            mTouchFrame = new Rect();
            frame = mTouchFrame;
        }

        final int count = rv.getChildCount();
        for (int i = count - 1; i >= 0; i--) {
            final View child = rv.getChildAt(i);
            if (child.getVisibility() == View.VISIBLE) {
                child.getHitRect(frame);
                if (frame.contains(x, y)) {
                    return firstPosition + i;
                }
            }
        }
        return INVALID_POSITION;
    }

    private void initView() {
        rv = (SlideRecyclerView) findViewById(R.id.rv);
    }
}