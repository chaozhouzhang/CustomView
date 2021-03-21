package androidstack.customview.animation.property;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidstack.customview.R;
import androidstack.customview.animation.property.advanced.AdvancedPropertyActivity;
import androidstack.customview.animation.property.advanced.PhoneActivity;
import androidstack.customview.animation.property.advanced.ViewGroupAnimateActivity;
import androidstack.customview.animation.property.object.FallingBallObjectActivity;
import androidstack.customview.animation.property.object.ObjectAnimatorActivity;
import androidstack.customview.animation.property.set.AnimatorSetActivity;
import androidstack.customview.animation.property.set.MenuActivity;
import androidstack.customview.animation.property.value.FallingBallValueActivity;
import androidstack.customview.animation.property.value.ValueAnimatorActivity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/12 18:15
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnValue;
    private Button mBtnValueFalling;

    private Button mBtnObject;
    private Button mBtnObjectFalling;


    private Button mBtnAnimatorSet;
    private Button mBtnAnimatorMenu;
    private Button mBtnAnimatorAdvanced;
    private Button mBtnAnimatorPhone;

    private Button mBtnAnimatorViewGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        mBtnValue = findViewById(R.id.btn_value_animator);
        mBtnValue.setOnClickListener(this);

        mBtnValueFalling = findViewById(R.id.btn_value_falling);
        mBtnValueFalling.setOnClickListener(this);


        mBtnObject = findViewById(R.id.btn_object_animator);
        mBtnObject.setOnClickListener(this);


        mBtnObjectFalling = findViewById(R.id.btn_object_falling);
        mBtnObjectFalling.setOnClickListener(this);

        mBtnAnimatorSet = findViewById(R.id.btn_animator_set);
        mBtnAnimatorSet.setOnClickListener(this);


        mBtnAnimatorMenu = findViewById(R.id.btn_animator_menu);
        mBtnAnimatorMenu.setOnClickListener(this);


        mBtnAnimatorAdvanced = findViewById(R.id.btn_animator_advanced);
        mBtnAnimatorAdvanced.setOnClickListener(this);


        mBtnAnimatorPhone = findViewById(R.id.btn_animator_phone);
        mBtnAnimatorPhone.setOnClickListener(this);



        mBtnAnimatorViewGroup = findViewById(R.id.btn_animator_view_group);
        mBtnAnimatorViewGroup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_value_animator:
                startActivity(new Intent(this, ValueAnimatorActivity.class));
                break;

            case R.id.btn_value_falling:
                startActivity(new Intent(this, FallingBallValueActivity.class));
                break;

            case R.id.btn_object_animator:
                startActivity(new Intent(this, ObjectAnimatorActivity.class));
                break;


            case R.id.btn_object_falling:
                startActivity(new Intent(this, FallingBallObjectActivity.class));
                break;

            case R.id.btn_animator_set:
                startActivity(new Intent(this, AnimatorSetActivity.class));
                break;

            case R.id.btn_animator_menu:
                startActivity(new Intent(this, MenuActivity.class));
                break;

            case R.id.btn_animator_advanced:
                startActivity(new Intent(this, AdvancedPropertyActivity.class));
                break;


            case R.id.btn_animator_phone:
                startActivity(new Intent(this, PhoneActivity.class));
                break;

            case R.id.btn_animator_view_group:
                startActivity(new Intent(this, ViewGroupAnimateActivity.class));
                break;


            default:

                break;
        }
    }
}
