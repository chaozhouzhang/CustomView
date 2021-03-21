package androidstack.customview.drawing;

import android.os.Bundle;

import androidstack.customview.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/19 23:08
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class PaintActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
    }
    /**
     * 硬件加速：GPU 图形处理器，全称Graphic Processing Unit，专门处理多媒体的计算、存储任务。
     * Android11之前没有GPU硬件加速；
     * Android11-13：有GPU硬件加速，但是默认关闭；
     * Android14开始：默认开启硬件加速。
     */



}
