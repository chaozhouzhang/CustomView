package androidstack.customview.animation.property.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created on 2020/8/15 15:00
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        char currentChar = (char) (startValue+fraction*(endValue-startValue));
        return currentChar;
    }
}
