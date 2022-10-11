package com.wd.wd_healthy.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.model.adapter.SuoYaoShi;
import com.wd.wd_healthy.model.adapter.SuoYiShi;
import com.wd.wd_healthy.model.adapter.SuoZhengShi;
import com.wd.wd_healthy.model.bean.ShouSouBean;
import com.wd.wd_healthy.model.util.HttpUtils;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.activity</p>
 *
 * @author 赵某某
 * @date 2022/10/11
 */
public class SouTiaoMainActivity extends AppCompatActivity {
    private ImageView liutiaoImg;
    private EditText liutiaoShu;
    private TextView sss;
    private LinearLayout aabu;
    private TextView yishengName;
    private RecyclerView suoyiRv;
    private TextView yaopingName;
    private RecyclerView suoyaoRv;
    private TextView zhengzhaungName;
    private RecyclerView suozhengRv;
    private LinearLayout bbbu;
    private TextView meishuju;
    private String tiaoshu;
    private String s;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_tiao_main);
        initView();
        liutiaoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        tiaoshu = intent.getStringExtra("tiaoshu");
        liutiaoShu.setText(tiaoshu);
        sss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = liutiaoShu.getText().toString();
                if(s.equals("")){
                    Toast.makeText(SouTiaoMainActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
        HttpUtils.getInstance()
                .getApiService()
                .getss(tiaoshu)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShouSouBean>() {
                    @Override
                    public void accept(ShouSouBean shouSouBean) throws Exception {
                        ShouSouBean.ResultBean result = shouSouBean.getResult();
                        List<ShouSouBean.ResultBean.DiseaseSearchVoListBean> diseaseSearchVoList = result.getDiseaseSearchVoList();
                        List<ShouSouBean.ResultBean.DoctorSearchVoListBean> doctorSearchVoList = result.getDoctorSearchVoList();
                        List<ShouSouBean.ResultBean.DrugsSearchVoListBean> drugsSearchVoList = result.getDrugsSearchVoList();
                        if(diseaseSearchVoList!=null&&diseaseSearchVoList.size()>0||doctorSearchVoList!=null&&doctorSearchVoList.size()>0||drugsSearchVoList!=null&&drugsSearchVoList.size()>0){
                            bbbu.setVisibility(View.GONE);
                            aabu.setVisibility(View.VISIBLE);
                            if(diseaseSearchVoList!=null&&diseaseSearchVoList.size()>0){
                                zhengzhaungName.setVisibility(View.VISIBLE);
                                suozhengRv.setVisibility(View.VISIBLE);
                                suozhengRv.setLayoutManager(new LinearLayoutManager(SouTiaoMainActivity.this));
                                SuoZhengShi suoZhengShi = new SuoZhengShi(SouTiaoMainActivity.this, R.layout.souzhengbu, diseaseSearchVoList);
                                suozhengRv.setAdapter(suoZhengShi);
                                suoZhengShi.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {

                                    }

                                    @Override
                                    public boolean onItemLongClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                                        return false;
                                    }
                                });
                            }else {
                                zhengzhaungName.setVisibility(View.GONE);
                                suozhengRv.setVisibility(View.GONE);
                            }
                            if(doctorSearchVoList!=null&&doctorSearchVoList.size()>0){
                                yishengName.setVisibility(View.VISIBLE);
                                suoyiRv.setLayoutManager(new LinearLayoutManager(SouTiaoMainActivity.this));
                                SuoYiShi suoYiShi = new SuoYiShi(SouTiaoMainActivity.this, R.layout.souyibu, doctorSearchVoList);
                                suoyiRv.setAdapter(suoYiShi);
                                suoYiShi.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                                        Intent intent = new Intent(SouTiaoMainActivity.this, SouTiaoMainActivity.class);
                                        intent.putExtra("doctorId",doctorSearchVoList.get(i).getDoctorId());
                                        startActivity(intent);
                                    }

                                    @Override
                                    public boolean onItemLongClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                                        return false;
                                    }
                                });
                                suoyiRv.setVisibility(View.VISIBLE);
                            }else {
                                yishengName.setVisibility(View.GONE);
                                suoyiRv.setVisibility(View.GONE);
                            }
                            if(drugsSearchVoList!=null&&drugsSearchVoList.size()>0){
                                yaopingName.setVisibility(View.VISIBLE);
                                suoyaoRv.setLayoutManager(new LinearLayoutManager(SouTiaoMainActivity.this));
                                SuoYaoShi suoYaoShi = new SuoYaoShi(SouTiaoMainActivity.this, R.layout.souyaobu, drugsSearchVoList);
                                suoyaoRv.setAdapter(suoYaoShi);
                                suoYaoShi.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {

                                    }

                                    @Override
                                    public boolean onItemLongClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                                        return false;
                                    }
                                });
                                suoyaoRv.setVisibility(View.VISIBLE);
                            }else {
                                yaopingName.setVisibility(View.GONE);
                                suoyaoRv.setVisibility(View.GONE);
                            }
                        }else {
                            bbbu.setVisibility(View.VISIBLE);
                            aabu.setVisibility(View.GONE);
                            meishuju.setText("抱歉！没有找到“"+s+"”的相关病信息");
                        }
                    }

                });
    }

    private void initView() {
        liutiaoImg = (ImageView) findViewById(R.id.liutiao_img);
        liutiaoShu = (EditText) findViewById(R.id.liutiao_shu);
        sss = (TextView) findViewById(R.id.sss);
        aabu = (LinearLayout) findViewById(R.id.aabu);
        yishengName = (TextView) findViewById(R.id.yisheng_name);
        suoyiRv = (RecyclerView) findViewById(R.id.suoyi_rv);
        yaopingName = (TextView) findViewById(R.id.yaoping_name);
        suoyaoRv = (RecyclerView) findViewById(R.id.suoyao_rv);
        zhengzhaungName = (TextView) findViewById(R.id.zhengzhaung_name);
        suozhengRv = (RecyclerView) findViewById(R.id.suozheng_rv);
        bbbu = (LinearLayout) findViewById(R.id.bbbu);
        meishuju = (TextView) findViewById(R.id.meishuju);
    }
}
