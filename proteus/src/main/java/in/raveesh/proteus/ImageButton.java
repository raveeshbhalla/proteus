package in.raveesh.proteus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * Created by Raveesh on 02/04/15.
 */
public class ImageButton extends android.widget.ImageButton {
    private int proteusColorResource;
    private Drawable defaultDrawable;

    public ImageButton(Context context) {
        super(context);
    }

    public ImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
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
        defaultDrawable = drawable;
        if (proteusColorResource != 0) {
            BitmapDrawable d = new BitmapDrawable(getResources(), Proteus.getColoredBitmap(drawable, proteusColorResource));
            super.setImageDrawable(d);
        } else {
            super.setImageDrawable(drawable);
        }
    }

    public void setPaint(int color){
        proteusColorResource = color;
        if (getDrawable() != null){
            setImageDrawable(defaultDrawable);
        }
    }

    public void setPaintResource(int resource){
        setPaint(getResources().getColor(resource));
    }
}
