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
import com.wd.wd_healthy.databinding.DocitemBinding;
import com.wd.wd_healthy.databinding.Frag1itemBinding;
import com.wd.wd_healthy.model.bean.DocListBean;
import com.wd.wd_healthy.model.bean.KsBean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/13
 */
public class DocAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<DocListBean.ResultBean> list;
    private Context context;

    public DocAdapter(List<DocListBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DocitemBinding itemBinding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.docitem,null,false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        DocitemBinding binding= (DocitemBinding) viewHolder.binding;
        if(position>0){
            binding.doc1Name.setText(list.get(position).getDoctorName());
            Glide.with(context).load(list.get(position).getImagePic()).into(binding.doc1Img);
        }else{
            binding.doc1Name.setVisibility(View.GONE);
            binding.doc1Img.setVisibility(View.GONE);
        }
        binding.doc1Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onclickListener!=null){
                    onclickListener.onClick(position);
                }
            }
        });
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
    public interface OnclickListener{
        void onClick(int p);
    }
    private OnclickListener onclickListener;

    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }
}
