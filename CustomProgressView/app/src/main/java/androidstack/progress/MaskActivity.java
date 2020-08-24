package androidstack.progress;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidstack.progress.view.mask.GuideMask;
import androidstack.progress.view.mask.GuideMaskSet;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/24 13:05
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class MaskActivity extends AppCompatActivity {
    private ImageView mIvTest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask);

        mIvTest = findViewById(R.id.iv_test);

        GuideMask guideMask = new GuideMask.Builder(this)
                //蒙版所在activity
                .setMaskActivity(this)
                //目标布局
                .setTargetView(mIvTest)
                //蒙版背景颜色包括透明度
                .setBgColor(Color.parseColor("#40000000"))
                //蒙版布局
                .setMaskLayout(R.layout.layout_mask)
                //关闭蒙版的按钮
                .setMaskCloseId(R.id.btn_close)
                //围栏与目标布局的距离
                .setFencePadding(5,5,5,5)
                //围栏布局四角的角度
                .setFenceRadius(100)
                .build();

        GuideMaskSet guideMaskSet = new GuideMaskSet();
        //添加蒙版
        guideMaskSet.addGuide(guideMask);
        //显示所有蒙版
        guideMaskSet.show();
    }
}
