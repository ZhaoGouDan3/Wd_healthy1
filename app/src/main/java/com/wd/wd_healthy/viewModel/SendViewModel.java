package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.BzmessageBean;
import com.wd.wd_healthy.model.bean.KsBean;
import com.wd.wd_healthy.model.bean.SendByqBean;
import com.wd.wd_healthy.model.util.HttpUtils;
import com.wd.wd_healthy.model.util.SpUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.activity</p>
 *
 * @author 赵某某
 * @date 2022/9/21
 */
public class SendViewModel extends ViewModel {
    public MediatorLiveData<SendByqBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<SendByqBean> getLiveData(
            String title,int departmentId,String disease,String detail,
            String treatmentHospital,String treatmentStartTime,String treatmentEndTime,
            String treatmentProcess,int amount
    ){
        Map<String,Object> map=new HashMap<>();
        map.put("title",title);
        map.put("departmentId",departmentId);
        map.put("disease",disease);
        map.put("detail",detail);
        map.put("treatmentHospital",treatmentHospital);
        map.put("treatmentStartTime",treatmentStartTime);
        map.put("treatmentEndTime",treatmentEndTime);
        map.put("treatmentProcess",treatmentProcess);
        map.put("amount",amount);
        HttpUtils.getInstance()
                .getApiService()
                .senbyq(SpUtils.getString("userId"),SpUtils.getString("sessionId"),map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendByqBean>() {
                    @Override
                    public void accept(SendByqBean sendByqBean) throws Exception {
                        liveData.postValue(sendByqBean);
                    }
                });

        return liveData;
    }
    public MediatorLiveData<KsBean> kslivedata=new MediatorLiveData<>();
    public MediatorLiveData<KsBean> getKslivedata(){
        HttpUtils.getInstance().getApiService()
                .getKs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<KsBean>() {
                    @Override
                    public void accept(KsBean bannerBean) throws Exception {
                        kslivedata.postValue(bannerBean);
                    }
                });
        return kslivedata;
    }
    public MediatorLiveData<BzmessageBean> bzmessageBeanMediatorLiveData=new MediatorLiveData<>();
    public MediatorLiveData<BzmessageBean> getBzmessageBeanMediatorLiveData(int id){
        HttpUtils.getInstance()
                .getApiService()
                .getBzmess(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BzmessageBean>() {
                    @Override
                    public void accept(BzmessageBean bzmessageBean) throws Exception {
                        bzmessageBeanMediatorLiveData.postValue(bzmessageBean);
                    }
                });
        return bzmessageBeanMediatorLiveData;
    }
}
