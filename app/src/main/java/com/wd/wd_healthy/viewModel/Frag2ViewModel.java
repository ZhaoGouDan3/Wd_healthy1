package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.KsBean;
import com.wd.wd_healthy.model.util.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 *
 * @author 赵某某
 * @date 2022/9/20
 */
public class Frag2ViewModel extends ViewModel {
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
}
