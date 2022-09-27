package com.wd.wd_healthy.model.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.util</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public class HttpUtils {
    private ApiService apiService;

    public ApiService getApiService() {
        return apiService;
    }
    private static HttpUtils httpUtils=null;

    private HttpUtils(){
        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000,TimeUnit.MILLISECONDS)
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://wq.bwstudent.com:7999/")
                .client(client)
                .build();
        apiService=retrofit.create(ApiService.class);
    }
    public static HttpUtils getInstance(){
        if(httpUtils==null){
            synchronized (HttpUtils.class){
                if(httpUtils==null){
                    httpUtils=new HttpUtils();
                }
            }
        }
        return httpUtils;
    }
}
