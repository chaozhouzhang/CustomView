package androidstack.customview;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidstack.customview.animation.advanced.PathMeasureActivity;
import androidstack.customview.animation.interpolator.InterpolatorActivity;
import androidstack.customview.animation.property.PropertyAnimationActivity;
import androidstack.customview.animation.property.evaluator.EvaluatorActivity;
import androidstack.customview.animation.view.ViewAnimationActivity;
import androidstack.customview.custom.CustomProgressActivity;
import androidstack.customview.rv.layoutmanager.CardActivity;
import androidstack.customview.rv.partrv.PartRvActivity;
import androidstack.customview.svg.SvgActivity;
import androidstack.customview.svg.lottie.LottieActivity;
import androidstack.customview.svg.svga.SvgaActivity;
import androidstack.customview.svg.svga.SvgaTextActivity;
import androidstack.customview.toolbar.ToolBarActivity;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author zhangchaozhou
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnBasisView;
    private Button mBtnViewAnimation;
    private Button mBtnPropertyAnimation;
    private Button mBtnInterpolator;
    private Button mBtnEvaluator;
    private Button mBtnProgress;
    private Button mBtnPathAnimation;
    private Button mBtnSvga;
    private Button mBtnLottie;
    private Button mBtnSvg;
    private Button mBtnMask;

    private ImageView mIvTest;

    private Button mBtnToolBar;
    private Button mBtnRvCard;
    private Button mBtnRvPart;
    private Button mBtnSvgaText;
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
        mBtnInterpolator = findViewById(R.id.btn_interpolator);
        mBtnInterpolator.setOnClickListener(this);
        mBtnProgress = findViewById(R.id.btn_custom_progress);
        mBtnProgress.setOnClickListener(this);
        mBtnEvaluator = findViewById(R.id.btn_evaluator);
        mBtnEvaluator.setOnClickListener(this);
        mBtnPathAnimation = findViewById(R.id.btn_path_animation);
        mBtnPathAnimation.setOnClickListener(this);
        mBtnSvga = findViewById(R.id.btn_svga);
        mBtnSvga.setOnClickListener(this);
        mBtnLottie = findViewById(R.id.btn_lottie);
        mBtnLottie.setOnClickListener(this);

        mBtnSvg= findViewById(R.id.btn_svg);
        mBtnSvg.setOnClickListener(this);


        mBtnMask = findViewById(R.id.btn_mask);
        mBtnMask.setOnClickListener(this);

        mIvTest = findViewById(R.id.iv_test);
        mIvTest.setColorFilter(Color.RED);


        mBtnToolBar = findViewById(R.id.btn_tool_bar);
        mBtnToolBar.setOnClickListener(this);

        mBtnRvCard = findViewById(R.id.btn_rv_card);
        mBtnRvCard.setOnClickListener(this);


        mBtnRvPart = findViewById(R.id.btn_rv_part);
        mBtnRvPart.setOnClickListener(this);


        mBtnSvgaText = findViewById(R.id.btn_svga_text);
        mBtnSvgaText.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tool_bar:
                startActivity(new Intent(this, ToolBarActivity.class));
                break;
            case R.id.btn_basis_view:
                startActivity(new Intent(this,BasisViewActivity.class));
                break;
            case R.id.btn_view_animation:
                startActivity(new Intent(this, ViewAnimationActivity.class));
                break;
            case R.id.btn_property_animation:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;

            case R.id.btn_interpolator:
                startActivity(new Intent(this, InterpolatorActivity.class));
                break;
            case R.id.btn_evaluator:
                startActivity(new Intent(this, EvaluatorActivity.class));
                break;

            case R.id.btn_custom_progress:
                startActivity(new Intent(this, CustomProgressActivity.class));
                break;

            case R.id.btn_path_animation:
                startActivity(new Intent(this, PathMeasureActivity.class));
                break;

            case R.id.btn_svga:
                startActivity(new Intent(this, SvgaActivity.class));
                break;


            case R.id.btn_svga_text:
                startActivity(new Intent(this, SvgaTextActivity.class));
                break;

            case R.id.btn_lottie:
                startActivity(new Intent(this, LottieActivity.class));
                break;

            case R.id.btn_svg:
                startActivity(new Intent(this, SvgActivity.class));
                break;

            case R.id.btn_mask:
                startActivity(new Intent(this, MaskActivity.class));
                break;
            case R.id.btn_rv_card:
                startActivity(new Intent(this, CardActivity.class));
                break;
            case R.id.btn_rv_part:
                startActivity(new Intent(this, PartRvActivity.class));
                break;
            default:
                break;
        }
    }
}