package androidstack.progress.svg.svga;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;

import java.net.MalformedURLException;
import java.net.URL;

import androidstack.progress.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * Created on 2020/8/17 14:39
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class SvgaActivity extends AppCompatActivity {
    private SVGAImageView mSvgaTest;
    private ConstraintLayout mCLSvga;
    private FrameLayout mFlSvga1;
    private FrameLayout mFlSvga2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svga);
        mSvgaTest = findViewById(R.id.svga_test);
        mCLSvga = findViewById(R.id.cl_svga);
        mFlSvga1 = findViewById(R.id.fl_svga1);
        mFlSvga2 = findViewById(R.id.fl_svga2);


        /**
         * xml代码实现：
         * source:表示 svga 文件的路径，提供一个在 assets 目录下的文件名，或者提供一个 http url 地址。
         * autoPlay:当动画加载完成后，自动播放。
         * loopCount:默认为 0，设置动画的循环次数，0 表示无限循环。
         * clearsAfterStop:默认为 true，当动画播放完成后，是否清空画布。
         * fillMode:默认为 Forward。Forward 表示动画结束后，将停留在最后一帧。Backward 表示动画结束后，将停留在第一帧。
         */
        codeAnimation();


    }

    private void codeAnimation() {

        SVGAImageView svgaImageView = new SVGAImageView(this);
        SVGAParser.Companion.shareParser().init(this);
        SVGAParser parser = SVGAParser.Companion.shareParser();
        parser = new SVGAParser(this);
        parser.decodeFromAssets("posche.svga", new SVGAParser.ParseCompletion() {
            @Override
            public void onComplete(SVGAVideoEntity svgaVideoEntity) {
                SVGADrawable drawable = new SVGADrawable(svgaVideoEntity);
                svgaImageView.setImageDrawable(drawable);
                mFlSvga1.addView(svgaImageView );
                svgaImageView.startAnimation();
            }

            @Override
            public void onError() {

                System.out.println("解析错误decodeFromAssets");
            }
        });

        try {
            SVGAImageView svgaImageView1 = new SVGAImageView(this);
            SVGAParser parser1 = SVGAParser.Companion.shareParser();
            parser1 = new SVGAParser(this);
            URL url = new URL("https://github.com/yyued/SVGA-Samples/blob/master/posche.svga?raw=true");
            parser1.decodeFromURL(url, new SVGAParser.ParseCompletion() {
                @Override
                public void onComplete(SVGAVideoEntity svgaVideoEntity) {
                    SVGADrawable drawable = new SVGADrawable(svgaVideoEntity);
                    svgaImageView1.setImageDrawable(drawable);
                    mFlSvga2.addView(svgaImageView1 );
                    svgaImageView1.startAnimation();
                }

                @Override
                public void onError() {
                    System.out.println("解析错误decodeFromURL");
                }
            });
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

}
