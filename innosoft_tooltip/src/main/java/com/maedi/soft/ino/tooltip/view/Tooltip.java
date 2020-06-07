package com.maedi.soft.ino.tooltip.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.maedi.soft.ino.tooltip.R;

public class Tooltip extends LinearLayout {

    private Paint paint;
    private Path path;
    private Context ctx;
    private int bgColor, radius, arrowDirection, arrowHeight, arrowWidth, tt_gravity, tt_style;
    private int arrowPos;
    private String strArrowPos;
    private int heightWall;

    private Tooltip tooltip;

    public Tooltip(Context context) {
        super(context);
        ctx = context;
        initialize(ctx);
    }

    public Tooltip(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        initialize(ctx);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TooltipLayout,
                0, 0
        );
        try {
            if(null != a)
            {
                bgColor = a.getColor(R.styleable.TooltipLayout_tooltip_backgroundColor, ctx.getResources().getColor(R.color.em_black_100));
                radius = a.getInt(R.styleable.TooltipLayout_tooltip_cornerRadius, 0);
                arrowDirection = a.getInt(R.styleable.TooltipLayout_tooltip_arrowDirection, 0);
                arrowHeight = a.getInt(R.styleable.TooltipLayout_tooltip_arrowHeight, 0);
                arrowWidth = a.getInt(R.styleable.TooltipLayout_tooltip_arrowWidth, 0);
                strArrowPos = a.getString(R.styleable.TooltipLayout_tooltip_arrowPosition);
                tt_gravity = a.getInt(R.styleable.TooltipLayout_tooltip_gravity, 0);
                tt_style = a.getInt(R.styleable.TooltipLayout_tooltip_style, 0);

                if(null != strArrowPos) {
                    if (strArrowPos.equalsIgnoreCase("-1")) {
                        arrowPos = a.getInt(R.styleable.TooltipLayout_tooltip_arrowPosition, -1);
                    } else {
                        arrowPos = a.getInt(R.styleable.TooltipLayout_tooltip_arrowPosition, 0);
                    }
                }
            }
        } finally {
            // release the TypedArray so that it can be reused.
            a.recycle();
        }

    }

    public Tooltip(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        ctx = context;
        initialize(ctx);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();
        heightWall = h;
        if(tt_style == 0)
        {
            paint.setStyle(Paint.Style.FILL);
        }
        else
        {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);
        }
        paint.setColor(bgColor);

        if(arrowHeight > (h/2))arrowHeight = h/2;
        if(arrowWidth > (w/2))arrowWidth = w/2;
        int ch = h/8;
        if(radius > ch)radius = ch;
        int p = arrowHeight;
        int p2 = arrowWidth/2;
        if(arrowPos > 0){
            if(arrowPos < radius)arrowPos = radius;
            else if(arrowPos > (w-(radius*4)))arrowPos = w-(radius*4);
        }
        int c = arrowPos < 0 ? (w/2)-(p2) : arrowPos;
        c = Math.abs(c);
        if(c < radius)c=radius;
        else {
            int limitRight = w - (radius * 2);
            if (c > limitRight) c = limitRight;
        }

        int c2 = c+p2;
        int c3 = c+(p2*2);
        int y = h-(h-p);

        if(arrowDirection == 0) {
            path.moveTo(0, y + radius);
            path.quadTo(0, y, radius, y);
            path.lineTo(c, y);
            path.lineTo(c2, 0);
            path.lineTo(c3, y);

            path.lineTo(w - radius, y);
            path.quadTo(w, y, w, y + radius);

            path.lineTo(w, h - radius);
            path.quadTo(w, h, w - radius, h);

            path.lineTo(radius, h);
            path.quadTo(0, h, 0, h - radius);

            path.lineTo(0, y + radius);
            canvas.drawPath(path, paint);
        }
        else
        {
            int posFromBottom = h-arrowHeight;
            path.moveTo(0, radius);
            path.quadTo(0, 0, radius, 0);

            path.lineTo(w - radius, 0);
            path.quadTo(w, 0, w, radius);

            path.lineTo(w, posFromBottom - radius);
            path.quadTo(w, posFromBottom, w - radius, posFromBottom);

            path.lineTo(c3, posFromBottom);
            path.lineTo(c2, h);
            path.lineTo(c, posFromBottom);

            path.lineTo(radius, posFromBottom);
            path.quadTo(0, posFromBottom, 0, posFromBottom-radius);

            path.lineTo(0, radius);
            canvas.drawPath(path, paint);

        }

        findSpecChild(tooltip, arrowDirection);
    }

    private void initialize(Context context) {
        ctx = context;
        this.setWillNotDraw(false);
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
        tooltip = this;
        //default value
        radius = 30;
        arrowHeight = 50;
        arrowWidth = 80;
        arrowDirection = 1;
        arrowPos = -1;
        tt_gravity = 0;
        tt_style = 0;
        bgColor = ctx.getResources().getColor(R.color.em_black_100);//default
    }

    private View findSpecChild(View view, int arrow_dir) {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        int top = tt_gravity == 0 ? arrowHeight : heightWall/2;
        int mrgT = arrow_dir == 0 ? 0 : (top+radius);
        params.setMargins(radius, top, radius, mrgT);//l,t,r,b
        //params.gravity = Gravity.CENTER;
        ViewGroup group = (ViewGroup) view;
        for (int i = 0, count = group.getChildCount(); i < count; i++) {
            if(i==0)
            {
                View v = group.getChildAt(i);
                v.setLayoutParams(params);
                break;
            }
        }
        return view;
    }

    public boolean isVisible()
    {
        if(tooltip.getVisibility() == View.VISIBLE)
            return true;
        else return false;
    }

    public void showViewWithAnim(View view)
    {
        scaleView(view, 0f, 1f, true);//startScale = Y == 0, endScale = Y == full
    }

    public void hideViewWithAnim(View view)
    {
        scaleView(view, 1f, 0f, false);//startScale = Y == full, endScale = Y == 0
    }

    private void scaleView(View v, float startScale, float endScale, boolean show) {
        if(show)v.setVisibility(View.VISIBLE);
        float pivotYVal = arrowDirection == 1 ? 1 : 0;
        Animation anim = new ScaleAnimation(
                1f, 1f, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 1f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, pivotYVal); // Pivot point of Y scaling, 0 anim from top, 1 anim from bottom
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(200);
        anim.setAnimationListener(new Animation.AnimationListener() {

                                      @Override
                                      public void onAnimationStart(Animation animation) {

                                      }

                                      @Override
                                      public void onAnimationEnd(Animation animation) {
                                        if(!show)v.setVisibility(View.GONE);
                                      }

                                      @Override
                                      public void onAnimationRepeat(Animation animation) {

                                      }
                                  });
        v.startAnimation(anim);
    }
}
