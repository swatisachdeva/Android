package in.technomania.imagewithshadows;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private static final String TAG = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView imgBackground = (ImageView) findViewById(R.id.imageView1);

		Log.d(TAG, "Creating the bitmap for profile image");
		// Fetch a scaled down image for efficient memory usage
		Bitmap imgBitmap = GraphicsHelper.getBitmapFromResource(getResources(),
				R.drawable.img, imgBackground.getLayoutParams().width,
				imgBackground.getLayoutParams().height);

		ImageView img = (ImageView) findViewById(R.id.imageView2);

		Log.d(TAG, "Applying shadow effects in background");
		imgBackground.setImageBitmap(GraphicsHelper.getShadow(
				imgBackground.getLayoutParams().width,
				imgBackground.getLayoutParams().height, 30,
				img.getLayoutParams().width));

		Log.d(TAG, "Applying created bitmap to image");
		img.setImageBitmap(GraphicsHelper.getRoundedCornerBitmap(imgBitmap, 30));
	}
}
