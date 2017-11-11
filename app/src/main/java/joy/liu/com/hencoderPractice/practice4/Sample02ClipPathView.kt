package joy.liu.com.hencoderPractice.practice4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/9.
 */
class Sample02ClipPathView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var path1 = Path()
    var path2 = Path()
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

        path1.addCircle(point1.x + 200f, point1.y + 200f, 150f, Path.Direction.CW)

        path2.fillType = Path.FillType.INVERSE_WINDING//结果是截去 path 形状内的图形
        path2.addCircle(point2.x + 200f, point2.y + 200f, 150f, Path.Direction.CW)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.save()
        canvas.clipPath(path1)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        canvas.clipPath(path2)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}