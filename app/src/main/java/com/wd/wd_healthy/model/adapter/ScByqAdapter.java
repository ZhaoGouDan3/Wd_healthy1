package com.wd.wd_healthy.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ScbyqitemBinding;
import com.wd.wd_healthy.model.bean.MyByqBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/16
 */
public class ScByqAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    private List<MyByqBean.ResultBean> list;
    private Context context;

    public ScByqAdapter(List<MyByqBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ScbyqitemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.scbyqitem,null,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;

        ScbyqitemBinding binding= (ScbyqitemBinding) viewHolder.binding;
        binding.byqItemMess.setText(list.get(position).getDetail());
        binding.byqItemTitle.setText(list.get(position).getTitle());
        String format = sdf.format(list.get(position).getReleaseTime());
        String[] split = format.split("-");
        binding.month.setText(split[1]+"月");
        binding.date.setText(Integer.parseInt(split[2])>9?split[2]:"0"+split[2]);
        binding.year.setText(split[0]);
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
}
