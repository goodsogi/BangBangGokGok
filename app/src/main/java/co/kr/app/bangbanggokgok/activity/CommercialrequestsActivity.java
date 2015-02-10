package co.kr.app.bangbanggokgok.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import co.kr.app.bangbanggokgok.R;


public class CommercialrequestsActivity extends Activity {

	Boolean house11flag = false;
	Boolean house12flag = false;
	Boolean house13flag = false;
	Boolean house14flag = false;
	Boolean house15flag = false;
	Boolean house16flag = false;

	Button house11 , house12 , house13 ,house14 , house15, house16;
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


		house11 = (Button)findViewById(R.id.housesale11);
		house12 = (Button)findViewById(R.id.housesale12);
		house13 = (Button)findViewById(R.id.housesale13);
		house14 = (Button)findViewById(R.id.housesale14);
		house15 = (Button)findViewById(R.id.housesale15);
		house16 = (Button)findViewById(R.id.housesale16);


	}

	View.OnClickListener btnListener = new View.OnClickListener(){
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
				}else if (house11flag == true) {
					house11.setBackgroundResource(R.drawable.icon_find_01_01);
					house11flag = false;
				}
				break;
			case R.id.housesale12:
				if (house12flag == false) {
					house12.setBackgroundResource(R.drawable.icon_find_01_02_g);
					house12flag = true;
				}else if (house12flag == true) {
					house12.setBackgroundResource(R.drawable.icon_find_01_02);
					house12flag = false;
				}
				break;
			case R.id.housesale13:
				if (house13flag == false) {
					house13.setBackgroundResource(R.drawable.icon_find_01_03_g);
					house13flag = true;
				}else if (house13flag == true) {
					house13.setBackgroundResource(R.drawable.icon_find_01_03);
					house13flag = false;
				}
				break;
			case R.id.housesale14:
				if (house14flag == false) {
					house14.setBackgroundResource(R.drawable.icon_find_01_04_g);
					house14flag = true;
				}else if (house14flag == true) {
					house14.setBackgroundResource(R.drawable.icon_find_01_04);
					house14flag = false;
				}
				break;
			case R.id.housesale15:
				if (house15flag == false) {
					house15.setBackgroundResource(R.drawable.icon_find_01_05_g);
					house15flag = true;
				}else if (house15flag == true) {
					house15.setBackgroundResource(R.drawable.icon_find_01_05);
					house15flag = false;
				}
				break;
			case R.id.housesale16:
				if (house16flag == false) {
					house16.setBackgroundResource(R.drawable.icon_find_01_06_g);
					house16flag = true;
				}else if (house16flag == true) {
					house16.setBackgroundResource(R.drawable.icon_find_01_06);
					house16flag = false;
				}
				break;
			}
		}
	};
}
