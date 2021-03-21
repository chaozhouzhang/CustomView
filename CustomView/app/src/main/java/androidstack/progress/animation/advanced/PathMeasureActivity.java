package androidstack.progress.animation.advanced;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Bundle;

import androidstack.progress.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created on 2020/8/16 11:31
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class PathMeasureActivity extends AppCompatActivity {
    private LoadingPathView mLoadingPathView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_measure);
        mLoadingPathView = findViewById(R.id.lpv_circle);
    }


    public void path() {

        Path path = new Path();
        PathMeasure pathMeasure1 = new PathMeasure();
        /**
         * 路径是否闭合 forceClosed
         */
        pathMeasure1.setPath(path, true);


        PathMeasure pathMeasure2 = new PathMeasure(path, true);


        /**
         * 路径长度，测量的是当前路径状态的长度，如果forceClosed为true，则不论路径是否闭合，测量的都是路径的闭合长度。
         * 获取到的长度是当前曲线的长度。
         */
        System.out.println(pathMeasure1.getLength());

        System.out.println(pathMeasure2.getLength());

        /**
         * 判断路径是否闭合
         */
        System.out.println(pathMeasure1.isClosed());


        /**
         * 跳转到下一条曲线，true表示跳转成功，false表示跳转失败。
         *
         */
        System.out.println(pathMeasure1.nextContour());


        /**
         * 通过nextContour得到的曲线的顺序和Path中添加的顺序相同。
         */
        do {
            System.out.println(pathMeasure1.getLength());
        } while (pathMeasure1.nextContour());

        /**
         * 截取整个Path中startD到stopD的某个片段，如果不在范围则返回false，截取后添加Path到dst中。
         * startWithMoveTo：如果为true，则被截取的Path片段保持原状添加到dst中；如果为false，则被截取的Path片段的起始点移动到dst的最后一个点，保证dst路径的连续性。
         * 需要禁用硬件加速功能，setLayerType(LAYER_TYPE_SOFTWARE,null)。
         * 路径截取是以左上角顺时针Path.Direction.CW或逆时针Path.Direction.CCW截取。
         */
        boolean isSuccess = pathMeasure1.getSegment(0, 10, new Path(), true);


        /**
         *
         * 获取路径上某一长度的位置以及该位置的正切值
         * distance：距离path起始点的长度，0<=distance<=pathMeasure1.getLength()
         * pos 位置的坐标值，pos[0]是x坐标，pos[1]是y坐标
         * tan 位置坐标的正切值，也就是坐标到原点与X轴所成夹角对应的正切值，tan[0]是x坐标，tan[1]是y坐标，是半径为1的圆的对应点，y/x就是正切值
         * 求反正切值，根据正切值获得对应夹角的度数，也就是反正切，atan(double d)传入弧度值也就是正切的结果值，atan2(double x, double y)传入正切的点的坐标值。
         * 如果想要让移动点旋转至与切线重合，则旋转角度要与正切角度相同。
         */
        boolean isTanSuccess = pathMeasure1.getPosTan(1, new float[]{1F, 1F}, new float[]{1F, 1F});


        /**
         * 得到路径上某一长度的位置，以及该位置的正切值的矩阵。
         * distance：距离Path起始点的长度
         * matrix：matrix会根据flags的设置而存入不同的内容。
         * flags：指定存入matrix中的内容。POSITION_MATRIX_FLAG：获取位置信息。TANGENT_MATRIX_FLAG：获取切边信息，使得图片按Path旋转。
         */
        boolean isMatrixSuccess = pathMeasure1.getMatrix(1, new Matrix(), PathMeasure.POSITION_MATRIX_FLAG);


        /**
         * getMatrix()是getPosTan()函数的另一种实现。
         * getPosTan()将获取到的位置信息和切边信息存储在pos和tan数组中；
         * getMatrix()将位置信息和切边信息存储在matrix中。
         */
    }
}
