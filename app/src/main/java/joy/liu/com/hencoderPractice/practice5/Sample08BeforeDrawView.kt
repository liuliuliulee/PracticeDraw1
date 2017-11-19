package joy.liu.com.hencoderPractice.practice5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet


/**
 * Created by joy on 2017/11/14.
 */
class Sample08BeforeDrawView : AppCompatEditText {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

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

    override fun draw(canvas: Canvas?) {
        canvas?.drawColor(Color.parseColor("#66BB6A")); // 涂上绿色
        super.draw(canvas)
    }

}