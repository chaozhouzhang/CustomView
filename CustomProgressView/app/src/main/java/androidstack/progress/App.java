package androidstack.progress;

import android.app.Application;
import android.net.http.HttpResponseCache;

import java.io.File;
import java.io.IOException;

/**
 * Created on 2020/8/17 15:05
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            File cacheDir = new File(getCacheDir(), "http");
            HttpResponseCache.install(cacheDir, 1024 * 1024 * 128);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
