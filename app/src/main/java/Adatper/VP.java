package Adatper;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;

import xyx.newmusic.R;

/**
 * Created by Administrator on 2017/3/27.
 */

public class VP extends PagerAdapter {
    Context mContext;
    Dialog dialog;
    int[] ints;

    public VP(Context mContext, Dialog dialog) {
        this.mContext = mContext;
        this.dialog = dialog;
        ints = new int[]{R.drawable.ma, R.drawable.mb};
    }

    @Override
    public int getCount() {
        return ints.length;
    }

    /**
     * 以最省内存的方式读取本地资源的图片
     *
     * @param context
     * @param resId
     * @return
     */
    public static Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        //获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        // TODO 自动生成的方法存根

        final ImageView imageView = new ImageView(mContext);
        Bitmap bit = readBitMap(mContext, ints[position]);
        imageView.setImageBitmap(bit);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        //imageView.setOnTouchListener(new ontou());// 图片滑动的监听
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dialog.dismiss();
                return false;
            }
        });
        return imageView;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
