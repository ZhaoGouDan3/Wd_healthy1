package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.BzBean;
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
public class BzViewModel extends ViewModel {
    public MediatorLiveData<BzBean> bzliveData=new MediatorLiveData<>();
    public MediatorLiveData<BzBean> getBzliveData(){
        HttpUtils.getInstance()
                .getApiService()
                .getBz()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BzBean>() {
                    @Override
                    public void accept(BzBean bzBean) throws Exception {
                        bzliveData.postValue(bzBean);
                    }
                });
        return bzliveData;
    }
}
