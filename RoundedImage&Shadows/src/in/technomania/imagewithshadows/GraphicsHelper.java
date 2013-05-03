package in.technomania.imagewithshadows;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class GraphicsHelper {

	/*
	 * Create rounded corner image
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int roundPx) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);

		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		return output;
	}

	/*
	 * Add shadow effect to image
	 */
	public static Bitmap getShadow(int widthShadowLayout,
			int heightShadowLayout, int roundPx, int widthIamge) {

		final Rect rect = new Rect(0, 0, widthShadowLayout, heightShadowLayout);

		Bitmap output = Bitmap.createBitmap(rect.width(), rect.height(),
				Bitmap.Config.ALPHA_8);
		Canvas canvas = new Canvas(output);

		rect.left += widthShadowLayout - widthIamge;
		rect.top += widthShadowLayout - widthIamge;
		rect.right -= widthShadowLayout - widthIamge;
		rect.bottom -= widthShadowLayout - widthIamge;
		final RectF rectF = new RectF(rect);
		Paint shadowPaint = new Paint();
		shadowPaint.setColor(Color.BLACK);
		shadowPaint.setShadowLayer((widthShadowLayout - widthIamge) / 2, 5, 5,
				0xFF555555);

		canvas.drawRoundRect(rectF, roundPx, roundPx, shadowPaint);
		return output;
	}

	/*
	 * Returns a scaled down image Bitmap to improve memory usage
	 */
	public static Bitmap getBitmapFromResource(Resources resources,
			int resourceId, int reqWidth, int reqHeight) {
		// Set options
		BitmapFactory.Options options = new BitmapFactory.Options();

		// Fetch Image bounds (width/height)
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(resources, resourceId, options);

		// Calculate Sample Size based upon required height and width
		options.inSampleSize = calculateInSampleSize(options, reqWidth,
				reqHeight);
		options.inJustDecodeBounds = false;

		// Fetch bitmap
		Bitmap image = BitmapFactory.decodeResource(resources, resourceId,
				options);
		return image;
	}

	// Start - Private Methods

	/*
	 * Calculates Sample Size to scale down/up the given image
	 */
	private static int calculateInSampleSize(Options options, int reqWidth,
			int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			// Calculate ratios of height and width to requested height and
			// width
			final int heightRatio = Math.round((float) height
					/ (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);

			// Choose the smallest ratio as inSampleSize value, this will
			// guarantee
			// a final image with both dimensions larger than or equal to the
			// requested height and width.
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}

		return inSampleSize;
	}

	// End - Private Methods

}
