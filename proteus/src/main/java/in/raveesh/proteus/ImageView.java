package in.raveesh.proteus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;


/**
 * Created by Raveesh on 02/04/15.
 */
public class ImageView extends android.widget.ImageView {
    private int proteusColorResource = 0;

    public ImageView(Context context) {
        super(context);
    }

    public ImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.ImageView, defStyleAttr, 0);
        proteusColorResource = a.getColor(R.styleable.ImageView_paint, 0);
        Drawable d = getDrawable();
        if (d != null && proteusColorResource != 0) {
            setImageDrawable(d);
        }
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        if (proteusColorResource != 0) {
            BitmapDrawable d = new BitmapDrawable(getResources(), Proteus.getColoredBitmap(drawable, proteusColorResource));
            super.setImageDrawable(d);
        } else {
            super.setImageDrawable(drawable);
        }
    }

    /**
     * Use this function to set an painted image using resource identifiers for drawable and paint
     * @param drawable Resource id for image
     * @param paintResource Resource id for paint
     */
    public void setPaintedDrawableFromResource(int drawable, int paintResource) {
        proteusColorResource = getContext().getResources().getColor(paintResource);
        setImageDrawable(getContext().getResources().getDrawable(drawable));
    }
}
