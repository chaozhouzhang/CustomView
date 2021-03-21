package androidstack.customview.animation.property.evaluator;

import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import androidstack.customview.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/15 10:05
 * 估值器，根据插值器的数值进度变化规律，计算出具体的动画数值
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class EvaluatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnInt;
    private Button mBtnFloat;
    private Button mBtnArgb;
    private Button mBtnReverse;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluator);
        mBtnInt = findViewById(R.id.btn_int_evaluator);
        mBtnFloat = findViewById(R.id.btn_float_evaluator);
        mBtnArgb = findViewById(R.id.btn_argb_evaluator);
        mBtnReverse = findViewById(R.id.btn_reverse);
        mBtnInt.setOnClickListener(this);
        mBtnFloat.setOnClickListener(this);
        mBtnArgb.setOnClickListener(this);
        mBtnReverse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_int_evaluator:
                valueAnimatorInt();
                break;
            case R.id.btn_float_evaluator:
                valueAnimatorFloat();
                break;
            case R.id.btn_argb_evaluator:
                valueAnimatorArgb();
                break;
            case R.id.btn_reverse:
                valueAnimatorReverse();
                break;
            default:
                break;
        }
    }

    private void valueAnimatorReverse() {
        ValueAnimator valueAnimatorInt = ValueAnimator.ofInt(200, 0, 200);
        valueAnimatorInt.setDuration(1000);
        valueAnimatorInt.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorInt.setEvaluator(new ReverseEvaluator());
        valueAnimatorInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                System.out.println(currentValue);
            }
        });
    }

    private void valueAnimatorArgb() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ValueAnimator valueAnimatorArgb = ValueAnimator.ofArgb(0, 255, 0);
            valueAnimatorArgb.setDuration(1000);
            valueAnimatorArgb.setEvaluator(new ArgbEvaluator());
            valueAnimatorArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    /**
                     * 对于颜色argb的运算涉及位移和与运算等
                     */
                    int currentValue = (int) animation.getAnimatedValue();
                    System.out.println(currentValue);
                }
            });
        }

    }

    private void valueAnimatorFloat() {
        ValueAnimator valueAnimatorFloat = ValueAnimator.ofFloat(100F, 0F, 100F);
        valueAnimatorFloat.setDuration(1000);
        valueAnimatorFloat.setEvaluator(new FloatEvaluator());
        valueAnimatorFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                System.out.println(currentValue);
            }
        });
    }

    private void valueAnimatorInt() {
        ValueAnimator valueAnimatorInt = ValueAnimator.ofInt(200, 0, 200);
        valueAnimatorInt.setDuration(1000);
        valueAnimatorInt.setEvaluator(new IntEvaluator());
        valueAnimatorInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                System.out.println(currentValue);
            }
        });
    }
}
