package androidstack.customview.animation.view.tween;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import androidstack.customview.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/12 17:43
 * pivot：枢轴 中心点
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class ScaleAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_animation);
        mIvTest = findViewById(R.id.iv_test);
        mIvTest.setOnClickListener(this);
    }


    private void codeAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f,0.5f,1.5f,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setFillBefore(false);
        scaleAnimation.setFillEnabled(false);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        mIvTest.startAnimation(scaleAnimation);
    }

    private void xmlAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_test);
        mIvTest.startAnimation(animation);
    }

    /**
     * <scale xmlns:android="http://schemas.android.com/apk/res/android"
     * android:duration="1000"
     * android:fillAfter="true"
     * android:fillBefore="false"
     * android:fillEnabled="false"
     * android:fromXScale="1.5"
     * android:fromYScale="1.5"
     * android:interpolator="@android:anim/accelerate_interpolator"
     * android:pivotX="50%"
     * android:pivotY="50%"
     * android:repeatCount="infinite"
     * android:repeatMode="reverse"
     * android:toXScale="0.5"
     * android:toYScale="0.5">
     * </scale>
     * 完成一次动画的持续时间，单位毫秒
     * 动画结束后，停留在结束时的状态
     * 动画结束后，回到开始前的状态
     * 动画结束后，回到开始前的状态
     * 动画开始时空间在X轴相对自身的缩放比例
     * 动画开始时空间在Y轴相对自身的缩放比例
     * 插值器：指定动画效果
     * 缩放起始点X轴坐标：以当前控件的左上角为原点加上：数值、百分数（自身宽度的百分数）、百分数p（父控件宽度的百分数）
     * 缩放起始点Y轴坐标：以当前控件的左上角为原点加上：数值、百分数（自身高度的百分数）、百分数p（父控件高度的百分数）
     * 重复次数：infinite为无限循环
     * 重复模式：reverse为倒序回放；restart为重放，且必须与repeatCount一起使用
     * 动画结束时空间在X轴相对自身的缩放比例
     * 动画结束时空间在Y轴相对自身的缩放比例
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_test:
                codeAnimation();
//                xmlAnimation();
                break;
            default:
                break;
        }
    }




}
