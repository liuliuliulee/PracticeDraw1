package joy.liu.com.hencoderPractice.practice4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import joy.liu.com.practicedraw1.R



/**
 * Created by joy on 2017/11/9.
 */
class Sample12CameraRotateFixedView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var point1 = Point(200, 500)
    var point2 = Point(600, 500)
    var camera: Camera = Camera()
    var mMatrix = Matrix()
    constructor(context: Context) : super(context) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initData()
    }

    private fun initData() {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
//        camera.setLocation(0f,0f,2000f)
    }

    var deg = 0f
    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        val bitmapWidth = bitmap?.width?:0
        val bitmapHeight = bitmap?.height?:0
        val center1X = point1.x + bitmapWidth / 2
        val center1Y = point1.y + bitmapHeight / 2
        val center2X = point2.x + bitmapWidth / 2
        val center2Y = point2.y + bitmapHeight / 2

//        camera.save()
//        mMatrix.reset()
//        camera.rotateX(deg)
//        camera.getMatrix(matrix)
////        camera.applyToCanvas(canvas)
//        camera.restore()
//        matrix.postTranslate(-center1X.toFloat(),-center1Y.toFloat())
//        matrix.postTranslate(center1X.toFloat(),center1Y.toFloat())
//        canvas.save()
//        canvas.concat(matrix)
//        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
//        canvas.restore()
//
//
//        camera.save()
//        matrix.reset()
//        camera.rotateY(deg)
//        camera.getMatrix(matrix)
//        camera.restore()
//        matrix.postTranslate(-center2X.toFloat(),-center2Y.toFloat())
//        matrix.postTranslate(center2X.toFloat(),center2Y.toFloat())
//        canvas.save()
//        canvas.concat(matrix)
//        canvas.drawBitmap(bitmap,point2.x.toFloat(),point2.y.toFloat(),paint)
//        canvas.restore()

        camera.save()
        mMatrix.reset()
        camera.rotateX(deg)
        //计算当前状态下矩阵对应的状态，并将计算后的矩阵赋值给参数 matrix，得到 camera 旋转后的矩阵。
        camera.getMatrix(mMatrix)
        camera.restore()
        //前乘，让 camera 移动到图片中心的上方，pre 操作越前，越迟执行
        mMatrix.preTranslate(-center1X.toFloat(),-center1Y.toFloat())
        //后乘，让 camera 移动回原位，post 操作越前，越前执行
        mMatrix.postTranslate(center1X.toFloat(),center1Y.toFloat())
        canvas.save()
        canvas.concat(mMatrix)//矩阵换行作用到 canvas
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        camera.save()
        camera.rotateY(deg)
        //让 camera 移动回原位
        canvas.translate(center2X.toFloat(),center2Y.toFloat())
        //投影
        camera.applyToCanvas(canvas)
        //让 camera 移动到图片中心的上方
        canvas.translate(-center2X.toFloat(),-center2Y.toFloat())
        camera.restore()
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()

        if (deg < 360) {
            Log.e("===>", "draw")
            deg += 5f
            postDelayed(Runnable { invalidate() }, 100)
        }




    }
}