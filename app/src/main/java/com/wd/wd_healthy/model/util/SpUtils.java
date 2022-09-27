package com.wd.wd_healthy.model.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.util</p>
 *
 * @author 赵某某
 * @date 2022/9/9
 */
public class SpUtils {
    private static SharedPreferences sp;

    public static void initSP(Context context){
        if(sp==null){
            sp=context.getSharedPreferences("first",Context.MODE_PRIVATE);
        }
    }
    public static void putInt(String key,int value){
        sp.edit().putInt(key, value).commit();
    }
    public static int getInt(String key){
        return sp.getInt(key,0);
    }
    public static void putString(String key,String value){
        sp.edit().putString(key, value).commit();
    }
    public static String getString(String key){
        return sp.getString(key,"");
    }
    public static void putBoolean(String key,boolean value){
        sp.edit().putBoolean(key, value).commit();
    }
    public static boolean getBoolean(String key){
        return sp.getBoolean(key,false);
    }
    public static void clear(){
        sp.edit().clear().commit();
    }
}
