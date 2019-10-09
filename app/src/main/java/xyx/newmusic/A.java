package xyx.newmusic;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import Adatper.Share;
import Adatper.Util;
import Image.SmartImageView;
import Image.WebImageCache;
import Intentnet.VIP;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2017/3/25.
 */

public class A extends Activity implements RewardedVideoAdListener {
    private Handler handler = new Handler();
    private SmartImageView view;
    private String string;
    private Intent intent;

    private RewardedVideoAd mRewardedVideoAd;
    private Button button;
    private ProgressBar progressBar;
    private TextView textView;
    int point = 0;

    private int TIME = 1500;  //每隔1s执行一次.
    Handler mHandler = new Handler();
     ImageView imageView ;
      int[] images = {R.drawable.homeb, R.drawable.homeb01, R.drawable.homeb02};
    Runnable runnable = new Runnable() {
        @Override

        public void run() {
            try {
                mHandler.postDelayed(this, TIME);
                imageView.setImageDrawable(getResources().getDrawable(images[point]));
                point += 1;
                if (point == 3) {
                    point = 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a);

        setAD();//设置广告
        imageView = (ImageView) findViewById(R.id.homeb);
        www();//访问官网

        view = (SmartImageView) findViewById(R.id.myImage);
        view.setImageUrl(Share.ReadVip(getApplicationContext(), "address"));

        //Toast.makeText(this,JNIUtils.getA()+"\n"+JNIUtils.getB()+"\n"+JNIUtils.getC()+"\n"+JNIUtils.getD(),Toast.LENGTH_LONG).show();
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        final int code = c.get(Calendar.YEAR) * 1000 + c.get(Calendar.MONTH) * 100 + c.get(Calendar.DATE);
        if (Share.ReadVip(getApplicationContext(), "address") != null) {
            if (code - Share.ReadVipTime(getApplicationContext(), "code") > 5) {
                new WebImageCache(this).clear();
                final long time1 = System.currentTimeMillis();
                OkHttpClient mHttpClient = new OkHttpClient();
                final Request request = new Request.Builder().url(Util.string).build();
                mHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result = response.body().string();
                        if (Util.isJson(result)) {
                            List<VIP> pare = VIP.pare(result);
                            for (int i = 0; i < pare.size(); i++) {
                                if (pare.get(i).getName().toString().equals(Share.ReadVip(getApplicationContext(), "name"))) {
                                    Share.saveVIP(getApplicationContext(), pare.get(i).getName(), code, pare.get(i).getAddress());
                                    break;
                                }
                            }
                        }
                    }
                });

            }

        }


        button = (Button) this.findViewById(R.id.home_bt);
        button.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }
            }
        });

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.text);

        //start();

        //设置图片变化
        ChangImage();


    }

    private void www() {
        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("https://www.lanlitong.com");
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }

    private void ChangImage() {


        mHandler.postDelayed(runnable, TIME); // 在初始化方法里.





    }

    private void setAD() {
//ca-app-pub-3940256099942544~3347511713 <<<<test
        MobileAds.initialize(this, "ca-app-pub-7420611722821229~8927274232");
        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
    }

    private void loadRewardedVideoAd() {
        //ca-app-pub-7420611722821229/2361865884  test==ca-app-pub-3940256099942544/5224354917  ca-app-pub-7420611722821229/4886907124  .addTestDevice("E2782288774296B6BE310FCA507A4867")
        mRewardedVideoAd.loadAd("ca-app-pub-7420611722821229/2361865884",
                new AdRequest.Builder().build());
    }

    private void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    AT.load(A.this, intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    public void onRewardedVideoAdLoaded() {
        button.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        // Load the next rewarded video ad.
        loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Toast.makeText(A.this, "獎勵使用次數+" + rewardItem.getAmount(), Toast.LENGTH_SHORT).show();
        if (rewardItem.getAmount() == 1) {
            start();
        }
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        Toast.makeText(A.this, "抱歉，請求失敗，3秒後重新請求" + i, Toast.LENGTH_SHORT).show();

        try {
            sleep(3000);
            // Load the next rewarded video ad.
            loadRewardedVideoAd();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRewardedVideoCompleted() {
        Toast.makeText(A.this, "播放完成，即將進入主界面", Toast.LENGTH_SHORT).show();
        start();
    }


    @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }
}
