package androidstack.customview.animation.interpolator;

import android.view.animation.Interpolator;

/**
 * Created on 2020/8/15 09:29
 * 自定义插值器，实现时间插值器TimeInterpolator后，实现获取插值Interpolation的方法，此方法的实现需要数学知识。
 * 也可以直接实现Interpolator，因为Interpolator继承的是时间插值器TimeInterpolator。
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class ReverseInterpolator implements Interpolator {

    /**
     * @param input 取值范围为0-1，表示当前动画进度，0刚开始动画，1结束动画，0-1，动画进行中。
     * @return 返回实际想要的进度，小于0表示小于开始位置，大于1表示超过目标位置，0-1表示在开始位置和目标位置中间。
     */
    @Override
    public float getInterpolation(float input) {
        return 1 - input;
    }
}
