package joy.liu.com.hencoderPractice.practice7;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import joy.liu.com.practicedraw1.R;

/**
 * Created by joy on 2017/11/21.
 */

public class Sample01ArgbEvaluatorLayout extends RelativeLayout {
    Sample01ArgbEvaluatorView view;
    Button animateBt;
    public Sample01ArgbEvaluatorLayout(Context context) {
        super(context);
    }

    public Sample01ArgbEvaluatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01ArgbEvaluatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        view = findViewById(R.id.objectAnimatorView);
        animateBt = findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofInt(view, "color", 0xffff0000, 0xff00ff00);
                animator.setEvaluator(new ArgbEvaluator());
                animator.setDuration(2000);
                animator.start();
            }
        });
    }
}
