package androidstack.customview.animation.interpolator;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidstack.customview.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/13 09:19
 * 插值器，定义动画数值的进度变化规律
 * 视图动画的插值器实现的是Interpolator接口，属性动画的插值器实现的是TimeInterpolator接口
 * 而Interpolator接口继承的是TimeInterpolator接口。
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class InterpolatorActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvTest;
    private Button mBtnAccelerateDecelerate;
    private Button mBtnAccelerate;
    private Button mBtnDecelerate;
    private Button mBtnLinear;
    private Button mBtnBounce;
    private Button mBtnOvershoot;
    private Button mBtnAnticipate;
    private Button mBtnAnticipateOvershoot;
    private Button mBtnCycle;
    private Button mBtnReverse;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);
        mIvTest = findViewById(R.id.iv_test);


        mBtnAccelerateDecelerate = findViewById(R.id.btn_accelerate_decelerate);
        mBtnAccelerate = findViewById(R.id.btn_accelerate);
        mBtnDecelerate = findViewById(R.id.btn_decelerate);
        mBtnLinear = findViewById(R.id.btn_linear);
        mBtnBounce = findViewById(R.id.btn_bounce);
        mBtnOvershoot = findViewById(R.id.btn_overshoot);
        mBtnAnticipate = findViewById(R.id.btn_anticipate);
        mBtnAnticipateOvershoot = findViewById(R.id.btn_anticipate_overshoot);
        mBtnCycle = findViewById(R.id.btn_cycle);
        mBtnReverse = findViewById(R.id.btn_cycle);

        mBtnAccelerateDecelerate.setOnClickListener(this);
        mBtnAccelerate.setOnClickListener(this);
        mBtnDecelerate.setOnClickListener(this);
        mBtnLinear.setOnClickListener(this);
        mBtnBounce.setOnClickListener(this);
        mBtnOvershoot.setOnClickListener(this);
        mBtnAnticipate.setOnClickListener(this);
        mBtnAnticipateOvershoot.setOnClickListener(this);
        mBtnCycle.setOnClickListener(this);
        mBtnReverse.setOnClickListener(this);

    }

    private TranslateAnimation codeAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.1f, Animation.RELATIVE_TO_SELF, 1.0f);
        translateAnimation.setDuration(1000);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        return translateAnimation;
    }


    @Override
    public void onClick(View v) {
        TranslateAnimation translateAnimation = codeAnimation();
        switch (v.getId()) {
            case R.id.btn_accelerate_decelerate:
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            case R.id.btn_accelerate:
                translateAnimation.setInterpolator(new AccelerateInterpolator());
                break;
            case R.id.btn_decelerate:
                translateAnimation.setInterpolator(new DecelerateInterpolator());
                break;
            case R.id.btn_linear:
                translateAnimation.setInterpolator(new LinearInterpolator());
                break;
            case R.id.btn_bounce:
                translateAnimation.setInterpolator(new BounceInterpolator());
                break;
            case R.id.btn_overshoot:
                translateAnimation.setInterpolator(new OvershootInterpolator());
                break;
            case R.id.btn_anticipate:
                translateAnimation.setInterpolator(new AnticipateInterpolator());
                break;
            case R.id.btn_anticipate_overshoot:
                translateAnimation.setInterpolator(new AnticipateOvershootInterpolator());
                break;
            case R.id.btn_cycle:
                translateAnimation.setInterpolator(new CycleInterpolator(1));
                break;

            case R.id.btn_reverse:
                translateAnimation.setInterpolator(new ReverseInterpolator());
                break;
            default:
                break;
        }
        mIvTest.startAnimation(translateAnimation);
    }
}
