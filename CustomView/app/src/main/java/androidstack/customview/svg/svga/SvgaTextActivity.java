package androidstack.customview.svg.svga;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;

import org.jetbrains.annotations.NotNull;

import java.net.URL;

import androidstack.customview.R;

public class SvgaTextActivity extends AppCompatActivity {


    private Button mBtnSvgaText;
    private EditText mEdtSvgaText;


    private SVGAParser svgaParser;

    private SVGAImageView svgaImageView;

    private SVGAVideoEntity videoEntity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svga_text);

        mBtnSvgaText = findViewById(R.id.btn_svga_text);
        mEdtSvgaText = findViewById(R.id.edt_svga_text);
        svgaImageView = findViewById(R.id.svga_text);
        svgaParser = new SVGAParser(this);

        try {
            svgaParser.parse(new URL("https://github.com/yyued/SVGA-Samples/blob/master/kingset.svga?raw=true"),
                    new SVGAParser.ParseCompletion() {


                        @Override
                        public void onComplete(@NotNull SVGAVideoEntity videoItem) {
                            videoEntity =videoItem;
                        }
                        @Override
                        public void onError() {
                            Toast.makeText(SvgaTextActivity.this,"出错",Toast.LENGTH_LONG).show();
                        }
                    }
            );
        } catch (Exception e) {
            System.out.print(true);
        }


        mBtnSvgaText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mEdtSvgaText.getText().toString();
                if (TextUtils.isEmpty(content)){
                    Toast.makeText(SvgaTextActivity.this,"输入内容",Toast.LENGTH_LONG).show();
                    return;
                }
                if (videoEntity==null){
                    Toast.makeText(SvgaTextActivity.this,"svga资源解析中",Toast.LENGTH_LONG).show();
                    return;
                }
                SVGADynamicEntity dynamicEntity = new SVGADynamicEntity();
                TextPaint textPaint = new TextPaint();
                textPaint.setColor(Color.WHITE);
                textPaint.setTextSize(28);
                dynamicEntity.setDynamicText(content, textPaint, "banner");
                SVGADrawable drawable = new SVGADrawable(videoEntity, dynamicEntity);
                svgaImageView.setImageDrawable(drawable);
                svgaImageView.startAnimation();
            }
        });
    }
}
