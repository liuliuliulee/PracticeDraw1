package joy.liu.com.hencoderPractice.practice4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.R




/**
 * Created by joy on 2017/11/9.
 */
class Sample04ScaleView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var point1 = Point(200, 200)
    var point2 = Point(600, 200)
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
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        val bitmapWidth = bitmap?.width?:0
        val bitmapHeight = bitmap?.height?:0

        canvas.save()
        canvas.scale(1.3f, 1.3f, (point1.x + bitmapWidth / 2).toFloat(), (point1.y + bitmapHeight / 2).toFloat())
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()


        canvas.save()
        canvas.scale(0.6f, 1.6f, (point2.x + bitmapWidth / 2).toFloat(), (point2.y + bitmapHeight / 2).toFloat())
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}