package com.wd.wd_healthy.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.wd.wd_healthy.model.bean.CategoryBean;
import com.wd.wd_healthy.model.bean.DmBean;
import com.wd.wd_healthy.model.bean.KsBean;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.bean.VideoBean;
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
 * @date 2022/9/24
 */
public class VideoViewModel extends ViewModel {
    public MediatorLiveData<CategoryBean> kslivedata=new MediatorLiveData<>();
    public MediatorLiveData<CategoryBean> getKslivedata(){
        HttpUtils.getInstance().getApiService()
                .getCateGory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CategoryBean>() {
                    @Override
                    public void accept(CategoryBean bannerBean) throws Exception {
                        kslivedata.postValue(bannerBean);
                    }
                });
        return kslivedata;
    }
    public MediatorLiveData<VideoBean> videolivedata=new MediatorLiveData<>();
    public MediatorLiveData<VideoBean> getVideolivedata(int categoryId,int page,int count){
        HttpUtils.getInstance().getApiService()
                .getVideoList(categoryId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VideoBean>() {
                    @Override
                    public void accept(VideoBean bannerBean) throws Exception {
                        videolivedata.postValue(bannerBean);
                    }
                });
        return videolivedata;
    }
    public MediatorLiveData<SendEmailBean> sendDmData=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getSendDmData(int videoId,String content){
        HttpUtils.getInstance().getApiService()
                .sendDm(SpUtils.getString("userId"),SpUtils.getString("sessionId"),videoId,content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean bannerBean) throws Exception {
                        sendDmData.postValue(bannerBean);
                    }
                });
        return sendDmData;
    }
    public MediatorLiveData<SendEmailBean> deleteVd=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getDeleteVd(int videoId){
        HttpUtils.getInstance().getApiService()
                .deleteVd(SpUtils.getString("userId"),SpUtils.getString("sessionId"),videoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean bannerBean) throws Exception {
                        deleteVd.postValue(bannerBean);
                    }
                });
        return deleteVd;
    }
    public MediatorLiveData<SendEmailBean> scVd=new MediatorLiveData<>();
    public MediatorLiveData<SendEmailBean> getScVd(int videoId){
        HttpUtils.getInstance().getApiService()
                .scVd(SpUtils.getString("userId"),SpUtils.getString("sessionId"),videoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendEmailBean>() {
                    @Override
                    public void accept(SendEmailBean bannerBean) throws Exception {
                        deleteVd.postValue(bannerBean);
                    }
                });
        return scVd;
    }
    public MediatorLiveData<DmBean> dm=new MediatorLiveData<>();
    public MediatorLiveData<DmBean> getDm(int videoId){
        HttpUtils.getInstance().getApiService()
                .getDm(videoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DmBean>() {
                    @Override
                    public void accept(DmBean bannerBean) throws Exception {
                        dm.postValue(bannerBean);
                    }
                });
        return dm;
    }

}
