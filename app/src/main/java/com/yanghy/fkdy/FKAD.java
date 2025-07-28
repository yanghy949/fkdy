package com.yanghy.fkdy;

import android.os.Handler;
import android.os.Looper;

import java.lang.reflect.Method;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XC_MethodHook;

public class FKAD implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!"com.ss.android.ugc.aweme.lite".equals(lpparam.packageName)  && !"com.ss.android.ugc.aweme".equals(lpparam.packageName)) return;
        ADTool.log("FKAD: Loaded TikTok Lite");

        try {
            ADTool.hookAdActivity(lpparam);
        } catch (Throwable e) {
            ADTool.log("FKAD: Error during hook: " + e.getMessage());
            ADTool.log(String.valueOf(e));
        }
    }
}