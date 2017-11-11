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
class Sample11CameraRotateView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var point1 = Point(200, 500)
    var point2 = Point(600, 500)
    var camera: Camera = Camera()

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
        camera.setLocation(0f,0f,2000f)
    }

    var deg = 0f
    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        canvas.save()
        camera.save()
        camera.rotateX(deg)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        camera.save()
        camera.rotateY(deg)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.drawBitmap(bitmap,point2.x.toFloat(),point2.y.toFloat(),paint)
        canvas.restore()
        if (deg < 360) {
            Log.e("===>","draw")
            deg += 5f
            postDelayed(Runnable { invalidate() }, 100)
        }




    }
}