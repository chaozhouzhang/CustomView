package androidstack.progress.animation.view.tween;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import androidstack.progress.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/12 18:06
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class SetAnimationActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView mIvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_animation);
        mIvTest = findViewById(R.id.iv_test);
        mIvTest.setOnClickListener(this);
    }


    private void xmlAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set_test);
        mIvTest.startAnimation(animation);
    }


    private AlphaAnimation codeAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        return alphaAnimation;
    }

    private ScaleAnimation codeScaleAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f, 0.5f, 1.5f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setFillBefore(false);
        scaleAnimation.setFillEnabled(false);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        return scaleAnimation;
    }

    private RotateAnimation codeRotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(90, -270, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        return rotateAnimation;
    }


    private TranslateAnimation codeTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.1f, Animation.RELATIVE_TO_SELF, 1.0f);
        translateAnimation.setDuration(1000);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        return translateAnimation;
    }

    AnimationSet animationSet;

    private void codeSetAnimation() {
        animationSet = new AnimationSet(true);
        animationSet.addAnimation(codeScaleAnimation());
        animationSet.addAnimation(codeAlphaAnimation());
        animationSet.addAnimation(codeRotateAnimation());
        animationSet.addAnimation(codeTranslateAnimation());
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {//动画开始
                Toast.makeText(SetAnimationActivity.this, "动画开始", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {//动画结束
                Toast.makeText(SetAnimationActivity.this, "动画结束", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {//动画重复
                Toast.makeText(SetAnimationActivity.this, "重复动画", Toast.LENGTH_SHORT).show();

            }
        });
        mIvTest.startAnimation(animationSet);
    }

    /**
     * 取消动画
     */
    public void cancelAnimation() {
        animationSet.cancel();
    }

    /**
     * 重置动画
     */
    public void resetAnimation() {
        animationSet.reset();
    }

    /**
     * <set xmlns:android="http://schemas.android.com/apk/res/android"
     * android:duration="1000"
     * android:fillAfter="true"
     * android:fillBefore="false"
     * android:fillEnabled="false">
     * <scale
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
     * <alpha
     * android:fromAlpha="1.0"
     * android:repeatMode="reverse"
     * android:repeatCount="infinite"
     * android:toAlpha="0.1">
     * </alpha>
     * <rotate
     * android:fromDegrees="90"
     * android:pivotY="50%"
     * android:pivotX="50%"
     * android:drawable="@color/colorAccent"
     * android:visible="true"
     * android:repeatCount="infinite"
     * android:repeatMode="reverse"
     * android:toDegrees="-270">
     * </rotate>
     * <translate
     * android:fromXDelta="10%"
     * android:fromYDelta="10%"
     * android:toXDelta="100%"
     * android:toYDelta="100%"
     * android:repeatCount="infinite"
     * android:repeatMode="reverse">
     * </translate>
     * </set>
     * <p>
     * set中：repeatCount标签无效
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_test:
                codeSetAnimation();
//                xmlAnimation();
                break;
            default:
                break;
        }
    }


}
