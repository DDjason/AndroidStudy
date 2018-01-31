package com.jason.firework.study.base

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2018/1/30$ 10:26$
 * <p/>Description: 主Application Kotlin 极简单例方式
 */
class MyApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        initBasic()
    }
    private fun initBasic(){
        initArouter()
    }

    private fun initArouter(){
        Log.i("MyApplication","init ARouter")
        ARouter.openDebug()
        ARouter.openLog()
        ARouter.init(this)
    }

    private fun initLogger(){
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}