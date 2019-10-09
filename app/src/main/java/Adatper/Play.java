package Adatper;

import android.media.SoundPool;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/3/24.
 */

public class Play {

    public static int State=1;

    public static int getState() {
        return State;
    }

    public static void setState(int state) {
        State = state;
    }

    private static HashMap<Integer, Integer> Map;
    private static SoundPool soundPool;

    public static HashMap<Integer, Integer> getMap() {
        return Map;
    }

    public static void setMap(HashMap<Integer, Integer> map) {
        Map = map;
    }

    public static SoundPool getSoundPool() {
        return soundPool;
    }

    public static void setSoundPool(SoundPool soundPool) {
        Play.soundPool = soundPool;
    }

    private static Play play=new Play();
    private Play(){}
    public static Play CreatSingle(){
        return play;
    }


    public static void play(int position){
        switch (State){
            case 0:
                //第五个参数设置,0.5-2; 2越快,0.5越慢
                soundPool.play(getMap().get(position),1,1,0,0,2f);
                break;
            case 1:
                soundPool.play(getMap().get(position),1,1,0,0,1f);
                break;
            case 2:
                //第五个参数设置,0.5-2; 2越快,0.5越慢
                soundPool.play(getMap().get(position),1,1,0,0,0.8f);
                break;
            case 3:
                //第五个参数设置,0.5-2; 2越快,0.5越慢
                soundPool.play(getMap().get(position),1,1,0,0,0.6f);
                break;
        }

    }


}
