package com.fta.skr.testhotfix.util;

import android.content.Context;

import com.alipay.euler.andfix.AndFixManager;
import com.alipay.euler.andfix.patch.PatchManager;

/**
 * Created by fta
 * on 2019/4/24
 */
public class AndFixPatchManager {

    private static AndFixPatchManager mInstance = null;
    private static PatchManager mPatchManager = null;

    public static AndFixPatchManager getInstance() {
        if (mInstance == null) {
            synchronized (AndFixManager.class) {
                if (mInstance == null) {
                    mInstance = new AndFixPatchManager();
                }
            }

        }
        return mInstance;
    }

    /**
     * 初始化
     *
     * @param context
     */
    public void init(Context context) {
        mPatchManager = new PatchManager(context);
        mPatchManager.init(AppUtils.getVersionName(context));
        mPatchManager.loadPatch();
    }

    /**
     * 加载拆分包
     *
     * @param path
     */
    public void addPatch(String path) {
        try {
            if (mPatchManager != null) {
                mPatchManager.addPatch(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
