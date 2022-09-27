package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.TxBean;
import com.wd.wd_healthy.model.util.HttpUtils;
import com.wd.wd_healthy.model.util.SpUtils;

import java.io.File;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 *
 * @author 赵某某
 * @date 2022/9/19
 */
public class TxViewModel extends ViewModel {
    public MediatorLiveData<TxBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<TxBean> getLiveData(MultipartBody.Part file){
        HttpUtils.getInstance()
                .getApiService()
                .updateTx(SpUtils.getString("userId"),SpUtils.getString("sessionId"),file)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TxBean>() {
                    @Override
                    public void accept(TxBean txBean) throws Exception {
                        liveData.postValue(txBean);
                    }
                });

        return liveData;
    }
}
