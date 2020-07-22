package androidstack.progress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created on 2020/7/22 07:09
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class BasisView extends View {

    private Paint mPaint;
    private RectF mRectF;
    private Rect mRect;
    private Bitmap mBitmap;
    private Path mPath;


    public BasisView(Context context) {
        this(context, null);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }


    public BasisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * Lint警告：
     * Avoid object allocations during draw/layout operations (preallocate and reuse instead)
     * Issue: Looks for memory allocations within drawing code
     * Id: DrawAllocation
     * You should avoid allocating objects during a drawing or layout operation.
     * These are called frequently, so a smooth UI can be interrupted by garbage collection pauses caused by the object allocations.
     * The way this is generally handled is to allocate the needed objects up front and to reuse them for each drawing operation.
     * Some methods allocate memory on your behalf (such as Bitmap.create), and these should be handled in the same way.
     * 建议：不要在View绘制和做布局操作的时候实例化数据。
     * 原因：因为在View及其子类的onDraw(Canvas canvas)方法，会实时调用以更新界面，会频繁的创建对象和进行垃圾回收等，这明显就会影响UI的显示性能，这样一个显示很顺畅的用户界面就会因对象分配引起的一些垃圾回收机制进行短暂的停滞。
     * 解决方法：将创建对象等这些分配内存资源和会引起垃圾回收机制的操作在onDraw/onLayout之前进行，例如设置为全局变量，提取一个init()方法来实例化对象。
     */
    private void init() {
        mPaint = new Paint();
        mRectF = new RectF();
        mRect = new Rect();
        mBitmap = getBitmap(getContext(), R.mipmap.ic_launcher);
        mPath = new Path();
    }


    /**
     * BitmapFactory.decodeResource为null的处理方法。
     * 原因：其中R.mipmap.ic_launcher是一个vector图片，在5.0及以上的系统会出现空指针，原因在于此版本方法不能将vector转化为bitmap。
     *
     * @param context
     * @param vectorDrawableId
     * @return
     */
    private static Bitmap getBitmap(Context context, int vectorDrawableId) {
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            Drawable vectorDrawable = context.getDrawable(vectorDrawableId);
            bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                    vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            vectorDrawable.draw(canvas);
        } else {
            bitmap = BitmapFactory.decodeResource(context.getResources(), vectorDrawableId);
        }
        return bitmap;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 画布清屏
         */
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);


        /**
         * 绘制画布背景
         */
        //绘制画布背景，argb
        canvas.drawARGB(99, 255, 0, 255);
        canvas.drawRGB(255, 0, 255);
        canvas.drawColor(0xffFFF3F3);


        /**
         * 绘制圆形
         */
        //设置画笔的基本属性
        //设置画笔颜色
        mPaint.setColor(Color.RED);
        //设置画笔填充样式
        //仅填充内部
        mPaint.setStyle(Paint.Style.FILL);
        //填充内部和描边
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //仅填充描边
        mPaint.setStyle(Paint.Style.STROKE);
        //设置描边宽度，单位px，当填充样式是FILL_AND_STROKE时候有效
        mPaint.setStrokeWidth(20);
        //使用画布画圆
        canvas.drawCircle(200, 200, 150, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(200, 200, 130, mPaint);


        /**
         * 绘制点
         */
        //点的大小
        mPaint.setStrokeWidth(20);
        //绘制点，x坐标、y坐标
        canvas.drawPoint(340, 340, mPaint);


        /**
         * 绘制直线
         */
        //直线粗细
        mPaint.setStrokeWidth(20);
        //绘制直线起点x坐标、起点y坐标、终点x坐标、终点y坐标
        canvas.drawLine(360, 360, 660, 660, mPaint);


        /**
         * 绘制矩形
         */
        //矩形的边框粗细
        mPaint.setStrokeWidth(5);
        //仅填充矩形描边
        mPaint.setStyle(Paint.Style.STROKE);
        //绘制矩形，RectF是保存float类型的矩形，Rect是保存int类型的矩形，左上右下
        mRectF.set(400F, 400F, 450F, 450F);
        mRect.set(500, 500, 550, 550);
        canvas.drawRect(mRectF, mPaint);
        canvas.drawRect(mRect, mPaint);


        /**
         * 绘制扇形
         */
        mRectF.set(600, 600, 700, 700);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //椭圆、开始角度、扇形扫描过的角度、是否有焦点圆心，画笔，停止角度=开始角度+扇形扫描过的角度
        //true，绘制全部扇形
        //false，绘制开始点到结束点之间的区域，也就是扇形去除三角形后的区域
        canvas.drawArc(mRectF, -45, 180, true, mPaint);


        /**
         * 绘制位图，bitmap，左，上，画笔
         *
         setDither(boolean dither) 设置抖动处理
         setAlpha(int a) 设置透明度
         setAntiAlias(boolean aa) 是否开启抗锯齿
         setFilterBitmap() 是否开启优化Bitmap
         setColorFilter(ColorFilter filter) 设置颜色过滤
         setMaskFilter(MaskFilter maskFilter) 设置滤镜的效果
         setShader(Shader shader) 设置图像渐变效果
         setStrokeJoin(Paint.Join join) 设置图像结合方式
         setXfermode(Xfermode xfermode) 设置图像重叠效果
         setPathEffect(PathEffect effect) 设置路径效果 reset() 恢复默认设置
         */
        canvas.drawBitmap(mBitmap, 90, 90, mPaint);

        /**
         * 绘制文字
         * setColor(@ColorInt int color) 设置画笔颜色
         * setStrokeWidth(float width) 设置画笔粗细
         * setTextSkewX(float f) 设置倾斜，负右斜，正为左
         * setARGB(int a, int r, int g, int b) 设置颜色，a为透明度
         * setTextSize(float textSize) 设置绘制文字大小
         * setFakeBoldText(boolean fakeBoldText) 是否粗体
         * setTextAlign(Paint.Align align) 设置文字对齐方式，LEFT，CENTER，RIGHT setUnderlineText(boolean underlineText) 设置下划线
         * setStyle(Style style) 设置画笔样式，FILL，STROKE，FILL_AND_STROKE setTypeface(Typeface typeface) 设置Typeface对象，即字体风格，包括粗体，斜体以及衬线体，非衬线体等
         */
        mPaint.setTextSize(90f);
        canvas.drawText("Android Stack", 200, 1000, mPaint);


        /**
         * 绘制路径
         * moveTo()绘制的起始点
         * lineTo()连接的点
         */
        mPath.moveTo(600, 400);
        mPath.lineTo(700, 300);
        mPath.lineTo(700, 400);
        mPath.lineTo(600, 500);
        //闭环
        mPath.close();
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(mPath, mPaint);


        /**
         * 绘制圆角矩形
         */
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mRectF.set(100, 850, 850, 1100);
        canvas.drawRoundRect(mRectF, 200f, 200f, mPaint);



        /**
         * 绘制椭圆
         */
        mRectF.set(100, 1200, 300, 1300);
        canvas.drawOval(mRectF, mPaint);


        /**
         * 在路径上绘制文本
         */
        mPaint.setTextSize(60f);
        canvas.drawTextOnPath("android stack", mPath, 0f, -20f, mPaint);

        /**
         * 平移操作
         * 水平方向向平移动距离
         * 垂直方向向下平移距离
         * 坐标系的位置会随着Canvas左上角点的移动而移动，仅仅只是坐标系移动了而已，已经绘制的内容不会跟着移动。
         */
        canvas.translate(10F, 10F);

    }
}
