package androidstack.customview.animation.property.advanced;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidstack.customview.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * Created on 2020/8/16 10:36
 * <p>
 * LayoutAnimation：ListView的进场动画
 * GridLayoutAnimation：GridView的进场动画
 * android:animateLayoutChanges属性：ViewGroup添加删除子View默认动画
 * 布局动画 LayoutTransition：ViewGroup添加删除子View添加删除的自定义动画
 * <p>
 * LayoutTransition.APPEARING;新元素在容器中出现时的动画；
 * LayoutTransition.CHANGE_APPEARING;容器中显示新元素，其他元素需要变化时的动画；
 * LayoutTransition.CHANGE_DISAPPEARING;容器中移除旧元素，其他元素需要变化时的动画；
 * LayoutTransition.CHANGING;
 * LayoutTransition.DISAPPEARING;旧元素在容器中移除时的动画；
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class ViewGroupAnimateActivity extends AppCompatActivity implements View.OnClickListener {
    private ConstraintLayout mClLayoutTransition;
    private ImageView mIvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group_animate);
        mClLayoutTransition = findViewById(R.id.cl_layout_transition);
        mIvTest = findViewById(R.id.iv_test);
        mIvTest.setOnClickListener(this);

        /**
         * 设置移除容器内图片控件时候的动画
         */
        LayoutTransition layoutTransition = new LayoutTransition();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, objectAnimator);
        /**
         * 设置动画间的间隔
         */
        layoutTransition.setStagger(LayoutTransition.DISAPPEARING, 1000);
        mClLayoutTransition.setLayoutTransition(layoutTransition);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_test:
                /**
                 * 移除布局
                 */
                mClLayoutTransition.removeView(mIvTest);
                break;
            default:
                break;
        }
    }
}
