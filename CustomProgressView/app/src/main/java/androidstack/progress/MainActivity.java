package androidstack.progress;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author zhangchaozhou
 */
public class MainActivity extends AppCompatActivity {

    private CustomProgressView mCustomProgressView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomProgressView = findViewById(R.id.cpv);
        mCustomProgressView.setProgressMax(100);
        mCustomProgressView.setCpBackgroundColor(Color.parseColor("#FFF3F3"));
        mCustomProgressView.setCpPercentTextcolor(Color.parseColor("#666666"));
        mCustomProgressView.setCpProgressColor(Color.parseColor("#FEC7CD"));
        mCustomProgressView.setProgressCurrent(40);
        mCustomProgressView.setCpBackgroundIsStroke(false);
        mCustomProgressView.setCpPercentTextsize(40);
    }


    public void customView(View view) {
        startActivity(new Intent(this,CustomViewActivity.class));
    }
}