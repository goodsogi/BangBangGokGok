package co.kr.app.bangbanggokgok.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusInputStreamStringConverter;
import com.pluslibrary.server.PlusOnGetDataListener;
import com.pluslibrary.utils.PlusToaster;

import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import co.kr.app.bangbanggokgok.BBGGCommonActivity;
import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;


public class PostRoomActivity extends BBGGCommonActivity implements
        PlusOnGetDataListener {

    private static final int REGISTER_ROOM = 44;
    Boolean option01flag = false;
    Boolean option02flag = false;
    Boolean option03flag = false;
    Boolean option04flag = false;
    Boolean option05flag = false;
    Boolean option06flag = false;
    Boolean option07flag = false;
    Boolean option08flag = false;
    Boolean option09flag = false;
    Boolean option10flag = false;
    Boolean option11flag = false;
    Boolean option12flag = false;
    Boolean option13flag = false;
    Boolean option21flag = false;
    Boolean option22flag = false;
    Boolean option23flag = false;
    Boolean option24flag = false;
    Boolean option25flag = false;
    Boolean option26flag = false;
    Boolean flag01 = true;
    Boolean flag02 = true;

    ImageView option01, option02, option03, option04, option05, option06,
            option07, option08, option09, option10, option11, option12, option13,
            option21, option22, option23, option24, option25, option26;
    EditText detail_edt, name_edt, payimfor_edt, size_edt, pay_edt;
    String[] room = {"원룸", "투룸", "쓰리룸", "오피스텔", "아파트", "주택"};
    String[] floor = {"반지하", "1층", "2층", "3층", "4층", "5층", "옥탑"};
    String[] mHeatTypeValues = {"개별난방", "중앙난방"};
    Button im01, im02, po01, po02;
    private String option;
    private String parking;
    private String userId;
    private String userType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.back).setOnClickListener(btnListener);
        findViewById(R.id.location_btn).setOnClickListener(btnListener);
        findViewById(R.id.picture_btn).setOnClickListener(btnListener);
        findViewById(R.id.room_btn).setOnClickListener(btnListener);
        findViewById(R.id.floor_btn).setOnClickListener(btnListener);
        findViewById(R.id.heat_btn).setOnClickListener(btnListener);

        findViewById(R.id.option01_btn).setOnClickListener(btnListener);
        findViewById(R.id.option02_btn).setOnClickListener(btnListener);
        findViewById(R.id.option03_btn).setOnClickListener(btnListener);
        findViewById(R.id.option04_btn).setOnClickListener(btnListener);
        findViewById(R.id.option05_btn).setOnClickListener(btnListener);
        findViewById(R.id.option06_btn).setOnClickListener(btnListener);
        findViewById(R.id.option07_btn).setOnClickListener(btnListener);
        findViewById(R.id.option08_btn).setOnClickListener(btnListener);
        findViewById(R.id.option09_btn).setOnClickListener(btnListener);
        findViewById(R.id.option10_btn).setOnClickListener(btnListener);
        findViewById(R.id.option11_btn).setOnClickListener(btnListener);
        findViewById(R.id.option12_btn).setOnClickListener(btnListener);
        findViewById(R.id.option13_btn).setOnClickListener(btnListener);
        findViewById(R.id.option21_btn).setOnClickListener(btnListener);
        findViewById(R.id.option22_btn).setOnClickListener(btnListener);
        findViewById(R.id.option23_btn).setOnClickListener(btnListener);
        findViewById(R.id.option24_btn).setOnClickListener(btnListener);
        findViewById(R.id.option25_btn).setOnClickListener(btnListener);
        findViewById(R.id.option26_btn).setOnClickListener(btnListener);

        findViewById(R.id.write_btn).setOnClickListener(btnListener);

        findViewById(R.id.im01_btn).setOnClickListener(btnListener);
        findViewById(R.id.im02_btn).setOnClickListener(btnListener);
        findViewById(R.id.po01_btn).setOnClickListener(btnListener);
        findViewById(R.id.po02_btn).setOnClickListener(btnListener);

        im01 = (Button) findViewById(R.id.im01_btn);
        im02 = (Button) findViewById(R.id.im02_btn);
        po01 = (Button) findViewById(R.id.po01_btn);
        po02 = (Button) findViewById(R.id.po02_btn);


        option01 = (ImageView) findViewById(R.id.option01_img);
        option02 = (ImageView) findViewById(R.id.option02_img);
        option03 = (ImageView) findViewById(R.id.option03_img);
        option04 = (ImageView) findViewById(R.id.option04_img);
        option05 = (ImageView) findViewById(R.id.option05_img);
        option06 = (ImageView) findViewById(R.id.option06_img);
        option07 = (ImageView) findViewById(R.id.option07_img);
        option08 = (ImageView) findViewById(R.id.option08_img);
        option09 = (ImageView) findViewById(R.id.option09_img);
        option10 = (ImageView) findViewById(R.id.option10_img);
        option11 = (ImageView) findViewById(R.id.option11_img);
        option12 = (ImageView) findViewById(R.id.option12_img);
        option13 = (ImageView) findViewById(R.id.option13_img);
        option21 = (ImageView) findViewById(R.id.option21_img);
        option22 = (ImageView) findViewById(R.id.option22_img);
        option23 = (ImageView) findViewById(R.id.option23_img);
        option24 = (ImageView) findViewById(R.id.option24_img);
        option25 = (ImageView) findViewById(R.id.option25_img);
        option26 = (ImageView) findViewById(R.id.option26_img);

    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.back:
                    finish();
                    break;
                case R.id.location_btn:
                    Toast.makeText(getApplicationContext(), "위치설정", 0).show();
                    startActivity(new Intent(getApplicationContext(), LocationSettingActivity.class));
                    break;
                case R.id.picture_btn:
                    Toast.makeText(getApplicationContext(), "사진올리기", 0).show();
                    break;
                case R.id.room_btn:
                    Room();
                    break;
                case R.id.floor_btn:
                    Floor();
                    break;
                case R.id.heat_btn:
                    showHeatType();
                    break;
                case R.id.po01_btn:
                    if (flag01 == false) {
                        po01.setBackgroundResource(R.drawable.icon_upload_03_01);
                        im01.setBackgroundResource(R.drawable.icon_upload_03_02);
                        flag01 = true;
                    }
                    break;
                case R.id.po02_btn:
                    if (flag02 == false) {
                        po02.setBackgroundResource(R.drawable.icon_upload_03_01);
                        im02.setBackgroundResource(R.drawable.icon_upload_03_02);
                        flag02 = true;
                    }
                    break;
                case R.id.im01_btn:
                    if (flag01 == true) {
                        po01.setBackgroundResource(R.drawable.icon_upload_03_03);
                        im01.setBackgroundResource(R.drawable.icon_upload_03_04);
                        flag01 = false;
                    }
                    break;
                case R.id.im02_btn:
                    if (flag02 == true) {
                        po02.setBackgroundResource(R.drawable.icon_upload_03_03);
                        im02.setBackgroundResource(R.drawable.icon_upload_03_04);
                        flag02 = false;
                    }
                    break;


                case R.id.write_btn:
                    registerRoom();
                    Toast.makeText(getApplicationContext(), "글등록", 0).show();
                    break;

                case R.id.option01_btn:
                    if (option01flag == false) {
                        option01.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option01flag = true;
                    } else if (option01flag == true) {
                        option01.setBackgroundResource(R.drawable.icon_upload_02);
                        option01flag = false;
                    }
                    break;
                case R.id.option02_btn:
                    if (option02flag == false) {
                        option02.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option02flag = true;
                    } else if (option02flag == true) {
                        option02.setBackgroundResource(R.drawable.icon_upload_02);
                        option02flag = false;
                    }
                    break;
                case R.id.option03_btn:
                    if (option03flag == false) {
                        option03.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option03flag = true;
                    } else if (option03flag == true) {
                        option03.setBackgroundResource(R.drawable.icon_upload_02);
                        option03flag = false;
                    }
                    break;
                case R.id.option04_btn:
                    if (option04flag == false) {
                        option04.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option04flag = true;
                    } else if (option04flag == true) {
                        option04.setBackgroundResource(R.drawable.icon_upload_02);
                        option04flag = false;
                    }
                    break;
                case R.id.option05_btn:
                    if (option05flag == false) {
                        option05.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option05flag = true;
                    } else if (option05flag == true) {
                        option05.setBackgroundResource(R.drawable.icon_upload_02);
                        option05flag = false;
                    }
                    break;
                case R.id.option06_btn:
                    if (option06flag == false) {
                        option06.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option06flag = true;
                    } else if (option06flag == true) {
                        option06.setBackgroundResource(R.drawable.icon_upload_02);
                        option06flag = false;
                    }
                    break;
                case R.id.option07_btn:
                    if (option07flag == false) {
                        option07.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option07flag = true;
                    } else if (option07flag == true) {
                        option07.setBackgroundResource(R.drawable.icon_upload_02);
                        option07flag = false;
                    }
                    break;
                case R.id.option08_btn:
                    if (option08flag == false) {
                        option08.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option08flag = true;
                    } else if (option08flag == true) {
                        option08.setBackgroundResource(R.drawable.icon_upload_02);
                        option08flag = false;
                    }
                    break;
                case R.id.option09_btn:
                    if (option09flag == false) {
                        option09.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option09flag = true;
                    } else if (option09flag == true) {
                        option09.setBackgroundResource(R.drawable.icon_upload_02);
                        option09flag = false;
                    }
                    break;
                case R.id.option10_btn:
                    if (option10flag == false) {
                        option10.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option10flag = true;
                    } else if (option10flag == true) {
                        option10.setBackgroundResource(R.drawable.icon_upload_02);
                        option10flag = false;
                    }
                    break;
                case R.id.option11_btn:
                    if (option11flag == false) {
                        option11.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option11flag = true;
                    } else if (option11flag == true) {
                        option11.setBackgroundResource(R.drawable.icon_upload_02);
                        option11flag = false;
                    }
                    break;
                case R.id.option12_btn:
                    if (option12flag == false) {
                        option12.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option12flag = true;
                    } else if (option12flag == true) {
                        option12.setBackgroundResource(R.drawable.icon_upload_02);
                        option12flag = false;
                    }
                    break;
                case R.id.option13_btn:
                    if (option13flag == false) {
                        option13.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option13flag = true;
                    } else if (option13flag == true) {
                        option13.setBackgroundResource(R.drawable.icon_upload_02);
                        option13flag = false;
                    }
                    break;
                case R.id.option21_btn:
                    if (option21flag == false) {
                        option21.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option21flag = true;
                    } else if (option21flag == true) {
                        option21.setBackgroundResource(R.drawable.icon_upload_02);
                        option21flag = false;
                    }
                    break;
                case R.id.option22_btn:
                    if (option22flag == false) {
                        option22.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option22flag = true;
                    } else if (option22flag == true) {
                        option22.setBackgroundResource(R.drawable.icon_upload_02);
                        option22flag = false;
                    }
                    break;
                case R.id.option23_btn:
                    if (option23flag == false) {
                        option23.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option23flag = true;
                    } else if (option23flag == true) {
                        option23.setBackgroundResource(R.drawable.icon_upload_02);
                        option23flag = false;
                    }
                    break;
                case R.id.option24_btn:
                    if (option24flag == false) {
                        option24.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option24flag = true;
                    } else if (option24flag == true) {
                        option24.setBackgroundResource(R.drawable.icon_upload_02);
                        option24flag = false;
                    }
                    break;
                case R.id.option25_btn:
                    if (option25flag == false) {
                        option25.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option25flag = true;
                    } else if (option25flag == true) {
                        option25.setBackgroundResource(R.drawable.icon_upload_02);
                        option25flag = false;
                    }
                    break;
                case R.id.option26_btn:
                    if (option26flag == false) {
                        option26.setBackgroundResource(R.drawable.icon_upload_02_2);
                        option26flag = true;
                    } else if (option26flag == true) {
                        option26.setBackgroundResource(R.drawable.icon_upload_02);
                        option26flag = false;
                    }
                    break;

            }
            ;
        }
    };

    private void showHeatType() {
        AlertDialog.Builder ab = new AlertDialog.Builder(PostRoomActivity.this, AlertDialog.THEME_HOLO_LIGHT);
        ab.setTitle("선택해주세요.");
        ab.setItems(mHeatTypeValues, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                changeHeatType(whichButton);
            }
        }).setNegativeButton("닫기",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        ab.show();
    }

    private void changeHeatType(int whichButton) {
        Button heatType = (Button) findViewById(R.id.heat_btn);
        heatType.setText(mHeatTypeValues[whichButton]);
    }


    /**
     * 방 등록
     */
    protected void registerRoom() {

        String userId = getUserId();
        String userType = getUserType();

        EditText subjectView = (EditText) findViewById(R.id.name_edt);
        String subject = subjectView.getText().toString();

        if (subject.equals("")) {
            PlusToaster.doIt(this, "제목을 입력해주세요");
            return;
        }

        EditText detailView = (EditText) findViewById(R.id.detail_edt);
        String detail = detailView.getText().toString();

        if (detail.equals("")) {
            PlusToaster.doIt(this, "방에 대해 자세히 설명해주세요");
            return;
        }


        Button roomTypeView = (Button) findViewById(R.id.room_btn);
        String roomType = getRoomType(roomTypeView.getText().toString());

        EditText priceView = (EditText) findViewById(R.id.priv);
        String price = priceView.getText().toString();

        if (price.equals("")) {
            PlusToaster.doIt(this, "가격을 입력해주세요");
            return;
        }

        Button floorView = (Button) findViewById(R.id.floor_btn);
        String floor = getFloor(floorView.getText().toString());

        EditText roomSizeView = (EditText) findViewById(R.id.roomsize_edt);
        String roomSize = roomSizeView.getText().toString();

        if (roomSize.equals("")) {
            PlusToaster.doIt(this, "방크기를 입력해주세요");
            return;
        }

        String option = getOption();

        EditText moveDateView = (EditText) findViewById(R.id.movedate_edt);
        String moveDate = moveDateView.getText().toString();

        if (moveDate.equals("")) {
            PlusToaster.doIt(this, "입주가능날을 입력해주세요");
            return;
        }

        Button heatTypeView = (Button) findViewById(R.id.heat_btn);
        String heatType = getHeatType(heatTypeView.getText().toString());

        EditText managementFeeView = (EditText) findViewById(R.id.pay_edt);
        String managementFee = managementFeeView.getText().toString();

        if (managementFee.equals("")) {
            PlusToaster.doIt(this, "관리비를 입력해주세요");
            return;
        }

        String managementOption = getManagementOption();

        String parking = getParking();

        String pet = getPet();

        Charset chars = Charset.forName("UTF-8");

        MultipartEntity entity = new MultipartEntity();
        try {

            //!! 위치, 이미지 처리
            entity.addPart("id", new StringBody(userId, chars));
            entity.addPart("type", new StringBody(userType, chars));
            entity.addPart("detail", new StringBody(detail, chars));
            entity.addPart("subject", new StringBody(subject, chars));
            entity.addPart("kind", new StringBody(roomType, chars));
            entity.addPart("price", new StringBody(price, chars));
            entity.addPart("floor", new StringBody(floor, chars));
            entity.addPart("size", new StringBody(roomSize, chars));
            entity.addPart("option", new StringBody(option, chars));
            entity.addPart("movedate", new StringBody(moveDate, chars));
            entity.addPart("heat_kind", new StringBody(heatType, chars));
            entity.addPart("m_price", new StringBody(managementFee, chars));
            entity.addPart("m_price_option", new StringBody(managementOption, chars));
            entity.addPart("parking", new StringBody(parking, chars));
            entity.addPart("ani", new StringBody(pet, chars));


//이미지 처리
//            String imageUrl = (String) imageView.getTag();
//
//            if (imageUrl != null && !imageUrl.equals("")) {
//                ByteArrayBody imgBody = null;
//                try {
//                    String[] tokens = imageUrl.split("/");
//                    String fileName = tokens[tokens.length - 1];
//                    imgBody = new ByteArrayBody(HttpUtils.readBytes(imageUrl),
//                            StalkConstants.SERVER_IMAGE_TYPE, fileName);
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//                entity.addPart(StalkConstants.SERVER_UPLOAD_IMAGE, imgBody);
//            }

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        new PlusHttpClient(this, this, false)
                .execute(REGISTER_ROOM, BBGGApiConstants.REGISTER_ROOM,
                        new PlusInputStreamStringConverter(), entity);

    }

    private String getHeatType(String s) {
        if (s.contains("개별")) return "1";
        if (s.equals("중앙")) return "2";
        return "1";
    }

    private String getFloor(String s) {
        if (s.equals("반지하")) return "0";
        if (s.equals("옥탑")) return "99";

        return s.replace("층", "");

    }

    private String getRoomType(String s) {
        if (s.equals("원룸")) return "1";
        if (s.equals("투룸")) return "2";
        if (s.equals("쓰리룸")) return "3";
        if (s.equals("오피스텔")) return "4";
        if (s.equals("아파트")) return "5";
        if (s.equals("주택")) return "6";
        return "1";

    }


    private void Room() {
        AlertDialog.Builder ab = new AlertDialog.Builder(PostRoomActivity.this, AlertDialog.THEME_HOLO_LIGHT);
        ab.setTitle("선택해주세요.");
        ab.setItems(room, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                changeRoomType(whichButton);

            }
        }).setNegativeButton("닫기",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        ab.show();
    }

    private void changeRoomType(int whichButton) {
        Button roomType = (Button) findViewById(R.id.room_btn);
        roomType.setText(room[whichButton]);
    }

    private void Floor() {
        AlertDialog.Builder ab = new AlertDialog.Builder(PostRoomActivity.this, AlertDialog.THEME_HOLO_LIGHT);
        ab.setTitle("선택해주세요.");
        ab.setItems(floor, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                changeFloor(whichButton);
            }
        }).setNegativeButton("닫기",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        ab.show();
    }

    private void changeFloor(int whichButton) {
        Button floorView = (Button) findViewById(R.id.floor_btn);
        floorView.setText(floor[whichButton]);
    }

    @Override
    public void onSuccess(Integer from, Object datas) {
        switch (from) {
            case REGISTER_ROOM:
                //구현!!
                break;

        }
    }

    public String getOption() {
        StringBuilder builder = new StringBuilder();
        if (option01flag) builder.append("4" + ",");
        if (option02flag) builder.append("5" + ",");
        if (option03flag) builder.append("6" + ",");
        if (option04flag) builder.append("7" + ",");
        if (option05flag) builder.append("8" + ",");
        if (option06flag) builder.append("9" + ",");
        if (option07flag) builder.append("10" + ",");
        if (option08flag) builder.append("11" + ",");
        if (option09flag) builder.append("12" + ",");
        if (option10flag) builder.append("13" + ",");
        if (option11flag) builder.append("14" + ",");
        if (option12flag) builder.append("15" + ",");
        if (option13flag) builder.append("16" + ",");

        return builder.toString();
    }

    public String getManagementOption() {

        StringBuilder builder = new StringBuilder();
        if (option21flag) builder.append("6" + ",");
        if (option22flag) builder.append("4" + ",");
        if (option23flag) builder.append("1" + ",");
        if (option24flag) builder.append("3" + ",");
        if (option25flag) builder.append("5" + ",");
        if (option26flag) builder.append("2" + ",");

        return builder.toString();
    }

    public String getParking() {
        return flag01 ? "2" : "1";
    }

    public String getPet() {
        return flag02 ? "2" : "1";
    }


    public String getUserType() {

        SharedPreferences sharedPreference = getSharedPreferences(
                BBGGConstants.PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreference.getString(BBGGConstants.KEY_USER_TYPE, "");
    }
}