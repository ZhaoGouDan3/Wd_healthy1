package com.wd.wd_healthy.model.bean;

import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/10/6
 */
public class AppInfo {

    public String appName="";

    public String packageName="";

    public String versionName="";

    public int versionCode=0;

    public Drawable appIcon=null;

    public void print()

    {

        Log.v("app","Name:"+appName+" Package:"+packageName);

        Log.v("app","Name:"+appName+" versionName:"+versionName);

        Log.v("app","Name:"+appName+" versionCode:"+versionCode);

    }

}