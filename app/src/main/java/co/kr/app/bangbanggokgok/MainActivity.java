package co.kr.app.bangbanggokgok;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusOnGetDataListener;

import java.io.Serializable;
import java.util.ArrayList;

import co.kr.app.bangbanggokgok.activity.AllListActivity;
import co.kr.app.bangbanggokgok.activity.AllListDetailActivity;
import co.kr.app.bangbanggokgok.activity.CommercialrequestsActivity;
import co.kr.app.bangbanggokgok.activity.IntroActivity;
import co.kr.app.bangbanggokgok.activity.MydishActivity;
import co.kr.app.bangbanggokgok.activity.MylistActivity;
import co.kr.app.bangbanggokgok.activity.PostRoomActivity;
import co.kr.app.bangbanggokgok.activity.SearchActivity;
import co.kr.app.bangbanggokgok.activity.SettingActivity;
import co.kr.app.bangbanggokgok.server.AllListModel;
import co.kr.app.bangbanggokgok.server.AllListParser;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;

public class MainActivity extends FragmentActivity implements LocationListener, PlusOnGetDataListener {
    private static final long DELAY_TIME = 10 * 1000;
    private LocationManager mLocationManager;
    private boolean mIsGpsCatched;
    private GoogleMap mGoogleMap;
    private final int GET_ALL_LIST = 3;
    private ArrayList<AllListModel> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLogoScreen();
        changeActionBarIconAndBackground();
        getCurrentLocation();
        setUpMapIfNeeded();

    }

    private void getCurrentLocation() {

        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                0, 0, this);
        mIsGpsCatched = false;
        //테스트용
//		mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
//				5000, 5, this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!mIsGpsCatched) {

                    mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                            0, 0, MainActivity.this);
                }

            }
        }, DELAY_TIME);
    }

    private void changeActionBarIconAndBackground() {
        //아이콘 이미지 변경
        getActionBar().setIcon(R.drawable.icon_main_top_logo_2);

        //배경색 이미지 변경
        BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.bg_main_top_title));
        background.setTileModeX(android.graphics.Shader.TileMode.REPEAT);
        getActionBar().setBackgroundDrawable(background);
        findViewById(R.id.list).setOnClickListener(btnListener);

    }

    private void showLogoScreen() {
        startActivity(new Intent(this, IntroActivity.class));
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.list:
                    Log.d("CHECK", "목록보기");
                    startActivity(new Intent(getApplicationContext(), AllListActivity.class));
                    break;
            }
            ;
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
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        // TODO Auto-generated method stub
        Log.e("CHECK", "featureId  ->" + featureId + "  // item.getItemId()" + item.getItemId());
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        //에뮬레이터가 위치가 안잡혀 인위적으로 테스트, 나중에 삭제 필요!!
         showHouseMarkers();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setUpMapIfNeeded() {
        //서울을 기본 위치로 설정
        double lat = 37.545231;
        double lng = 126.981310;
        LatLng position = new LatLng(lat, lng);
        GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        mGoogleMap = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapview)).getMap();
        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);

        //mGoogleMap.setOnMapClickListener(this);

        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 11));
        mGoogleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                Intent board = new Intent(MainActivity.this, AllListDetailActivity.class);
                board.putExtra("data", mDatas.get(Integer.parseInt(marker
                        .getSnippet())));
                startActivity(board);
                return false;
            }
        });
    }


    /**
     * location listener 제거
     */
    public void removeLocationListener() {

        mLocationManager.removeUpdates(this);
        mIsGpsCatched = false;

    }


    @Override
    public void onLocationChanged(Location location) {
        mIsGpsCatched = true;
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 15));
        showHouseMarkers();
    }

    private void showHouseMarkers() {
        getDataFromServer();

    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSuccess(Integer from, Object datas) {
        switch (from) {
            case GET_ALL_LIST:

                drawHouseMarkers((ArrayList<AllListModel>) datas);
                break;



        }

    }

    private void drawHouseMarkers(ArrayList<AllListModel> datas) {
        mDatas = datas;
        LatLng position = null;
        for(int i=0; i< datas.size(); i++) {
            position =  new LatLng(Double.valueOf(datas.get(i).getLat()), Double.valueOf(datas.get(i).getLng()));
            mGoogleMap.addMarker(new MarkerOptions().position(position).snippet("" + i).icon(BitmapDescriptorFactory.fromResource(R.drawable.house_icon)));
            //마커 클릭처리 필요!!
        }



    }

    public void getDataFromServer() {
        new PlusHttpClient(this, this, false).execute(GET_ALL_LIST,
                BBGGApiConstants.GET_ALL_LIST,
                new AllListParser());

    }


}
