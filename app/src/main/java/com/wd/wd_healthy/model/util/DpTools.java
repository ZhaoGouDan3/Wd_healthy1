package com.wd.wd_healthy.model.util;

import android.content.Context;

/**
 * @author: JinYuanYuan
 * @date: 2022/2/14
 * @Description: 功能
 */
public class DpTools {
    // todo 转化分辨率

        public static int dip2px(Context context, float dpValue) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        }

        /**
         * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
         */
        public static int px2dip(Context context, float pxValue) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (pxValue / scale + 0.5f);
        }



}
