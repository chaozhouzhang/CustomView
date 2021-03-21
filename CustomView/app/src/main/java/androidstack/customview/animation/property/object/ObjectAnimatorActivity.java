package androidstack.customview.animation.property.object;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidstack.customview.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/15 16:25
 * 对象动画继承自值动画，让动画直接与控件关联，解放监听过程
 * 对象动画是通过控件中相关的set方法进行操作的，View已经实现了alpha、rotation、translate、scale等相关方法。
 * setTranslationX(float translationX)
 * setTranslationY(float translationY)
 * setTranslationZ(float translationZ)
 * setScaleX(float scaleX)
 * setScaleY(float scaleY)
 * <p>
 * 属性动画之对象动画：
 * 1、指定动画数值区间以及属性和控件
 * 2、指定插值器，定义动画数值的进度变化规律
 * 3、指定估值器，根据插值器的进度变化规律，计算具体的动画数值
 * 4、系统自定调用控件的set方法，根据属性拼装set方法并反射调用，并将当前值作为参数传入
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class ObjectAnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvBall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        mIvBall = findViewById(R.id.iv_ball);
        mIvBall.setOnClickListener(this);
    }

    /**
     * 根据ImageView的setAlpha(int alpha)方法设置
     */
    public void alpha() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvBall, "alpha", 1, 0, 1);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    /**
     * 通过View的setRotation(float rotation)方法设置
     * setRotationY(float rotationY)
     * setRotationX(float rotationX)
     */
    public void rotation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvBall, "rotation", 0, 180, 0);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_ball:
//                alpha();
                rotation();
                break;
            default:
                break;
        }
    }
}
