package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.ZxBean;
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
public class HomeFragViewModel extends ViewModel {
    public MediatorLiveData<ZxBean> XvliveData=new MediatorLiveData<>();
    public MediatorLiveData<ZxBean> getZxliveData(int plateId,int page,int count){
        HttpUtils.getInstance().getApiService()
                .getZx(plateId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZxBean>() {
                    @Override
                    public void accept(ZxBean bannerBean) throws Exception {
                        XvliveData.postValue(bannerBean);
                    }
                });
        return XvliveData;
    }
}
