package androidstack.progress.animation.property.value;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidstack.progress.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/15 15:55
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class FallingBallValueActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvBall;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_falling_ball_value);
        mIvBall = findViewById(R.id.iv_ball);
        mIvBall.setOnClickListener(this);
    }
    private Point mPoint=null;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_ball:
                ValueAnimator animator = ValueAnimator.ofObject(new FallingBallEvaluator(),new Point(0,0),new Point(500,500));
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        mPoint = (Point) animation.getAnimatedValue();
                        mIvBall.layout(mPoint.x,mPoint.y,mPoint.x+mIvBall.getWidth(),mPoint.y+mIvBall.getHeight());
                    }
                });
                animator.setDuration(2000);
                animator.start();
                break;
            default:
                break;
        }
    }
}
