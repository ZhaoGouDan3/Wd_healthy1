package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.ColSickBean;
import com.wd.wd_healthy.model.bean.ColVideoBean;
import com.wd.wd_healthy.model.bean.ColZxBean;
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
 * @date 2022/9/16
 */
public class MyColViewModel extends ViewModel {
    public MediatorLiveData<ColZxBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<ColZxBean> getLiveData(){
        HttpUtils.getInstance()
                .getApiService()
                .myColList(SpUtils.getString("userId"),SpUtils.getString("sessionId"),1,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ColZxBean>() {
                    @Override
                    public void accept(ColZxBean loginBean) throws Exception {
                        liveData.postValue(loginBean);
                    }
                });
        return liveData;
    }
    public MediatorLiveData<ColVideoBean> liveData1=new MediatorLiveData<>();
    public MediatorLiveData<ColVideoBean> getLiveData1(){
        HttpUtils.getInstance()
                .getApiService()
                .myColVideoList(SpUtils.getString("userId"),SpUtils.getString("sessionId"),1,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ColVideoBean>() {
                    @Override
                    public void accept(ColVideoBean loginBean) throws Exception {
                        liveData1.postValue(loginBean);
                    }
                });
        return liveData1;
    }
    public MediatorLiveData<ColSickBean> liveData2=new MediatorLiveData<>();
    public MediatorLiveData<ColSickBean> getLiveData2(){
        HttpUtils.getInstance()
                .getApiService()
                .myColSickList(SpUtils.getString("userId"),SpUtils.getString("sessionId"),1,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ColSickBean>() {
                    @Override
                    public void accept(ColSickBean loginBean) throws Exception {
                        liveData2.postValue(loginBean);
                    }
                });
        return liveData2;
    }
    public MediatorLiveData<SendEmailBean> liveData3=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getLiveData3(int sickCircleId){
        HttpUtils.getInstance()
                .getApiService()
                .deleteSickList(SpUtils.getString("userId"),SpUtils.getString("sessionId"),sickCircleId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean loginBean) throws Exception {
                        liveData3.postValue(loginBean);
                    }
                });
        return liveData3;
    }

}
