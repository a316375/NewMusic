package Adatper;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/25.
 */

public class Share {

    public static SharedPreferences NOAD(Context mcontext){
        return mcontext.getSharedPreferences("NOAD",
                Context.MODE_PRIVATE);// TODO 自动生成的方法存根
    }
    public static void saveNOAD(Context mcontext, int times){
        SharedPreferences sp = NOAD(mcontext);
        sp.edit().putInt("times",times).commit();
        //Toast.makeText(mcontext,"邀请码保存成功",Toast.LENGTH_LONG).show();
    }
    public static int  getNOAD(Context mcontext){
        return NOAD(mcontext).getInt("times",0);
        //Toast.makeText(mcontext,"邀请码保存成功",Toast.LENGTH_LONG).show();
    }




    public static SharedPreferences music(Context mcontext){
        return mcontext.getSharedPreferences("music",
                Context.MODE_PRIVATE);// TODO 自动生成的方法存根
    }


    public static SharedPreferences vip(Context mcontext){
        return mcontext.getSharedPreferences("vip",
                Context.MODE_PRIVATE);// TODO 自动生成的方法存根
    }

    //保存邀请码
    public static void saveVIP(Context mcontext,String str1,int i,String str2){
        SharedPreferences sp = vip(mcontext);
        sp.edit().putString("name",str1).commit();
        sp.edit().putInt("code",i).commit();
        sp.edit().putString("address",str2).commit();
       //Toast.makeText(mcontext,"邀请码保存成功",Toast.LENGTH_LONG).show();
    }

    public static ArrayList<String> getvipAll(Context mcontext) {
        SharedPreferences sp = vip(mcontext);
        Map<String, ?> all = sp.getAll();

        ArrayList<String> list=new ArrayList<>();
        Set<String> keys = all.keySet();

        for(String key :keys){
            list.add(key);
            //System.out.println(key+" "+all.get(key));
        }
        return list;
    }
    public static ArrayList<String> getmusicAll(Context mcontext) {
        SharedPreferences sp = music(mcontext);
        Map<String, ?> all = sp.getAll();

        ArrayList<String> list=new ArrayList<>();
        Set<String> keys = all.keySet();

        for(String key :keys){
             list.add(key);
            //System.out.println(key+" "+all.get(key));
        }
        return list;
    }
    public static void removemusic(Context context,String string){
        SharedPreferences sp=music(context);
        sp.edit().remove(string).commit();
    }

    public static String ReadVip(Context mcontext, String str){
        SharedPreferences sp=vip(mcontext);
       return sp.getString(str,null);

    }
    public static int ReadVipTime(Context mcontext,String str){
        SharedPreferences sp=vip(mcontext);
        return sp.getInt(str,0);

    }
    public static String ReadMusic(Context mcontext, String str){
        SharedPreferences sp=music(mcontext);
      return  sp.getString(str,null);
    }
}
