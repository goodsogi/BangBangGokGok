package co.kr.app.bangbanggokgok.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusOnGetDataListener;

import java.io.Serializable;
import java.util.ArrayList;

import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.adapter.AllListAdapter;
import co.kr.app.bangbanggokgok.server.AllListModel;
import co.kr.app.bangbanggokgok.server.AllListParser;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;


public class AllListActivity extends FragmentActivity implements PlusOnGetDataListener {
    ListView listview;
    AllListAdapter adapter;
    private final int GET_ALL_ROOM_LIST = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alllist);

        setUpActionBar();
        setUpSoftMenu();

        //검색화면에서 온 경우 처리
        String searchApiString = getIntent().getStringExtra(BBGGConstants.KEY_SEARCH_API);
        getDataFromServer(searchApiString != null && !searchApiString.equals("") ? searchApiString : BBGGApiConstants.GET_ALL_ROOM_LIST);


    }

    private void setUpSoftMenu() {
        ListSoftMenuActivity softmenu = (ListSoftMenuActivity) findViewById(R.id.softmenu_menu_list);
        softmenu.setSofeMenuEvent(0, this);
    }

    private void setUpActionBar() {
        //아이콘 이미지 변경
        getActionBar().setTitle(Html.fromHtml("<font color='#75c703'>지역목록 </font>"));
        getActionBar().setIcon(android.R.color.transparent);

        //젤리빈 이상 사용 가능
        //getActionBar().setHomeAsUpIndicator(R.drawable.icon_top_back);

        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //배경색 이미지 변경
        BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.bg_main_top_title));
        background.setTileModeX(android.graphics.Shader.TileMode.REPEAT);
        getActionBar().setBackgroundDrawable(background);

    }

    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @SuppressWarnings("unchecked")
        public void onItemClick(AdapterView parent, View view, int position,
                                long id) {

            Intent board = new Intent(AllListActivity.this, AllListDetailActivity.class);
            board.putExtra("data", (Serializable) parent.getItemAtPosition(position));
            startActivity(board);
        }
    };

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
                Log.e("CHECK", "검색");
                startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                return true;
            }
        });


        //메뉴
        SubMenu subMenu2 = menu.addSubMenu("Navigation Menu");
        subMenu2.add("매물등록").setIcon(R.drawable.menu_icon_01).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.e("CHECK", "1");
                startActivity(new Intent(getApplicationContext(), PostRoomActivity.class));
                return true;
            }
        });
        subMenu2.add("내가본 매물").setIcon(R.drawable.menu_icon_02).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.e("CHECK", "2");
                startActivity(new Intent(getApplicationContext(), MylistActivity.class));
                return true;
            }
        });
        subMenu2.add("찜목록").setIcon(R.drawable.menu_icon_03).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.e("CHECK", "3");
                startActivity(new Intent(getApplicationContext(), MydishActivity.class));
                return true;
            }
        });
        subMenu2.add("매물요청").setIcon(R.drawable.menu_icon_04).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.e("CHECK", "4");
                startActivity(new Intent(getApplicationContext(), CommercialrequestsActivity.class));
                return true;
            }
        });
        subMenu2.add("매물번호로 검색").setIcon(R.drawable.menu_icon_05).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.e("CHECK", "5");
                return true;
            }
        });
        subMenu2.add("설정").setIcon(R.drawable.menu_icon_06).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.e("CHECK", "6");
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        // TODO Auto-generated method stub
        Log.e("CHECK", "featureId  ->" + featureId + "  // item.getItemId()" + item.getItemId());
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    public void onSuccess(Integer from, Object datas) {
        switch (from) {
            case GET_ALL_ROOM_LIST:

                makeList((ArrayList<AllListModel>) datas);
                getRoomCount((ArrayList<AllListModel>) datas);
                showRoomCount();

                break;


        }

    }

    private void getRoomCount(ArrayList<AllListModel> datas) {
        BBGGConstants.ALL_ROOM_COUNT = datas.size();
        BBGGConstants.BROKER_ROOM_COUNT = getBrokerRoomCount(datas);
        BBGGConstants.DIRECT_ROOM_COUNT = getDirectRoomCount(datas);
    }

    private int getDirectRoomCount(ArrayList<AllListModel> datas) {
        int count = 0;
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).getGubun().equals("1")) count++;
        }

        return count;

    }

    private int getBrokerRoomCount(ArrayList<AllListModel> datas) {
        int count = 0;
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).getGubun().equals("2")) count++;
        }

        return count;

    }

    private void showRoomCount() {
        showAllRoomCount();
        showBrokerRoomCount();
        showDirectRoomCount();
    }

    private void showDirectRoomCount() {
        Button directRoomCount = (Button) findViewById(R.id.sm_btn03);
        directRoomCount.setText("직거래 (" + BBGGConstants.DIRECT_ROOM_COUNT + ")");

    }

    private void showAllRoomCount() {
        Button allRoomCount = (Button) findViewById(R.id.sm_btn01);
        allRoomCount.setText("전체 (" + BBGGConstants.ALL_ROOM_COUNT + ")");
    }

    private void showBrokerRoomCount() {
        Button brokerRoomCount = (Button) findViewById(R.id.sm_btn02);
        brokerRoomCount.setText("중개 (" + BBGGConstants.BROKER_ROOM_COUNT + ")");
    }


    private void makeList(ArrayList<AllListModel> datas) {

        listview = (ListView) findViewById(R.id.mylist);
        adapter = new AllListAdapter(getApplicationContext(), datas);
        listview.setOnItemClickListener(mItemClickListener);
        listview.setAdapter(adapter);
    }

    public void getDataFromServer(String apiString) {
        new PlusHttpClient(this, this, false).execute(GET_ALL_ROOM_LIST,
                apiString,
                new AllListParser());

    }
}