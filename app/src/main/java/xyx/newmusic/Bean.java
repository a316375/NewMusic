package xyx.newmusic;

import android.content.Context;
import android.widget.Toast;

//import net.youmi.android.normal.common.ErrorCode;
//import net.youmi.android.normal.spot.SpotListener;
//import net.youmi.android.normal.spot.SpotManager;
//import net.youmi.android.normal.video.VideoAdManager;

import Adatper.Util;

/**
 * Created by Administrator on 2017/3/24.
 */
public   class Bean {}
//public   class Bean {
//
//    public static void  show(final Context mContext){
//
////        // 设置服务器回调 userId，一定要在请求广告之前设置，否则无效
////        VideoAdManager.getInstance(mContext).setUserId("d410a6d456cd17c4");
////        // 请求视频广告
////        VideoAdManager.getInstance(mContext).requestVideoAd(mContext);
//
//        SpotManager.getInstance(mContext).setImageType(SpotManager.IMAGE_TYPE_VERTICAL);
//        SpotManager.getInstance(mContext).setAnimationType(SpotManager.ANIMATION_TYPE_ADVANCED);
//        {
//            // 展示插屏广告
//            SpotManager.getInstance(mContext).showSpot(mContext, new SpotListener() {
//
//                @Override
//                public void onShowSuccess() {
//                    //mytoast(mContext,"插屏展示成功");
//                    Util.ad++;
//                }
//
//                @Override
//                public void onShowFailed(int errorCode) {
//                    //mytoast(mContext,"插屏展示失败");
//                    switch (errorCode) {
//                        case ErrorCode.NON_NETWORK:
//                           // mytoast(mContext,"网络异常");
//                            break;
//                        case ErrorCode.NON_AD:
//                           // mytoast(mContext,"暂无插屏广告");
//                            break;
//                        case ErrorCode.RESOURCE_NOT_READY:
//                            //mytoast(mContext,"插屏资源还没准备好");
//                            break;
//                        case ErrorCode.SHOW_INTERVAL_LIMITED:
//                           // mytoast(mContext,"请勿频繁展示");
//                            break;
//                        case ErrorCode.WIDGET_NOT_IN_VISIBILITY_STATE:
//                            //mytoast(mContext,"请设置插屏为可见状态");
//                            break;
//                        default:
//                           // mytoast(mContext,"请稍后再试");
//                            break;
//                    }
//
//
//                }
//
//                @Override
//                public void onSpotClosed() {
//                    //mytoast(mContext,"插屏被关闭");
//                }
//
//                @Override
//                public void onSpotClicked(boolean isWebPage) {
//                   // mytoast(mContext,"插屏被点击");
//                    // mytoast("是否是网页广告？%s", isWebPage ? "是" : "不是");
//                }
//            });
//        }
//    }
//
//    private static void mytoast(Context mContext, String str){
//        Toast.makeText(mContext,str, Toast.LENGTH_LONG).show();
//    }
//    public static boolean aBoolean(Context mContext){
//        return SpotManager.getInstance(mContext).isSpotShowing();
//    }
//
//    public static void onPause(Context mContext){
//        // 插屏广告
//        SpotManager.getInstance(mContext).onPause();
//    }
//    public static void onStop(Context mContext){
//        // 插屏广告
//        SpotManager.getInstance(mContext).onStop();
//    }
//    public static void onDestroy(Context mContext){
//        // 插屏广告
//        SpotManager.getInstance(mContext).onDestroy();
//    }
//}
