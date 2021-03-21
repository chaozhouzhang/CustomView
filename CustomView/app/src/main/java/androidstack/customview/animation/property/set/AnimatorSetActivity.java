package androidstack.customview.animation.property.set;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import androidstack.customview.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/15 17:23
 * 组合动画一般都是用到object animator的组合动画
 * 如果需要让组合动画无限循环，则需要各种设置每个动画无限循环
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class AnimatorSetActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvTest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);
        mIvTest = findViewById(R.id.iv_test);
        mIvTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_test:
//                playSequentially();
//                playTogether();
//                xmlAnimator();
                animatorSetBuilder();
                break;
            default:
                break;
        }
    }

    /**
     * <animator/>: 对应 ValueAnimator
     * <objectAnimator />: 对应ObjectAnimator
     * <set/>:对应 AnimatorSet
     * xml文件需要放在res/animator文件夹中
     */
    private void xmlAnimator() {
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.animator_set);
        animatorSet.start();
    }

    private void animatorSetBuilder() {
        ObjectAnimator objectAnimatorBgColor = ObjectAnimator.ofInt(mIvTest,"BackgroundColor",0xffff00ff,0xffffff00,0xffff00ff);
        ObjectAnimator objectAnimatorTranY = ObjectAnimator.ofFloat(mIvTest,"translationY",0,300,0);
        ObjectAnimator objectAnimatorTranX = ObjectAnimator.ofFloat(mIvTest,"translationX",0,300,0);
        AnimatorSet animatorSet = new AnimatorSet();
        //play:当前运行的动画；with：与当前动画一起运行的动画；before：运行在当前动画之前的动画；after：运行在当前动画之后的动画。
        animatorSet.play(objectAnimatorBgColor).with(objectAnimatorTranX).before(objectAnimatorTranY);
//        animatorSet.play(objectAnimatorBgColor).with(objectAnimatorTranX).after(objectAnimatorTranY);
        //以组合动画的以下设置为准
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.setDuration(2000);
        animatorSet.setTarget(mIvTest);
        //对各个动画的延时无影响
        animatorSet.setStartDelay(1000);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                System.out.println("开始组合动画");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                System.out.println("结束组合动画");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

                System.out.println("取消组合动画");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                //永远无法执行此方法，因为组合动画无法设置循环次数，只执行一次

            }
        });
        animatorSet.start();
    }


    /**
     * 同时动画
     */
    private void playTogether() {
        ObjectAnimator objectAnimatorBgColor = ObjectAnimator.ofInt(mIvTest,"BackgroundColor",0xffff00ff,0xffffff00,0xffff00ff);
        ObjectAnimator objectAnimatorTranY = ObjectAnimator.ofFloat(mIvTest,"translationY",0,300,0);
        ObjectAnimator objectAnimatorTranX = ObjectAnimator.ofFloat(mIvTest,"translationX",0,300,0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorBgColor,objectAnimatorTranY,objectAnimatorTranX);
        animatorSet.start();
    }

    /**
     * 连续动画
     */
    private void playSequentially() {

        ObjectAnimator objectAnimatorBgColor = ObjectAnimator.ofInt(mIvTest,"BackgroundColor",0xffff00ff,0xffffff00,0xffff00ff);
        ObjectAnimator objectAnimatorTranY = ObjectAnimator.ofFloat(mIvTest,"translationY",0,300,0);
        ObjectAnimator objectAnimatorTranX = ObjectAnimator.ofFloat(mIvTest,"translationX",0,300,0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorBgColor,objectAnimatorTranY,objectAnimatorTranX);
        animatorSet.start();
    }
}
