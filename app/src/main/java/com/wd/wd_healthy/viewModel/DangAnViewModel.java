package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.DangAnBean;
import com.wd.wd_healthy.model.bean.LoginBean;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.HttpUtils;
import com.wd.wd_healthy.model.util.SpUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 *
 * @author 赵某某
 * @date 2022/9/15
 */
public class DangAnViewModel extends ViewModel {
    public MediatorLiveData<DangAnBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<DangAnBean> getLiveData(){
        HttpUtils.getInstance()
                .getApiService()
                .getDangAn(SpUtils.getString("userId"),SpUtils.getString("sessionId"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DangAnBean>() {
                    @Override
                    public void accept(DangAnBean loginBean) throws Exception {
                        liveData.postValue(loginBean);
                    }
                });
        return liveData;
    }
    public MediatorLiveData<SendEmailBean> liveData1=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getLiveData1(){
        HttpUtils.getInstance()
                .getApiService()
                .getDelDangan(SpUtils.getString("userId"),SpUtils.getString("sessionId"),SpUtils.getInt("archivesId"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean loginBean) throws Exception {
                        liveData1.postValue(loginBean);
                    }
                });
        return liveData1;
    }
    public MediatorLiveData<SendEmailBean> liveData2=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getLiveData2(
//            String diseaseMain,
//            String diseaseNow,
//            String diseaseBefore,
//            String treatmentHospitalRecent,
//            String treatmentProcess,
//            String treatmentStartTime,
//            String treatmentEndTime
                Map<String,String> map
    ){
        HttpUtils.getInstance()
                .getApiService()
                .getTjDa(SpUtils.getString("userId"),SpUtils.getString("sessionId"),map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean loginBean) throws Exception {
                        liveData2.postValue(loginBean);
                    }
                });
        return liveData2;
    }
}
