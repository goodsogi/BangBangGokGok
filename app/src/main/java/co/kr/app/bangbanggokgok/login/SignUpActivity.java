package co.kr.app.bangbanggokgok.login;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pluslibrary.server.PlusHttpClient;
import com.pluslibrary.server.PlusInputStreamStringConverter;
import com.pluslibrary.server.PlusOnGetDataListener;
import com.pluslibrary.utils.PlusClickGuard;
import com.pluslibrary.utils.PlusToaster;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import co.kr.app.bangbanggokgok.BBGGCommonActivity;
import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;

public class SignUpActivity extends BBGGCommonActivity implements PlusOnGetDataListener {

    private static final int SIGN_UP = 2;
    private String mUserPhoneNumber;
    private String mUserEmail;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        showPhoneNumber();
    }

    private void showPhoneNumber() {
        TelephonyManager systemService = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        String phoneNumber = systemService.getLine1Number();

        phoneNumber = phoneNumber.substring(phoneNumber.length() - 10, phoneNumber.length());

        phoneNumber = "0" + phoneNumber;


        mUserPhoneNumber = phoneNumber;
        TextView userPhoneNumberView = (TextView) findViewById(R.id.userPhoneNumber);
        userPhoneNumberView.setText(phoneNumber);

    }

    /**
     * 가입하기
     *
     * @param v
     */
    public void signUp(View v) {

        PlusClickGuard.doIt(v);


        // 이름
        EditText userNameInput = (EditText) findViewById(R.id.userName);
        String userName = userNameInput.getText().toString();

        if (userName.equals("")) {
            PlusToaster.doIt(this, "이름을 입력해주세요");
            return;
        }
        //  이메일주소
        EditText userEmailInput = (EditText) findViewById(R.id.userEmail);
        mUserEmail = userEmailInput.getText().toString();

        if (mUserEmail.equals("")) {
            PlusToaster.doIt(this, "이메일주소를 입력해주세요");
            return;
        }

        //  이메일주소
        EditText userEmailAgainInput = (EditText) findViewById(R.id.userEmailAgain);
        String userEmailAgain = userEmailAgainInput.getText().toString();

        if (userEmailAgain.equals("")) {
            PlusToaster.doIt(this, "이메일주소를 다시 한번 입력해주세요");
            return;
        }


        if (!userEmailAgain.equals(mUserEmail)) {
            PlusToaster.doIt(this, "이메일주소가 동일하지 않습니다. 다시 한번 입력해주세요");
            return;
        }


        // 비밀번호(6자리 이상)
        EditText passwordInput = (EditText) findViewById(R.id.userPassword);
        String password = passwordInput.getText().toString();

        if (password.equals("")) {
            PlusToaster.doIt(this, "비밀번호를 입력해주세요");
            return;
        }

        if (password.length() < 6) {
            PlusToaster.doIt(this, "비밀번호를 6자리 이상 입력해주세요");
            return;
        }


        // 푸시 아이디
        BBGGGcmRegister register = new BBGGGcmRegister(SignUpActivity.this);
        String deviceId = register.getRegistrationId();

        List<NameValuePair> postParams = new ArrayList<NameValuePair>();
        postParams.add(new BasicNameValuePair("name", userName));
        postParams.add(new BasicNameValuePair("id", mUserEmail));
        postParams.add(new BasicNameValuePair("passwd", password));
        postParams.add(new BasicNameValuePair("hphone", mUserPhoneNumber));
        postParams.add(new BasicNameValuePair("addinfo6", deviceId));

        new PlusHttpClient(this, this, false).execute(SIGN_UP,
                BBGGApiConstants.SIGN_UP, new PlusInputStreamStringConverter(), postParams);

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
        switch (from) {

            case SIGN_UP:
                if(((String) datas).contains("가입완료")) {
                    PlusToaster.doIt(this, "가입완료했습니다");
                    saveUserInfo();
                } else {
                    PlusToaster.doIt(this, "가입에 성공하지 못했습니다");
                }


                break;
        }

    }

    private void saveUserInfo() {

        SharedPreferences sharedPreference = getSharedPreferences(
                BBGGConstants.PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreference.edit();
        e.putString(BBGGConstants.KEY_USER_ID, mUserEmail);
        e.putString(BBGGConstants.KEY_USER_TYPE, BBGGConstants.USER_TYPE_NORMAL);
        e.commit();
    }
}
