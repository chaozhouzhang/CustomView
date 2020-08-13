package androidstack.progress.animation.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidstack.progress.R;
import androidstack.progress.animation.view.tween.TweenAnimationActivity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/12 18:15
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnTween;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        mBtnTween = findViewById(R.id.btn_tween_animation);
        mBtnTween.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tween_animation:
                startActivity(new Intent(this, TweenAnimationActivity.class));
                break;
            default:
                break;
        }
    }
}
