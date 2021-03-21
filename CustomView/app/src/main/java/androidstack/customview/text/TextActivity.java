package androidstack.customview.text;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidstack.customview.R;

/**
 * @author zhangchaozhou
 * @time 2021/3/21 22:43
 */
public class TextActivity extends AppCompatActivity {

    private GradientTextView mTvGradientText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        mTvGradientText = findViewById(R.id.tv_gradient_text);
//        mTvGradientText.getPaint().setShader(new LinearGradient(
//                0, 0, mTvGradientText.getWidth(), mTvGradientText.getHeight(),
//                new int[]{0xFFFFEABA, 0xFFDFBB82, 0xFFBE8B49}, new float[]{0, 0.5f, 1},
//                Shader.TileMode.CLAMP));
//        Shader shader_vertical=new LinearGradient(0, mTvGradientText.getHeight()/4, 0, mTvGradientText.getHeight(), Color.parseColor("#D51400"), Color.parseColor("#F96F00"), Shader.TileMode.CLAMP);
//        mTvGradientText.getPaint().setShader(shader_vertical);

        mTvGradientText.setText("00000000999925");
    }
}
