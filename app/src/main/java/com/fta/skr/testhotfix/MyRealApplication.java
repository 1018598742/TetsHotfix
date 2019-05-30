package com.fta.skr.testhotfix;

import android.app.Application;

import com.taobao.sophix.SophixManager;

/**
 * Created by fta
 * on 2019/4/25
 */
public class MyRealApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SophixManager.getInstance().queryAndLoadNewPatch();
    }
}
