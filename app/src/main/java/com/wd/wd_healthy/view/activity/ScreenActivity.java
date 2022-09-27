package com.wd.wd_healthy.view.activity;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.wd_healthy.R;

public class ScreenActivity extends AppCompatActivity {

    private SeekBar seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        initView();
        seek.setMax(255);
        int screenBrightness = getScreenBrightness(ScreenActivity.this);
//        setAppScreenBrightness(screenBrightness/255);
        seek.setProgress(screenBrightness/255);
        allowModifySettings();
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ModifySettingsScreenBrightness(ScreenActivity.this,progress*255);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    //全部app
    private static final int REQUEST_CODE_WRITE_SETTINGS = 1000;

    private void allowModifySettings() {
        // Settings.System.canWrite(MainActivity.this)
        // 检测是否拥有写入系统 Settings 的权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(ScreenActivity.this)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this,
                        android.R.style.Theme_Material_Light_Dialog_Alert);
                builder.setTitle("请开启修改屏幕亮度权限");
                builder.setMessage("请点击允许开启");
                // 拒绝, 无法修改
                builder.setNegativeButton("拒绝",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ScreenActivity.this,
                                        "您已拒绝修系统Setting的屏幕亮度权限", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                builder.setPositiveButton("去开启",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 打开允许修改Setting 权限的界面
                                Intent intent = new Intent(
                                        Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri
                                        .parse("package:"
                                                + getPackageName()));
                                startActivityForResult(intent,
                                        REQUEST_CODE_WRITE_SETTINGS);
                            }
                        });
                builder.setCancelable(false);
                builder.show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_WRITE_SETTINGS) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // Settings.System.canWrite方法检测授权结果
                if (Settings.System.canWrite(getApplicationContext())) {
                    // 5.调用修改Settings屏幕亮度的方法 屏幕亮度值 200
                    ModifySettingsScreenBrightness(ScreenActivity.this, 200);
                    Toast.makeText(this, "系统屏幕亮度值" + getScreenBrightness(this),
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ScreenActivity.this, "您已拒绝修系统Setting的屏幕亮度权限",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    public void setScreenManualMode(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int mode = Settings.System.getInt(contentResolver,
                    Settings.System.SCREEN_BRIGHTNESS_MODE);
            if (mode == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC) {
                Settings.System.putInt(contentResolver,
                        Settings.System.SCREEN_BRIGHTNESS_MODE,
                        Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void ModifySettingsScreenBrightness(Context context,
                                                int birghtessValue) {
        // 首先需要设置为手动调节屏幕亮度模式
        setScreenManualMode(context);

        ContentResolver contentResolver = context.getContentResolver();
        Settings.System.putInt(contentResolver,
                Settings.System.SCREEN_BRIGHTNESS, birghtessValue);
    }

    //当前app
    private int getScreenBrightness(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        int defVal = 125;
        return Settings.System.getInt(contentResolver,
                Settings.System.SCREEN_BRIGHTNESS, defVal);
    }
    private void setAppScreenBrightness(int birghtessValue) {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.screenBrightness = birghtessValue / 255.0f;
        window.setAttributes(lp);
    }
    private void initView() {
        seek = (SeekBar) findViewById(R.id.seek);
    }
}