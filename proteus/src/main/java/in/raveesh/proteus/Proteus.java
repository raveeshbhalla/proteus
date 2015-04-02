package in.raveesh.proteus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by Raveesh on 02/04/15.
 */
public class Proteus {

    public static final String TAG = "Proteus";
    private static HashMap<String, Integer> staticCache;

    public static int getResourceId(Context context, String stringEquivalent){
        Log.i(TAG, "Getting Resource ID for " + stringEquivalent);
        if (staticCache == null){
            staticCache = new HashMap<String, Integer>();
        }
        int cached = staticCache.get(stringEquivalent);
        if (cached == 0){
            int id = context.getResources().getIdentifier(stringEquivalent, null, null);
            staticCache.put(stringEquivalent, id);
            return id;
        }
        else{
            return cached;
        }
    }

    public static Bitmap getColoredBitmap(Drawable src, int color) {
        boolean invert = false;
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
