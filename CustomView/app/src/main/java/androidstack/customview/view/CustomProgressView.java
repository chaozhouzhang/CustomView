package androidstack.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidstack.customview.R;
import androidx.annotation.Nullable;

/**
 * Created on 2020/6/22 22:02
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class CustomProgressView extends View {
    private int cpPercentTextsize = 40;
    private int cpPercentTextcolor = 0xff666666;
    private int cpBackgroundColor = 0xffFFF3F3;
    private int cpProgressColor = 0xffFEC7CD;
    private boolean cpBackgroundIsStroke = true;
    private int cpRectRound = 5;
    private Paint mPaint;
    private int mCenterX;
    private int mCenterY;

    private int progressCurrent = 0;
    private int progressMax = 100;


    /**
     * 一个参数的构造函数是在代码中创建对象的时候会被调用.
     *
     * @param context
     */
    public CustomProgressView(Context context) {
//        super(context);
        this(context, null);
    }

    /**
     * 两个参数的构造函数会在布局文件中使用这个View的时候被调用
     *
     * @param context
     * @param attrs
     */
    public CustomProgressView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
    }

    /**
     * 三个参数的构造函数会在布局文件中使用 style 的情况下会被调用
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CustomProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.CustomProgressView);
        cpPercentTextsize = (int) typedArray.getDimension(R.styleable.CustomProgressView_cp_percent_textsize, cpPercentTextsize);
        cpPercentTextcolor = typedArray.getColor(R.styleable.CustomProgressView_cp_percent_textcolor, cpPercentTextcolor);
        cpBackgroundColor = typedArray.getColor(R.styleable.CustomProgressView_cp_background_color, cpBackgroundColor);
        cpProgressColor = typedArray.getColor(R.styleable.CustomProgressView_cp_progress_color, cpProgressColor);
        cpBackgroundIsStroke = typedArray.getBoolean(R.styleable.CustomProgressView_cp_background_is_stroke, cpBackgroundIsStroke);
        cpRectRound = (int) typedArray.getDimension(R.styleable.CustomProgressView_cp_rect_round, cpRectRound);
        typedArray.recycle();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mCenterX = getWidth() / 2;
        mCenterY = getHeight() / 2;
        drawHorProgress(mPaint, canvas);
    }

    public int getCpPercentTextsize() {
        return cpPercentTextsize;
    }

    public CustomProgressView setCpPercentTextsize(int cpPercentTextsize) {
        this.cpPercentTextsize = cpPercentTextsize;
        return this;
    }

    public int getCpPercentTextcolor() {
        return cpPercentTextcolor;
    }

    public CustomProgressView setCpPercentTextcolor(int cpPercentTextcolor) {
        this.cpPercentTextcolor = cpPercentTextcolor;
        return this;
    }

    public int getCpBackgroundColor() {
        return cpBackgroundColor;
    }

    public CustomProgressView setCpBackgroundColor(int cpBackgroundColor) {
        this.cpBackgroundColor = cpBackgroundColor;
        return this;
    }

    public int getCpProgressColor() {
        return cpProgressColor;
    }

    public CustomProgressView setCpProgressColor(int cpProgressColor) {
        this.cpProgressColor = cpProgressColor;
        return this;
    }

    public boolean isCpBackgroundIsStroke() {
        return cpBackgroundIsStroke;
    }

    public CustomProgressView setCpBackgroundIsStroke(boolean cpBackgroundIsStroke) {
        this.cpBackgroundIsStroke = cpBackgroundIsStroke;
        return this;
    }

    public int getCpRectRound() {
        return cpRectRound;
    }

    public CustomProgressView setCpRectRound(int cpRectRound) {
        this.cpRectRound = cpRectRound;
        return this;
    }


    public int getProgressMax() {
        return progressMax;
    }

    public CustomProgressView setProgressMax(int progressMax) {
        this.progressMax = progressMax;
        return this;
    }

    private void drawHorProgress(Paint paint, Canvas canvas) {
        //画背景
        paint.setColor(cpBackgroundColor);
        if (cpBackgroundIsStroke) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(1);
        } else {
            paint.setStyle(Paint.Style.FILL);
        }
        RectF rectF = new RectF(mCenterX - getWidth() / 2, mCenterY - getHeight() / 2,
                mCenterX + getWidth() / 2, mCenterY + getHeight() / 2);
        Path path = new Path();
        /**
         * 必须传入8个数值，分四组，分别对应每个角所使用的椭圆的横轴半径和纵轴半径，如｛x1,y1,x2,y2,x3,y3,x4,y4｝，
         * 其中，x1,y1对应第一个角的（左上角）用来产生圆角的椭圆的横轴半径和纵轴半径，其它类推……
         */
        float radii[] ={0,0,25,25,25,25,25,25};
        path.addRoundRect(rectF, radii, Path.Direction.CCW);
        canvas.drawPath(path,paint);



        //画进度条
        paint.setColor(cpProgressColor);
        paint.setStyle(Paint.Style.FILL);
        RectF rectFPercent = new RectF(mCenterX - getWidth() / 2, mCenterY - getHeight() / 2,
                (int) (progressCurrent * getWidth() / progressMax), mCenterY + getHeight() / 2);
        Path pathPercent = new Path();
        /**
         * 必须传入8个数值，分四组，分别对应每个角所使用的椭圆的横轴半径和纵轴半径，如｛x1,y1,x2,y2,x3,y3,x4,y4｝，
         * 其中，x1,y1对应第一个角的（左上角）用来产生圆角的椭圆的横轴半径和纵轴半径，其它类推……
         */
        float radiiPercent[] ={0,0,25,25,25,25,25,25};
        pathPercent.addRoundRect(rectFPercent, radiiPercent, Path.Direction.CCW);
        canvas.drawPath(pathPercent,paint);


        //画文字
        paint.setColor(cpPercentTextcolor);
        paint.setTextSize(cpPercentTextsize);
        paint.setStyle(Paint.Style.FILL);
        String value_str = (int) (progressCurrent * 100 / progressMax) + "%";
        Rect rect = new Rect();
        paint.getTextBounds(value_str, 0, value_str.length(), rect);

        float textWidth = rect.width();
        float textHeight = rect.height();
        if (textWidth >= getWidth()) {
            textWidth = getWidth();
        }
        Paint.FontMetrics metrics = paint.getFontMetrics();
        float baseline = (getMeasuredHeight() - metrics.bottom + metrics.top) / 2 - metrics.top;
        canvas.drawText(value_str, getWidth()*9/10 - textWidth / 2, baseline, paint);

    }

    public int getProgressCurrent() {
        return progressCurrent;
    }

    public void setProgressCurrent(int progressCurrent) {
        if (progressCurrent > progressMax) {
            this.progressCurrent = progressMax;
        } else {
            this.progressCurrent = progressCurrent;
        }
        postInvalidate();
    }
}
