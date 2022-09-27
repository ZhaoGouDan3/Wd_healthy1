package com.wd.wd_healthy.model.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model</p>
 *
 * @author 赵某某
 * @date 2022/9/9
 */
public abstract class BaseActivity<VM extends ViewModel,DBD extends ViewDataBinding> extends AppCompatActivity implements Observer {
    public VM viewModel;
    public DBD binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,initlayout());
        init();
        initData();
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

}
