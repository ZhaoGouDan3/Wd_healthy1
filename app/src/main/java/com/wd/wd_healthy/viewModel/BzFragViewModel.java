package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.BzmessageBean;
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
public class BzFragViewModel extends ViewModel {
    public MediatorLiveData<BzmessageBean> bzmessageBeanMediatorLiveData=new MediatorLiveData<>();
    public MediatorLiveData<BzmessageBean> getBzmessageBeanMediatorLiveData(int id){
        HttpUtils.getInstance()
                .getApiService()
                .getBzmess(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BzmessageBean>() {
                    @Override
                    public void accept(BzmessageBean bzmessageBean) throws Exception {
                        bzmessageBeanMediatorLiveData.postValue(bzmessageBean);
                    }
                });
        return bzmessageBeanMediatorLiveData;
    }
}
