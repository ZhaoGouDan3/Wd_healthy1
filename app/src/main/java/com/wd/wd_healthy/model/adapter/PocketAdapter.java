package com.wd.wd_healthy.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ItemBinding;
import com.wd.wd_healthy.model.bean.PayHistoryBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/16
 */
public class PocketAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<PayHistoryBean.ResultBean> list;
    private Context context;

    public PocketAdapter(List<PayHistoryBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        ItemBinding binding= (ItemBinding) viewHolder.binding;
        switch (list.get(position).getType()){
            case 1:
                binding.itemTitle.setText("签到");
                break;
            case 2:
                binding.itemTitle.setText("病友圈首评");
                break;
            case 3:
                binding.itemTitle.setText("首发病友圈");
                break;
            case 4:
                binding.itemTitle.setText("完善档案");
                break;
            case 5:
                binding.itemTitle.setText("健康评测");
                break;
            case 6:
                binding.itemTitle.setText("悬赏消费");
                break;
            case 7:
                binding.itemTitle.setText("悬赏奖励");
                break;
            case 8:
                binding.itemTitle.setText("邀请奖励");
                break;
            case 9:
                binding.itemTitle.setText("问诊消费");
                break;
            case 10:
                binding.itemTitle.setText("问诊收入");
                break;
            case 11:
                binding.itemTitle.setText("观看资讯");
                break;
            case 12:
                binding.itemTitle.setText("送礼物");
                break;
            case 13:
                binding.itemTitle.setText("绑定身份证");
                break;
            case 14:
                binding.itemTitle.setText("绑定银行卡");
                break;
            case 15:
                binding.itemTitle.setText("充值");
                break;
            case 16:
                binding.itemTitle.setText("提现");
                break;
            case 17:
                binding.itemTitle.setText("购买健康视频");
                break;
        }
        if(list.get(position).getChangeNum()<0){
            binding.itemMx1.setText(list.get(position).getChangeNum()+"");
            binding.itemMx1.setVisibility(View.VISIBLE);
            binding.itemMx2.setVisibility(View.GONE);
        }else{
            binding.itemMx2.setVisibility(View.VISIBLE);
            binding.itemMx2.setText(list.get(position).getChangeNum()+"");
            binding.itemMx1.setVisibility(View.GONE);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
        binding.itemTime.setText(sdf.format(list.get(position).getCreateTime()));
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
