package in.technomania.demoviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment{
	
	int mCurrentPage;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/** Getting the arguments to the Bundle object */
		Bundle data = getArguments();
		
		/** Getting integer data of the key current_page from the bundle */
		mCurrentPage = data.getInt("current_page", 0);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.myfragment_layout, container,false);				
		TextView textView = (TextView ) view.findViewById(R.id.tv);
		textView.setText("You are viewing the page #" + mCurrentPage + "\n\n" + "Swipe Horizontally left / right");	
		return view;		
	}
}
