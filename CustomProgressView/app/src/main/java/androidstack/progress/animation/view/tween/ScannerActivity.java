package androidstack.progress.animation.view.tween;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidstack.progress.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/13 13:23
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class ScannerActivity extends AppCompatActivity implements View.OnClickListener {
    private View mIv1;
    private View mIv2;
    private View mIv3;
    private View mIv4;
    private ImageView mIvScanner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        mIv1 = findViewById(R.id.iv_1);
        mIv2 = findViewById(R.id.iv_2);
        mIv3 = findViewById(R.id.iv_3);
        mIv4 = findViewById(R.id.iv_4);
        mIvScanner = findViewById(R.id.iv_scanner);
        mIvScanner.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_scanner:

                Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.set_sanner);
                Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.set_sanner);
                Animation animation3 = AnimationUtils.loadAnimation(this,R.anim.set_sanner);
                Animation animation4 = AnimationUtils.loadAnimation(this,R.anim.set_sanner);
                mIv1.startAnimation(animation1);
                animation2.setStartOffset(600);
                mIv2.startAnimation(animation2);

                animation3.setStartOffset(1200);
                mIv3.startAnimation(animation3);

                animation4.setStartOffset(1800);
                mIv4.startAnimation(animation4);
                break;
            default:
                break;
        }
    }
}
