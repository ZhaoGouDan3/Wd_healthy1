package com.wd.wd_healthy.model.util;

import android.os.CountDownTimer;
import android.widget.Button;

public class TimerUtils extends CountDownTimer {

    private Button btn;


    public TimerUtils(long millisInFuture, long countDownInterval, Button btn) {
        super(millisInFuture, countDownInterval);
        this.btn=btn;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        btn.setEnabled(false);
        btn.setText("还剩下"+millisUntilFinished/1000+"s后可重新发送验证码");
    }

    @Override
    public void onFinish() {
        btn.setEnabled(true);
        btn.setText("重新发送验证码");
    }
}
