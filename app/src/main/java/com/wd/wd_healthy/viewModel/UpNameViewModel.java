package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.LoginBean;
import com.wd.wd_healthy.model.bean.SendEmailBean;
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
 * @date 2022/9/20
 */
public class UpNameViewModel extends ViewModel {
    public MediatorLiveData<SendEmailBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getLiveData(String nickname){
        HttpUtils.getInstance()
                .getApiService()
                .upname(SpUtils.getString("userId"),SpUtils.getString("sessionId"),nickname)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean loginBean) throws Exception {
                        liveData.postValue(loginBean);
                    }
                });
        return liveData;
    }
}
