package joy.liu.com.hencoderPractice.practice4

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/9.
 */
class Sample01ClipRectView: View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
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
        var left = (width-(bitmap?.width?:0))/2
        var top = (height-(bitmap?.height?:0))/2

        canvas.save()
        canvas.clipRect(left+50f,top+50f,left+300f,top+200f)
        canvas.drawBitmap(bitmap,left.toFloat(),top.toFloat(),paint)
        canvas.restore()
        canvas.drawBitmap(bitmap,0f,0f,paint)
    }
}