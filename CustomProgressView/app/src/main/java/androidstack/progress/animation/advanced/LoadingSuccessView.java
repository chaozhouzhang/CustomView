package androidstack.progress.animation.advanced;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created on 2020/8/18 07:01
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class LoadingSuccessView extends View {
    private Path mDstPath;
    private Path mCirclePath;

    public LoadingSuccessView(Context context) {
        this(context, null);
    }

    public LoadingSuccessView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingSuccessView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private void init() {
        mDstPath = new Path();
        mCirclePath = new Path();
        mCirclePath.addCircle(getWidth()/2,getHeight()/2, dip2px(getContext(),10), Path.Direction.CW);

    }

}
