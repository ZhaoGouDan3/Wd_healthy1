package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.BzDetailBean;
import com.wd.wd_healthy.model.util.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 *
 * @author 赵某某
 * @date 2022/9/13
 */
public class BzDetailViewModel extends ViewModel {
    public MediatorLiveData<BzDetailBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<BzDetailBean> getLiveData(int id){
        HttpUtils.getInstance()
                .getApiService()
                .getBzDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BzDetailBean>() {
                    @Override
                    public void accept(BzDetailBean bzDetailBean) throws Exception {
                        liveData.postValue(bzDetailBean);
                    }
                });
        return liveData;
    }
}
