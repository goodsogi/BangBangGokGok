package co.kr.app.bangbanggokgok;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

// Market 아이디 : myofficekorea / mj03153398 
// 사원 kbma1 / housing24 
public class MyApplication extends Application {

	public static final boolean DEBUG_MODE = true;
	public static final int PAGE_SIZE = 15;

	public static Context appContext;
	public static Typeface font;

	@Override
	public void onCreate() {

		super.onCreate();
		appContext = getApplicationContext();

	}

	public static Typeface getAppFont() {
		if (appContext == null) {
			return Typeface.DEFAULT;  
		}
		if (font == null)
			font = Typeface.createFromAsset(appContext.getAssets(), "fonts/yw_yg120.ttf");

		return font;
	}
}
// 사이트 papyrus 6388
// 마이오피스 heachus / heachus1 