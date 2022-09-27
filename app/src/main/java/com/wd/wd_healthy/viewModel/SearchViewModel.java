package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.RmBean;
import com.wd.wd_healthy.model.util.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 *
 * @author 赵某某
 * @date 2022/9/14
 */
public class SearchViewModel extends ViewModel {
    public MediatorLiveData<RmBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<RmBean> getLiveData(){
        HttpUtils.getInstance()
                .getApiService()
                .getRm()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RmBean>() {
                    @Override
                    public void accept(RmBean rmBean) throws Exception {
                        liveData.postValue(rmBean);
                    }
                });
        return liveData;

    }
}
