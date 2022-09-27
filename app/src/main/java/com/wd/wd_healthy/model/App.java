package com.wd.wd_healthy.model;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wd.wd_healthy.model.util.SpUtils;

import cn.jpush.im.android.api.JMessageClient;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model</p>
 *
 * @author 赵某某
 * @date 2022/9/9
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SpUtils.initSP(this);
        JMessageClient.setDebugMode(false);
        JMessageClient.init(this);
        ARouter.init(this);
    }
}
