package androidstack.customview.animation.view.tween.effect;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import androidstack.customview.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/13 12:56
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvTest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mIvTest = findViewById(R.id.iv_test);
        mIvTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_test:
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,1.2f,1.0f,1.2f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                scaleAnimation.setDuration(6000);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setInterpolator(new BounceInterpolator());
                mIvTest.startAnimation(scaleAnimation);
                break;
            default:
                break;
        }
    }
}
