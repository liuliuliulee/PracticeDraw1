package joy.liu.com.hencoderPractice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by joy on 2017/11/9.
 */
class Sample : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

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

    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
    }
}