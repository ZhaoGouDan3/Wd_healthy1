package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.bean.TxBean;
import com.wd.wd_healthy.model.util.HttpUtils;
import com.wd.wd_healthy.model.util.SpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 *
 * @author 赵某某
 * @date 2022/9/20
 */
public class UpsexyViewModel extends ViewModel {
    public MediatorLiveData<SendEmailBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getLiveData(int sexy){
        HttpUtils.getInstance()
                .getApiService()
                .upsexy(SpUtils.getString("userId"),SpUtils.getString("sessionId"),sexy)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean txBean) throws Exception {
                        liveData.postValue(txBean);
                    }
                });

        return liveData;
    }
}
