package co.kr.app.bangbanggokgok.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.pluslibrary.PlusConstants;
import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusInputStreamStringConverter;
import com.pluslibrary.server.PlusOnGetDataListener;
import com.pluslibrary.utils.PlusClickGuard;
import com.pluslibrary.utils.PlusToaster;

import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.MainActivity;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;

public class LoginActivity extends Activity implements PlusOnGetDataListener {

	private static final int LOG_IN = 0;

	private String mID;
	private SharedPreferences mSharedPreference;
	private String mPassword;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		showLoginLayout();

	}

	private void showLoginLayout() {
		setContentView(R.layout.activity_login);
		mSharedPreference = getSharedPreferences(BBGGConstants.PREF_NAME,
				Context.MODE_PRIVATE);
		// 아이디저장 처리
		if (mSharedPreference.getBoolean(BBGGConstants.KEY_SAVE_ID, false)) {

			showID();
			return;
		}

	}

	/**
	 * 아이디 표시
	 */
	private void showID() {
//		EditText idInput = (EditText) findViewById(R.id.id_input);
//		idInput.setText(mSharedPreference
//				.getString(FWConstants.KEY_USER_ID, ""));
//
//		CheckBox saveId = (CheckBox) findViewById(R.id.save_id);
//		saveId.setChecked(true);
//
	}

	/**
	 * 메인으로 이동
	 */
	private void goMain() {
		finish();
		Intent intent = new Intent(this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);

	}

	/**
	 * 회원가입
	 * 
	 * @param v
	 */
	public void signUp(View v) {

		PlusClickGuard.doIt(v);
		Intent intent = new Intent(this, SignUpActivity.class);
		startActivity(intent);

	}

	/**
	 * 아이디찾기
	 * 
	 * @param v
	 */
//	public void findID(View v) {
//		PlusClickGuard.doIt(v);
//
//		Intent intent = new Intent(this, FWWebViewActivity.class);
//		intent.putExtra(PlusConstants.KEY_URL, FWWebpageUrls.URL_MAIN
//				+ FWWebpageUrls.FIND_ID);
//		startActivity(intent);
//	}

	/**
	 * 비밀번호찾기
	 * 
	 * @param v
	 */
	public void findPassword(View v) {
        //구현 필요


//		PlusClickGuard.doIt(v);
//		Intent intent = new Intent(this, FWWebViewActivity.class);
//		intent.putExtra(PlusConstants.KEY_URL, FWWebpageUrls.URL_MAIN
//				+ FWWebpageUrls.FIND_PASSWORD);
//		startActivity(intent);
	}


    public void doFacebookLogin(View v) {
        //구현 필요


    }

    public void doJoin(View v) {
        Intent intent = new Intent(this, SignUpActivity.class);
		startActivity(intent);

    }

    public void doJoinBroker(View v) {
        Intent intent = new Intent(this, SignUpBrokerActivity.class);
        startActivity(intent);

    }

	/**
	 * 로그인
	 * 
	 * @param v
	 */
	public void doLogin(View v) {
//임시로 처리
        goMain();
        return;


//		PlusClickGuard.doIt(v);
//		// 아이디
//		EditText idInput = (EditText) findViewById(R.id.id_input);
//		mID = idInput.getText().toString();
//
//		if (mID.equals("")) {
//			PlusToaster.doIt(this, "아이디를 입력해주세요");
//			return;
//		}
//		// 비밀번호
//		EditText passwordInput = (EditText) findViewById(R.id.password_input);
//		mPassword = passwordInput.getText().toString();
//
//		if (mPassword.equals("")) {
//			PlusToaster.doIt(this, "비밀번호를 입력해주세요");
//			return;
//		}
////수정 필요!!
//        new PlusHttpClient(this, this, false).execute(LOG_IN,
//                BBGGApiConstants.LOG_IN + "?mid=" + mID + "&pass=" + mPassword
//                       ,
//                new PlusInputStreamStringConverter());

// gcm 푸시
//		FWGcmRegister gcmRegister = new FWGcmRegister(this);
//		String deviceId = gcmRegister.getRegistrationId();

//		new PlusHttpClient(this, this, false).execute(LOG_IN,
//				BBGGConstants.LOG_IN + "?mid=" + mID + "&pass=" + mPassword
//						+ "&deviceId=" + deviceId,
//				new PlusInputStreamStringConverter());

	}

	@Override
	public void onSuccess(Integer from, Object datas) {
		switch (from) {
		case LOG_IN:

			if (((String) datas).contains("OK")) {
				PlusToaster.doIt(LoginActivity.this, "로그인했습니다");

//				Editor e = mSharedPreference.edit();
//				// 로그인유지 저장
//				CheckBox autoLogin = (CheckBox) findViewById(R.id.keep_login);
//				if (autoLogin.isChecked()) {
//
//					e.putBoolean(FWConstants.KEY_KEEP_LOGIN, true);
//
//				}
//
//				// 아이디 저장
//				CheckBox saveID = (CheckBox) findViewById(R.id.save_id);
//				if (saveID.isChecked()) {
//
//					e.putBoolean(FWConstants.KEY_SAVE_ID, true);
//
//				}
//
//				e.putString(FWConstants.KEY_USER_ID, mID);
//				e.putString(FWConstants.KEY_USER_PASSWORD, mPassword);
//
//				e.commit();

				goMain();
			} else {
				PlusToaster.doIt(LoginActivity.this, "아이디와 비밀번호를 확인하세요");
			}
			break;

		default:
			break;
		}

	}


}
