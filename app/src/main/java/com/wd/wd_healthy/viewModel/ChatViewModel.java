package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.WenZhenBean;
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
 * @date 2022/9/22
 */
public class ChatViewModel extends ViewModel {
    public MediatorLiveData<WenZhenBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<WenZhenBean> getLiveData(){
        HttpUtils.getInstance()
                .getApiService()
                .wznow(SpUtils.getString("userId"),SpUtils.getString("sessionId"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WenZhenBean>() {
                    @Override
                    public void accept(WenZhenBean wenZhenBean) throws Exception {
                        liveData.postValue(wenZhenBean);
                    }
                });
        return liveData;
    }
}
