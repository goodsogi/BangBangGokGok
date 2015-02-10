package co.kr.app.bangbanggokgok.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.adapter.MyAdapter;
import co.kr.app.bangbanggokgok.board.MyBoard;


public class MylistActivity extends Activity {

	ListView listview;
	MyAdapter adapter;
	ArrayList<MyBoard> arrData = new ArrayList<MyBoard>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mylist);
		arrData.add(new MyBoard("100/70", "강남구논현동, 3층", "초근접 역세권!" , "1", "1","1","","" , ""));
		arrData.add(new MyBoard("50000", "강남구논현동, 고층/20층", "강남구청역1분거리" , "2", "","","1","1" , "1"));
		arrData.add(new MyBoard("100/70", "강남구논현동, 3층", "초근접 역세권!" , "3", "1","1","","" , ""));
		arrData.add(new MyBoard("50000", "강남구논현동, 고층/20층", "강남구청역1분거리" , "4", "","","1","1" , "1"));

		listview = (ListView)findViewById(R.id.mylist);
		adapter = new MyAdapter(getApplicationContext(),MylistActivity.this, arrData );
		listview.setAdapter(adapter);

	}

}