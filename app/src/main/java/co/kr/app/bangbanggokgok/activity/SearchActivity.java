package co.kr.app.bangbanggokgok.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import co.kr.app.bangbanggokgok.R;


public class SearchActivity extends Activity {
	
	Boolean house01flag = false;
	Boolean house02flag = false;
	Boolean house03flag = false;
	Boolean house04flag = false;
	Boolean house05flag = false;
	Boolean house06flag = false;
	Boolean deal01flag = false;
	Boolean deal02flag = false;
	Boolean deal03flag = false;

	Button house01 , house02 , house03 ,house04 , house05, house06, deal01 ,deal02 ,deal03;
	public static String Location_ = "";
	@Override
	public void onResume(){
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

		house01 = (Button)findViewById(R.id.housesale01);
		house02 = (Button)findViewById(R.id.housesale02);
		house03 = (Button)findViewById(R.id.housesale03);
		house04 = (Button)findViewById(R.id.housesale04);
		house05 = (Button)findViewById(R.id.housesale05);
		house06 = (Button)findViewById(R.id.housesale06);

		deal01 = (Button)findViewById(R.id.deal01);
		deal02 = (Button)findViewById(R.id.deal02);
		deal03 = (Button)findViewById(R.id.deal03);


	}

	View.OnClickListener btnListener = new View.OnClickListener(){
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
				}else if (house01flag == true) {
					house01.setBackgroundResource(R.drawable.icon_main_02_01);
					house01flag = false;
				}
				break;
			case R.id.housesale02:
				if (house02flag == false) {
					house02.setBackgroundResource(R.drawable.icon_main_02_02_g);
					house02flag = true;
				}else if (house02flag == true) {
					house02.setBackgroundResource(R.drawable.icon_main_02_02);
					house02flag = false;
				}
				break;
			case R.id.housesale03:
				if (house03flag == false) {
					house03.setBackgroundResource(R.drawable.icon_main_02_03_g);
					house03flag = true;
				}else if (house03flag == true) {
					house03.setBackgroundResource(R.drawable.icon_main_02_03);
					house03flag = false;
				}
				break;
			case R.id.housesale04:
				if (house04flag == false) {
					house01.setBackgroundResource(R.drawable.icon_main_02_04_g);
					house04flag = true;
				}else if (house01flag == true) {
					house04.setBackgroundResource(R.drawable.icon_main_02_04);
					house04flag = false;
				}
				break;
			case R.id.housesale05:
				if (house05flag == false) {
					house01.setBackgroundResource(R.drawable.icon_main_02_05_g);
					house05flag = true;
				}else if (house05flag == true) {
					house05.setBackgroundResource(R.drawable.icon_main_02_05);
					house05flag = false;
				}
				break;
			case R.id.housesale06:
				if (house06flag == false) {
					house06.setBackgroundResource(R.drawable.icon_main_02_06_g);
					house06flag = true;
				}else if (house06flag == true) {
					house06.setBackgroundResource(R.drawable.icon_main_02_06);
					house06flag = false;
				}
				break;
			case R.id.deal01:
				if (deal01flag == false) {
					deal01.setBackgroundResource(R.drawable.icon_main_03_01_g);
					deal01flag = true;
				}else if (deal01flag == true) {
					deal01.setBackgroundResource(R.drawable.icon_main_03_01);
					deal01flag = false;
				}
				break;
			case R.id.deal02:
				if (deal02flag == false) {
					deal02.setBackgroundResource(R.drawable.icon_main_03_02_g);
					deal02flag = true;
				}else if (deal02flag == true) {
					deal02.setBackgroundResource(R.drawable.icon_main_03_02);
					deal02flag = false;
				}
				break;
			case R.id.deal03:
				if (deal03flag == false) {
					deal03.setBackgroundResource(R.drawable.icon_main_03_03_g);
					deal03flag = true;
				}else if (deal03flag == true) {
					deal03.setBackgroundResource(R.drawable.icon_main_03_03);
					deal03flag = false;
				}
				break;
			};
		}
	};
}