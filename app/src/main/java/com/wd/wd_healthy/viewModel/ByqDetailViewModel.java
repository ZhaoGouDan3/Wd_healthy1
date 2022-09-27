package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.ByqDetailBean;
import com.wd.wd_healthy.model.bean.QuanPingLieBean;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.HttpUtils;
import com.wd.wd_healthy.model.util.SpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Query;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.viewModel</p>
 *
 * @author 赵某某
 * @date 2022/9/20
 */
public class ByqDetailViewModel extends ViewModel {
    public MediatorLiveData<ByqDetailBean> liveData=new MediatorLiveData<>();
    public MediatorLiveData<ByqDetailBean> getLiveData(int sickId){
        HttpUtils.getInstance()
                .getApiService()
                .bydetail(SpUtils.getString("userId"),SpUtils.getString("sessionId"),sickId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ByqDetailBean>() {
                    @Override
                    public void accept(ByqDetailBean byqDetailBean) throws Exception {
                        liveData.postValue(byqDetailBean);
                    }
                });
        return liveData;
    }
    public MediatorLiveData<SendEmailBean> liveData1=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getLiveData1(int sickId){
        HttpUtils.getInstance()
                .getApiService()
                .scbyq(SpUtils.getString("userId"),SpUtils.getString("sessionId"),sickId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean byqDetailBean) throws Exception {
                        liveData1.postValue(byqDetailBean);
                    }
                });
        return liveData1;
    }
    public MediatorLiveData<SendEmailBean> liveData2=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getLiveData2(int sickId){
        HttpUtils.getInstance()
                .getApiService()
                .qxbyq(SpUtils.getString("userId"),SpUtils.getString("sessionId"),sickId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean byqDetailBean) throws Exception {
                        liveData2.postValue(byqDetailBean);
                    }
                });
        return liveData2;
    }
    public MediatorLiveData<QuanPingLieBean> liveData3=new MediatorLiveData<>();
    public MediatorLiveData<QuanPingLieBean> getLiveData3(int sickId,int page,int count){
        HttpUtils.getInstance()
                .getApiService()
                .dplist(SpUtils.getString("userId"),SpUtils.getString("sessionId"),sickId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<QuanPingLieBean>() {
                    @Override
                    public void accept(QuanPingLieBean byqDetailBean) throws Exception {
                        liveData3.postValue(byqDetailBean);
                    }
                });
        return liveData3;
    }
    public MediatorLiveData<SendEmailBean> liveData4=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getLiveData4(int commentId,int opinion){
        HttpUtils.getInstance()
                .getApiService()
                .opinion(SpUtils.getString("userId"),SpUtils.getString("sessionId"),commentId,opinion)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean byqDetailBean) throws Exception {
                        liveData4.postValue(byqDetailBean);
                    }
                });
        return liveData4;
    }
    public MediatorLiveData<SendEmailBean> liveData5=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getLiveData5(int sickId,String content){
        HttpUtils.getInstance()
                .getApiService()
                .sendpl(SpUtils.getString("userId"),SpUtils.getString("sessionId"),sickId,content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean byqDetailBean) throws Exception {
                        liveData4.postValue(byqDetailBean);
                    }
                });
        return liveData4;
    }

}
