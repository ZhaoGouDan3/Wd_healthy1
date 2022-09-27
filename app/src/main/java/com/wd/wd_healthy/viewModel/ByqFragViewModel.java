package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.ByqBean;
import com.wd.wd_healthy.model.util.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.activity</p>
 *
 * @author 赵某某
 * @date 2022/9/20
 */
public class ByqFragViewModel extends ViewModel {
    private MediatorLiveData<ByqBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<ByqBean> getLiveData(int dpid,int page){
        HttpUtils.getInstance()
                .getApiService()
                .byqlist(dpid,page,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ByqBean>() {
                    @Override
                    public void accept(ByqBean byqBean) throws Exception {
                        liveData.postValue(byqBean);
                    }
                });
        return liveData;
    }
}
