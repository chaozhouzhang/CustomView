package androidstack.progress.animation.view.tween;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidstack.progress.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/12 18:12
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class TweenAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnScale;
    private Button mBtnAlpha;
    private Button mBtnTranslate;
    private Button mBtnRotate;
    private Button mBtnSet;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        mBtnScale = findViewById(R.id.btn_scale_animation);
        mBtnScale.setOnClickListener(this);
        mBtnAlpha = findViewById(R.id.btn_alpha_animation);
        mBtnAlpha.setOnClickListener(this);
        mBtnTranslate = findViewById(R.id.btn_translate_animation);
        mBtnTranslate.setOnClickListener(this);
        mBtnRotate = findViewById(R.id.btn_rotate_animation);
        mBtnRotate.setOnClickListener(this);
        mBtnSet = findViewById(R.id.btn_set_animation);
        mBtnSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_scale_animation:
                startActivity(new Intent(this,ScaleAnimationActivity.class));
                break;
            case R.id.btn_alpha_animation:
                startActivity(new Intent(this,AlphaAnimationActivity.class));
                break;
            case R.id.btn_translate_animation:
                startActivity(new Intent(this,TranslateAnimationActivity.class));
                break;
            case R.id.btn_rotate_animation:
                startActivity(new Intent(this,RotateAnimationActivity.class));
                break;
            case R.id.btn_set_animation:
                startActivity(new Intent(this,SetAnimationActivity.class));
                break;
            default:
                break;
        }
    }
}
