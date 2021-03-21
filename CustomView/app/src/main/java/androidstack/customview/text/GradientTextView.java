package androidstack.customview.text;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author zhangchaozhou
 * @time 2021/3/21 22:42
 */
public class GradientTextView extends TextView {

    public enum GradientDirection {
        TOP_2_BOTTOM(1),
        START_2_END(2),
        TOP_START_2_BOTTOM_END(3);

        int direction;

        GradientDirection(int direction) {
            this.direction = direction;
        }


        public int getDirection() {
            return direction;
        }
    }


    public GradientTextView(@NonNull Context context) {
        super(context);
    }

    public GradientTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GradientTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
//            getPaint().setShader(new LinearGradient(
//                    0, 0, getWidth(), getHeight(),
//                    new int[]{0xFFFFEABA, 0xFFDFBB82, 0xFFBE8B49}, new float[]{0, 0.5f, 1},
//                    Shader.TileMode.CLAMP));

            Shader shader = new LinearGradient(0, 0, 0, getHeight(), Color.parseColor("#EE6A00"), Color.parseColor("#B80000"), Shader.TileMode.CLAMP);
            getPaint().setShader(shader);
        }
    }
}
