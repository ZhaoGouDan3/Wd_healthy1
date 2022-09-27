package com.wd.wd_healthy.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ByqitemBinding;
import com.wd.wd_healthy.model.bean.ByqBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/20
 */
public class ByqAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ByqBean.ResultBean> list;
    private Context context;

    public ByqAdapter(List<ByqBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View binding= LayoutInflater.from(context).inflate(R.layout.byqitem,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,final int position) {
        ViewHolder binding= (ViewHolder) holder;
//        ByqitemBinding binding= (ByqitemBinding) viewHolder.binding;
        binding.byqtitle.setText(list.get(position).getTitle());
        binding.byqtime.setText(new SimpleDateFormat("yyyy-MM-dd").format(list.get(position).getReleaseTime()));
        binding.byqmess.setText(list.get(position).getDetail());
        binding.titleadv.setText("建议 "+list.get(position).getCommentNum());
        binding.titlesc.setText("收藏 "+list.get(position).getCollectionNum());
        if(list.get(position).getAmount()!=0){
            binding.byqxs.setVisibility(View.VISIBLE);
            binding.byqxsnum.setVisibility(View.VISIBLE);
            binding.byqxsnum.setText(list.get(position).getAmount()+"");
        }else{
            binding.byqxs.setVisibility(View.GONE);
            binding.byqxsnum.setVisibility(View.GONE);
        }
        binding.byqtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onclick!=null){
                    onclick.onClick(list.get(position).getSickCircleId(),list.get(position).getAmount());
                }
            }
        });
//        viewHolder.byq_title.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView byqtitle,byqxsnum,byqtime,byqmess,titlesc,titleadv;
        ImageView byqxs;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            byqtitle=itemView.findViewById(R.id.byq_title);
            byqxsnum=itemView.findViewById(R.id.byq_xsnum);
            byqtime=itemView.findViewById(R.id.byq_time);
            byqmess=itemView.findViewById(R.id.byq_mess);
            titlesc=itemView.findViewById(R.id.title_sc);
            titleadv=itemView.findViewById(R.id.title_adv);
            byqxs=itemView.findViewById(R.id.byq_xs);

        }
    }
    public interface Onclick{
        void onClick(int sickId,int amount);
    }
    private Onclick onclick;

    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }
}
