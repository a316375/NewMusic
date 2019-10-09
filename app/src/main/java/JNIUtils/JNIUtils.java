package JNIUtils;

import android.util.Base64;

/**
 * Created by Administrator on 2017/3/27.
 */

public class JNIUtils {

    public static native String getStringFormA();
    public static native String getStringFormB();
    public static native String getStringFormC();
    public static native String getStringFormD();
    static {
        System.loadLibrary("app");//这里的b指的是libb这个so文件
    }

    public static  String getA(){
        return new String(Base64.decode(getStringFormA().getBytes(), Base64.DEFAULT));
    }
    public static  String getB(){
        return new String(Base64.decode(getStringFormB().getBytes(), Base64.DEFAULT));
    }
    public static  String getC(){
        return new String(Base64.decode(getStringFormC().getBytes(), Base64.DEFAULT));
    }
    public static  String getD(){
        return new String(Base64.decode(getStringFormD().getBytes(), Base64.DEFAULT));
    }

}
