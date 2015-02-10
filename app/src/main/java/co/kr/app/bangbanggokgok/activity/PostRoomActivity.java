package co.kr.app.bangbanggokgok.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.pluslibrary.img.HttpUtils;
import com.pluslibrary.server.ApiConstants;
import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusInputStreamStringConverter;
import com.pluslibrary.server.PlusOnGetDataListener;
import com.pluslibrary.utils.PlusToaster;

import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;


public class PostRoomActivity extends Activity implements
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
    String[] floor = {"1층", "2층", "3층", "4층", "5층"};
    Button im01, im02, po01, po02;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.back).setOnClickListener(btnListener);
        findViewById(R.id.location_btn).setOnClickListener(btnListener);
        findViewById(R.id.picture_btn).setOnClickListener(btnListener);
        findViewById(R.id.room_btn).setOnClickListener(btnListener);
        findViewById(R.id.floor_btn).setOnClickListener(btnListener);

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


    /**
     * 경매등록
     */
    protected void registerRoom() {

        EditText subjectView = (EditText) findViewById(R.id.name_edt);
        String subject = subjectView.getText().toString();

        if (subject.equals("")) {
            PlusToaster.doIt(this, "제목을 입력해주세요");
            return;
        }

        Charset chars = Charset.forName("UTF-8");

        MultipartEntity entity = new MultipartEntity();
        try {


            entity.addPart("subject", new StringBody(subject, chars));
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


    private void Room() {
        AlertDialog.Builder ab = new AlertDialog.Builder(PostRoomActivity.this, AlertDialog.THEME_HOLO_LIGHT);
        ab.setTitle("선택해주세요.");
        ab.setItems(room, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        }).setNegativeButton("닫기",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        ab.show();
    }

    private void Floor() {
        AlertDialog.Builder ab = new AlertDialog.Builder(PostRoomActivity.this, AlertDialog.THEME_HOLO_LIGHT);
        ab.setTitle("선택해주세요.");
        ab.setItems(floor, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        }).setNegativeButton("닫기",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        ab.show();
    }

    @Override
    public void onSuccess(Integer from, Object datas) {
        switch (from) {
            case REGISTER_ROOM:
               //구현!!
                break;

        }
    }
}