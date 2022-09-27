package com.wd.wd_healthy.model.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.wd.wd_healthy.R;


import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 * @date:
 * @Description:
 */
public class Tools {
    /**
     * 请求权限
     */
    public static void requestPermissions(final AppCompatActivity activity) {
        XXPermissions.with(activity)
                .permission(Permission.Group.STORAGE)
                .permission(Permission.CAMERA)
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean all) {
                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                    }
                });
    }
    /**
     * 打开图库+拍照按钮
     */
    public static void galleryPictures(AppCompatActivity activity, int maxSize) {
        PictureSelector.create(activity)
                .openGallery(PictureMimeType.ofImage())
                .maxSelectNum(maxSize)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageEngine(GlideEngine.createGlideEngine())
                .imageSpanCount(3)// 每行显示个数 int
                .isCamera(true)// 是否显示拍照按钮 true or false
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .isCompress(true)// 是否压缩 true or false
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    /**
     * 加载圆角图片
     *
     * @param context 上下文
     * @param view    图片控件
     * @param url     网络图片地址
     */

    public static void showGlide(Context context, ImageView view, String url) {
        RequestOptions options = new RequestOptions()
                .error(R.mipmap.ic_launcher);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(view);
    }
}
