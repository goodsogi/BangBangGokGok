package co.kr.app.bangbanggokgok.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.kr.app.bangbanggokgok.BBGGCommonActivity;
import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;


public class SearchActivity extends BBGGCommonActivity {

    private static final String STUDIO = "1";
    private static final String TWO_ROOM = "2";
    private static final String THREE_ROOM = "3";
    private static final String OFFICETEL = "4";
    private static final String APARTMENT = "5";
    private static final String HOUSE = "6";
    private static final String RENT = "1";
    private static final String LEASE = "2";
    private static final String BUY = "3";
    Boolean house01flag = false;
    Boolean house02flag = false;
    Boolean house03flag = false;
    Boolean house04flag = false;
    Boolean house05flag = false;
    Boolean house06flag = false;
    Boolean deal01flag = false;
    Boolean deal02flag = false;
    Boolean deal03flag = false;

    Button house01, house02, house03, house04, house05, house06, deal01, deal02, deal03;
    public static String Location_ = "";
    private String houseType;
    private String depositFrom;

    @Override
    public void onResume() {
        if (!Location_.equals("")) {
            Toast.makeText(getApplicationContext(), "choice  -->" + Location_, 0).show();
            Location_ = "";

        }
        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        findViewById(R.id.btn_location).setOnClickListener(btnListener);
        findViewById(R.id.housesale01).setOnClickListener(btnListener);
        findViewById(R.id.housesale02).setOnClickListener(btnListener);
        findViewById(R.id.housesale03).setOnClickListener(btnListener);
        findViewById(R.id.housesale04).setOnClickListener(btnListener);
        findViewById(R.id.housesale05).setOnClickListener(btnListener);
        findViewById(R.id.housesale06).setOnClickListener(btnListener);

        findViewById(R.id.deal01).setOnClickListener(btnListener);
        findViewById(R.id.deal02).setOnClickListener(btnListener);
        findViewById(R.id.deal03).setOnClickListener(btnListener);
        //asdasd

        house01 = (Button) findViewById(R.id.housesale01);
        house02 = (Button) findViewById(R.id.housesale02);
        house03 = (Button) findViewById(R.id.housesale03);
        house04 = (Button) findViewById(R.id.housesale04);
        house05 = (Button) findViewById(R.id.housesale05);
        house06 = (Button) findViewById(R.id.housesale06);

        deal01 = (Button) findViewById(R.id.deal01);
        deal02 = (Button) findViewById(R.id.deal02);
        deal03 = (Button) findViewById(R.id.deal03);


    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_location:
                    Log.d("CHECK", "위치설정");
                    startActivity(new Intent(getApplicationContext(), LocationSettingActivity.class));
                    break;
                case R.id.housesale01:
                    if (house01flag == false) {
                        house01.setBackgroundResource(R.drawable.icon_main_02_01_g);
                        house01flag = true;
                    } else if (house01flag == true) {
                        house01.setBackgroundResource(R.drawable.icon_main_02_01);
                        house01flag = false;
                    }
                    break;
                case R.id.housesale02:
                    if (house02flag == false) {
                        house02.setBackgroundResource(R.drawable.icon_main_02_02_g);
                        house02flag = true;
                    } else if (house02flag == true) {
                        house02.setBackgroundResource(R.drawable.icon_main_02_02);
                        house02flag = false;
                    }
                    break;
                case R.id.housesale03:
                    if (house03flag == false) {
                        house03.setBackgroundResource(R.drawable.icon_main_02_03_g);
                        house03flag = true;
                    } else if (house03flag == true) {
                        house03.setBackgroundResource(R.drawable.icon_main_02_03);
                        house03flag = false;
                    }
                    break;
                case R.id.housesale04:
                    if (house04flag == false) {
                        house01.setBackgroundResource(R.drawable.icon_main_02_04_g);
                        house04flag = true;
                    } else if (house01flag == true) {
                        house04.setBackgroundResource(R.drawable.icon_main_02_04);
                        house04flag = false;
                    }
                    break;
                case R.id.housesale05:
                    if (house05flag == false) {
                        house01.setBackgroundResource(R.drawable.icon_main_02_05_g);
                        house05flag = true;
                    } else if (house05flag == true) {
                        house05.setBackgroundResource(R.drawable.icon_main_02_05);
                        house05flag = false;
                    }
                    break;
                case R.id.housesale06:
                    if (house06flag == false) {
                        house06.setBackgroundResource(R.drawable.icon_main_02_06_g);
                        house06flag = true;
                    } else if (house06flag == true) {
                        house06.setBackgroundResource(R.drawable.icon_main_02_06);
                        house06flag = false;
                    }
                    break;
                case R.id.deal01:
                    if (deal01flag == false) {
                        deal01.setBackgroundResource(R.drawable.icon_main_03_01_g);
                        deal01flag = true;
                    } else if (deal01flag == true) {
                        deal01.setBackgroundResource(R.drawable.icon_main_03_01);
                        deal01flag = false;
                    }
                    break;
                case R.id.deal02:
                    if (deal02flag == false) {
                        deal02.setBackgroundResource(R.drawable.icon_main_03_02_g);
                        deal02flag = true;
                    } else if (deal02flag == true) {
                        deal02.setBackgroundResource(R.drawable.icon_main_03_02);
                        deal02flag = false;
                    }
                    break;
                case R.id.deal03:
                    if (deal03flag == false) {
                        deal03.setBackgroundResource(R.drawable.icon_main_03_03_g);
                        deal03flag = true;
                    } else if (deal03flag == true) {
                        deal03.setBackgroundResource(R.drawable.icon_main_03_03);
                        deal03flag = false;
                    }
                    break;
            }
            ;
        }
    };

    public void doSearch(View v) {
        String userId = getUserId();
        String userType = getUserType();
        String locationType = ""; // AREA, SUBWAY, UNIVERSITY, DIRECT
        String locationValue = "";
        String houseType =
                getHouseType(); //STUDIO, TWO_ROOM, THREE_ROOM, OFFICETEL, APARTMENT, HOUSE
        String dealType = getDealType(); //Rent,LEASE, BUY
        String depositFrom = getDepositFrom();
        String depositTo = getDepositTo();
        String rentFrom = getRentFrom();
        String rentTo = getRentTo();
        String buyFrom = getBuyFrom();
        String buyTo = getBuyTo();


        String searchApiString = BBGGApiConstants.DO_SEARCH + "?" + "id=" + userId + "&type=" + userType + "&locationType=" + locationType + "&locationValue=" + locationValue + "&kind="
                + houseType + "&category=" + dealType + "&depositFrom=" + depositFrom + "&depositTo=" + depositTo + "&rentFrom=" + rentFrom + "&rentTo=" + rentTo
                + "&buyFrom=" + buyFrom + "&buyTo=" + buyTo;

        goToList(searchApiString);


    }


    public String getUserType() {

        SharedPreferences sharedPreference = getSharedPreferences(
                BBGGConstants.PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreference.getString(BBGGConstants.KEY_USER_TYPE, "");
    }

    private void goToList(String searchApiString) {

        Intent intent = new Intent(SearchActivity.this, AllListActivity.class);
        intent.putExtra(BBGGConstants.KEY_SEARCH_API, searchApiString);
        startActivity(intent);

    }

    public String getHouseType() {
        StringBuilder builder = new StringBuilder();
        if (deal01flag) builder.append(RENT + ",");
        if (deal02flag) builder.append(LEASE + ",");
        if (deal03flag) builder.append(BUY + ",");

        return builder.toString();
    }

    public String getDealType() {
        StringBuilder builder = new StringBuilder();
        if (house01flag) builder.append(STUDIO + ",");
        if (house02flag) builder.append(TWO_ROOM + ",");
        if (house03flag) builder.append(THREE_ROOM + ",");
        if (house04flag) builder.append(OFFICETEL + ",");
        if (house05flag) builder.append(APARTMENT + ",");
        if (house06flag) builder.append(HOUSE + ",");

        return builder.toString();
    }

    public String getDepositFrom() {
        EditText depositFromView = (EditText) findViewById(R.id.cash_edt01);

        return depositFromView.getText().toString();
    }

    public String getDepositTo() {
        EditText depositToView = (EditText) findViewById(R.id.cash_edt02);

        return depositToView.getText().toString();
    }

    public String getRentFrom() {
        EditText rentFromView = (EditText) findViewById(R.id.month_edt01);

        return rentFromView.getText().toString();
    }

    public String getRentTo() {
        EditText rentToView = (EditText) findViewById(R.id.month_edt02);

        return rentToView.getText().toString();
    }

    public String getBuyFrom() {
        EditText buyFromView = (EditText) findViewById(R.id.trade_edt01);

        return buyFromView.getText().toString();
    }

    public String getBuyTo() {
        EditText buyToView = (EditText) findViewById(R.id.trade_edt02);

        return buyToView.getText().toString();
    }

}