package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.YpBean;
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
public class YpViewModel extends ViewModel {
    public MediatorLiveData<YpBean> ypBeanMediatorLiveData=new MediatorLiveData<>();
    public MediatorLiveData<YpBean> getYpBeanMediatorLiveData(){
        HttpUtils.getInstance()
                .getApiService()
                .getYp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YpBean>() {
                    @Override
                    public void accept(YpBean ypBean) throws Exception {
                        ypBeanMediatorLiveData.postValue(ypBean);
                    }
                });
        return ypBeanMediatorLiveData;
    }
}
