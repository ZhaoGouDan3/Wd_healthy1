package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.HttpUtils;
import com.wd.wd_healthy.model.util.SpUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 * @author 赵某某
 * @date 2022/9/20
 */
public class RnaViewModel extends ViewModel {
    public MediatorLiveData<SendEmailBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getLiveData(int userId,String name,String sex,String nation,String birthday,String address,String idNumber,String issueOffice){
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        map.put("name",name);
        map.put("sex",sex);
        map.put("nation",nation);
        map.put("birthday",birthday);
        map.put("address",address);
        map.put("idNumber",idNumber);
        map.put("issueOffice",issueOffice);
        HttpUtils.getInstance()
                .getApiService()
                .rna(SpUtils.getString("userId"),SpUtils.getString("sessionId"),map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean sendEmailBean) throws Exception {
                        liveData.postValue(sendEmailBean);
                    }
                });
        return liveData;
    }
}
