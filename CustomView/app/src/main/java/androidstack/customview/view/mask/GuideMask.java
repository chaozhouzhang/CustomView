package androidstack.customview.view.mask;

import android.app.Activity;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

/**
 * Created on 2020/8/23 21:52
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class GuideMask extends FrameLayout {

    /**
     * 当前蒙版所处的activity
     */
    private Activity mMaskActivity;
    /**
     * 当前activity的根布局
     */
    private FrameLayout mContentParent;
    /**
     * 当前activity的根布局的坐标位置
     */
    private Rect mContentRect;
    /**
     * 当前蒙版的目标布局
     */
    private View mTargetView;
    /**
     * 当前蒙版的目标布局的坐标位置
     */
    private Rect mTargetRect;
    /**
     * 当前需要绘制的围绕着目标布局的围栏布局
     */
    private RectF mFenceRectF;
    /**
     * 当前需要绘制的围绕着目标布局的围栏布局，对应的画笔
     */
    private Paint mFencePaint;
    /**
     * 当前蒙版所显示的引导布局，需要进行解析，然后显示
     */
    private int mMaskLayout;

    /**
     * 蒙版布局
     */
    private View mMaskLayoutView;

    /**
     * 点击该ID对应的控件后，关闭蒙版
     */
    private int mCloseId;

    /**
     * 蒙版的背景颜色
     */
    private int mBgColor = BG_COLOR_DEFAULT;

    /**
     * 蒙版的默认背景颜色
     */
    private static int BG_COLOR_DEFAULT = Color.parseColor("#B3000000");

    /**
     * 设置图像合成模式为CLEAR，用于显示目标布局
     */
    private PorterDuffXfermode mFenceClearMode;
    /**
     * 所需绘制的布局和目标布局的左边的距离大小
     */
    private int mPaddingLeft;

    /**
     * 所需绘制的布局和目标布局的右边的距离大小
     */
    private int mPaddingRight;

    /**
     * 所需绘制的布局和目标布局的上边的距离大小
     */
    private int mPaddingTop;

    /**
     * 所需绘制的布局和目标布局的下边的距离大小
     */
    private int mPaddingBottom;

    /**
     * 所需绘制的布局的四边圆角半径
     */
    private float mRadius;

    private GuideMask(@NonNull Context context) {
        super(context);
        init();
    }


    private void init() {
        //在ViewGroup中，初始化时设置了WILL_NOT_DRAW，设置WILL_NOT_DRAW之后，onDraw()不会被调用，通过略过绘制的过程，优化了性能。
        //所以，在写自定义布局时，如果需要调用onDraw()进行绘制，则需要在初始化时候，调用setWillNotDraw(false)。
        setWillNotDraw(false);
        mContentRect = new Rect();
        mTargetRect = new Rect();
        initFence();
    }

    /**
     * 初始化围栏区域
     */
    private void initFence() {
        //围栏区域坐标位置
        mFenceRectF = new RectF();
        //绘制围栏区域的画笔
        mFencePaint = new Paint();
        //设置围栏区域背景颜色为全透明色
        mFencePaint.setColor(Color.TRANSPARENT);
        //首先xfermode绘图需要两部分，DST,SRC 两种。可以理解为DST 在下边，SRC在上面。也就是说DST先绘制，SRC 后绘制。
        //PorterDuff.Mode.CLEAR：清除模式，[0, 0]，即图像中所有像素点的alpha和颜色值均为0。
        PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
        mFenceClearMode = new PorterDuffXfermode(mode);
        //这个方法用于设置图像的过渡模式，所谓过渡是指图像的饱和度、颜色值等参数的计算结果的图像表现。
        //设置围栏区域为清除模式，以达到显示目标布局的目的
        mFencePaint.setXfermode(mFenceClearMode);
        //设置画笔遮罩滤镜，传入BlurMaskFilter或EmbossMaskFilter，前者为模糊遮罩滤镜而后者为浮雕遮罩滤镜。
        //如果应用启用了硬件加速，将看不到任何阴影效果。
        mFencePaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.INNER));
        //关闭当前View的硬件加速。
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 设置蒙版背景颜色
         */
        canvas.drawColor(mBgColor);


        /**
         * 获取当前蒙版所目标的布局的坐标位置。
         */
        mTargetView.getGlobalVisibleRect(mTargetRect);

        /**
         * getGlobalVisibleRect()是View可见区域相对与屏幕来说的坐标位置。
         * getLocalVisibleRect()是View可见区域想对于自己坐标的位置。
         * 获取当前蒙版所在activity根布局的坐标位置。
         */
        mContentParent.getGlobalVisibleRect(mContentRect);

        /**
         * 需要绘制的坐标位置
         */
        int topMargin = mContentRect.top;
        int left = mTargetRect.left - mPaddingLeft;
        mFenceRectF.left = left;
        int right = mTargetRect.right + mPaddingRight;
        mFenceRectF.right = right;
        int top = mTargetRect.top - mPaddingTop - topMargin;
        mFenceRectF.top = top;
        int bottom = mTargetRect.bottom + mPaddingBottom - topMargin;
        mFenceRectF.bottom = bottom;
        /**
         * rx：x方向上的圆角半径。
         * ry：y方向上的圆角半径。
         */
        canvas.drawRoundRect(mFenceRectF, mRadius, mRadius, mFencePaint);
    }


    public void show() {
        //需要显示的蒙版布局：配置root为当前蒙版this，配置attachToRoot为true，也就是解析结束蒙版布局后，添加到当前蒙版中
        mMaskLayoutView = LayoutInflater.from(mMaskActivity).inflate(mMaskLayout, this, true);
        mContentParent.post(new Runnable() {
            @Override
            public void run() {
                //显示蒙版，也就是将当前蒙版加到mContentParent的FrameLayout布局上
                mContentParent.addView(GuideMask.this, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }
        });

        if (mCloseId != 0) {
            //在蒙版布局中找到点击关闭蒙版的控件
            mMaskLayoutView.findViewById(mCloseId).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                    if (mOnDismissListener != null) {
                        mOnDismissListener.onDismiss();
                    }
                }
            });
        }
    }

    public void dismiss() {
        mContentParent.post(new Runnable() {
            @Override
            public void run() {
                //关闭蒙版，也就是将当前蒙版从mContentParent的FrameLayout布局上移除
                mContentParent.removeView(GuideMask.this);
            }
        });
    }


    public static class Builder {

        private GuideMask mGuideMask;

        public Builder(Context context) {
            mGuideMask = new GuideMask(context);
        }

        /**
         * 设置目标布局
         *
         * @param view
         * @return
         */
        public Builder setTargetView(View view) {
            mGuideMask.mTargetView = view;
            return this;
        }

        /**
         * 设置当前引导蒙版所在的Activity
         *
         * @param activity
         */
        public Builder setMaskActivity(Activity activity) {
            mGuideMask.mMaskActivity = activity;
            mGuideMask.mContentParent = activity.findViewById(android.R.id.content);
            return this;
        }

        /**
         * 设置显示的蒙版布局
         *
         * @param layout
         * @return
         */
        public Builder setMaskLayout(@LayoutRes int layout) {
            mGuideMask.mMaskLayout = layout;
            return this;
        }

        /**
         * 设置关闭蒙版的控件ID
         *
         * @param closeId
         * @return
         */
        public Builder setMaskCloseId(@IdRes int closeId) {
            mGuideMask.mCloseId = closeId;
            return this;
        }

        /**
         * 所绘制布局的四边圆角半径
         *
         * @param radius
         * @return
         */
        public Builder setFenceRadius(float radius) {
            mGuideMask.mRadius = radius;
            return this;
        }

        /**
         * 与目标布局间的距离
         *
         * @param paddingLeft
         * @param paddingRight
         * @param paddingTop
         * @param paddingBottom
         * @return
         */
        public Builder setFencePadding(int paddingLeft, int paddingRight, int paddingTop, int paddingBottom) {
            mGuideMask.mPaddingTop = paddingTop;
            mGuideMask.mPaddingBottom = paddingBottom;
            mGuideMask.mPaddingLeft = paddingLeft;
            mGuideMask.mPaddingRight = paddingRight;
            return this;
        }

        /**
         * 设置蒙版背景颜色
         *
         * @param bgColor
         * @return
         */
        public Builder setBgColor(int bgColor) {
            mGuideMask.mBgColor = bgColor;
            return this;
        }

        public GuideMask build() {
            return mGuideMask;
        }
    }


    private OnDismissListener mOnDismissListener;

    public GuideMask setOnDismissListener(OnDismissListener onDismissListener) {
        mOnDismissListener = onDismissListener;
        return this;
    }

    public interface OnDismissListener {
        /**
         * 关闭蒙版
         */
        void onDismiss();
    }

}
