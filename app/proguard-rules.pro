-keep class de.robv.android.xposed.** { *; }

# 基本保护规则
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

# 保留注解
-keepattributes *Annotation*

# 保留行号信息，方便调试
-keepattributes SourceFile,LineNumberTable

# 保留泛型信息
-keepattributes Signature

# 保护MainActivity不被混淆
-keep public class * extends androidx.appcompat.app.AppCompatActivity


# 保护 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# 保护 Serializable 不被混淆
-keepnames class * implements java.io.Serializable
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# 保护 R 文件不被混淆
-keepclassmembers class **.R$* {
    public static <fields>;
}

# 保护资源文件不被混淆
-keepclassmembers class **.R {
    public static <fields>;
}

# 保护JNI方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

# 保护回调方法不被混淆
-keepclassmembers class * extends androidx.appcompat.app.AppCompatActivity {
    public void *(android.view.View);
}

# 保护枚举不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 保护AndroidX相关类
-keep class androidx.** {*;}
-dontwarn androidx.**

# 保护Material相关类
-keep class com.google.android.material.** {*;}
-dontwarn com.google.android.material.**

# 保护可能通过反射访问的类和方法
-keep class com.yanghy.fkdy.FKAD

# 保护Xposed相关API
-keepclassmembers class de.robv.android.xposed.** {
    *;
}

# 保护Navigation组件
-keep class androidx.navigation.** {*;}
-dontwarn androidx.navigation.**
