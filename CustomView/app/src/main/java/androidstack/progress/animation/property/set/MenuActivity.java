package androidstack.progress.animation.property.set;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidstack.progress.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/15 21:46
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvMenu;
    private ImageView mIv1;
    private ImageView mIv2;
    private ImageView mIv3;
    private ImageView mIv4;
    private ImageView mIv5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mIvMenu = findViewById(R.id.iv_menu);
        mIv1 = findViewById(R.id.iv_menu_1);
        mIv2 = findViewById(R.id.iv_menu_2);
        mIv3 = findViewById(R.id.iv_menu_3);
        mIv4 = findViewById(R.id.iv_menu_4);
        mIv5 = findViewById(R.id.iv_menu_5);
        mIvMenu.setOnClickListener(this);
    }

    private boolean mIsMenuOpen = false;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_menu:

                mIsMenuOpen = !mIsMenuOpen;
                if (mIsMenuOpen) {
                    openMenu();
                } else {
                    closeMenu();
                }
                break;
            default:
                break;
        }
    }

    private void closeMenu() {
        menuClose(mIv1, 0, 5, 300);
        menuClose(mIv2, 1, 5, 300);
        menuClose(mIv3, 2, 5, 300);
        menuClose(mIv4, 3, 5, 300);
        menuClose(mIv5, 4, 5, 300);
    }

    private void menuClose(View view, int currIndex, int totalIndex, int radius) {
        //每一份角度
        double degree = Math.PI * currIndex /((totalIndex-1)*2);
        //X轴移动距离
        int translationX = -(int) (radius * Math.sin(degree));
        //Y轴移动距离
        int translationY = -(int) (radius * Math.cos(degree));

        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorTranslationX = ObjectAnimator.ofFloat(view, "translationX", translationX, 0);
        ObjectAnimator objectAnimatorTranslationY = ObjectAnimator.ofFloat(view, "translationY", translationY, 0);
        ObjectAnimator objectAnimatorScaleX = ObjectAnimator.ofFloat(view, "ScaleX", 1F, 0F);
        ObjectAnimator objectAnimatorScaleY = ObjectAnimator.ofFloat(view, "ScaleY", 1F, 0F);
        ObjectAnimator objectAnimatorAlpha = ObjectAnimator.ofFloat(view, "alpha", 1F, 0F);
        animatorSet.playTogether(objectAnimatorTranslationX, objectAnimatorTranslationY, objectAnimatorScaleX, objectAnimatorScaleY, objectAnimatorAlpha);
        animatorSet.setDuration(500);
        animatorSet.start();
    }

    private void menuOpen(View view, int currIndex, int totalIndex, int radius) {
        //每一份角度
        double degree = Math.toRadians(90) / (totalIndex - 1) * currIndex;
        //X轴移动距离
        int translationX = -(int) (radius * Math.sin(degree));
        //Y轴移动距离
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorTranslationX = ObjectAnimator.ofFloat(view, "translationX", 0, translationX);
        ObjectAnimator objectAnimatorTranslationY = ObjectAnimator.ofFloat(view, "translationY", 0, translationY);
        ObjectAnimator objectAnimatorScaleX = ObjectAnimator.ofFloat(view, "ScaleX", 0F, 1F);
        ObjectAnimator objectAnimatorScaleY = ObjectAnimator.ofFloat(view, "ScaleY", 0F, 1F);
        ObjectAnimator objectAnimatorAlpha = ObjectAnimator.ofFloat(view, "alpha", 0F, 1F);
        animatorSet.playTogether(objectAnimatorTranslationX, objectAnimatorTranslationY, objectAnimatorScaleX, objectAnimatorScaleY, objectAnimatorAlpha);
        animatorSet.setDuration(500);
        animatorSet.start();
    }

    private void openMenu() {
        menuOpen(mIv1, 0, 5, 300);
        menuOpen(mIv2, 1, 5, 300);
        menuOpen(mIv3, 2, 5, 300);
        menuOpen(mIv4, 3, 5, 300);
        menuOpen(mIv5, 4, 5, 300);
    }
}
