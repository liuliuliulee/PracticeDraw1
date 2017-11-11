package joy.liu.com.hencoderPractice.practice4

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import joy.liu.com.practicedraw1.R




/**
 * Created by joy on 2017/11/9.
 */
class Sample13CameraRotateHittingFaceView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var point1 = Point(200, 500)
    var point2 = Point(600, 500)
    var camera: Camera = Camera()
    var mMatrix = Matrix()
    var degree = 0f
        set(value) {
            Log.e("===>","set degree")
            field = value
            invalidate()
        }
    var animator = ObjectAnimator.ofFloat(this,"degree",0f,360f)
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
//        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, (bitmap?.width)?:0 * 2, (bitmap?.height)?:0 * 2, true)
//        bitmap?.recycle()
//        bitmap = scaledBitmap
        animator.duration = 5000
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE

        val displayMetrics = resources.displayMetrics
        val newZ = -displayMetrics.density * 6
        camera.setLocation(0f, 0f, newZ)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }


    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        val bitmapWidth = bitmap?.width?:0
        val bitmapHeight = bitmap?.height?:0
        val center1X = point1.x + bitmapWidth / 2
        val center1Y = point1.y + bitmapHeight / 2
        val center2X = point2.x + bitmapWidth / 2
        val center2Y = point2.y + bitmapHeight / 2


        camera.save()
        mMatrix.reset()
        camera.rotateX(degree)
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
        camera.rotateY(degree)
        //让 camera 移动回原位
        canvas.translate(center2X.toFloat(),center2Y.toFloat())
        //投影
        camera.applyToCanvas(canvas)
        //让 camera 移动到图片中心的上方
        canvas.translate(-center2X.toFloat(),-center2Y.toFloat())
        camera.restore()
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()

    }
}