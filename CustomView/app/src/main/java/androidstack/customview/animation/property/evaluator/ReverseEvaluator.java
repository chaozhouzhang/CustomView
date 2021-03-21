package androidstack.customview.animation.property.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created on 2020/8/15 11:24
 * 自定义估值器，实现类型估值器TypeEvaluator<Integer>，并传入泛型的具体类型
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class ReverseEvaluator implements TypeEvaluator<Integer> {

    /**
     * @param fraction   插值器中的进度返回值
     * @param startValue 动画数值区间的起始数值
     * @param endValue   动画数值区间的结束数值
     * @return 估值器返回给监听器的具体动画数值
     */
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int) (endValue - fraction * (endValue - startValue));
    }
}
