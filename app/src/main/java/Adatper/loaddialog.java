package Adatper;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import Intentnet.SingleMusic;
import xyx.newmusic.R;

/**
 * Created by Administrator on 2017/3/25.
 */

public class loaddialog extends RecyclerView.Adapter<loaddialog.ViewHolder> {
    Context mContext;

    ArrayList list;
    G1 g1;
    Dialog dialog;
    public loaddialog(Context mContext, Dialog dialog, G1 g1) {
        this.mContext = mContext;
        this.dialog=dialog;
        this.g1=g1;
        list = Share.getmusicAll(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.loaditem, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder   viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                dialog.dismiss();

                final Dialog dialog = new AlertDialog.Builder(v.getContext())

                        .setTitle("确定删除？")
                        .setMessage("确定删除"+list.get(position).toString()+"吗?")
                        .setPositiveButton("删除",
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface arg0,
                                                        int arg1) {
                                      Share.removemusic(v.getContext(),list.get(position).toString());
                                    }
                                })
                        .setNegativeButton("取消",
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface arg0,
                                                        int arg1) {
                                          arg0.dismiss();
                                    }
                                }).create();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.show();

            }
        });
        //holder.button.setText(Share.ReadMusic(mContext,list.get(position).toString()));
        holder.button.setText(list.get(position).toString());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=Share.ReadMusic(mContext,list.get(position).toString());


                ArrayList<SingleMusic> lists = new ArrayList<SingleMusic>();
                List<SingleMusic> list = Util.gson.fromJson(str, new TypeToken<List<SingleMusic>>() {
                }.getType());

                for (int i = 0; i < list.size(); i++) {
                    SingleMusic music = new SingleMusic(list.get(i).getMode(), list.get(i).getTime(), list.get(i).getNum());
                    music.setTitle(list.get(i).getTitle());
                    lists.add(music);
                }
                g1.setList(lists);
                g1.notifyDataSetChanged();

                dialog.dismiss();
                //Toast.makeText(holder.button.getContext(),""+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public  Button button,button2;
        // each data item is just a string in this case
        public ViewHolder(View v) {
            super(v);
            button = ( Button) v.findViewById(R.id.textView2);
            button2 = ( Button) v.findViewById(R.id.del

            );
        }
    }
}

//    //*
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        TextView textView = new TextView(mContext);
//        //textView.setText("ssdfdsf"+position+Share.ReadMusic(mContext,list.get(position).toString()));
//        if (Util.isJson(Share.ReadMusic(mContext, list.get(position).toString()))) {
//            textView.setText("-->" + position + list.get(position).toString());
//        } else {
//            Share.music(mContext).edit().remove(list.get(position).toString()).commit();
//        }
//        return textView;
//    }

