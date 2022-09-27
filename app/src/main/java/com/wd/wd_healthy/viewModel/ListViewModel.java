package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

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
public class ListViewModel extends ViewModel {
    public MediatorLiveData<DocListBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<DocListBean> getLiveData(int deptId,int condition,int page,int count){
        HttpUtils.getInstance()
                .getApiService()
                .getDocList(deptId, condition, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DocListBean>() {
                    @Override
                    public void accept(DocListBean docListBean) throws Exception {
                        liveData.postValue(docListBean);
                    }
                });
        return liveData;
    }
    public MediatorLiveData<ZxNowBean> liveData1=new MediatorLiveData<>();
    public MediatorLiveData<ZxNowBean> getLiveData1(int id){
        HttpUtils.getInstance()
                .getApiService()
                .zxnow(SpUtils.getString("userId"),SpUtils.getString("sessionId"),id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZxNowBean>() {
                    @Override
                    public void accept(ZxNowBean docListBean) throws Exception {
                        liveData1.postValue(docListBean);
                    }
                });
        return liveData1;
    }
}
