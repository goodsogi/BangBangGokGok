package co.kr.app.bangbanggokgok.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.adapter.SubwayAdapter;
import co.kr.app.bangbanggokgok.board.SubwayBoard;


public class SubwayActivity extends Activity {
	ListView listview;
	SubwayAdapter adapter;
	ArrayList<SubwayBoard> arrData = new ArrayList<SubwayBoard>();
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subway);
		
		SoftMenuActivity softmenu = (SoftMenuActivity)findViewById(R.id.softmenu_menu_list);
		softmenu.setSofeMenuEvent(1 , this);
		
		arrData.add(new SubwayBoard("서면역", "부산1호선"));
		arrData.add(new SubwayBoard("해운대구역", "부산2호선"));
		arrData.add(new SubwayBoard("하단역", "부산1호선"));
		arrData.add(new SubwayBoard("강남역", "2호선"));
		arrData.add(new SubwayBoard("신림역", "2호선"));
		arrData.add(new SubwayBoard("신촌역", "2호선"));

		listview = (ListView)findViewById(R.id.list);
		adapter = new SubwayAdapter(getApplicationContext(),this, arrData );
		listview.setAdapter(adapter);
	}
}