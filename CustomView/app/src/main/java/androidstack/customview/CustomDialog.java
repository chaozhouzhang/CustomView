package androidstack.customview;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import static android.graphics.Color.WHITE;

/**
 * Created on 2020/8/20 16:55
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class CustomDialog extends Dialog {
    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        immerseStatusBarColor(getWindow(), true, WHITE, true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = LayoutInflater.from(getContext()).inflate(R.layout.dialog_custom, null);
        Window w = getWindow();
        w.setContentView(v);
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.width = ConstraintLayout.LayoutParams.MATCH_PARENT;
        lp.height = ConstraintLayout.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.BOTTOM;
        w.setAttributes(lp);
        w.setBackgroundDrawable(null);
        w.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
    }

    /**
     * 设置沉浸模式
     * @param isDarkMode 状态栏字体为黑色
     */
    public static void immerseStatusBarColor(Window window, boolean isDarkMode, int color, boolean isDialog) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return;
        int uiVisibility = window.getDecorView().getSystemUiVisibility();
        if (isDarkMode) {
            uiVisibility ^= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            uiVisibility |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        } else {
            uiVisibility ^= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            uiVisibility |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        }
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        if (isDialog){
//            uiVisibility |=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE;
//        }else {
//        uiVisibility |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
//        }
        window.setStatusBarColor(color);
        window.getDecorView().setSystemUiVisibility(uiVisibility);
    }
}
