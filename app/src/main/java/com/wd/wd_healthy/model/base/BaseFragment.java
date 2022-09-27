package com.wd.wd_healthy.model.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.shuyu.gsyvideoplayer.GSYVideoManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model</p>
 *
 * @author 赵某某
 * @date 2022/9/9
 */
public abstract class BaseFragment<VM extends ViewModel,DBD extends ViewDataBinding> extends Fragment implements Observer {
    public VM viewModel;
    public DBD binding;
    protected boolean isInit = false;
    protected boolean isLoad = false;
    protected final String TAG = "LazyLoadFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,initlayout(),null,false);
        init();
        isInit = true;
        /**初始化的时候去加载数据**/
        isCanLoadData();
        return binding.getRoot();
    }

    private void init() {
        if(viewModel==null){
            Class cls=null;
            Type type = getClass().getGenericSuperclass();
            if(type instanceof ParameterizedType){
                cls= (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            }else{
                cls=getClass();
            }
            viewModel= (VM) ViewModelProviders.of(this).get(cls);
        }
    }

    public abstract  int initlayout();
    public abstract void initData();
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    /**
     * 是否可以加载数据
     * 可以加载数据的条件：
     * 1.视图已经初始化
     * 2.视图对用户可见
     */
    private void isCanLoadData() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            initData();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }

    /**
     * 视图销毁的时候讲Fragment是否初始化的状态变为false
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;

    }

    protected void showToast(String message) {
        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }

    }




    /**
     * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以覆写此方法
     */
    protected void stopLoad() {

    }
}
