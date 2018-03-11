package com.atguigu.im;

import android.app.Application;
import android.content.Context;

import com.atguigu.im.model.Model;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;

/**
 * Created by Administrator on 2016/9/23.
 */
public class IMApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化EaseUI
        EMOptions options = new EMOptions();
        options.setAcceptInvitationAlways(false);// 设置需要同意后才能接受邀请
        options.setAutoAcceptGroupInvitation(false);// 设置需要同意后才能接受群邀请

        EaseUI.getInstance().init(this,options);

        // 初始化数据模型层类
        Model.getInstance().init(this);

        // 初始化全局上下文对象
        mContext = this;
    }

    // 获取全局上下文对象
    public static Context getGlobalApplication(){
        return mContext;
    }
}
