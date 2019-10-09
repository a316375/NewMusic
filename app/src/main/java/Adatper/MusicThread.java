package Adatper;


import xyx.newmusic.BT;

/**
 * Created by Administrator on 2017/3/17.
 */
public class MusicThread extends Thread {
    private  boolean Fag =true;
    private  Play play;
    private  G1 g1;

    public MusicThread(Play play, G1 g1) {
        this.play = play;
        this.g1 = g1;
    }

    public boolean isFag() {
        return Fag;
    }

    public void setFag(boolean fag) {
        this.Fag = fag;
    }

    @Override
    public void run() {

        while (Fag){
            for (int i=0;i<g1.getList().size();i++) {

                {
                    switch (g1.getList().get(i).getMode()){
                        case 0:
                            //第五个参数设置,0.5-2; 2越快,0.5越慢
                            if (g1.getList().get(i).getNum()!=-1)
                            play.getSoundPool().play(play.getMap().get(g1.getList().get(i).getNum()),1,1,0,0,2f);
                            break;
                        case 1:
                            if (g1.getList().get(i).getNum()!=-1)
                            play.getSoundPool().play(play.getMap().get(g1.getList().get(i).getNum()),1,1,0,0,1f);
                            break;
                        case 2:
                            if (g1.getList().get(i).getNum()!=-1)
                            //第五个参数设置,0.5-2; 2越快,0.5越慢
                            play.getSoundPool().play(play.getMap().get(g1.getList().get(i).getNum()),1,1,0,0,0.8f);
                            break;
                        case 3:
                            if (g1.getList().get(i).getNum()!=-1)
                            //第五个参数设置,0.5-2; 2越快,0.5越慢
                            play.getSoundPool().play(play.getMap().get(g1.getList().get(i).getNum()),1,1,0,0,0.6f);
                            break;
                    }

                }

                try {
                    switch (g1.getList().get(i).getTime()){
                        case -3:
                            Thread.sleep(BT.time/8);break;
                        case -2:
                            Thread.sleep(BT.time/4);break;
                        case -1:
                            Thread.sleep(BT.time/2); break;
                        case 0: Thread.sleep(BT.time);break;
                        case 1: Thread.sleep(BT.time*2);break;
                        case 2: Thread.sleep(BT.time*4);break;
                        case 3: Thread.sleep(BT.time*8);break;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            setFag(false);
        }

    }
}
