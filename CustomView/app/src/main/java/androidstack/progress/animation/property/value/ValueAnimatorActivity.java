package androidstack.progress.animation.property.value;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidstack.progress.R;
import androidstack.progress.animation.interpolator.ReverseInterpolator;
import androidstack.progress.animation.property.evaluator.CharEvaluator;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/14 13:12
 *
 * 属性动画之值动画：
 * 1、指定动画数值区间
 * 2、指定插值器，定义动画数值的进度变化规律
 * 3、指定估值器，根据插值器的进度变化规律，计算具体的动画数值
 * 4、设置监听器，监听估值器返回的具体动画数值，然后根据此具体数值，来对控件做出属性变化的设置操作
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class ValueAnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvTest;
    private ValueAnimator valueAnimatorInt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        mIvTest = findViewById(R.id.iv_test);
        mIvTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_test:
                valueAnimatorInt();
                break;
            default:
                break;
        }
    }


    /**
     * int类型的值动画，包括多个int范围的取值
     * 设置动画时间
     * 设置动画重复次数
     * 设置动画重复模式
     * 设置动画延迟开始的时间
     * 设置动画插值器
     * 设置动画更新的监听
     * 设置动画开始、结束、取消、重复的监听
     * 设置动画暂停和重新开始的监听
     */
    private void valueAnimatorInt() {
        //int类型的动画取值区间，默认使用IntEvaluator估值器
        valueAnimatorInt = ValueAnimator.ofInt(0, 200, 100, 400, 300, 500);
        valueAnimatorInt.setDuration(1000);
        //重复次数为INFINITE无限循环的动画时，当activity结束的时候，必须调用cancel方法取消动画；
        //否则动画将无限循环，导致view无法释放，进一步导致activity无法释放，引起内存泄露。
        valueAnimatorInt.setRepeatCount(Animation.INFINITE);
        valueAnimatorInt.setRepeatMode(ValueAnimator.REVERSE);
        //延迟多久开始，单位毫秒
        valueAnimatorInt.setStartDelay(1000);
        //插值器：控制动画的区间值的计算规律，可以使用自定义插值器
        valueAnimatorInt.setInterpolator(new ReverseInterpolator());
        valueAnimatorInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //不是对控件进行运算，而是针对值进行运算
                //通过对指定区间进行运算，通过对运算过程进行监控，来操作控件
                //在运动时获取当前运动点的值
                int currentValue = (int) animation.getAnimatedValue();
                //位移操作，左上右下
                mIvTest.layout(currentValue, currentValue, currentValue + mIvTest.getWidth(), currentValue + mIvTest.getHeight());
            }
        });
        valueAnimatorInt.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                System.out.println("开始");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                System.out.println("结束");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                System.out.println("取消");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                System.out.println("重复");
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            valueAnimatorInt.addPauseListener(new Animator.AnimatorPauseListener() {
                @Override
                public void onAnimationPause(Animator animation) {
                    System.out.println("暂停");
                }

                @Override
                public void onAnimationResume(Animator animation) {
                    System.out.println("重新开始");
                }
            });
        }
        valueAnimatorInt.start();
    }




    /**
     * float类型的值动画
     */
    private void valueAnimatorFloat() {
        //float类型的动画取值区间，默认使用IntEvaluator估值器
        ValueAnimator valueAnimatorFloat = ValueAnimator.ofFloat(0F, 200F, 100F, 400F, 300F, 500F);
        valueAnimatorFloat.setDuration(1000);
        valueAnimatorFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //不是对控件进行运算，而是针对值进行运算
                //通过对指定区间进行运算，通过对运算过程进行监控，来操作控件
                float currentValue = (float) animation.getAnimatedValue();
                System.out.println(currentValue);
            }
        });
        valueAnimatorFloat.start();
    }

    /**
     * alpha类型的值动画，需要LOLLIPOP版本或以上使用
     */
    private void valueAnimatorArgb(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ValueAnimator valueAnimator = ValueAnimator.ofArgb(0,255);
        }
    }

    /**
     *
     * object类型的值动画，需要传入自定义估值器
     */
    private void valueAnimatorObject(){
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char text = (char) animation.getAnimatedValue();
                System.out.println(text);
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.start();
    }


    /**
     * 移各种除监听器，动画会继续运行，不会停止
     */
    private void valueAnimatorRemoveListener() {
        valueAnimatorInt.removeUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
        valueAnimatorInt.removeListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            valueAnimatorInt.removePauseListener(new Animator.AnimatorPauseListener() {
                @Override
                public void onAnimationPause(Animator animation) {

                }

                @Override
                public void onAnimationResume(Animator animation) {

                }
            });
        }
        valueAnimatorInt.removeAllUpdateListeners();
        valueAnimatorInt.removeAllListeners();
    }


    /**
     * 克隆实例，包括设置和对监听器代码的处理
     *
     * @return
     */
    private ValueAnimator valueAnimatorClone() {
        return valueAnimatorInt.clone();
    }


    /**
     * 取消动画，释放资源
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (valueAnimatorInt != null) {
            valueAnimatorInt.cancel();
        }
    }
}
