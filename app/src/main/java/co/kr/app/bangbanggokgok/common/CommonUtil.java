package co.kr.app.bangbanggokgok.common;

import java.util.ArrayList;
import java.util.StringTokenizer;

import android.app.Activity;
import android.util.DisplayMetrics;



/*
 * 공통함수 및 전체클래스에서 변수 접근하기 위한 공통 변수들 셋팅 클래스
 * */
public class CommonUtil {
	private static CommonUtil _instance;
	public int EA;
	public int HomeBtn;
	public double deviceWidth; // 해상도 넓이
	public double deviceHeight; // 해상도 높이
	public double myLat;
	public double myLng;
	public String user_img_url;
	public String upche_logo;
	public ArrayList<Activity> av = new ArrayList<Activity>();					//Activity 를 담는다.
	public String upche_back;
	public String REG_ID;
	public String PROJECT_ID;
	public String PUSH_FLAG;
	public String SITE_PHONE;
	
	static {
		_instance = new CommonUtil();
		try {
			_instance.user_img_url = "";
			_instance.upche_logo = "";
			_instance.upche_back = "";
			_instance.PUSH_FLAG = "";
			_instance.SITE_PHONE = "01062400444";		//운영자 번호
			_instance.PROJECT_ID = "116532731833";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static CommonUtil getInstance() {
		return _instance;
	}

	
	public ArrayList<String> Token_String(String url , String token){
		ArrayList<String> Obj = new ArrayList<String>();

		StringTokenizer st1 = new StringTokenizer( url , token);
		while(st1.hasMoreTokens()){
			Obj.add(st1.nextToken());
		}
		return Obj;
	}
}
