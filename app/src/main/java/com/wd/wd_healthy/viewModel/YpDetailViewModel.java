package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.YpDetailBean;
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
public class YpDetailViewModel extends ViewModel {
    public MediatorLiveData<YpDetailBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<YpDetailBean> getLiveData(int id){
        HttpUtils.getInstance()
                .getApiService()
                .getYpDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YpDetailBean>() {
                    @Override
                    public void accept(YpDetailBean ypDetailBean) throws Exception {
                        liveData.postValue(ypDetailBean);
                    }
                });
        return liveData;
    }
}
