package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.TodaySignBean;
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
 * @date 2022/9/19
 */
public class MySignViewModel extends ViewModel {
    public MediatorLiveData<TodaySignBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<TodaySignBean> getLiveData(){
        HttpUtils.getInstance()
                .getApiService()
                .getToday(SpUtils.getString("userId"),SpUtils.getString("sessionId"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TodaySignBean>() {
                    @Override
                    public void accept(TodaySignBean todaySignBean) throws Exception {
                        liveData.postValue(todaySignBean);
                    }
                });
        return liveData;
    }
    public MediatorLiveData<TodaySignBean> liveData1=new MediatorLiveData<>();
    public MediatorLiveData<TodaySignBean> getLiveData1(){
        HttpUtils.getInstance()
                .getApiService()
                .getCoil(SpUtils.getString("userId"),SpUtils.getString("sessionId"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TodaySignBean>() {
                    @Override
                    public void accept(TodaySignBean todaySignBean) throws Exception {
                        liveData1.postValue(todaySignBean);
                    }
                });
        return liveData1;
    }
}
