package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.DocDetailBean;
import com.wd.wd_healthy.model.bean.DocListBean;
import com.wd.wd_healthy.model.bean.ZxNowBean;
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
 * @date 2022/9/13
 */
public class DocDetailViewModel extends ViewModel {
    public MediatorLiveData<DocDetailBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<DocDetailBean> getLiveData(int id){
        HttpUtils.getInstance()
                .getApiService()
                .getDocDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DocDetailBean>() {
                    @Override
                    public void accept(DocDetailBean docListBean) throws Exception {
                        liveData.postValue(docListBean);
                    }
                });
        return liveData;
    }

}
