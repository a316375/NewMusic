package Intentnet;

/**
 * Created by Administrator on 2017/3/24.
 */

public class SingleMusic {


    /**
     * 轻重 默认0
     **/
    private int mode;
    /**
     * 时长 默认0  分别有-3  -2  -1  0  1  2  3 共7种
     **/
    private int time;
    /**
     * 数字 0-27
     **/
    private int num;
    /**
     * 显示的文字
     **/
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(int position) {

        if ((position % 28) / 7 == 3) setTitle("↓\n↓\n" + (position % 7 + 1));
        if ((position % 28) / 7 == 1) setTitle("" + (position % 7 + 1));
        if ((position % 28) / 7 == 2) setTitle("↓\n" + (position % 7 + 1));
        if ((position % 28) / 7 == 0) setTitle((position % 7 + 1) + "\n↑");

    }

    public SingleMusic(int mode, int time, int num) {
        this.mode = mode;
        this.time = time;
        this.num = num;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "SingleMusic{" +
                "mode=" + mode +
                ", time=" + time +
                ", num=" + num +
                '\'' +
                '}';
    }
}