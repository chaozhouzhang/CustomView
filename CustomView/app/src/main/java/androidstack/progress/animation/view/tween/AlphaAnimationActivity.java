package androidstack.progress.animation.view.tween;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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
public class AlphaAnimationActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView mIvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_animation);
        mIvTest = findViewById(R.id.iv_test);
        mIvTest.setOnClickListener(this);
    }

    private void codeAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.1f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        mIvTest.startAnimation(alphaAnimation);
    }

    private void xmlAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_test);
        mIvTest.startAnimation(animation);
    }

    /**
     * <alpha xmlns:android="http://schemas.android.com/apk/res/android"
     * android:fromAlpha="1.0"
     * android:duration="1000"
     * android:repeatMode="reverse"
     * android:repeatCount="infinite"
     * android:toAlpha="0.1">
     * </alpha>
     * 动画开始时的透明度：0-1
     * 动画结束时的透明度：0-1
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
