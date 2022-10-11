package com.wd.wd_healthy.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.wd_healthy.R;

import java.util.Collections;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/10/4
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements ItemTouchHelperAdapter {
    private List<String> list;
    private Context context;

    public MyAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.nestitem,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        MyViewHolder holder1= (MyViewHolder) holder;
        holder1.t1.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(list,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDissmiss(int position) {
        list.remove(position);
        notifyItemChanged(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.item_item);
            t2=itemView.findViewById(R.id.tv_delete);
        }
    }
}
