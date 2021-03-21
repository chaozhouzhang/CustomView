package androidstack.customview.svg.lottie;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import androidstack.customview.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.airbnb.lottie.LottieDrawable.INFINITE;

/**
 * Created on 2020/8/17 10:11
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class LottieActivity extends AppCompatActivity {


    private LottieAnimationView mLavGift;
    private LottieAnimationView mLavTest;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        mLavGift = findViewById(R.id.animation_view);
        mLavTest = findViewById(R.id.animation_view_test);
//        initGift();
        initTest();
    }

    private void initTest() {
        mLavGift.setAnimation("test.json");
        mLavGift.setRepeatCount(INFINITE);
        mLavGift.playAnimation();
    }

    private void initGift() {
        mLavTest.setAnimation("liwu.json");
        mLavTest.setRepeatCount(INFINITE);
        mLavTest.setImageAssetsFolder("images/");
        mLavTest.playAnimation();
    }
}
