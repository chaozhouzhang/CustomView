package androidstack.progress.animation.view.tween;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidstack.progress.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/12 17:43
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class TranslateAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_animation);
        mIvTest = findViewById(R.id.iv_test);
        mIvTest.setOnClickListener(this);
    }


    private void codeAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.1f, Animation.RELATIVE_TO_SELF, 1.0f);
        translateAnimation.setDuration(1000);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        mIvTest.startAnimation(translateAnimation);
    }

    private void xmlAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_test);
        mIvTest.startAnimation(animation);
    }


    /**
     * <translate xmlns:android="http://schemas.android.com/apk/res/android"
     * android:fromXDelta="10%"
     * android:fromYDelta="10%"
     * android:toXDelta="100%"
     * android:toYDelta="100%"
     * android:duration="1000"
     * android:repeatCount="infinite"
     * android:repeatMode="reverse"
     * >
     * </translate>
     * 起始点X轴坐标
     * 起始点Y轴坐标
     * 结束点X轴坐标
     * 结束点Y轴坐标
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
