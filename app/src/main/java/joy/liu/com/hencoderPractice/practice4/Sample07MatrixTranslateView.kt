package joy.liu.com.hencoderPractice.practice4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/9.
 */
class Sample07MatrixTranslateView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var point1 = Point(200, 200)
    var point2 = Point(600, 200)
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
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        canvas.save()
        mMatrix.reset()
        mMatrix.postTranslate(-100f, -100f)
        canvas.concat(mMatrix)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        mMatrix.reset()
        mMatrix.postTranslate(200f, 0f)
        canvas.concat(mMatrix)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}