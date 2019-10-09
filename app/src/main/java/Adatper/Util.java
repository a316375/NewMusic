package Adatper;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import JNIUtils.JNIUtils;
import xyx.newmusic.R;

/**
 * Created by Administrator on 2017/3/24.
 */

public class Util {
    public static int ad = 0;

    public static String string(Context context) {
        return  context.getResources().getString(R.string.app_name);
    }

    public static String string = JNIUtils.getA();
    public static String string1 = JNIUtils.getB();
    public static String string2 = JNIUtils.getC();
    public static String string3 = JNIUtils.getD();
    public static Gson gson = new Gson();
    public static String str = "[{\"mode\":1,\"num\":16,\"time\":0,\"title\":\"↓\\n3\"},{\"mode\":1,\"num\":18,\"time\":1,\"title\":\"↓\\n5\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":7,\"time\":1,\"title\":\"1\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":7,\"time\":0,\"title\":\"1\"},{\"mode\":1,\"num\":18,\"time\":0,\"title\":\"↓\\n5\"},{\"mode\":1,\"num\":11,\"time\":1,\"title\":\"5\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":9,\"time\":0,\"title\":\"3\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":8,\"time\":2,\"title\":\"2\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":9,\"time\":0,\"title\":\"3\"},{\"mode\":1,\"num\":20,\"time\":0,\"title\":\"↓\\n7\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":18,\"time\":1,\"title\":\"↓\\n5\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":7,\"time\":0,\"title\":\"1\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":16,\"time\":0,\"title\":\"↓\\n3\"},{\"mode\":1,\"num\":7,\"time\":0,\"title\":\"1\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":18,\"time\":0,\"title\":\"↓\\n5\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":7,\"time\":0,\"title\":\"1\"},{\"mode\":1,\"num\":18,\"time\":2,\"title\":\"↓\\n5\"},{\"mode\":1,\"num\":9,\"time\":1,\"title\":\"3\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":20,\"time\":0,\"title\":\"↓\\n7\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":7,\"time\":0,\"title\":\"1\"},{\"mode\":1,\"num\":18,\"time\":0,\"title\":\"↓\\n5\"},{\"mode\":1,\"num\":16,\"time\":0,\"title\":\"↓\\n3\"},{\"mode\":1,\"num\":18,\"time\":0,\"title\":\"↓\\n5\"},{\"mode\":0,\"num\":-1,\"time\":0,\"title\":\"0\"},{\"mode\":1,\"num\":16,\"time\":0,\"title\":\"↓\\n3\"},{\"mode\":1,\"num\":18,\"time\":0,\"title\":\"↓\\n5\"},{\"mode\":1,\"num\":16,\"time\":0,\"title\":\"↓\\n3\"},{\"mode\":0,\"num\":18,\"time\":1,\"title\":\"↓\\n5\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":20,\"time\":0,\"title\":\"↓\\n7\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":19,\"time\":1,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":18,\"time\":0,\"title\":\"↓\\n5\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":7,\"time\":1,\"title\":\"1\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":9,\"time\":0,\"title\":\"3\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":9,\"time\":0,\"title\":\"3\"},{\"mode\":1,\"num\":7,\"time\":0,\"title\":\"1\"},{\"mode\":1,\"num\":19,\"time\":1,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":7,\"time\":0,\"title\":\"1\"},{\"mode\":1,\"num\":18,\"time\":0,\"title\":\"↓\\n5\"},{\"mode\":0,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":16,\"time\":0,\"title\":\"↓\\n3\"},{\"mode\":1,\"num\":7,\"time\":0,\"title\":\"1\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":7,\"time\":0,\"title\":\"1\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":18,\"time\":0,\"title\":\"↓\\n5\"},{\"mode\":1,\"num\":16,\"time\":0,\"title\":\"↓\\n3\"},{\"mode\":1,\"num\":18,\"time\":0,\"title\":\"↓\\n5\"},{\"mode\":1,\"num\":19,\"time\":0,\"title\":\"↓\\n6\"},{\"mode\":1,\"num\":7,\"time\":0,\"title\":\"1\"},{\"mode\":1,\"num\":18,\"time\":1,\"title\":\"↓\\n5\"}]";
    public static String str2 = " [{\"mode\":1,\"num\":1,\"time\":0,\"title\":\"2\\n↑\"},{\"mode\":1,\"num\":1,\"time\":0,\"title\":\"2\\n↑\"},{\"mode\":1,\"num\":1,\"time\":0,\"title\":\"2\\n↑\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":12,\"time\":2,\"title\":\"6\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":11,\"time\":2,\"title\":\"5\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":9,\"time\":2,\"title\":\"3\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":9,\"time\":0,\"title\":\"3\"},{\"mode\":1,\"num\":9,\"time\":0,\"title\":\"3\"},{\"mode\":1,\"num\":8,\"time\":2,\"title\":\"2\"},{\"mode\":1,\"num\":7,\"time\":0,\"title\":\"1\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":9,\"time\":1,\"title\":\"3\"},{\"mode\":1,\"num\":9,\"time\":0,\"title\":\"3\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":9,\"time\":1,\"title\":\"3\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":9,\"time\":1,\"title\":\"3\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":9,\"time\":0,\"title\":\"3\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":9,\"time\":0,\"title\":\"3\"},{\"mode\":1,\"num\":11,\"time\":1,\"title\":\"5\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":11,\"time\":1,\"title\":\"5\"},{\"mode\":1,\"num\":9,\"time\":0,\"title\":\"3\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":1,\"time\":0,\"title\":\"2\\n↑\"},{\"mode\":1,\"num\":2,\"time\":0,\"title\":\"3\\n↑\"},{\"mode\":1,\"num\":1,\"time\":0,\"title\":\"2\\n↑\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":1,\"time\":0,\"title\":\"2\\n↑\"},{\"mode\":1,\"num\":1,\"time\":0,\"title\":\"2\\n↑\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":8,\"time\":0,\"title\":\"2\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":0,\"time\":0,\"title\":\"1\\n↑\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":12,\"time\":0,\"title\":\"6\"},{\"mode\":1,\"num\":11,\"time\":0,\"title\":\"5\"}]";


    public static boolean isJson(String json) {

        try {
            JSONArray jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}

