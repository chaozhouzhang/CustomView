package androidstack.progress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidstack.progress.animation.interpolator.InterpolatorActivity;
import androidstack.progress.animation.property.PropertyAnimationActivity;
import androidstack.progress.animation.view.ViewAnimationActivity;
import androidstack.progress.custom.CustomProgressActivity;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author zhangchaozhou
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnBasisView;
    private Button mBtnViewAnimation;
    private Button mBtnPropertyAnimation;
    private Button mBtnInterpolator;
    private Button mBtnProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mBtnBasisView = findViewById(R.id.btn_basis_view);
        mBtnBasisView.setOnClickListener(this);
        mBtnViewAnimation = findViewById(R.id.btn_view_animation);
        mBtnViewAnimation.setOnClickListener(this);
        mBtnPropertyAnimation = findViewById(R.id.btn_property_animation);
        mBtnPropertyAnimation.setOnClickListener(this);
        mBtnInterpolator = findViewById(R.id.btn_view_interpolator);
        mBtnInterpolator.setOnClickListener(this);
        mBtnProgress = findViewById(R.id.btn_custom_progress);
        mBtnProgress.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_basis_view:
                startActivity(new Intent(this,BasisViewActivity.class));
                break;
            case R.id.btn_view_animation:
                startActivity(new Intent(this, ViewAnimationActivity.class));
                break;
            case R.id.btn_property_animation:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;

            case R.id.btn_view_interpolator:
                startActivity(new Intent(this, InterpolatorActivity.class));
                break;

            case R.id.btn_custom_progress:
                startActivity(new Intent(this, CustomProgressActivity.class));
                break;
            default:
                break;
        }
    }
}