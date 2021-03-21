package androidstack.progress.animation.property.object;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;

/**
 * Created on 2020/8/15 16:59
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class FallingImageView extends androidx.appcompat.widget.AppCompatImageView {

    public FallingImageView(Context context) {
        super(context);
    }

    public FallingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FallingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 对象动画会使用反射自动调用此set方法
     * @param point
     */
    public void setFallingPos(Point point){
        layout(point.x,point.y,point.x+getWidth(),point.y+getHeight());
    }

    /**
     * 当指定一个动画值时，动画会通过get方法来获取初始值，否则会崩溃
     * @return
     */
    public Point getFallingPos(){
        return new Point(0,0);
    }

}
