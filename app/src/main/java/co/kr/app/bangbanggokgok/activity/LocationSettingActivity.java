package co.kr.app.bangbanggokgok.activity;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.common.H5TextView;


public class LocationSettingActivity extends Activity {
	Button btn1_1,btn1_2,btn1_3;
	Button btn2_1,btn2_2,btn2_3;
	Button btn3_1,btn3_2,btn3_3;
	Button btn4_1,btn4_2,btn4_3;
	Button btn5_1,btn5_2,btn5_3;
	Button btn6_1,btn6_2,btn6_3;

	FrameLayout view;
	LinearLayout view_01,view_02;
	H5TextView location_txt;

	String []val;
	String []seoul = {"강남구" ,"강동구" ,"강북구" , "강서구" , "관악구" , "구로구"};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locationsetting);

		SoftMenuActivity softmenu = (SoftMenuActivity)findViewById(R.id.softmenu_menu_list);
		softmenu.setSofeMenuEvent(0 , this);

		init();
	}
	private void init(){
		view = (FrameLayout)findViewById(R.id.view);
		view_01 = (LinearLayout)findViewById(R.id.view_01);
		view_02 = (LinearLayout)findViewById(R.id.view_02);
		location_txt = (H5TextView)findViewById(R.id.location_txt);
		btn1_1 = (Button)findViewById(R.id.btn1_1);
		btn1_2 = (Button)findViewById(R.id.btn1_2);
		btn1_3 = (Button)findViewById(R.id.btn1_3);
		btn2_1 = (Button)findViewById(R.id.btn2_1);
		btn2_2 = (Button)findViewById(R.id.btn2_2);
		btn2_3 = (Button)findViewById(R.id.btn2_3);
		btn3_1 = (Button)findViewById(R.id.btn3_1);
		btn3_2 = (Button)findViewById(R.id.btn3_2);
		btn3_3 = (Button)findViewById(R.id.btn3_3);
		btn4_1 = (Button)findViewById(R.id.btn4_1);
		btn4_2 = (Button)findViewById(R.id.btn4_2);
		btn4_3 = (Button)findViewById(R.id.btn4_3);
		btn5_1 = (Button)findViewById(R.id.btn5_1);
		btn5_2 = (Button)findViewById(R.id.btn5_2);
		btn5_3 = (Button)findViewById(R.id.btn5_3);
		btn6_1 = (Button)findViewById(R.id.btn6_1);
		btn6_2 = (Button)findViewById(R.id.btn6_2);

		findViewById(R.id.btn1_1).setOnClickListener(btnListener);
		findViewById(R.id.btn1_2).setOnClickListener(btnListener);
		findViewById(R.id.btn1_3).setOnClickListener(btnListener);
		findViewById(R.id.btn2_1).setOnClickListener(btnListener);
		findViewById(R.id.btn2_2).setOnClickListener(btnListener);
		findViewById(R.id.btn2_3).setOnClickListener(btnListener);
		findViewById(R.id.btn3_1).setOnClickListener(btnListener);
		findViewById(R.id.btn3_2).setOnClickListener(btnListener);
		findViewById(R.id.btn3_3).setOnClickListener(btnListener);
		findViewById(R.id.btn4_1).setOnClickListener(btnListener);
		findViewById(R.id.btn4_2).setOnClickListener(btnListener);
		findViewById(R.id.btn4_3).setOnClickListener(btnListener);
		findViewById(R.id.btn5_1).setOnClickListener(btnListener);
		findViewById(R.id.btn5_2).setOnClickListener(btnListener);
		findViewById(R.id.btn5_3).setOnClickListener(btnListener);
		findViewById(R.id.btn6_1).setOnClickListener(btnListener);
		findViewById(R.id.btn6_2).setOnClickListener(btnListener);
	}
	private void addview(String []str){
		view_01.setVisibility(View.GONE);
		//		view_02.setVisibility(View.VISIBLE);
		int resut = str.length/3;
		int size = 0;
		size  = resut + 1;
		int jeri = 0 ;
		Boolean flag = false;
		for (int i = 0; i < size; i++) {
			// new 연산자로 리니어 레이아웃 만들고 방향 설정
			if (flag) {
				continue;
			}
			LinearLayout mainLayout = new LinearLayout(this);   
			mainLayout.setOrientation(LinearLayout.HORIZONTAL);
			for (int j = 0; j < 3; j++) {
				if (jeri > (str.length-1)) {
					if (flag) {
						Log.e("CHECK" , "ID11 --> "+jeri);
						Button topButton = new Button(this);
						topButton.setId(jeri);
						topButton.setText("뒤로");
						topButton.setBackgroundResource(R.drawable.img_upload_03);
						topButton.setVisibility(View.INVISIBLE);
						topButton.setOnClickListener(btnListener);

						// RelativeLayout의 차일드 View이기 때문에 RelativeLayout의 LayoutParams을
						// 적용해 준다.
						LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
								LayoutParams.WRAP_CONTENT,
								LayoutParams.WRAP_CONTENT, 1.0f);

						topButton.setLayoutParams(param);
						mainLayout.addView(topButton);
						jeri++;
						flag = true;
						continue;
					}else{
						Log.e("CHECK" , "ID11 --> "+jeri);
						Button topButton = new Button(this);
						topButton.setId(jeri);
						topButton.setText("뒤로");
						topButton.setBackgroundResource(R.drawable.img_upload_03);
//						topButton.setVisibility(View.INVISIBLE);
						topButton.setOnClickListener(btnListener);
						// RelativeLayout의 차일드 View이기 때문에 RelativeLayout의 LayoutParams을
						// 적용해 준다.
						LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
								LayoutParams.WRAP_CONTENT,
								LayoutParams.WRAP_CONTENT, 1.0f);

						topButton.setLayoutParams(param);
						mainLayout.addView(topButton);
						jeri++;
						flag = true;
						continue;
					}
					
				}else{
					Log.e("CHECK" , "ID --> "+jeri);
					Button topButton = new Button(this);
					topButton.setId(jeri);
					topButton.setText(str[jeri]);
					topButton.setBackgroundResource(R.drawable.img_upload_03);
					topButton.setOnClickListener(btnListener);
					// RelativeLayout의 차일드 View이기 때문에 RelativeLayout의 LayoutParams을
					// 적용해 준다.
					LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT, 1.0f);

					topButton.setLayoutParams(param);
					mainLayout.addView(topButton);
					jeri++;
				}
				

			}
			view_02.addView(mainLayout);
		}
	}
	View.OnClickListener btnListener = new View.OnClickListener(){
		public void onClick(View v) {
			
		
			switch (v.getId()) {
			case R.id.btn1_1:
				Log.d("CHECK", btn1_1.getText().toString());
				val = seoul;
				location_txt.setText("지역 > " + btn1_1.getText().toString());
				addview(val);
				break;
			case R.id.btn1_2:
				Log.d("CHECK", btn1_2.getText().toString());
				location_txt.setText("지역 > " + btn1_2.getText().toString());
				view_01.setVisibility(View.GONE);
				break;
			case R.id.btn1_3:
				Log.d("CHECK", btn1_3.getText().toString());
				location_txt.setText("지역 > " + btn1_3.getText().toString());
				view_01.setVisibility(View.GONE);
				break;
			case R.id.btn2_1:
				Log.d("CHECK", btn2_1.getText().toString());
				location_txt.setText("지역 > " + btn2_1.getText().toString());
				view_01.setVisibility(View.GONE);
				break;
			case R.id.btn2_2:
				Log.d("CHECK", btn2_2.getText().toString());
				location_txt.setText("지역 > " + btn2_2.getText().toString());
				view_01.setVisibility(View.GONE);
				break;
			case R.id.btn2_3:
				Log.d("CHECK", btn2_3.getText().toString());
				location_txt.setText("지역 > " + btn2_3.getText().toString());
				view_01.setVisibility(View.GONE);
				break;

			case R.id.btn3_1:
				Log.d("CHECK", btn3_1.getText().toString());
				location_txt.setText("지역 > " + btn3_1.getText().toString());
				view_01.setVisibility(View.GONE);
				break;
			case R.id.btn3_2:
				Log.d("CHECK", btn3_2.getText().toString());
				location_txt.setText("지역 > " + btn3_2.getText().toString());
				view_01.setVisibility(View.GONE);
				break;
			case R.id.btn3_3:
				Log.d("CHECK", btn3_3.getText().toString());
				location_txt.setText("지역 > " + btn3_3.getText().toString());
				view_01.setVisibility(View.GONE);
				break;

			case R.id.btn4_1:
				Log.d("CHECK", btn4_1.getText().toString());
				location_txt.setText("지역 > " + btn4_1.getText().toString());
				view_01.setVisibility(View.GONE);
				break;
			case R.id.btn4_2:
				Log.d("CHECK", btn4_2.getText().toString());
				location_txt.setText("지역 > " + btn4_2.getText().toString());
				view_01.setVisibility(View.GONE);
				break;
			case R.id.btn4_3:
				Log.d("CHECK", btn4_3.getText().toString());
				location_txt.setText("지역 > " + btn4_3.getText().toString());
				view_01.setVisibility(View.GONE);
				break;

			case R.id.btn5_1:
				Log.d("CHECK", btn5_1.getText().toString());
				location_txt.setText("지역 > " + btn5_1.getText().toString());
				view_01.setVisibility(View.GONE);
				break;
			case R.id.btn5_2:
				Log.d("CHECK", btn5_2.getText().toString());
				location_txt.setText("지역 > " + btn5_2.getText().toString());
				view_01.setVisibility(View.GONE);
				break;
			case R.id.btn5_3:
				Log.d("CHECK", btn5_3.getText().toString());
				location_txt.setText("지역 > " + btn5_3.getText().toString());
				view_01.setVisibility(View.GONE);
				break;


			case R.id.btn6_1:
				Log.d("CHECK", btn6_1.getText().toString());
				location_txt.setText("지역 > " + btn6_1.getText().toString());
				view_01.setVisibility(View.GONE);
				break;
			case R.id.btn6_2:
				Log.d("CHECK", btn6_2.getText().toString());
				location_txt.setText("지역 > " + btn6_2.getText().toString());
				view_01.setVisibility(View.GONE);
				break;

				
			};
			//상세주소 (구)
			for (int i = 0; i < (val.length+1); i++) {
				Log.e("CHECK", "I  --> " +v.getId()   + "///size  ->" + val.length);
				if (v.getId() == (val.length)) {//뒤로가기
					view_01.setVisibility(View.VISIBLE);
					view_02.setVisibility(View.GONE);
				}
				else if (v.getId() == i) {
					Log.e("CHECK", "I111  --> " +i   + "///size111  ->" + val.length);
					SearchActivity.Location_ = val[i];
					location_txt.setText(location_txt.getText().toString() + " > " + val[i]);
					finish();
					continue;
				}
			}
		}
	};
}