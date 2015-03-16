package co.kr.app.bangbanggokgok.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusInputStreamStringConverter;
import com.pluslibrary.server.PlusOnGetDataListener;
import com.pluslibrary.utils.PlusClickGuard;
import com.pluslibrary.utils.PlusToaster;

import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.server.AllListModel;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;


public class AllListDetailActivity extends FragmentActivity implements PlusOnGetDataListener {
    private static final int SAVE_ROOM_TO_SERVER = 23;
    private static final int ADD_TO_BOOKMARK = 44;
    // 이미지 다운로드
    protected ImageLoader mImageLoader;
    protected DisplayImageOptions mOption;
    private String mRoomIdx;

    private static final String STUDIO = "1";
    private static final String TWO_ROOM = "2";
    private static final String THREE_ROOM = "3";
    private static final String OFFICETEL = "4";
    private static final String APARTMENT = "5";
    private static final String HOUSE = "6";
    private static final String RENT = "1";
    private static final String LEASE = "2";
    private static final String BUY = "3";
    private int roomSizeByPyeong;
    private String mRoomSize;
    private GoogleMap mGoogleMap;
    private String mLat;
    private String mLon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alllistdetail);

        initImgLoader();

        makeLayout();
        showMap();
        saveRoomToServer();

    }

    private void showMap() {

        LatLng position = new LatLng(Double.parseDouble(mLat), Double.parseDouble(mLon));
        GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        mGoogleMap = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapview)).getMap();
        mGoogleMap.getUiSettings().setZoomControlsEnabled(false);

        //mGoogleMap.setOnMapClickListener(this);

        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 15));

        mGoogleMap.addMarker(new MarkerOptions().position(position).icon(BitmapDescriptorFactory.fromResource(R.drawable.house_icon)));



    }

    @Override
    public void onSuccess(Integer from, Object datas) {
        switch (from) {

            case SAVE_ROOM_TO_SERVER:


                break;
            case ADD_TO_BOOKMARK:
//!!수정
                PlusToaster.doIt(this, ((String) datas).contains("success") ? "찜했습니다" : "하지 못했습니다");
                selectBookmarkButton(((String) datas).contains("success"));


                break;
        }

    }

    private void selectBookmarkButton(boolean isSelected) {
        ImageButton bookmark = (ImageButton) findViewById(R.id.bookmark_btn);
        bookmark.setSelected(isSelected);
    }

    public void addToBookmark() {
        String userId = getUserId();

        new PlusHttpClient(this, this, false)
                .execute(ADD_TO_BOOKMARK, BBGGApiConstants.ADD_TO_BOOKMARK + "?id=" + userId + "&idx=" + mRoomIdx,
                        new PlusInputStreamStringConverter());
    }

    private void saveRoomToServer() {
        String userId = getUserId();

        new PlusHttpClient(this, this, false)
                .execute(SAVE_ROOM_TO_SERVER, BBGGApiConstants.SAVE_ROOM_TO_SERVER + "?id=" + userId + "&idx=" + mRoomIdx,
                        new PlusInputStreamStringConverter());

    }

    public String getUserId() {
        SharedPreferences sharedPreference = getSharedPreferences(
                BBGGConstants.PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreference.getString(BBGGConstants.KEY_USER_ID, "");
    }


    private void initImgLoader() {

        mImageLoader = ImageLoader.getInstance();

        mOption = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(com.pluslibrary.R.drawable.empty_photo)
                .showImageOnFail(com.pluslibrary.R.drawable.empty_photo).cacheInMemory(true)
                .cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).build();
    }

    private void makeLayout() {
        Intent i = getIntent();
        AllListModel data = (AllListModel) i.getSerializableExtra("data");
        mRoomIdx = data.getIdx();


        ImageView mainImg = (ImageView) findViewById(R.id.main_img);
        mImageLoader.displayImage(
                BBGGConstants.IMG_URL_HEAD + data.getImg01(), mainImg,
                mOption);


        TextView titleView = (TextView) findViewById(R.id.title_txt);
        titleView.setText(data.getSubject());

        TextView contentView = (TextView) findViewById(R.id.name_txt);
        contentView.setText(data.getContent());

        TextView addressView = (TextView) findViewById(R.id.area_txt);
        addressView.setText(data.getAddress());


        TextView priceView = (TextView) findViewById(R.id.body_depositsum);
        priceView.setText(data.getPrice01());

        TextView roomTypeView = (TextView) findViewById(R.id.body_room);
        roomTypeView.setText(getRoomTypeText(data.getRoomType()));

        TextView roomSizeView = (TextView) findViewById(R.id.body_roomsize);
        mRoomSize = data.getSize();
        roomSizeView.setText(data.getSize());

        TextView floorView = (TextView) findViewById(R.id.body_floor);
        floorView.setText(getFloorText(data.getFloor()));

        TextView managementFeeView = (TextView) findViewById(R.id.body_cost);
        managementFeeView.setText(data.getManagementPrice());

        TextView moveDateView = (TextView) findViewById(R.id.body_day);
        moveDateView.setText(data.getMoveDate());

        TextView parkView = (TextView) findViewById(R.id.body_park);
        parkView.setText(getParkText(data.getParking()));

        TextView petView = (TextView) findViewById(R.id.body_pet);
        petView.setText(getPetText(data.getPet()));

        TextView heatTypeView = (TextView) findViewById(R.id.body_heat);
        heatTypeView.setText(getheatTypeText(data.getHeatType()));

        TextView detailView = (TextView) findViewById(R.id.body_add);
        detailView.setText(data.getMemo());

        TextView addressView2 = (TextView) findViewById(R.id.body_body);
        addressView2.setText(data.getAddress());

        mLat = data.getLat();
        mLon = data.getLng();


    }

    private String getheatTypeText(String heatType) {
        return heatType.equals("1") ? "개별난방" : "중앙난방";

    }

    private String getPetText(String pet) {
        return pet.equals("1") ? "가능" : "불가능";
    }

    private String getParkText(String parking) {
        return parking.equals("1") ? "가능" : "불가능";
    }

    private String getFloorText(String s) {

        if (s.equals("0")) return "반지하";
        if (s.equals("99")) return "옥탑";

        return s + ("층");

    }

    public void showRoomSizeByPyeong(View v) {
        PlusClickGuard.doIt(v);

        TextView roomSizeByPyeong = (TextView) findViewById(R.id.pyeong_roomsize);
        roomSizeByPyeong.setText(getRoomSizeByPyeong());

    }

    public void showStreetView(View v) {
        PlusClickGuard.doIt(v);

        String uri = "google.streetview:cbll="+ mLat+","+mLon+"&cbp=1,99.56,,1,-5.27&mz=21";
        Intent streetView = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(streetView);

    }

    private String getRoomTypeText(String roomType) {

        if (roomType.equals(STUDIO)) return "원룸";
        if (roomType.equals(TWO_ROOM)) return "룸";
        if (roomType.equals(THREE_ROOM)) return "쓰리룸";
        if (roomType.equals(OFFICETEL)) return "오피스텔";
        if (roomType.equals(APARTMENT)) return "아파트";
        if (roomType.equals(HOUSE)) return "주택";


        return "원룸";
    }

    public String getRoomSizeByPyeong() {
        int roomSize = Integer.parseInt(mRoomSize);
        int firstResult = roomSize / 3;
        int secondResult = firstResult - (firstResult / 10);
        return String.valueOf(secondResult);
    }
}