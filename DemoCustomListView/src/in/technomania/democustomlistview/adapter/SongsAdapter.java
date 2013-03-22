package in.technomania.democustomlistview.adapter;

import in.technomania.democustomlistview.R;
import in.technomania.democustomlistview.model.Songs;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SongsAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private ArrayList<Songs> itemList;

	public SongsAdapter(Context context, ArrayList<Songs> itemList) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.itemList = itemList;
	}

	public int getCount() {
		return itemList.size();
	}

	public Object getItem(int position) {
		return itemList.get(position);
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View view, ViewGroup parent) {
		SongDetailHolder holder;

		if (view == null) {

			view = mInflater.inflate(R.layout.listitem_songs, null);
			holder = new SongDetailHolder();

			holder.textView1 = (TextView) view.findViewById(R.id.textItem1);
			holder.textView2 = (TextView) view.findViewById(R.id.textItem2);
			holder.songsImage = ((ImageView) view
					.findViewById(R.id.songsImage));
			view.setTag(holder);
		} else {
			holder = (SongDetailHolder) view.getTag();
		}

		holder.textView1.setText(itemList.get(position).getName());
		holder.textView2.setText(itemList.get(position).getDetail());
		holder.songsImage.setBackgroundResource(itemList.get(position).getImage());
		holder.songsImage.setVisibility(View.VISIBLE);

		return view;
	}

}

class SongDetailHolder {
	TextView textView1;
	TextView textView2;
	ImageView songsImage;
}
