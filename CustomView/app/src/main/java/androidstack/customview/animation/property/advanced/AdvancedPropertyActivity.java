package androidstack.customview.animation.property.advanced;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import androidstack.customview.R;
import androidstack.customview.animation.property.evaluator.CharEvaluator;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/15 23:03
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class AdvancedPropertyActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvTest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_property);
        mIvTest = findViewById(R.id.iv_test);
        mIvTest.setOnClickListener(this);
    }

    /**
     * PropertyValuesHolder保存了动画工程中需要操作的属性和对应的值
     */
    public void propertyValues(){
        PropertyValuesHolder propertyValuesHolderRotation = PropertyValuesHolder.ofFloat("rotation",60F,-60F,40F,-40F,20F,-20F,10F,-10F,0F);
        PropertyValuesHolder propertyValuesHolderAlpha = PropertyValuesHolder.ofFloat("alpha",0.1F,1F,0.1F,1F);
        //对控件的多个属性同时执行动画操作
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mIvTest, propertyValuesHolderRotation,propertyValuesHolderAlpha);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }


    /**
     * 关键帧，为了方便控制动画速率，表示某个时间点应该在某个位置上
     * 视频，1秒要播24帧图片
     * 一个关键帧的两个元素：时间点和位置
     * fraction 动画进度
     * value 对应动画进度的动画数值
     * KeyFrame可以设置插值器，默认使用线性插值器
     * 可以做电话响铃的动画，一张电话图片，11张关键帧
     */
    public void keyFrame(){
        Keyframe keyframe = Keyframe.ofFloat(0.3F,-60F);
        keyframe.setInterpolator(new BounceInterpolator());
        PropertyValuesHolder propertyValuesHolderRotation = PropertyValuesHolder.ofKeyframe("rotation", Keyframe.ofFloat(0F,60F),keyframe,Keyframe.ofFloat(0.5F,10F),Keyframe.ofFloat(0.7F,-10F),Keyframe.ofFloat(1F,0F));
        PropertyValuesHolder propertyValuesHolderAlpha = PropertyValuesHolder.ofKeyframe("alpha",Keyframe.ofFloat(0F,0.1F),Keyframe.ofFloat(0.3F,1F),Keyframe.ofFloat(0.5F,0.1F),Keyframe.ofFloat(1F,1F));
        //对控件的多个属性同时执行动画操作
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mIvTest, propertyValuesHolderRotation,propertyValuesHolderAlpha);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }

    /**
     * Keyframe.ofObject之后
     * 一定要让PropertyValuesHolder，设置自定义Evaluator
     */
    public void keyFrameObject(){
        Keyframe keyframe1 = Keyframe.ofObject(0.1F,new Point(0,0));
        Keyframe keyframe2 = Keyframe.ofObject(1F,new Point(500,500));
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("CharText", keyframe1,keyframe2);
        propertyValuesHolder.setEvaluator(new CharEvaluator());
    }

    /**
     * 隐式自动启动
     * 会在下一次界面刷新的时候启动
     * 原理是计算对应的所有属性值，然后设置控件，再调用invalidate()进行重绘，相对于对象动画，性能有所提升
     * 不过动画对象的反射和JNI技术的开销对于整个程序来说是微不足道的
     */
    public void viewPropertyAnimator(){
        ViewPropertyAnimator animator = mIvTest.animate();
        animator.alpha(0.5f).x(20f).y(30f);
        animator.setListener(new Animator.AnimatorListener() {
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_test:
//                propertyValues();
                keyFrame();
                break;
            default:
                break;
        }
    }

}
