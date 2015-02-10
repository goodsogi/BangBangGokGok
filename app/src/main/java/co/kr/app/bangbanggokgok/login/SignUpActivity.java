package co.kr.app.bangbanggokgok.login;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusOnGetDataListener;
import com.pluslibrary.utils.PlusClickGuard;
import com.pluslibrary.utils.PlusStringEmailChecker;
import com.pluslibrary.utils.PlusToaster;

import co.kr.app.bangbanggokgok.R;

public class SignUpActivity extends Activity implements PlusOnGetDataListener {

	private static final int CHOOSE_AREA = 4;
	private static final int SIGN_UP = 2;
	private String mEmail;
	private String mPassword;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_signup);
	}

	/**
	 * 인증번호 발송 요청
	 * 
	 * @param v
	 */
	public void requestAuthNo(View v) {

		PlusClickGuard.doIt(v);

        //구현 필요!!

	}

    /**
     * 번호 인증
     *
     * @param v
     */
    public void doAuth(View v) {

        PlusClickGuard.doIt(v);

        //구현 필요!!

    }

    public void goBack(View v) {

        finish();

    }


    @Override
    public void onSuccess(Integer from, Object datas) {

    }
}
