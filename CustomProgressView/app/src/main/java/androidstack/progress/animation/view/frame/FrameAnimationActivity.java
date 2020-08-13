package androidstack.progress.animation.view.frame;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidstack.progress.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/12 18:15
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class FrameAnimationActivity extends AppCompatActivity {

    private ImageView mIvLoading;

    private ImageView mIvLoadingCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        mIvLoading = findViewById(R.id.iv_loading);
        mIvLoadingCode = findViewById(R.id.iv_loading_code);
        codeAnimation();
        xmlAnimation();
    }


    /**
     * oneshot 表示是否只执行一次
     */
    public void codeAnimation() {
        int num = 10;
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (int i = 1; i <= num; i++) {
            int id = getResources().getIdentifier("loading_0" + i, "mipmap", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            animationDrawable.addFrame(drawable, 50);
        }
        animationDrawable.setOneShot(false);
        mIvLoadingCode.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();
    }


    private void xmlAnimation() {
        AnimationDrawable animationDrawable = (AnimationDrawable) mIvLoading.getDrawable();
        animationDrawable.start();
    }
}
