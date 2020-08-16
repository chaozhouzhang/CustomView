package androidstack.progress.animation.property.advanced;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidstack.progress.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/16 09:31
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class PhoneActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        mIvPhone = findViewById(R.id.iv_phone);
        mIvPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_phone:
                //旋转效果，左右震动
                Keyframe keyframe1 = Keyframe.ofFloat(0f, 0);
                Keyframe keyframe2 = Keyframe.ofFloat(0.1f, -20f);
                Keyframe keyframe3 = Keyframe.ofFloat(0.2f, 20f);
                Keyframe keyframe4 = Keyframe.ofFloat(0.3f, -20f);
                Keyframe keyframe5 = Keyframe.ofFloat(0.4f, 20f);
                Keyframe keyframe6 = Keyframe.ofFloat(0.5f, -20f);
                Keyframe keyframe7 = Keyframe.ofFloat(0.6f, 20f);
                Keyframe keyframe8 = Keyframe.ofFloat(0.7f, -20f);
                Keyframe keyframe9 = Keyframe.ofFloat(0.8f, 20f);
                Keyframe keyframe10 = Keyframe.ofFloat(0.9f, -20f);
                Keyframe keyframe11 = Keyframe.ofFloat(1.0f, 0f);
                PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("rotation",
                        keyframe1, keyframe1, keyframe2, keyframe3, keyframe4, keyframe5,
                        keyframe6, keyframe7, keyframe8, keyframe9, keyframe10, keyframe11);
                //缩放效果 X
                Keyframe keyframeScaleX0 = Keyframe.ofFloat(0,1f);
                Keyframe keyframeScaleX1 = Keyframe.ofFloat(0.1f,1.1f);
                Keyframe keyframeScaleX9 = Keyframe.ofFloat(0.9f,1.1f);
                Keyframe keyframeScaleX10 = Keyframe.ofFloat(1f,1f);
                    PropertyValuesHolder propertyValuesHolderScaleX = PropertyValuesHolder.ofKeyframe("ScaleX",
                            keyframeScaleX0,keyframeScaleX1,keyframeScaleX9,keyframeScaleX10);

                //缩放效果 Y
                Keyframe keyframeScaleY0 = Keyframe.ofFloat(0,1f);
                Keyframe keyframeScaleY1 = Keyframe.ofFloat(0.1f,1.1f);
                Keyframe keyframeScaleY9 = Keyframe.ofFloat(0.9f,1.1f);
                Keyframe keyframeScaleY10 = Keyframe.ofFloat(1f,1f);
                PropertyValuesHolder propertyValuesHolderScaleY = PropertyValuesHolder.ofKeyframe("ScaleY",
                        keyframeScaleY0,keyframeScaleY1,keyframeScaleY9,keyframeScaleY10);

                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mIvPhone,
                        propertyValuesHolder,propertyValuesHolderScaleX,propertyValuesHolderScaleY);
                objectAnimator.setDuration(1000);
                objectAnimator.start();
                break;
            default:
                break;
        }
    }
}
