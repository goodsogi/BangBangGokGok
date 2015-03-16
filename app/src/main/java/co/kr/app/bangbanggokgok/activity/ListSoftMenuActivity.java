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

public class ListSoftMenuActivity extends RelativeLayout {
    String TAG = "SoftMenuActivity";
    Context mContext;

    public ListSoftMenuActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        Log.e(TAG, "SM시작!!");
        LayoutInflater.from(context).inflate(R.layout.list_menu, this, true); //상단바 레이아웃

    }


    public void setText(String text) {

    }


    public void setSofeMenuEvent(int position, final Activity it) {

        final Button btn1 = (Button) it.findViewById(R.id.sm_btn01);
        final Button btn2 = (Button) it.findViewById(R.id.sm_btn02);
        final Button btn3 = (Button) it.findViewById(R.id.sm_btn03);
        btn1.setSelected(false);
        btn2.setSelected(false);
        btn3.setSelected(false);


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e(TAG, "SMBtn01");
                Intent intent = new Intent(it.getApplicationContext(), AllListActivity.class);
                it.startActivity(intent);
                it.finish();
                it.overridePendingTransition(0, 0); //화면전화시 효과없음(딜레이X)

            }

        });


        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e(TAG, "SMBtn02");
                Intent intent = new Intent(it.getApplicationContext(), MediationActivity.class);
                it.startActivity(intent);
                it.finish();
                it.overridePendingTransition(0, 0); //화면전화시 효과없음(딜레이X)

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e(TAG, "SMBtn03");
                Intent intent = new Intent(it.getApplicationContext(), DirectdealActivity.class);
                it.startActivity(intent);
                it.finish();
                it.overridePendingTransition(0, 0); //화면전화시 효과없음(딜레이X)

            }
        });


        switch (position) {
            case 0:
                btn1.setSelected(true);

                break;
            case 1:
                btn2.setSelected(true);
                break;
            case 2:
                btn3.setSelected(true);
                break;

            default:
                break;
        }
    }

}
