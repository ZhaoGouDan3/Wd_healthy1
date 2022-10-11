package com.wd.wd_healthy.model.adapter;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/10/4
 */
public interface ItemTouchHelperAdapter {
    //数据交换
    void onItemMove(int fromPosition,int toPosition);
    //数据删除
    void onItemDissmiss(int position);
}
