package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.BannerBean;
import com.wd.wd_healthy.model.bean.KsBean;
import com.wd.wd_healthy.model.bean.TabBean;
import com.wd.wd_healthy.model.bean.ZxBean;
import com.wd.wd_healthy.model.util.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public class Frag1ViewModel extends ViewModel {
    public MediatorLiveData<BannerBean> bannerlive=new MediatorLiveData<>();
    public MediatorLiveData<BannerBean> getBannerlive(){
        HttpUtils.getInstance().getApiService()
                .getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        bannerlive.postValue(bannerBean);
                    }
                });
        return bannerlive;
    }
    public MediatorLiveData<KsBean> kslivedata=new MediatorLiveData<>();
    public MediatorLiveData<KsBean> getKslivedata(){
        HttpUtils.getInstance().getApiService()
                .getKs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<KsBean>() {
                    @Override
                    public void accept(KsBean bannerBean) throws Exception {
                        kslivedata.postValue(bannerBean);
                    }
                });
        return kslivedata;
    }
    public MediatorLiveData<TabBean> TabliveData=new MediatorLiveData<>();
    public MediatorLiveData<TabBean> getTabliveData(){
        HttpUtils.getInstance().getApiService()
                .getTab()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TabBean>() {
                    @Override
                    public void accept(TabBean bannerBean) throws Exception {
                        TabliveData.postValue(bannerBean);
                    }
                });
        return TabliveData;
    }

}
