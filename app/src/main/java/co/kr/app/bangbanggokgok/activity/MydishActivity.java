package co.kr.app.bangbanggokgok.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.adapter.DishAdapter;
import co.kr.app.bangbanggokgok.board.DishBoard;


public class MydishActivity extends Activity {

	ListView listview;
	DishAdapter adapter;
	ArrayList<DishBoard> arrData = new ArrayList<DishBoard>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mydish);
		arrData.add(new DishBoard("100/70", "강남구논현동, 3층", "초근접 역세권!" , "1", "1","1","","" , ""));
		arrData.add(new DishBoard("50000", "강남구논현동, 고층/20층", "강남구청역1분거리" , "2", "","","1","1" , "1"));

		listview = (ListView)findViewById(R.id.mylist);
		adapter = new DishAdapter(getApplicationContext(),MydishActivity.this, arrData );
		listview.setAdapter(adapter);

	}

}