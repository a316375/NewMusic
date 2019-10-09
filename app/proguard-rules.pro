# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\AS2017\SDK/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#-ignorewarning


-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-optimizationpasses 5


# Okio# OkHttp3
-dontwarn com.squareup.**
-keep public class org.codehaus.* { *; }
-keep public class java.nio.* { *; }
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature
# For using GSON @Expose annotation
-keepattributes *Annotation*
# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson
-keep class Intentnet.android.model.** { *; }
-keep class Intentnet.** { *; }
##---------------End: proguard configuration for Gson  ----------


-keep class android.support.** { *; }



# The remainder of this file is identical to the non-optimized version

# of the Proguard configuration file (except that the other file has

# flags to turn off optimization).

#-libraryjars jniLibs/armeabi/libapp.so

# -libraryjars libs/arm64-v8a/libapp.so

# -libraryjars libs/armeabi-v7a/libapp.so

# -libraryjars libs/x86/libapp.so

# -libraryjars libs/x86_64/libapp.so

# -libraryjars libs/mips/libapp.so

# -libraryjars libs/mips64/libapp.so





# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native

-keepclasseswithmembernames class * {

   native <methods>;

}

##################### 不混淆 #####################


# 这些类不混淆
-keep class com.shockwave.**


 -keep public class com.google.android.gms.ads.** {
    public *;
 }

 -keep public class com.google.ads.** {
    public *;
 }
-keep class com.android.vending.billing.**{
public *;
}

-dontwarn com.google.ads.**
-keep public class com.google.ads.**{
	public protected *;
}
