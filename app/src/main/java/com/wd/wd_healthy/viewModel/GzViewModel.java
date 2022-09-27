package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.GzBean;
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
 * @date 2022/9/17
 */
public class GzViewModel extends ViewModel {
    public MediatorLiveData<GzBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<GzBean> getLiveData(){
        HttpUtils.getInstance()
                .getApiService()
                .Gzdoc(SpUtils.getString("userId"),SpUtils.getString("sessionId"),1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GzBean>() {
                    @Override
                    public void accept(GzBean s) throws Exception {
                        liveData.postValue(s);
                    }
                })
        ;
        return liveData;
    }
}
