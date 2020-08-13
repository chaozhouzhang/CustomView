package androidstack.progress.animation.view.tween;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
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
public class RotateAnimationActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView mIvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_animation);
        mIvTest = findViewById(R.id.iv_test);
        mIvTest.setOnClickListener(this);
    }



    private void codeAnimation(){
        RotateAnimation rotateAnimation = new RotateAnimation(90,-270,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        mIvTest.startAnimation(rotateAnimation);
    }
    private void xmlAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_test);
        mIvTest.startAnimation(animation);
    }
    /**
     * <rotate xmlns:android="http://schemas.android.com/apk/res/android"
     * android:fromDegrees="90"
     * android:pivotY="50%"
     * android:pivotX="50%"
     * android:drawable="@color/colorAccent"
     * android:visible="true"
     * android:duration="1000"
     * android:repeatCount="infinite"
     * android:repeatMode="reverse"
     * android:toDegrees="-270"
     * >
     * </rotate>
     * 动画开始旋转时的角度位置：正数顺时针，负数逆时针
     * 动画结束旋转时的角度位置：正数顺时针，负数逆时针
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
