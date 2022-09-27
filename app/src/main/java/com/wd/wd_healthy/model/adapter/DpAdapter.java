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
import com.wd.wd_healthy.databinding.DpitemBinding;
import com.wd.wd_healthy.model.bean.QuanPingLieBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/21
 */
public class DpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<QuanPingLieBean.ResultBean> list;
    private Context context;

    public DpAdapter(List<QuanPingLieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DpitemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dpitem,null,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        DpitemBinding binding= (DpitemBinding) viewHolder.binding;
        Glide.with(context).load(list.get(position).getHeadPic()).into(binding.dpImg);
        binding.dpName.setText(list.get(position).getNickName());
        binding.dpMess.setText(list.get(position).getContent());
        binding.dpTime.setText(new SimpleDateFormat("dd/MM/yyyy").format(list.get(position).getCommentTime()));
        binding.disagree.setText(list.get(position).getOpposeNum()+"");
        binding.agree.setText(list.get(position).getSupportNum()+"");
        if(list.get(position).getWhetherDoctor()==1){
            binding.dpDoc.setVisibility(View.VISIBLE);
        }else{
            binding.dpDoc.setVisibility(View.GONE);
        }
        binding.disImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickListener!=null){
                    onClickListener.onClick(list.get(position).getCommentId(),2);
                }
            }
        });
        binding.agreeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickListener!=null){
                    onClickListener.onClick(list.get(position).getCommentId(),1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;
        public ViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    public interface OnClickListener{
        void onClick(int commentId,int flag);
    }
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
