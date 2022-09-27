package com.wd.wd_healthy.model.util;

import com.wd.wd_healthy.model.bean.BannerBean;
import com.wd.wd_healthy.model.bean.ByqBean;
import com.wd.wd_healthy.model.bean.ByqDetailBean;
import com.wd.wd_healthy.model.bean.BzBean;
import com.wd.wd_healthy.model.bean.BzDetailBean;
import com.wd.wd_healthy.model.bean.BzmessageBean;
import com.wd.wd_healthy.model.bean.CaiNaBean;
import com.wd.wd_healthy.model.bean.CategoryBean;
import com.wd.wd_healthy.model.bean.ColSickBean;
import com.wd.wd_healthy.model.bean.ColVideoBean;
import com.wd.wd_healthy.model.bean.ColZxBean;
import com.wd.wd_healthy.model.bean.DangAnBean;
import com.wd.wd_healthy.model.bean.DmBean;
import com.wd.wd_healthy.model.bean.DocDetailBean;
import com.wd.wd_healthy.model.bean.DocListBean;
import com.wd.wd_healthy.model.bean.GzBean;
import com.wd.wd_healthy.model.bean.KsBean;
import com.wd.wd_healthy.model.bean.LoginBean;
import com.wd.wd_healthy.model.bean.MyVideoBean;
import com.wd.wd_healthy.model.bean.PayHistoryBean;
import com.wd.wd_healthy.model.bean.QuanPingLieBean;
import com.wd.wd_healthy.model.bean.RmBean;
import com.wd.wd_healthy.model.bean.MyByqBean;
import com.wd.wd_healthy.model.bean.SendByqBean;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.bean.TabBean;
import com.wd.wd_healthy.model.bean.TodaySignBean;
import com.wd.wd_healthy.model.bean.TxBean;
import com.wd.wd_healthy.model.bean.VideoBean;
import com.wd.wd_healthy.model.bean.WallBean;
import com.wd.wd_healthy.model.bean.WenZhenBean;
import com.wd.wd_healthy.model.bean.YpBean;
import com.wd.wd_healthy.model.bean.YpDetailBean;
import com.wd.wd_healthy.model.bean.YpMessBean;
import com.wd.wd_healthy.model.bean.ZxBean;
import com.wd.wd_healthy.model.bean.ZxDetailBean;
import com.wd.wd_healthy.model.bean.ZxNowBean;

import java.io.File;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.util</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public interface ApiService {
    @GET("health/share/v1/bannersShow")
    Observable<BannerBean> getBanner();
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<KsBean> getKs();
    @GET("health/share/information/v1/findInformationPlateList")
    Observable<TabBean> getTab();
    @GET("health/share/information/v1/findInformationList")
    Observable<ZxBean> getZx(@Query("plateId") int plateId,@Query("page") int page,@Query("count") int count);
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<BzBean> getBz();
    @GET("health/share/knowledgeBase/v1/findDrugsCategoryList")
    Observable<YpBean> getYp();
    @GET("health/share/knowledgeBase/v1/findDiseaseCategory")
    Observable<BzmessageBean> getBzmess(@Query("departmentId") int id);
    @GET("health/share/knowledgeBase/v1/findDrugsKnowledgeList")
    Observable<YpMessBean> getYpMess(@Query("drugsCategoryId") int id,@Query("page") int page,@Query("count") int count);
    @GET("health/share/knowledgeBase/v1/findDiseaseKnowledge")
    Observable<BzDetailBean> getBzDetail(@Query("id") int id);
    @GET("health/share/knowledgeBase/v1/findDrugsKnowledge")
    Observable<YpDetailBean> getYpDetail(@Query("id") int id);
    @GET("health/share/information/v1/findInformation")
    Observable<ZxDetailBean> getzxDetail(@Query("infoId") int id);
    @GET("health/user/inquiry/v1/findDoctorList")
    Observable<DocListBean> getDocList(@Query("deptId") int deptId,@Query("condition") int condition,@Query("page") int page,@Query("count") int count);
    @GET("health/user/inquiry/v1/findDoctorInfo")
    Observable<DocDetailBean> getDocDetail(@Query("doctorId") int doctorId);
    @POST("health/user/v1/login")
    Observable<LoginBean> getLogin(@Query("email") String email,@Query("pwd") String pwd);
    @POST("health/user/v1/sendOutEmailCode")
    Observable<SendEmailBean> getEmaile(@Query("email") String email);
    @POST("health/user/v1/checkCode")
    Observable<SendEmailBean> getYz(@Query("email") String email,@Query("code") String code);
    @PUT("health/user/v1/resetUserPwd")
    Observable<SendEmailBean> getUpdate(@Query("email") String email,@Query("pwd1") String pwd1,@Query("pwd2") String pwd2);
    @POST("health/user/v1/register")
    Observable<SendEmailBean> getRegister(@Query("email") String email,@Query("code") String code,@Query("pwd1") String pwd1,@Query("pwd2")String pwd2);
    @GET("health/share/v1/popularSearch")
    Observable<RmBean> getRm();
    @GET("health/user/verify/v1/findUserArchives")
    Observable<DangAnBean> getDangAn(@Header("userId") String userId, @Header("sessionId")String sessionId);
    @DELETE("health/user/verify/v1/deleteUserArchives")
    Observable<SendEmailBean> getDelDangan(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("archivesId") int archivesId);


    @POST("health/user/verify/v1/addUserArchives")
    Observable<SendEmailBean> getTjDa(@Header("userId") String userId,
                               @Header("sessionId")String sessionId,
                               @Body Map<String,String> map
                               );

    @GET("health/user/verify/v1/findUserWallet")
    Observable<WallBean> getYe(@Header("userId") String userId, @Header("sessionId")String sessionId);
    @GET("health/user/verify/v1/findUserConsumptionRecordList")
    Observable<PayHistoryBean> Xfhistory(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") int page, @Query("count")int count);
    @GET("health/user/verify/v1/findUserInfoCollectionList")
    Observable<ColZxBean> myColList(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") int page, @Query("count")int count);
    @GET("health/user/verify/v1/findUserSickCollectionList")
    Observable<ColSickBean> myColSickList(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") int page, @Query("count")int count);
    @GET("health/user/verify/v1/findVideoCollectionList")
    Observable<ColVideoBean> myColVideoList(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") int page, @Query("count")int count);
    @DELETE("health/user/verify/v1/cancelSickCollection")
    Observable<SendEmailBean> deleteSickList(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("sickCircleId") int sickCircleId);
    @GET("health/user/verify/v1/findMyAdoptedCommentList")
    Observable<CaiNaBean> BCaiNa(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") int page, @Query("count")int count);
    @GET("health/user/verify/v1/findUserVideoBuyList")
    Observable<MyVideoBean> BroughtVideo(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") int page, @Query("count")int count);
    @GET("health/user/sickCircle/verify/v1/findMySickCircleList")
    Observable<MyByqBean> ScByq(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") int page, @Query("count")int count);
    @GET("health/user/verify/v1/findUserDoctorFollowList")
    Observable<GzBean> Gzdoc(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") int page, @Query("count")int count);

    @GET("health/user/verify/v1/whetherSignToday")
    Observable<TodaySignBean> getToday(@Header("userId") String userId, @Header("sessionId")String sessionId);

    @GET("health/user/verify/v1/findUserSign")
    Observable<TodaySignBean> getCoil(@Header("userId") String userId, @Header("sessionId")String sessionId);

    @PUT("health/user/verify/v1/updateUserPwd")
    Observable<SendEmailBean> updatePwd(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("oldPwd") String oldPwd,@Query("newPwd")String newPwd);

    @Multipart
    @POST("health/user/verify/v1/modifyHeadPic")
    Observable<TxBean> updateTx(@Header("userId") String userId, @Header("sessionId")String sessionId, @Part MultipartBody.Part file);

    @PUT("health/user/verify/v1/modifyNickName")
    Observable<SendEmailBean> upname(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("nickName")String nickName);
    @PUT("health/user/verify/v1/updateUserSex")
    Observable<SendEmailBean> upsexy(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("sex")int sex);

    @POST("health/user/verify/v1/bindUserIdCard")
    Observable<SendEmailBean> rna(@Header("userId") String userId, @Header("sessionId")String sessionId,@Body Map<String,Object> map);

    @GET("health/user/sickCircle/v1/findSickCircleList")
    Observable<ByqBean> byqlist(@Query("departmentId") int departmentId,@Query("page") int page,@Query("count") int count);
    @GET("health/user/sickCircle/v1/findSickCircleInfo")
    Observable<ByqDetailBean> bydetail(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("sickCircleId") int sickCircleId);
    @POST("health/user/verify/v1/addUserSickCollection")
    Observable<SendEmailBean> scbyq(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("sickCircleId")int sickCircleId);
    @DELETE("health/user/verify/v1/cancelSickCollection")
    Observable<SendEmailBean> qxbyq(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("sickCircleId")int sickCircleId);

    @GET("health/user/sickCircle/v1/findSickCircleCommentList")
    Observable<QuanPingLieBean> dplist(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("sickCircleId") int sickCircleId,@Query("page") int page,@Query("count") int count);

    @PUT("health/user/sickCircle/verify/v1/expressOpinion")
    Observable<SendEmailBean> opinion(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("commentId")int commentId,@Query("opinion") int opinion);

    @POST("health/user/sickCircle/verify/v1/publishComment")
    Observable<SendEmailBean> sendpl(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("sickCircleId")int sickCircleId,@Query("content") String content);
    @POST("health/user/sickCircle/verify/v1/publishSickCircle")
    Observable<SendByqBean> senbyq(@Header("userId") String userId, @Header("sessionId")String sessionId,@Body Map<String,Object> map);
    @PUT("health/user/inquiry/verify/v1/consultDoctor")
    Observable<ZxNowBean> zxnow(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("doctorId") int doctorId);

    @GET("health/user/inquiry/verify/v1/findCurrentInquiryRecord")
    Observable<WenZhenBean> wznow(@Header("userId") String userId, @Header("sessionId")String sessionId);
    @PUT("health/user/inquiry/verify/v1/endInquiry")
    Observable<SendEmailBean> endInquiry(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("recordId") int recordId);

    @GET("health/user/video/v1/findVideoCategoryList")
    Observable<CategoryBean> getCateGory();
    @GET("health/user/video/v1/findVideoVoList")
    Observable<VideoBean> getVideoList(@Query("categoryId") int categoryId,@Query("page") int page,@Query("count") int count);

    @Multipart
    @POST("health/user/verify/v1/uploadArchivesPicture")
    Observable<SendEmailBean> sendDt(@Header("userId") String userId, @Header("sessionId")String sessionId,@Part List<MultipartBody.Part> file);

    @POST("health/user/video/verify/v1/addVideoComment")
    Observable<SendEmailBean> sendDm(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("videoId") int videoId,@Query("content") String content);
    @POST("health/user/video/verify/v1/addUserVideoCollection")
    Observable<SendEmailBean> scVd(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("videoId") int videoId);
    @DELETE("health/user/verify/v1/cancelVideoCollection")
    Observable<SendEmailBean> deleteVd(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("videoId") int videoId);

    @GET("health/user/video/v1/findVideoCommentList")
    Observable<DmBean> getDm(@Query("videoId") int videoId);
}
