package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.CaiNaBean;
import com.wd.wd_healthy.model.bean.MyVideoBean;
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
public class MyVideoViewModel extends ViewModel {
    public MediatorLiveData<MyVideoBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<MyVideoBean> getLiveData(){
        HttpUtils.getInstance()
                .getApiService()
                .BroughtVideo(SpUtils.getString("userId"),SpUtils.getString("sessionId"),1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyVideoBean>() {
                    @Override
                    public void accept(MyVideoBean caiNaBean) throws Exception {
                        liveData.postValue(caiNaBean);
                    }
                });
        return liveData;
    }
}
