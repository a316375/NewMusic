package xyx.newmusic;

import android.app.Activity;
import android.content.Intent;

import Adatper.Share;
import Adatper.Util;

/**
 * Created by Administrator on 2017/3/27.
 */

public class AT {
    public static void load(Activity activity,Intent intent){
        intent = new Intent(Util.string3);
        intent.putExtra("name", Share.ReadVip(activity.getApplicationContext(), "name"));
        activity.startActivity(intent);
        activity.finish();
    }
}
