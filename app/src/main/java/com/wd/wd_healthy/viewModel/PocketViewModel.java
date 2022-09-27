package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.LoginBean;
import com.wd.wd_healthy.model.bean.PayHistoryBean;
import com.wd.wd_healthy.model.bean.WallBean;
import com.wd.wd_healthy.model.util.HttpUtils;
import com.wd.wd_healthy.model.util.SpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 *
 * @author 赵某某
 * @date 2022/9/16
 */
public class PocketViewModel extends ViewModel {
    public MediatorLiveData<WallBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<WallBean> getLiveData(){
        HttpUtils.getInstance()
                .getApiService()
                .getYe(SpUtils.getString("userId"),SpUtils.getString("sessionId"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WallBean>() {
                    @Override
                    public void accept(WallBean loginBean) throws Exception {
                        liveData.postValue(loginBean);
                    }
                });
        return liveData;
    }
    public MediatorLiveData<PayHistoryBean> liveData1=new MediatorLiveData<>();
    public MediatorLiveData<PayHistoryBean> getLiveData1(){
        HttpUtils.getInstance()
                .getApiService()
                .Xfhistory(SpUtils.getString("userId"),SpUtils.getString("sessionId"),1,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PayHistoryBean>() {
                    @Override
                    public void accept(PayHistoryBean loginBean) throws Exception {
                        liveData1.postValue(loginBean);
                    }
                });
        return liveData1;
    }
}
