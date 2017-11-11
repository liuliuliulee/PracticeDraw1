package joy.liu.com.hencoderPractice.practice4

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import joy.liu.com.practicedraw1.R

/**
 * Created by joy on 2017/11/9.
 */
class Sample14FlipboardView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var camera: Camera = Camera()
//    var mMatrix = Matrix()
    var degree = 0f
        set(value) {
//            Log.e("===>", "set degree")
            field = value
            invalidate()
        }
    var animator = ObjectAnimator.ofFloat(this, "degree", 0f, 360f)
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
        animator.repeatMode = ValueAnimator.REVERSE;

//        val displayMetrics = resources.displayMetrics
//        val newZ = -displayMetrics.density * 6
//        camera.setLocation(0f, 0f, newZ)
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
        val centerX = width / 2
        val centerY = height / 2
        val x = centerX - bitmapWidth / 2
        val y = centerY - bitmapHeight / 2

        //第一遍绘制：上半部分
        canvas.save()
        canvas.clipRect(0f,0f,width.toFloat(),centerY.toFloat())
        canvas.drawBitmap(bitmap,x.toFloat(),y.toFloat(),paint)
        canvas.restore()

        //第二遍绘制：下半部分
        if(degree<90){
            canvas.clipRect(0f,centerX.toFloat(),width.toFloat(),height.toFloat())
        }else{
            canvas.clipRect(0f,0f,width.toFloat(),centerY.toFloat())
        }
        camera.save()
        camera.rotateX(degree)
        canvas.translate(centerX.toFloat(),centerY.toFloat())
        camera.applyToCanvas(canvas)
        canvas.translate(-centerX.toFloat(),-centerY.toFloat())
        camera.restore()

        canvas.drawBitmap(bitmap,x.toFloat(),y.toFloat(),paint)
        canvas.restore()
    }
}