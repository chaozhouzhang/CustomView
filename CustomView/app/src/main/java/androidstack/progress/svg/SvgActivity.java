package androidstack.progress.svg;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import androidstack.progress.R;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

/**
 * Created on 2020/8/17 10:09
 * <p>
 * SVG 可缩放矢量图形 Scalable Vector Graphics：
 * 经过数学计算利用直线和曲线绘制而成，无论怎么放大，都不会出现马赛克现象。
 * illustrator：矢量图绘图软件。
 * <p>
 * Bitmap 位图：
 * 由一个个像素点组成，放大后会出现马赛克。
 * PhotoShop：位图绘图软件。
 * <p>
 * SVG优势：
 * 使用xml格式定义图形，读取和修改的工具多。
 * 不会失真，无需根据分辨率适配多套图标。
 * 占用空间小。
 * 可以转换为Path路径，与Path动画相结合，形成更丰富的动画。
 * <p>
 * SVG标签：
 * rect 矩形
 * circle 圆形
 * line 线段
 * polyline 折线段
 * ellipse 椭圆
 * polygon 多边形
 * path 路径
 * <p>
 * https://editor.method.ac/
 * 制作 SVG 图像。
 * <p>
 * http://www.iconfont.cn/
 * Iconfont是一种比较成熟的 SVG 解决方案，它的原理是:
 * 把矢量图标打包成一个.ttf文件，在 Android 中应用这个.ttf文件来方便地加载和指定各种图标。
 * <p>
 * http://inloop.github.io/svg2android/
 * SVG转vector
 * <p>
 * Android Studio-File-New-Vector Asset-Local File-RTL
 * SVG转vector：ic_love.xml
 * <p>
 * trimPathStart 属性表示截掉 从起点到某个位置的部分，保留剩下的部分；
 * trimPathEnd 属性表示截掉 从某个位置到终点的部分，保留剩下的部分。
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class SvgActivity extends AppCompatActivity {

    private ImageView mIvSvgVectorAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);
        mIvSvgVectorAnimation = findViewById(R.id.iv_svg_vector_animation);
        start1();
//        start2();
    }

    private void start1() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
                this, R.drawable.ic_logo
        );
        mIvSvgVectorAnimation.setImageDrawable(animatedVectorDrawableCompat);
        ((Animatable) mIvSvgVectorAnimation.getDrawable()).start();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void start2() {
        AnimatedVectorDrawable anim =
                (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.ic_logo);
        mIvSvgVectorAnimation.setImageDrawable(anim);
        anim.start();

    }
}
