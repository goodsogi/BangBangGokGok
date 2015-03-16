package co.kr.app.bangbanggokgok.activity; //상단바화면

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import co.kr.app.bangbanggokgok.R;

public class SoftMenuActivity extends RelativeLayout {
    String TAG = "SoftMenuActivity";
    Context mContext;

    public SoftMenuActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        Log.e(TAG, "SM시작!!");
        LayoutInflater.from(context).inflate(R.layout.soft_menu, this, true); //상단바 레이아웃

    }


    public void setText(String text) {

    }


    public void setSofeMenuEvent(int position, final Activity it) {

        final Button btn1 = (Button) it.findViewById(R.id.sm_btn01);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e(TAG, "SMBtn01");
                Intent intent = new Intent(it.getApplicationContext(), LocationSettingActivity.class);
                it.startActivity(intent);
                it.finish();
                it.overridePendingTransition(0, 0); //화면전화시 효과없음(딜레이X)

            }

        });

        final Button btn2 = (Button) it.findViewById(R.id.sm_btn02);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e(TAG, "SMBtn02");
                Intent intent = new Intent(it.getApplicationContext(), SubwayActivity.class);
                it.startActivity(intent);
                it.finish();
                it.overridePendingTransition(0, 0); //화면전화시 효과없음(딜레이X)

            }
        });
        final Button btn3 = (Button) it.findViewById(R.id.sm_btn03);
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e(TAG, "SMBtn03");
                Intent intent = new Intent(it.getApplicationContext(), UniversityActivity.class);
                it.startActivity(intent);
                it.finish();
                it.overridePendingTransition(0, 0); //화면전화시 효과없음(딜레이X)

            }
        });
        final Button btn4 = (Button) it.findViewById(R.id.sm_btn04);
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e(TAG, "SMBtn04");
                Intent intent = new Intent(it.getApplicationContext(), DirectinputActivity.class);
                it.startActivity(intent);
                it.finish();
                it.overridePendingTransition(0, 0); //화면전화시 효과없음(딜레이X)

            }
        });


        switch (position) {
            case 0:
                btn1.setBackgroundResource(R.drawable.icon_main_01_top_title_01_g);
                btn2.setBackgroundResource(R.drawable.icon_main_01_top_title_02);
                btn3.setBackgroundResource(R.drawable.icon_main_01_top_title_03);
                btn4.setBackgroundResource(R.drawable.icon_main_01_top_title_04);
                break;
            case 1:
                btn1.setBackgroundResource(R.drawable.icon_main_01_top_title_01);
                btn2.setBackgroundResource(R.drawable.icon_main_01_top_title_02_g);
                btn3.setBackgroundResource(R.drawable.icon_main_01_top_title_03);
                btn4.setBackgroundResource(R.drawable.icon_main_01_top_title_04);
                break;
            case 2:
                btn1.setBackgroundResource(R.drawable.icon_main_01_top_title_01);
                btn2.setBackgroundResource(R.drawable.icon_main_01_top_title_02);
                btn3.setBackgroundResource(R.drawable.icon_main_01_top_title_03_g);
                btn4.setBackgroundResource(R.drawable.icon_main_01_top_title_04);
                break;
            case 3:
                btn1.setBackgroundResource(R.drawable.icon_main_01_top_title_01);
                btn2.setBackgroundResource(R.drawable.icon_main_01_top_title_02);
                btn3.setBackgroundResource(R.drawable.icon_main_01_top_title_03);
                btn4.setBackgroundResource(R.drawable.icon_main_01_top_title_04_g);
                break;
            default:
                break;
        }
    }

}
