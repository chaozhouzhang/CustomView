package androidstack.progress.animation.property.object;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;

import androidstack.progress.R;
import androidstack.progress.animation.property.value.FallingBallEvaluator;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/15 15:55
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class FallingBallObjectActivity extends AppCompatActivity implements View.OnClickListener {
    private FallingImageView mIvBall;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_falling_ball_object);
        mIvBall = findViewById(R.id.iv_ball);
        mIvBall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_ball:
                ObjectAnimator objectAnimator = ObjectAnimator.ofObject(mIvBall,"fallingPos",new FallingBallEvaluator(),new Point(0,0),new Point(500,500));
                objectAnimator.setDuration(2000);
                objectAnimator.start();
                break;
            default:
                break;
        }
    }
}
