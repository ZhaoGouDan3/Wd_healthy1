package com.wd.wd_healthy.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.model.bean.AppInfo;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/10/6
 */
public class AllAppAdapter extends RecyclerView.Adapter<AllAppAdapter.AllAppViewHolder>{
    private List<AppInfo> list;
    private Context context;

    public AllAppAdapter(List<AppInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AllAppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.allapp,null);
        return new AllAppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllAppViewHolder holder, int position) {
        AllAppViewHolder holder1=holder;
        holder1.t1.setText(list.get(position).appName);
        holder1.t2.setText(list.get(position).packageName);
        holder1.t3.setText(list.get(position).versionName);
        holder1.t4.setText(list.get(position).versionCode+"");
        Glide.with(context).load(list.get(position).appIcon).into(holder1.img);
        holder1.img.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                if(onClick!=null){
                    onClick.onclick(position);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AllAppViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView t1,t2,t3,t4;
        public AllAppViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.app_img);
            t1=itemView.findViewById(R.id.app_name);
            t2=itemView.findViewById(R.id.package_name);
            t3=itemView.findViewById(R.id.version_name);
            t4=itemView.findViewById(R.id.version_code);
        }
    }
    public interface OnClick{
        void onclick(int position);
    }
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }
}
