package Adatper;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import xyx.newmusic.BT;
import Intentnet.SingleMusic;
import xyx.newmusic.R;

/**
 * Created by Administrator on 2017/3/24.
 */

public class GSETTING extends BaseAdapter {

    private Context context;

    private String[] str = {"平静", "清空", "60拍", "导入", "回退"};

    public Context getContext() {
        return context;
    }

    private GBT gbt;

    public GSETTING(Context context, GBT gbt) {
        this.context = context;
        this.gbt = gbt;
    }

    @Override
    public int getCount() {
        return 5;
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
        final Button bt = new Button(context);
        bt.setText(str[position]);
        bt.setTextSize(12);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {

                    PopupMenu menu = new PopupMenu(context, v);
                    menu.getMenuInflater().inflate(R.menu.mtheme, menu.getMenu());

                    menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                        @Override
                        public boolean onMenuItemClick(MenuItem arg0) {

                            switch (arg0.getItemId()) {
                                case R.id.item1:
                                    gbt.getPlay().setState(0);
                                    bt.setText("愉快");
                                    break;
                                case R.id.item2:
                                    gbt.getPlay().setState(1);
                                    bt.setText("平静");
                                    break;
                                case R.id.item3:
                                    gbt.getPlay().setState(2);
                                    bt.setText("严肃");
                                    break;
                                case R.id.item4:
                                    gbt.getPlay().setState(3);
                                    bt.setText("深沉");
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });


                    menu.show();
                }
                if (position == 1) {
                    gbt.g1.getList().clear();
                    ;
                    gbt.g1.notifyDataSetChanged();
                }
                if (position == 2) {
                    PopupMenu menu = new PopupMenu(context, v);
                    menu.getMenuInflater().inflate(R.menu.mpuset, menu.getMenu());

                    menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                        @Override
                        public boolean onMenuItemClick(MenuItem arg0) {

                            switch (arg0.getItemId()) {
                                case R.id.item1:

                                    BT.time = 125;
                                    bt.setText("30拍");
                                    break;
                                case R.id.item2:
                                    BT.time = 250;
                                    bt.setText("60拍");
                                    break;
                                case R.id.item3:
                                    BT.time = 375;
                                    bt.setText("90拍");
                                    break;
                                case R.id.item4:
                                    BT.time = 500;
                                    bt.setText("120拍");
                                    break;
                                case R.id.item5:
                                    BT.time = 625;
                                    bt.setText("150拍");
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });


                    menu.show();
                }
                if (position == 3) {
                    ;

                    final String string = Util.gson.toJson(gbt.g1.getList());
                    System.out.println(string);
                    final PopupMenu menu = new PopupMenu(context, v);
                    menu.getMenuInflater().inflate(R.menu.mload, menu.getMenu());

                    menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                        @Override
                        public boolean onMenuItemClick(MenuItem arg0) {

                            switch (arg0.getItemId()) {
                                case R.id.item1:
                                    ArrayList<SingleMusic> lists = new ArrayList<SingleMusic>();
                                    List<SingleMusic> list = Util.gson.fromJson(Util.str, new TypeToken<List<SingleMusic>>() {
                                    }.getType());

                                    for (int i = 0; i < list.size(); i++) {
                                        SingleMusic music = new SingleMusic(list.get(i).getMode(), list.get(i).getTime(), list.get(i).getNum());
                                        music.setTitle(list.get(i).getTitle());
                                        lists.add(music);
                                    }
                                    gbt.g1.setList(lists);
                                    gbt.g1.notifyDataSetChanged();

                                    break;
                                case R.id.item2:
                                    lists = new ArrayList<SingleMusic>();
                                    list = Util.gson.fromJson(Util.str2, new TypeToken<List<SingleMusic>>() {
                                    }.getType());

                                    for (int i = 0; i < list.size(); i++) {
                                        SingleMusic music = new SingleMusic(list.get(i).getMode(), list.get(i).getTime(), list.get(i).getNum());
                                        music.setTitle(list.get(i).getTitle());
                                        lists.add(music);
                                    }
                                    gbt.g1.setList(lists);
                                    gbt.g1.notifyDataSetChanged();

                                    break;

                                case R.id.item3:
                                    final SharedPreferences sp = context.getSharedPreferences("music",
                                            Context.MODE_PRIVATE);// TODO 自动生成的方法存根
                                    final Dialog dialog = new Dialog(context);
                                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                    dialog.setContentView(R.layout.save);
                                    final EditText editText = (EditText) dialog.findViewById(R.id.et);
                                    Button b1 = (Button) dialog.findViewById(R.id.save);
                                    b1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (editText.length() != 0) {
                                                String s=editText.getText().toString();
                                                sp.edit().putString(s, string).commit();// 提交数据
                                                Toast.makeText(context,"保存成功",Toast.LENGTH_LONG).show();
                                                dialog.dismiss();
                                            }

                                        }
                                    });
                                    Button b2 = (Button) dialog.findViewById(R.id.save2);
                                    b2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog.dismiss();
                                        }
                                    });

                                    dialog.show();
                                    break;

                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    menu.show();

                }
                if (position == 4) {
                    int i = gbt.g1.getList().size() - 1;
                    if (i >= 0) gbt.g1.getList().remove(i);
                    gbt.g1.notifyDataSetChanged();
                }

            }
        });


        return bt;
    }
}
