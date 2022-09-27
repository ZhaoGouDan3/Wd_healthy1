package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.YpMessBean;
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
public class YpFragViewModel extends ViewModel {
    public MediatorLiveData<YpMessBean> ypMessBeanMediatorLiveData=new MediatorLiveData<>();
    public MediatorLiveData<YpMessBean> getYpMessBeanMediatorLiveData(int id){
        HttpUtils.getInstance()
                .getApiService()
                .getYpMess(id,1,20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YpMessBean>() {
                    @Override
                    public void accept(YpMessBean ypMessBean) throws Exception {
                        ypMessBeanMediatorLiveData.postValue(ypMessBean);
                    }
                });
        return ypMessBeanMediatorLiveData;
    }
}
