package androidstack.progress.view.mask;

import java.util.ArrayList;
import java.util.List;

/**
 * 蒙版集合
 * @author zhangchaozhou
 */
public class GuideMaskSet {

    private List<GuideMask> mGuideMasks = new ArrayList<>();

    private int mPosition = 0;

    /**
     * 添加蒙版
     * @param guideMask
     */
    public void addGuide(GuideMask guideMask) {
        mGuideMasks.add(guideMask);
        guideMask.setOnDismissListener(new GuideMask.OnDismissListener() {
            @Override
            public void onDismiss() {//关闭后显示下一个蒙版
                int nextPosition = mPosition + 1;
                if (mGuideMasks.size() > nextPosition) {
                    GuideMask next = mGuideMasks.get(nextPosition);
                    mPosition++;
                    next.show();
                }
            }
        });
    }

    /**
     * 显示蒙版集合
     */
    public void show(){
        mGuideMasks.get(0).show();
    }
}
