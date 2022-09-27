package com.wd.wd_healthy.view.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.wd_healthy.R;

public class CsActivity extends AppCompatActivity {

    private Button tj;
    private LinearLayout linear;
    private boolean istj = false;
    private EditText editText;
    private LinearLayout lineartj;
    private Button xh;
    private TextView textview;
    private LinearLayout linearlay1;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs);
        initView();
//        RelativeLayout relativeLayout = new RelativeLayout(CsActivity.this);
//
//        linear.addView(relativeLayout);
//        relativeLayout.setBackgroundColor(Color.YELLOW);
//
//        editText = new EditText(CsActivity.this);
//        editText.setHint("请输入内容");
//        editText.setId(24);
//
//        RelativeLayout.LayoutParams lp=new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//        lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE); //紧贴父控件的右边边缘
//        lp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);//紧贴父控件的顶部边缘
//        relativeLayout.addView(editText, lp);
//        tj.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(!istj){
//                    relativeLayout.setVisibility(View.GONE);
//                }else{
//                    relativeLayout.setVisibility(View.VISIBLE);
//                }
//                istj=!istj;
//
//            }
//        });

        LinearLayout linear=(LinearLayout) findViewById(R.id.linearlay_1);
        //添加文本,this代表当前项目
        TextView tv=new TextView(this);
        tv.setText("示例文本框");
        tv.setId(1);//设置ID，可有可无，也可以在R文件中添加字符串，然后在这里使用引用的方式使用
        linear.addView(tv);

        // 将Button 加入到LinearLayout 中
        Button b1 = new Button(this);
        b1.setText("取消");
        linear.addView(b1);

        // 将Button 2 加入到LinearLayout 中
        Button b2 = new Button(this);
        b2.setText("确定");
        linear. addView ( b2 );

    }

    private void initView() {
        tj = (Button) findViewById(R.id.tj);
        linear = (LinearLayout) findViewById(R.id.lineartj);
        lineartj = (LinearLayout) findViewById(R.id.lineartj);
        xh = (Button) findViewById(R.id.xh);
        textview = (TextView) findViewById(R.id.textview);
        linearlay1 = (LinearLayout) findViewById(R.id.linearlay_1);
    }
}