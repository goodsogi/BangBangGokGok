package co.kr.app.bangbanggokgok.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusInputStreamStringConverter;
import com.pluslibrary.server.PlusOnGetDataListener;
import com.pluslibrary.utils.PlusClickGuard;
import com.pluslibrary.utils.PlusToaster;

import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import co.kr.app.bangbanggokgok.BBGGCommonActivity;
import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;


public class CommercialrequestsActivity extends BBGGCommonActivity implements
        PlusOnGetDataListener {

    Boolean house11flag = false;
    Boolean house12flag = false;
    Boolean house13flag = false;
    Boolean house14flag = false;
    Boolean house15flag = false;
    Boolean house16flag = false;

    private static final int REQUEST_ROOM = 44;

    Button house11, house12, house13, house14, house15, house16;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commercialrequests);


        findViewById(R.id.housesale11).setOnClickListener(btnListener);
        findViewById(R.id.housesale12).setOnClickListener(btnListener);
        findViewById(R.id.housesale13).setOnClickListener(btnListener);
        findViewById(R.id.housesale14).setOnClickListener(btnListener);
        findViewById(R.id.housesale15).setOnClickListener(btnListener);
        findViewById(R.id.housesale16).setOnClickListener(btnListener);


        house11 = (Button) findViewById(R.id.housesale11);
        house12 = (Button) findViewById(R.id.housesale12);
        house13 = (Button) findViewById(R.id.housesale13);
        house14 = (Button) findViewById(R.id.housesale14);
        house15 = (Button) findViewById(R.id.housesale15);
        house16 = (Button) findViewById(R.id.housesale16);


    }


    @Override
    public void onSuccess(Integer from, Object datas) {
        switch (from) {
            case REQUEST_ROOM:
                //!!수정
                PlusToaster.doIt(this, ((String) datas).contains("success") ? "매물요청했습니다" : "매물요청하지 못했습니다");
                break;

        }
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_location:
                    Log.d("CHECK", "위치설정");
                    startActivity(new Intent(getApplicationContext(), LocationSettingActivity.class));
                    break;
                case R.id.housesale11:
                    if (house11flag == false) {
                        house11.setBackgroundResource(R.drawable.icon_find_01_01_g);
                        house11flag = true;
                    } else if (house11flag == true) {
                        house11.setBackgroundResource(R.drawable.icon_find_01_01);
                        house11flag = false;
                    }
                    break;
                case R.id.housesale12:
                    if (house12flag == false) {
                        house12.setBackgroundResource(R.drawable.icon_find_01_02_g);
                        house12flag = true;
                    } else if (house12flag == true) {
                        house12.setBackgroundResource(R.drawable.icon_find_01_02);
                        house12flag = false;
                    }
                    break;
                case R.id.housesale13:
                    if (house13flag == false) {
                        house13.setBackgroundResource(R.drawable.icon_find_01_03_g);
                        house13flag = true;
                    } else if (house13flag == true) {
                        house13.setBackgroundResource(R.drawable.icon_find_01_03);
                        house13flag = false;
                    }
                    break;
                case R.id.housesale14:
                    if (house14flag == false) {
                        house14.setBackgroundResource(R.drawable.icon_find_01_04_g);
                        house14flag = true;
                    } else if (house14flag == true) {
                        house14.setBackgroundResource(R.drawable.icon_find_01_04);
                        house14flag = false;
                    }
                    break;
                case R.id.housesale15:
                    if (house15flag == false) {
                        house15.setBackgroundResource(R.drawable.icon_find_01_05_g);
                        house15flag = true;
                    } else if (house15flag == true) {
                        house15.setBackgroundResource(R.drawable.icon_find_01_05);
                        house15flag = false;
                    }
                    break;
                case R.id.housesale16:
                    if (house16flag == false) {
                        house16.setBackgroundResource(R.drawable.icon_find_01_06_g);
                        house16flag = true;
                    } else if (house16flag == true) {
                        house16.setBackgroundResource(R.drawable.icon_find_01_06);
                        house16flag = false;
                    }
                    break;
            }
        }
    };

    public void requestRoom(View v) {
        PlusClickGuard.doIt(v);

        String userId = getUserId();
        //String userType = getUserType();

        EditText userPhoneNumberView = (EditText) findViewById(R.id.userPhoneNumber);
        String userPhoneNumber = userPhoneNumberView.getText().toString();

        if (userPhoneNumber.equals("")) {
            PlusToaster.doIt(this, "연락처를 입력해주세요");
            return;
        }

        EditText favorateLocationView = (EditText) findViewById(R.id.favorateLocation);
        String favorateLocation = favorateLocationView.getText().toString();

        if (favorateLocation.equals("")) {
            PlusToaster.doIt(this, "원하는 위치를 입력해주세요");
            return;
        }

        String roomType = getRoomType();

        EditText priceMaximum1View = (EditText) findViewById(R.id.priceMaximum1);
        String priceMaximum1 = priceMaximum1View.getText().toString();

        if (priceMaximum1.equals("")) {
            PlusToaster.doIt(this, "최대가능 금액을 입력해주세요");
            return;
        }

        EditText priceMaximum2View = (EditText) findViewById(R.id.priceMaximum2);
        String priceMaximum2 = priceMaximum2View.getText().toString();

        if (priceMaximum2.equals("")) {
            PlusToaster.doIt(this, "최대가능 금액을 입력해주세요");
            return;
        }

        EditText conditionView = (EditText) findViewById(R.id.condition);
        String condition = conditionView.getText().toString();

        if (condition.equals("")) {
            PlusToaster.doIt(this, "원하는 조건을 입력해주세요");
            return;
        }

        Charset chars = Charset.forName("UTF-8");

        MultipartEntity entity = new MultipartEntity();
        try {

            //!! 위치, 이미지 처리
            entity.addPart("id", new StringBody(userId, chars));
            // entity.addPart("type", new StringBody(userType, chars));
            entity.addPart("hphone", new StringBody(userPhoneNumber, chars));
            entity.addPart("address", new StringBody(favorateLocation, chars));
            entity.addPart("wr_kind", new StringBody(roomType, chars));
            entity.addPart("price1", new StringBody(priceMaximum1, chars));
            entity.addPart("price2", new StringBody(priceMaximum2, chars));
            entity.addPart("wr_memo", new StringBody(condition, chars));


        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //!! api 주소 수정
        new PlusHttpClient(this, this, false)
                .execute(REQUEST_ROOM, BBGGApiConstants.REQUEST_ROOM,
                        new PlusInputStreamStringConverter(), entity);

    }

    public String getUserType() {

        SharedPreferences sharedPreference = getSharedPreferences(
                BBGGConstants.PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreference.getString(BBGGConstants.KEY_USER_TYPE, "");
    }

    public String getRoomType() {
        StringBuilder builder = new StringBuilder();
        if (house11flag) builder.append("1" + ",");
        if (house12flag) builder.append("2" + ",");
        if (house13flag) builder.append("3" + ",");
        if (house14flag) builder.append("4" + ",");
        if (house15flag) builder.append("5" + ",");
        if (house16flag) builder.append("6" + ",");


        return builder.toString();
    }
}
