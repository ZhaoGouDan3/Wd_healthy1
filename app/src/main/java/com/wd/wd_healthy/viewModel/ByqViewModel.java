package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.MyByqBean;
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
public class ByqViewModel extends ViewModel {
    public MediatorLiveData<MyByqBean> bzmessageBeanMediatorLiveData=new MediatorLiveData<>();
    public MediatorLiveData<MyByqBean> getBzmessageBeanMediatorLiveData(){
        HttpUtils.getInstance()
                .getApiService()
                .ScByq(SpUtils.getString("userId"),SpUtils.getString("sessionId"),1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyByqBean>() {
                    @Override
                    public void accept(MyByqBean bzmessageBean) throws Exception {
                        bzmessageBeanMediatorLiveData.postValue(bzmessageBean);
                    }
                });
        return bzmessageBeanMediatorLiveData;
    }
}
