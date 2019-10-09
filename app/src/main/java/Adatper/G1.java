package Adatper;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import Intentnet.SingleMusic;
import xyx.newmusic.R;

/**
 * Created by Administrator on 2017/3/24.
 */

public class G1 extends BaseAdapter{    private Context content;

    private ArrayList<SingleMusic> list = new ArrayList<SingleMusic>();

    public ArrayList<SingleMusic> getList() {
        return list;
    }

    public static String[] TAGADD = {"²", "³", "⁴"};
    public static String[] TAGDEL = {"½", "¼", "⅛"};
    public static String[] TAGMODE = {"a", "b", "c", "d"};

    public void setList(ArrayList<SingleMusic> list) {
        this.list = list;
    }

    public G1(Context content) {
        this.content = content;

    }

    public Context getContent() {
        return content;
    }

    public void setContent(Context content) {
        this.content = content;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final Hoder hoder;
        if (convertView == null) {
            hoder = new Hoder();
            convertView = View.inflate(getContent(), R.layout.pai, null);
            hoder.pai = (TextView) convertView.findViewById(R.id.pai);
            hoder.timetext = (TextView) convertView.findViewById(R.id.time);
            hoder.mode = (TextView) convertView.findViewById(R.id.mode);
            convertView.setTag(hoder);
        } else {
            hoder = (Hoder) convertView.getTag();
        }


        hoder.pai.setText(list.get(position).getTitle());
        if (list.get(position).getTime() > 0) {
            hoder.timetext.setText("" + TAGADD[list.get(position).getTime() - 1]);
        } else if (list.get(position).getTime() < 0) {
            hoder.timetext.setText("" + TAGDEL[-list.get(position).getTime() - 1]);
        } else {
            hoder.timetext.setText("");
        }
        hoder.mode.setText(TAGMODE[list.get(position).getMode()]);
        convertView.setOnClickListener(new OnClick(position, convertView));

        return convertView;
    }

    class Hoder {
        TextView pai, timetext, mode;
    }

    class OnClick implements View.OnClickListener {

        private final View convertView;
        private int position;

        public OnClick(int position, View convertView) {
            this.position = position;
            this.convertView = convertView;
        }

        @Override
        public void onClick(View v) {
            final int backgroundColor = convertView.getDrawingCacheBackgroundColor();
            convertView.setBackgroundColor(Color.parseColor("#11aaff"));
            PopupMenu menu = new PopupMenu(content, convertView);
            menu.getMenuInflater().inflate(R.menu.mpu, menu.getMenu());
            menu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                @Override
                public void onDismiss(PopupMenu menu) {
                    convertView.setBackgroundColor(backgroundColor);
                }
            });
            menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                @Override
                public boolean onMenuItemClick(MenuItem arg0) {

                    switch (arg0.getItemId()) {
                        case R.id.item1:
                            //扩拍
                            int addp = getList().get(position).getTime();
                            if (addp < 3) {
                                getList().get(position).setTime(addp + 1);
                                notifyDataSetChanged();
                            }
                            break;
                        case R.id.item2:
                            //缩拍
                            int delp = getList().get(position).getTime();
                            if (delp <= 3 && delp > -3) {
                                getList().get(position).setTime(delp - 1);
                                notifyDataSetChanged();
                            }
                            break;
                        case R.id.item3:
                            //沉音 +
                            int i = getList().get(position).getNum();
                            if (i <= 20 && i != -1) {
                                i += 7;
                                getList().get(position).setNum(i);
                                getList().get(position).setText(i);
                                notifyDataSetChanged();
                            }
                            break;
                        case R.id.item4:
                            //升音 -
                            int i2 = getList().get(position).getNum();
                            if (i2 >= 7 && i2 != -1) {
                                i2 -= 7;
                                getList().get(position).setNum(i2);
                                getList().get(position).setText(i2);
                                notifyDataSetChanged();
                            }
                            break;
                        case R.id.item5:
                            //休止
                            SingleMusic singleMusic = new SingleMusic(0, 0, -1);
                            singleMusic.setTitle("0");
                            getList().add(position + 1, singleMusic);
                            notifyDataSetChanged();
                            break;
                        case R.id.item6:
                            final Dialog dialog = new Dialog(content);
                            dialog.setTitle("添加音符");
                            View v = View.inflate(content, R.layout.add, null);

                            dialog.setContentView(v);
                            Button b1 = (Button) v.findViewById(R.id.bt1);
                            Button b2 = (Button) v.findViewById(R.id.bt2);
                            Button b3 = (Button) v.findViewById(R.id.bt3);
                            Button b4 = (Button) v.findViewById(R.id.bt4);
                            Button b5 = (Button) v.findViewById(R.id.bt5);
                            Button b6 = (Button) v.findViewById(R.id.bt6);
                            Button b7 = (Button) v.findViewById(R.id.bt7);
                            Button cancel = (Button) v.findViewById(R.id.cancel);
                            b1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    SingleMusic singleMusic = new SingleMusic(getList().get(position).getMode(), 0, 7);
                                    singleMusic.setTitle("1");
                                    getList().add(position + 1, singleMusic);
                                    notifyDataSetChanged();
                                    dialog.dismiss();
                                }
                            });
                            b2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    SingleMusic singleMusic = new SingleMusic(getList().get(position).getMode(), 0, 8);
                                    singleMusic.setTitle("2");
                                    getList().add(position + 1, singleMusic);
                                    notifyDataSetChanged();
                                    dialog.dismiss();
                                }
                            });
                            b3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    SingleMusic singleMusic = new SingleMusic(getList().get(position).getMode(), 0, 9);
                                    singleMusic.setTitle("3");
                                    getList().add(position + 1, singleMusic);
                                    notifyDataSetChanged();
                                    dialog.dismiss();
                                }
                            });
                            b4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    SingleMusic singleMusic = new SingleMusic(getList().get(position).getMode(), 0, 10);
                                    singleMusic.setTitle("4");
                                    getList().add(position + 1, singleMusic);
                                    notifyDataSetChanged();
                                    dialog.dismiss();
                                }
                            });
                            b5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    SingleMusic singleMusic = new SingleMusic(0, 0, 11);
                                    singleMusic.setTitle("5");
                                    getList().add(position + 1, singleMusic);
                                    notifyDataSetChanged();
                                    dialog.dismiss();
                                }
                            });
                            b6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    SingleMusic singleMusic = new SingleMusic(0, 0, 12);
                                    singleMusic.setTitle("6");
                                    getList().add(position + 1, singleMusic);
                                    notifyDataSetChanged();
                                    dialog.dismiss();
                                }
                            });
                            b7.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    SingleMusic singleMusic = new SingleMusic(0, 0, 13);
                                    singleMusic.setTitle("7");
                                    getList().add(position + 1, singleMusic);
                                    notifyDataSetChanged();
                                    dialog.dismiss();
                                }
                            });
                            cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();

                            break;
                        case R.id.item7:
                            getList().remove(position);
                            notifyDataSetChanged();
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            });


            menu.show();
        }
    }
}
