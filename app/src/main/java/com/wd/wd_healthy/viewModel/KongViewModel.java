package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.LoginBean;
import com.wd.wd_healthy.model.util.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 *
 * @author 赵某某
 * @date 2022/9/9
 */
public class KongViewModel extends ViewModel {
    public MediatorLiveData<LoginBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<LoginBean> getLiveData(String email,String pwd){
        HttpUtils.getInstance()
                .getApiService()
                .getLogin(email, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        liveData.postValue(loginBean);
                    }
                });
        return liveData;
    }
}
