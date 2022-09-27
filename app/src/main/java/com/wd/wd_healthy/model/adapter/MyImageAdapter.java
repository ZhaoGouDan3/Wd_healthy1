package com.wd.wd_healthy.model.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import com.luck.picture.lib.photoview.PhotoView;
import com.wd.wd_healthy.model.util.Tools;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/25
 */
public class MyImageAdapter extends PagerAdapter {

    private List<String> imageUrls;
    private Activity mContext;

    public MyImageAdapter(Activity context, List<String> imageUrls) {
        this.imageUrls = imageUrls;
        this.mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        String url = imageUrls.get(position);
        PhotoView photoView = new PhotoView(mContext);
        Tools.showGlide(mContext, photoView, url);
        container.addView(photoView);
        photoView.setOnClickListener(v -> mContext.finish());
        return photoView;
    }

    @Override
    public int getCount() {
        return imageUrls != null ? imageUrls.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}


