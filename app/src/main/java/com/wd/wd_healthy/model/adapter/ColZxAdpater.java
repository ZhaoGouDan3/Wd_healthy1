package com.wd.wd_healthy.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.Homeitem1Binding;
import com.wd.wd_healthy.databinding.Homeitem2Binding;
import com.wd.wd_healthy.model.bean.ColZxBean;
import com.wd.wd_healthy.model.bean.ZxBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public class ColZxAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private List<ColZxBean.ResultBean> list;
    private Context context;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");

    public ColZxAdpater(List<ColZxBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==2){
            Homeitem2Binding binding=DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.homeitem2,null,false);
            return new ViewHolder(binding);
        }else{
            Homeitem1Binding binding=DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.homeitem1,null,false);
            return new ViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(list.get(position).getThumbnail().split(";").length>1){
            ViewHolder viewHolder= (ViewHolder) holder;
            Homeitem2Binding binding= (Homeitem2Binding) viewHolder.binding;
            String[] split = list.get(position).getThumbnail().split(";");
            Glide.with(context).load(split[0]).into(binding.homeItem2Img1);
            Glide.with(context).load(split[1]).into(binding.homeItem2Img2);
            Glide.with(context).load(split[2]).into(binding.homeItem2Img3);
            binding.homeItem2Title.setText(list.get(position).getTitle());
            binding.homeItem2Name.setText("");
            String format = sdf.format(list.get(position).getCreateTime());
            binding.homeItem2Time.setText(format);
            if(onclickListener!=null){
                binding.homeItem2Title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onclickListener.onclick(list.get(position).getId());
                    }
                });
                binding.homeItem2Img1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onclickListener.onclick(list.get(position).getId());
                    }
                });
                binding.homeItem2Img2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onclickListener.onclick(list.get(position).getId());
                    }
                });
                binding.homeItem2Img3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onclickListener.onclick(list.get(position).getId());
                    }
                });

            }
        }else{
            ViewHolder viewHolder= (ViewHolder) holder;
            Homeitem1Binding binding= (Homeitem1Binding) viewHolder.binding;
            Glide.with(context).load(list.get(position).getThumbnail()).into(binding.homeItem1Img);
            binding.homeItem1Name.setText("");
            binding.homeItem1Title.setText(list.get(position).getTitle());
            String format = sdf.format(list.get(position).getCreateTime());
            binding.homeItem1Time.setText(format);
            if(onclickListener!=null) {
                binding.homeItem1Title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onclickListener.onclick(list.get(position).getId());
                    }
                });
                binding.homeItem1Img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onclickListener.onclick(list.get(position).getId());
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;
        public ViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
//    class ViewHolder1 extends RecyclerView.ViewHolder {
//        private ViewDataBinding binding;
//        public ViewHolder1(@NonNull ViewDataBinding binding) {
//            super(binding.getRoot());
//            this.binding=binding;
//        }
//    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getThumbnail().split(";").length>1){
            return 2;
        }else{
            return 1;
        }

    }
    public interface OnclickListener{
        void onclick(int infoid);
    }
    private OnclickListener onclickListener;

    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }
}
