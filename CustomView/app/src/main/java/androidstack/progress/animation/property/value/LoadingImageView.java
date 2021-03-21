package androidstack.progress.animation.property.value;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;

import androidstack.progress.R;
import androidstack.progress.animation.interpolator.ReverseInterpolator;

/**
 * Created on 2020/8/14 20:29
 * 自定义加载ImageView
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class LoadingImageView extends androidx.appcompat.widget.AppCompatImageView {
    private int mTop;
    private int mCurrRepeatCount = 0;
    private int mImageCount = 3;

    public LoadingImageView(Context context) {
        this(context, null);
    }

    public LoadingImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100, 0);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(new ReverseInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int dy = (int) animation.getAnimatedValue();
                /**
                 * 监听动画取值，根据取值改变空间的位置
                 */
                setTop(mTop - dy);
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                setImageDrawable(getResources().getDrawable(R.mipmap.ic_test));

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                /**
                 * 通过对动画的重复次数的监听，改变空间的图片资源
                 */
                mCurrRepeatCount++;
                switch (mCurrRepeatCount % mImageCount) {
                    case 0:
                        setImageDrawable(getResources().getDrawable(R.mipmap.ic_test));
                        break;
                    case 1:
                        setImageDrawable(getResources().getDrawable(R.mipmap.ic_loading));
                        break;
                    case 2:
                        setImageDrawable(getResources().getDrawable(R.mipmap.ic_scanner));
                        break;
                    default:
                        break;
                }
            }
        });
        valueAnimator.start();

    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        /**
         * 获取初始top
         */
        mTop = top;
    }
}
