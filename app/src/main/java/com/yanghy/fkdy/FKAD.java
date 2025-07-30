package com.yanghy.fkdy;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class FKAD implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!"com.ss.android.ugc.aweme.lite".equals(lpparam.packageName)
                && !"com.ss.android.ugc.aweme".equals(lpparam.packageName)) {
            return;
        }

        tools.log("Loaded " + lpparam.packageName);
        Hook.hook(lpparam);
    }
}
