package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.SendEmailBean;
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
 * @date 2022/9/14
 */
public class LoseViewModel extends ViewModel {
    public MediatorLiveData<SendEmailBean> ypBeanMediatorLiveData=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getYpBeanMediatorLiveData(String email){
        HttpUtils.getInstance()
                .getApiService()
                .getEmaile(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean ypBean) throws Exception {
                        ypBeanMediatorLiveData.postValue(ypBean);
                    }
                });
        return ypBeanMediatorLiveData;
    }
    public MediatorLiveData<SendEmailBean> jylivedata=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getJylivedata(String email,String code){
        HttpUtils.getInstance()
                .getApiService()
                .getYz(email,code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean ypBean) throws Exception {
                        jylivedata.postValue(ypBean);
                    }
                });
        return jylivedata;
    }
}
