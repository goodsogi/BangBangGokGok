package co.kr.app.bangbanggokgok.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusOnGetDataListener;

import java.io.Serializable;
import java.util.ArrayList;

import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.adapter.AllListAdapter;
import co.kr.app.bangbanggokgok.adapter.PinnedListViewAdapter;
import co.kr.app.bangbanggokgok.common.PinnedHeaderListView;
import co.kr.app.bangbanggokgok.server.AllListModel;
import co.kr.app.bangbanggokgok.server.AllListParser;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;


public class MediationActivity extends FragmentActivity implements PlusOnGetDataListener {
    private static final int GET_BROKER_ROOM_LIST = 77;

    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mediation);

setUpActionBar();

        getDataFromServer();
		

	}

    private void setUpActionBar() {
        //아이콘 이미지 변경
        getActionBar().setIcon(R.drawable.icon_main_top_logo_2);

        //배경색 이미지 변경
        BitmapDrawable background = new BitmapDrawable (BitmapFactory.decodeResource(getResources(),R.drawable.bg_main_top_title));
        background.setTileModeX(android.graphics.Shader.TileMode.REPEAT);
        getActionBar().setBackgroundDrawable(background);
        ListSoftMenuActivity softmenu = (ListSoftMenuActivity)findViewById(R.id.softmenu_menu_list);
        softmenu.setSofeMenuEvent(0 , this);
    }

    public void getDataFromServer() {
        new PlusHttpClient(this, this, false).execute(GET_BROKER_ROOM_LIST,

                BBGGApiConstants.GET_BROKER_ROOM_LIST,
                new AllListParser());

    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//검색
		SubMenu subMenu = menu.addSubMenu("Navigation Menu");
		MenuItem subMenu1Item = subMenu.getItem();
		subMenu1Item.setIcon(R.drawable.icon_top_menu_01);
		subMenu1Item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		subMenu1Item.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Log.e("CHECK" , "검색");
				startActivity(new Intent(getApplicationContext(), SearchActivity.class));
				return true;
			}
		});


		//메뉴
		SubMenu subMenu2 = menu.addSubMenu("Navigation Menu");
		subMenu2.add("매물등록").setIcon(R.drawable.menu_icon_01).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Log.e("CHECK" , "1");
				startActivity(new Intent(getApplicationContext(), PostRoomActivity.class));
				return true;
			}
		});
		subMenu2.add("내가본 매물").setIcon(R.drawable.menu_icon_02).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Log.e("CHECK" , "2");
				startActivity(new Intent(getApplicationContext(), MylistActivity.class));
				return true;
			}
		});
		subMenu2.add("찜목록").setIcon(R.drawable.menu_icon_03).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Log.e("CHECK" , "3");
				startActivity(new Intent(getApplicationContext(), MydishActivity.class));
				return true;
			}
		});	
		subMenu2.add("매물요청").setIcon(R.drawable.menu_icon_04).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Log.e("CHECK" , "4");
				startActivity(new Intent(getApplicationContext(), CommercialrequestsActivity.class));
				return true;
			}
		});
		subMenu2.add("매물번호로 검색").setIcon(R.drawable.menu_icon_05).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Log.e("CHECK" , "5");
				return true;
			}
		});
		subMenu2.add("설정").setIcon(R.drawable.menu_icon_06).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Log.e("CHECK" , "6");
				startActivity(new Intent(getApplicationContext(), SettingActivity.class));
				return true;
			}
		});

		MenuItem subMenu1Item2 = subMenu2.getItem();
		subMenu1Item2.setIcon(R.drawable.icon_top_menu_02);
		subMenu1Item2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		//		getMenuInflater().inflate(R.menu.main, menu);
		//		menu.add(0, 7777, 1, "Java Add Menu");

		//		menu.findItem(R.id.IconMenu).setOnMenuItemClickListener(new OnMenuItemClickListener() {
		//			@Override
		//			public boolean onMenuItemClick(MenuItem item) {
		//				// TODO Auto-generated method stub
		//				return false;
		//			}
		//		});
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		Log.e("CHECK" , "featureId  ->" + featureId    + "  // item.getItemId()" + item.getItemId());
		return super.onMenuItemSelected(featureId, item);
	}

    @Override
    public void onSuccess(Integer from, Object datas) {
        switch (from) {
            case GET_BROKER_ROOM_LIST:

                makeList((ArrayList<AllListModel>) datas);
                break;



        }

    }

    private void makeList(ArrayList<AllListModel> datas) {

        final PinnedListViewAdapter adapter = new PinnedListViewAdapter(this, datas);
        final PinnedHeaderListView listView = (PinnedHeaderListView) findViewById(R.id.list);
        listView.setOnItemClickListener(mItemClickListener);
        listView.setAdapter(adapter);
        listView.setPinnedHeaderInterface(adapter);


    }

    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @SuppressWarnings("unchecked")
        public void onItemClick(AdapterView parent, View view, int position,
                                long id) {

            Intent board = new Intent(MediationActivity.this, AllListDetailActivity.class);
            board.putExtra("data", (Serializable) parent.getItemAtPosition(position));
            startActivity(board);
        }
    };
}