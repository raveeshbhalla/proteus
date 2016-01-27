package in.raveesh.proteus;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/**
 * Created by Raveesh on 02/04/15.
 */
public class Proteus {

    public static final String TAG = "Proteus";

    /**
     * Credit for this Method goes to Roman Nurik, whose Gist this is where the code has been lifted from
     * https://gist.github.com/romannurik/5779875
     *
     * @param src
     * @param color
     * @return
     */
    public static Bitmap getColoredBitmap(Drawable src, int color) {
        boolean invert = true; //Setting to true, which helps color all black drawables
        int width = src.getIntrinsicWidth();
        int height = src.getIntrinsicHeight();
        if (width <= 0 || height <= 0) {
            throw new UnsupportedOperationException("Source drawable needs an intrinsic size.");
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint colorToAlphaPaint = new Paint();
        int invMul = invert ? -1 : 1;
        colorToAlphaPaint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{
                0, 0, 0, 0, Color.red(color),
                0, 0, 0, 0, Color.green(color),
                0, 0, 0, 0, Color.blue(color),
                invMul * 0.213f, invMul * 0.715f, invMul * 0.072f, 0, invert ? 255 : 0,
        })));
        canvas.saveLayer(0, 0, width, height, colorToAlphaPaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawColor(invert ? Color.WHITE : Color.BLACK);
        src.setBounds(0, 0, width, height);
        src.draw(canvas);
        canvas.restore();
        return bitmap;
    }
}
