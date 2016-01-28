package in.raveesh.proteus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;

/**
 * Created by Raveesh on 27/01/16.
 */
public class Button extends android.widget.Button {
    private int proteusColorResource = 0;
    private Drawable[] originalDrawables;

    public Button(Context context) {
        super(context);
    }

    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.ImageView);
        originalDrawables = getCompoundDrawables();
        setPaint(a.getColor(R.styleable.ImageView_paint, 0));
        a.recycle();
    }

    public Button(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    public void setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom){
        if (proteusColorResource != 0){
            if (left != null){
                Rect bounds = left.getBounds();
                left = new BitmapDrawable(getResources(), Proteus.getColoredBitmap(left, proteusColorResource));
                left.setBounds(bounds);
            }
            if (top != null){
                top = new BitmapDrawable(getResources(), Proteus.getColoredBitmap(top, proteusColorResource));
            }
            if (right != null){
                right = new BitmapDrawable(getResources(), Proteus.getColoredBitmap(right, proteusColorResource));
            }
            if (bottom != null){
                bottom = new BitmapDrawable(getResources(), Proteus.getColoredBitmap(bottom, proteusColorResource));
            }
        }
        super.setCompoundDrawables(left, top, right, bottom);
    }

    public void setPaint(@ColorInt int paint){
        proteusColorResource = paint;
        setCompoundDrawables(originalDrawables[0], originalDrawables[1], originalDrawables[2], originalDrawables[3]);
    }
    public void setPaintResource(@ColorRes int paint){
        proteusColorResource = getContext().getResources().getColor(paint);
        setCompoundDrawables(originalDrawables[0], originalDrawables[1], originalDrawables[2], originalDrawables[3]);
    }
}
