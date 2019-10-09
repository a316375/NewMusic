package xyx.newmusic;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

//import net.youmi.android.AdManager;
//import net.youmi.android.normal.spot.SpotManager;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Adatper.G1;
import Adatper.GBT;
import Adatper.GSETTING;
import Adatper.MusicThread;
import Adatper.Play;
import Adatper.Share;
import Intentnet.SingleMusic;
import Adatper.Util;
import Adatper.VP;
import Adatper.loaddialog;
import xyx.newmusic.Bean;
import xyx.newmusic.CT;
import xyx.newmusic.R;

/**主界面*/
public class BT extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    ArrayList<SingleMusic> savelist;
    Context mContext;
    private static HashMap<Integer, Integer> Map;
    private static SoundPool soundPool;
    GridView gv1;
    G1 g1;
    public static long time = 250;

    ExecutorService service;//单个线程池
    MusicThread musicThread;

    //ad
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent=getIntent();
        final String string = intent.getStringExtra("name");
        mContext = this;
        // 设定调整音量为媒体音量,当暂停播放的时候调整音量就不会再默认调整铃声音量了，
        ((Activity) this).setVolumeControlStream(AudioManager.STREAM_MUSIC);
        Map = new HashMap<Integer, Integer>();
        soundPool = new SoundPool(28, AudioManager.STREAM_MUSIC, 0);
        Map.put(0, soundPool.load(this, R.raw.b41, 1));
        Map.put(1, soundPool.load(this, R.raw.a42, 1));
        Map.put(2, soundPool.load(this, R.raw.c43, 1));
        Map.put(3, soundPool.load(this, R.raw.a44, 1));
        Map.put(4, soundPool.load(this, R.raw.a45, 1));
        Map.put(5, soundPool.load(this, R.raw.b46, 1));
        Map.put(6, soundPool.load(this, R.raw.a47, 1));
        Map.put(7, soundPool.load(this, R.raw.a31, 1));
        Map.put(8, soundPool.load(this, R.raw.b32, 1));
        Map.put(9, soundPool.load(this, R.raw.a33, 1));
        Map.put(10, soundPool.load(this, R.raw.a34, 1));
        Map.put(11, soundPool.load(this, R.raw.a35, 1));
        Map.put(12, soundPool.load(this, R.raw.a36, 1));
        Map.put(13, soundPool.load(this, R.raw.a37, 1));
        Map.put(14, soundPool.load(this, R.raw.a21, 1));
        Map.put(15, soundPool.load(this, R.raw.b22, 1));
        Map.put(16, soundPool.load(this, R.raw.c23, 1));
        Map.put(17, soundPool.load(this, R.raw.a24, 1));
        Map.put(18, soundPool.load(this, R.raw.a25, 1));
        Map.put(19, soundPool.load(this, R.raw.a26, 1));
        Map.put(20, soundPool.load(this, R.raw.a27, 1));
        Map.put(21, soundPool.load(this, R.raw.a11, 1));
        Map.put(22, soundPool.load(this, R.raw.b12, 1));
        Map.put(23, soundPool.load(this, R.raw.a13, 1));
        Map.put(24, soundPool.load(this, R.raw.b14, 1));
        Map.put(25, soundPool.load(this, R.raw.a15, 1));
        Map.put(26, soundPool.load(this, R.raw.a16, 1));
        Map.put(27, soundPool.load(this, R.raw.a17, 1));


        gv1 = (GridView) findViewById(R.id.g1);
        g1 = new G1(this);
        gv1.setAdapter(g1);

        GridView gv3 = (GridView) findViewById(R.id.g3);
        Play play = Play.CreatSingle();
        play.setMap(Map);
        play.setSoundPool(soundPool);
        GBT gbt = new GBT(g1, play);
        gv3.setAdapter(gbt);

        GridView gv2 = (GridView) findViewById(R.id.g2);
        GSETTING gsetting = new GSETTING(this, gbt);
        gv2.setAdapter(gsetting);
        service = Executors.newSingleThreadExecutor();
        musicThread = new MusicThread(play, g1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //AdManager.getInstance(mContext).init(Util.string1, Util.string2, false, false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这段是AD版的,百度审核不通过,那就搞个限制版
//                musicThread.setFag(true);
//                service.execute(musicThread);
//                if (string==null) {
//                    if (Util.ad % 5 == 0) {
//                        Bean.show(mContext);
//                    } else {
//                        if (Util.ad > 1000) Util.ad = 1;
//                        Util.ad++;
//                    }
//                }



                //限制版
                if (string!=null) {
                    musicThread.setFag(true);
                    service.execute(musicThread);}
                else{
                  //Share.saveNOAD(mContext,Share.getNOAD(mContext)+1);//don't save
                    if(Share.getNOAD(mContext)<90){
                        musicThread.setFag(true);
                        service.execute(musicThread);
                    }else{
                        Share.saveNOAD(mContext,0);//初始化数据
                        musicThread.setFag(true);
                        service.execute(musicThread);
                        Toast.makeText(mContext,"支持作者开发",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    protected void onRestart() {
        super.onRestart();
        if (savelist!=null){
            g1.setList(savelist);
            g1.notifyDataSetChanged();
        }
    }

    @Override
    protected void onPause() {
        savelist=new ArrayList<SingleMusic>();
        savelist=g1.getList();
        g1.setList(new ArrayList<SingleMusic>());
        g1.notifyDataSetChanged();
        super.onPause();
        // 插屏广告
       // Bean.onPause(mContext);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 插屏广告
       // Bean.onStop(mContext);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 插屏广告
       // Bean.onDestroy(mContext);
    }


    @Override
    public void onBackPressed() {
        // 点击后退关闭插屏广告
//        if (Bean.aBoolean(mContext)) {
//            SpotManager.getInstance(mContext).hideSpot();
//        } else {

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(this, CT.class));
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            int diswidth = getBaseContext().getResources().getDisplayMetrics().widthPixels;
            int disheight = getBaseContext().getResources().getDisplayMetrics().heightPixels;
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.load);
            dialog.getWindow().setLayout(diswidth, disheight * 9 / 10);
             RecyclerView lv = (RecyclerView) dialog.findViewById(R.id.lv);
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            lv.setHasFixedSize(true);
            // use a linear layout manager
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            lv.setLayoutManager(mLayoutManager);

            lv.setAdapter(new loaddialog(this,dialog,g1));
            dialog.show();
            ((Button)dialog.findViewById(R.id.b1)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"敬请期待",Toast.LENGTH_LONG).show();
                }
            });
            ((Button)dialog.findViewById(R.id.b2)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     dialog.dismiss();
                }
            });

        } else if (id == R.id.nav_slideshow) {
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

            View child=View.inflate(mContext,R.layout.viewpager,null);
            ViewPager vp= (ViewPager) child.findViewById(R.id.vp);
            vp.setAdapter(new VP(this,dialog));
            dialog.setContentView(child);
            dialog.show();


        }  else if (id == R.id.nav_send) {
            PackageManager pm = this.getPackageManager();
            String appName = getApplicationInfo().loadLabel(pm).toString();

            final Dialog dialog = new AlertDialog.Builder(mContext)
                    .setTitle(appName+"v"+getVersionName(mContext))
                    .setMessage("开发者邮箱:\n201418920@qq.com")
                    .create();
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    //版本名
    public static String getVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }

    //版本号
    public static int getVersionCode(Context context) {
        return getPackageInfo(context).versionCode;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;

        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pi;
    }
}
