package androidstack.progress.animation.property.value;

import android.animation.TypeEvaluator;
import android.graphics.Point;

/**
 * Created on 2020/8/15 15:56
 * 自定义估值器，一般与自定义View配合使用
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class FallingBallEvaluator implements TypeEvaluator<Point> {
    private Point mPoint = new Point();
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        mPoint.x = (int)(startValue.x+fraction*(endValue.x-startValue.x));
        if (fraction*2<1){
            mPoint.y = (int) (startValue.y+fraction*2*(endValue.y-startValue.y));
        }else {
            mPoint.y = endValue.y;
        }
        return mPoint;
    }
}
