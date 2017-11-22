package joy.liu.com.hencoderPractice.practice7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by joy on 2017/11/21.
 */

public class Sample02HsvEvaluatorView extends View {
    public int color = 0xffff0000;
    public Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Sample02HsvEvaluatorView(Context context) {
        super(context);
    }

    public Sample02HsvEvaluatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample02HsvEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        paint.setColor(color);
        canvas.drawCircle(width/2,height/2,width/6,paint);
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }

    public int getColor() {
        return color;
    }
}
