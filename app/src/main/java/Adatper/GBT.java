package Adatper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import Intentnet.SingleMusic;

/**
 * Created by Administrator on 2017/3/24.
 */

public class GBT extends BaseAdapter {
    G1 g1;
    public Play play;
    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public GBT(G1 g1,Play p) {
        this.g1=g1; this.play=p;
    }

    public G1 getG1() {
        return g1;
    }

    public void setG1(G1 g1) {
        this.g1 = g1;
    }

    @Override

    public int getCount() {
        return 28;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button bt=new Button(g1.getContent());
        bt.setText(""+(position%7+1));

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getPlay().play(position);

                SingleMusic singleMusic = new SingleMusic(getPlay().getState(), 0, position);
                try{

                    if ((position%28)/7==3)singleMusic.setTitle("↓\n↓\n"+(position%7+1));
                    if ((position%28)/7==1)singleMusic.setTitle(""+(position%7+1));
                    if ((position%28)/7==2)singleMusic.setTitle("↓\n"+(position%7+1));
                    if ((position%28)/7==0)singleMusic.setTitle((position%7+1)+"\n↑");
                }finally {
                    g1.getList().add(singleMusic);
                    g1.notifyDataSetChanged();
                }

            }
        });
        return bt;
    }
}
