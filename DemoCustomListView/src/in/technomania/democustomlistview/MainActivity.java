package in.technomania.democustomlistview;

import in.technomania.democustomlistview.adapter.SongsAdapter;
import in.technomania.democustomlistview.model.Songs;

import java.util.ArrayList;


import android.os.Bundle;
import android.widget.ListView;
import android.app.Activity;

public class MainActivity extends Activity {

	private ArrayList<Songs> songList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		songList=new ArrayList<Songs>();
		songList.add(new Songs(R.drawable.music,"Rihanna","Please don't stop the music"));
		songList.add(new Songs(R.drawable.music,"Taylor Swift","Teardrops on my guitar"));
		songList.add(new Songs(R.drawable.music,"Enrique","Somebody's me"));
		songList.add(new Songs(R.drawable.music,"Taylor Swift","Princess"));
		songList.add(new Songs(R.drawable.music,"Eminem","Space Bound"));
		songList.add(new Songs(R.drawable.music,"Rihanna","Love the way u lie"));
		songList.add(new Songs(R.drawable.music,"Rihanna","Please don't stop the music"));
		songList.add(new Songs(R.drawable.music,"Taylor Swift","Teardrops on my guitar"));
		songList.add(new Songs(R.drawable.music,"Enrique","Somebody's me"));
		songList.add(new Songs(R.drawable.music,"Taylor Swift","Princess"));
		songList.add(new Songs(R.drawable.music,"Eminem","Space Bound"));
		songList.add(new Songs(R.drawable.music,"Rihanna","Love the way u lie"));
		SongsAdapter adapter= new SongsAdapter(this, songList);
		ListView songsListView = (ListView) findViewById(R.id.techomania_listview);
		songsListView.setAdapter(adapter);
	}

}
