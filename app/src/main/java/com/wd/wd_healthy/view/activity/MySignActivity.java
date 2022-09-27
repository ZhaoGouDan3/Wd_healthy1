package com.wd.wd_healthy.view.activity;

import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.MysignactivityBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.StepBean;
import com.wd.wd_healthy.model.bean.TodaySignBean;
import com.wd.wd_healthy.model.util.SignListReq;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.MySignViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.activity</p>
 *
 * @author 赵某某
 * @date 2022/9/19
 */
public class MySignActivity extends BaseActivity<MySignViewModel, MysignactivityBinding> {
    private ArrayList<StepBean> mStepBeans = new ArrayList<>();
    @Override
    public int initlayout() {
        return R.layout.mysignactivity;
    }

    @Override
    public void initData() {

        initi();
        binding.rlOval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestSuccessData();
            }
        });
        viewModel.getLiveData1().observe(this,this);




    }

    private void initi() {
        //初始化模拟请求后台数据
        String reponse = "{\n" +
                "    \"datas\": {\n" +
                "        \"day\": 2,\n" +
                "        \"myPoint\": 10886,\n" +
                "        \"signLog\": {\n" +
                "            \"content\": \"每日签到\",\n" +
                "            \"createTime\": \"2019-05-28 09:31:02\",\n" +
                "            \"familyId\": \"0\",\n" +
                "            \"id\": \"951656\",\n" +
                "            \"integral\": \"9\",\n" +
                "            \"logType\": \"3\",\n" +
                "            \"orderId\": \"0\",\n" +
                "            \"type\": \"1\",\n" +
                "            \"userId\": \"43431\"\n" +
                "        },\n" +
                "        \"signState\": true,\n" +
                "        \"userSingninList\": [\n" +
                "            {\n" +
                "                \"createTime\": \"2019-05-27 18:04:15\",\n" +
                "                \"day\": \"1\",\n" +
                "                \"familyId\": \"0\",\n" +
                "                \"id\": \"278904\",\n" +
                "                \"seriesDay\": \"1\",\n" +
                "                \"type\": \"0\",\n" +
                "                \"userId\": \"43431\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"createTime\": \"2019-05-28 09:31:02\",\n" +
                "                \"day\": \"2\",\n" +
                "                \"familyId\": \"0\",\n" +
                "                \"id\": \"278905\",\n" +
                "                \"seriesDay\": \"2\",\n" +
                "                \"type\": \"0\",\n" +
                "                \"userId\": \"43431\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"msg\": \"success!\",\n" +
                "    \"ret\": 0\n" +
                "}";

        //解析后台请求数据
        SignListReq signListReq = new Gson().fromJson(reponse, SignListReq.class);
        if (signListReq.getRet() == 0) {
            setSignData(signListReq.getDatas());
        }
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof TodaySignBean){
            TodaySignBean bean= (TodaySignBean) o;
            if(bean.getMessage().equals("查询成功")){


            }
        }
    }
    private void requestSuccessData() {
        mStepBeans.clear();//清空初始化数据
        String reponse = "{\n" +
                "    \"datas\": {\n" +
                "        \"day\": 3,\n" +
                "        \"myPoint\": 10890,\n" +
                "        \"signLog\": {\n" +
                "            \"content\": \"每日签到\",\n" +
                "            \"createTime\": \"2019-05-29 09:42:05\",\n" +
                "            \"familyId\": \"0\",\n" +
                "            \"id\": \"951660\",\n" +
                "            \"integral\": \"4\",\n" +
                "            \"logType\": \"3\",\n" +
                "            \"orderId\": \"0\",\n" +
                "            \"type\": \"1\",\n" +
                "            \"userId\": \"43431\"\n" +
                "        },\n" +
                "        \"signState\": true,\n" +
                "        \"userSingninList\": [\n" +
                "            {\n" +
                "                \"createTime\": \"2019-05-27 18:04:15\",\n" +
                "                \"day\": \"1\",\n" +
                "                \"familyId\": \"0\",\n" +
                "                \"id\": \"278904\",\n" +
                "                \"seriesDay\": \"1\",\n" +
                "                \"type\": \"0\",\n" +
                "                \"userId\": \"43431\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"createTime\": \"2019-05-28 09:31:02\",\n" +
                "                \"day\": \"2\",\n" +
                "                \"familyId\": \"0\",\n" +
                "                \"id\": \"278905\",\n" +
                "                \"seriesDay\": \"2\",\n" +
                "                \"type\": \"0\",\n" +
                "                \"userId\": \"43431\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"createTime\": \"2019-05-29 09:42:05\",\n" +
                "                \"day\": \"3\",\n" +
                "                \"familyId\": \"0\",\n" +
                "                \"id\": \"278907\",\n" +
                "                \"seriesDay\": \"3\",\n" +
                "                \"type\": \"0\",\n" +
                "                \"userId\": \"43431\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"msg\": \"success!\",\n" +
                "    \"ret\": 0\n" +
                "}";

        //解析后台请求数据
        SignListReq signListReq = new Gson().fromJson(reponse, SignListReq.class);
        if (signListReq.getRet() == 0) {
            binding.rlOval.setBackgroundResource(R.drawable.lianxusign_bg);
            binding.textSign.setText("已签到");
            binding.textLianxusign.setVisibility(View.VISIBLE);
            binding.textLianxusign.setText("连续" + signListReq.getDatas().getDay() + "天");

            setSignData(signListReq.getDatas());
        }

    }
    private void setSignData(SignListReq.DatasBean datas) {

        //处理已签到的数据
        //先添加已签到的日期到集合中
        if (datas.getUserSingninList().size() != 0) {
            for (int i = 0; i < datas.getUserSingninList().size(); i++) {
                //时间格式：2019-05-27 18:04:15
                String createTime = datas.getUserSingninList().get(i).getCreateTime();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d1 = null;
                try {
                    d1 = df.parse(createTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String timeString = df.format(d1);
                //获取日期的月、日
                String[] timeList = timeString.split(" ");
                String[] split = timeList[0].split("-");
                String month = split[1];//月
                String day = split[2];//日

                //判断是否需要显示积分图标，number表示-- 0为不显示积分，非0为显示积分
                if (datas.getSignLog() != null && datas.getUserSingninList().get(i).getCreateTime().equals(datas.getSignLog().getCreateTime())) {
                    mStepBeans.add(new StepBean(StepBean.STEP_COMPLETED, Integer.parseInt(datas.getSignLog().getIntegral()), month + "." + day));
                } else {
                    mStepBeans.add(new StepBean(StepBean.STEP_COMPLETED, 0, month + "." + day));
                }
            }
        }

        //添加未签到的数据，填充为最近一周数据
        if (mStepBeans.size() < 7) {

            //获取当前时间的月日
            Calendar now = Calendar.getInstance();
            int currentMonth = now.get(Calendar.MONTH) + 1;//当月
            int currentDay = now.get(Calendar.DAY_OF_MONTH);//当天
            String currentTime = setData(currentMonth) + "." + setData(currentDay);

            //后台有签到集合数据
            if (datas.getUserSingninList().size() != 0) {
                String createTime = datas.getUserSingninList().get(datas.getUserSingninList().size() - 1).getCreateTime();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d1 = null;
                try {
                    d1 = df.parse(createTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String timeString = df.format(d1);
                String[] timeList = timeString.split(" ");
                String[] split = timeList[0].split("-");
                String month = split[1];//月
                String day = split[2];//日

                for (int i = mStepBeans.size(); i < 7; i++) {
                    int parseInt = Integer.parseInt(day) + i - 1;
                    //判断累积的天数是否超过当月的总天数
                    if (parseInt <= getDayOfMonth()) {
                        String time = setData(Integer.parseInt(month)) + "." + setData(parseInt);
                        if (currentTime.equals(time)) {
                            mStepBeans.add(new StepBean(StepBean.STEP_CURRENT, 0, time));
                        } else {
                            mStepBeans.add(new StepBean(StepBean.STEP_UNDO, 0, time));
                        }
                    } else {
                        String time = setData((Integer.parseInt(month) + 1)) + "." + setData(parseInt - getDayOfMonth());
                        if (currentTime.equals(time)) {
                            mStepBeans.add(new StepBean(StepBean.STEP_CURRENT, 0, time));
                        } else {
                            mStepBeans.add(new StepBean(StepBean.STEP_UNDO, 0, time));
                        }
                    }
                }
            } else {//后台没有签到集合数据，没有的话从当天时间开始添加未来一周的日期数据
                for (int i = 0; i < 7; i++) {
                    int parseInt = currentDay + i;
                    //判断累积的天数是否超过当月的总天数
                    if (parseInt <= getDayOfMonth()) {
                        String time = setData(currentMonth) + "." + setData(parseInt);
                        if (currentTime.equals(time)) {
                            mStepBeans.add(new StepBean(StepBean.STEP_CURRENT, 0, time));
                        } else {
                            mStepBeans.add(new StepBean(StepBean.STEP_UNDO, 0, time));
                        }
                    } else {
                        String time = setData((currentMonth + 1)) + "." + setData(parseInt - getDayOfMonth());
                        if (currentTime.equals(time)) {
                            mStepBeans.add(new StepBean(StepBean.STEP_CURRENT, 0, time));
                        } else {
                            mStepBeans.add(new StepBean(StepBean.STEP_UNDO, 0, time));
                        }
                    }
                }
            }
        }

        binding.stepView.setStepNum(mStepBeans);
    }

    /**
     * 获取最大天数
     *
     * @return
     */
    public int getDayOfMonth() {
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        return day;
    }

    /**
     * 日月份处理
     *
     * @param day
     * @return
     */
    public String setData(int day) {
        String time = "";
        if (day < 10) {
            time = "0" + day;
        } else {
            time = "" + day;
        }

        return time;
    }

}
