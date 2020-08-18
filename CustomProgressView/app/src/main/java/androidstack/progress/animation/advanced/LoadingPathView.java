package androidstack.progress.animation.advanced;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import androidstack.progress.R;
import androidx.annotation.Nullable;

/**
 * Created on 2020/8/16 17:42
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class LoadingPathView extends View {

    private Bitmap mArrow;
    private Paint mPaint;
    private Path mDstPath;
    private Path mCirclePath;
    private PathMeasure mPathMeasure;
    private Float mCurrentAnimValue;
    float mStop = 0.0f;
    float mStart = 0.0f;
    private float[] mPos = new float[2];
    private float[] mTan = new float[2];
    private Matrix mMatrix;
    public LoadingPathView(Context context) {
        this(context,null);
    }

    public LoadingPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoadingPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mArrow = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_arrow);
        mMatrix = new Matrix();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.RED);

        mDstPath = new Path();
        mCirclePath = new Path();
        mCirclePath.addCircle(dip2px(getContext(),100),dip2px(getContext(),100),dip2px(getContext(),25),Path.Direction.CW);
        mPathMeasure = new PathMeasure(mCirclePath,true);

        ValueAnimator animator = ValueAnimator.ofFloat(0,1);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取到旋转的角度值后刷新界面
                mCurrentAnimValue = (Float) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(2000);
        animator.start();
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mStop = mPathMeasure.getLength()*mCurrentAnimValue;
        mStart = (float) (mStop-((0.5-Math.abs(mCurrentAnimValue-0.5))*mPathMeasure.getLength()));
        mDstPath.reset();
        mPathMeasure.getSegment(mStart,mStop, mDstPath,true);
        //绘制路径
        canvas.drawPath(mDstPath, mPaint);

        mMatrix = new Matrix();

        /**
         * 第一种方式
         */
        mPathMeasure.getPosTan(mStop,mPos,mTan);
        float degrees = (float)(Math.atan2(mTan[1],mTan[0])*180.0/Math.PI);
        mMatrix.postRotate(degrees,mArrow.getWidth()/2,mArrow.getHeight()/2);
        mMatrix.postTranslate(mPos[0]-mArrow.getWidth()/2,mPos[1]-mArrow.getHeight()/2);

        /**
         * 第二种方式
         */
        mPathMeasure.getMatrix(mStop,mMatrix,PathMeasure.POSITION_MATRIX_FLAG|PathMeasure.TANGENT_MATRIX_FLAG);
        mMatrix.preTranslate(mArrow.getWidth()/2,-mArrow.getHeight()/2);
        //绘制箭头
        canvas.drawBitmap(mArrow,mMatrix,mPaint);
    }
}
