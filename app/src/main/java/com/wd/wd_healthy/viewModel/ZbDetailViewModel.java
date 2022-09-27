package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.ZxDetailBean;
import com.wd.wd_healthy.model.util.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 *
 * @author 赵某某
 * @date 2022/9/13
 */
public class ZbDetailViewModel extends ViewModel {
    public MediatorLiveData<ZxDetailBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<ZxDetailBean> getLiveData(int id){
        HttpUtils.getInstance()
                .getApiService()
                .getzxDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZxDetailBean>() {
                    @Override
                    public void accept(ZxDetailBean zxDetailBean) throws Exception {
                        liveData.postValue(zxDetailBean);
                    }
                });
        return liveData;
    }
}
