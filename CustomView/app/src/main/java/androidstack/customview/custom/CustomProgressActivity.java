package androidstack.customview.custom;

import android.graphics.Color;
import android.os.Bundle;

import androidstack.customview.R;
import androidstack.customview.view.CustomProgressView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/13 23:44
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class CustomProgressActivity extends AppCompatActivity {

    private CustomProgressView mCustomProgressView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_progress);

        mCustomProgressView = findViewById(R.id.cpv);
        mCustomProgressView.setProgressMax(100);
        mCustomProgressView.setCpBackgroundColor(Color.parseColor("#FFF3F3"));
        mCustomProgressView.setCpPercentTextcolor(Color.parseColor("#666666"));
        mCustomProgressView.setCpProgressColor(Color.parseColor("#FEC7CD"));
        mCustomProgressView.setProgressCurrent(40);
        mCustomProgressView.setCpBackgroundIsStroke(false);
        mCustomProgressView.setCpPercentTextsize(40);
    }
}
