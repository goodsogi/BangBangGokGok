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
import com.pluslibrary.server.PlusInputStreamStringConverter;
import com.pluslibrary.server.PlusOnGetDataListener;
import com.pluslibrary.utils.PlusClickGuard;
import com.pluslibrary.utils.PlusStringEmailChecker;
import com.pluslibrary.utils.PlusToaster;

import co.kr.app.bangbanggokgok.BBGGCommonActivity;
import co.kr.app.bangbanggokgok.BBGGConstants;
import co.kr.app.bangbanggokgok.R;
import co.kr.app.bangbanggokgok.server.BBGGApiConstants;

public class SignUpBrokerActivity extends BBGGCommonActivity implements PlusOnGetDataListener {

    private static final int SIGN_UP = 2;
    private String mAgentEmail;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup_broker);
    }

    /**
     * 가입하기
     *
     * @param v
     */
    public void signUp(View v) {

        PlusClickGuard.doIt(v);

        // 업체명
        EditText brokerNameInput = (EditText) findViewById(R.id.brokerName);
        String brokerName = brokerNameInput.getText().toString();

        if (brokerName.equals("")) {
            PlusToaster.doIt(this, "업체명을 입력해주세요");
            return;
        }

        // 중개등록번호
        EditText brokerRegisterNoInput = (EditText) findViewById(R.id.brokerRegisterNo);
        String brokerRegisterNo = brokerRegisterNoInput.getText().toString();

        if (brokerRegisterNo.equals("")) {
            PlusToaster.doIt(this, "중개등록번호를 입력해주세요");
            return;
        }
        // 대표이름
        EditText bossNameInput = (EditText) findViewById(R.id.bossName);
        String bossName = bossNameInput.getText().toString();

        if (bossName.equals("")) {
            PlusToaster.doIt(this, "대표이름을 입력해주세요");
            return;
        }
        // 전화번호
        EditText phoneNoInput = (EditText) findViewById(R.id.phoneNo);
        String phoneNo = phoneNoInput.getText().toString();

        if (phoneNo.equals("")) {
            PlusToaster.doIt(this, "전화번호를 입력해주세요");
            return;
        }
        // 주소
        EditText addressInput = (EditText) findViewById(R.id.address);
        String address = addressInput.getText().toString();

        if (address.equals("")) {
            PlusToaster.doIt(this, "주소를 입력해주세요");
            return;
        }
        // 담당자 이름
        EditText agentNameInput = (EditText) findViewById(R.id.agentName);
        String agentName = agentNameInput.getText().toString();

        if (agentName.equals("")) {
            PlusToaster.doIt(this, "담당자 이름을 입력해주세요");
            return;
        }
        // 담당자 이메일주소
        EditText agentEmailInput = (EditText) findViewById(R.id.agentEmail);
        mAgentEmail = agentEmailInput.getText().toString();

        if (mAgentEmail.equals("")) {
            PlusToaster.doIt(this, "담당자 이메일주소를 입력해주세요");
            return;
        }
        // 담당자 휴대폰 번호
        EditText agentMobileNoInput = (EditText) findViewById(R.id.agentMobileNo);
        String agentMobileNo = agentMobileNoInput.getText().toString();

        if (agentMobileNo.equals("")) {
            PlusToaster.doIt(this, "담당자 휴대폰 번호를 입력해주세요");
            return;
        }
        // 비밀번호(6자리 이상)
        EditText passwordInput = (EditText) findViewById(R.id.password);
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
        BBGGGcmRegister register = new BBGGGcmRegister(SignUpBrokerActivity.this);
        String deviceId = register.getRegistrationId();

        List<NameValuePair> postParams = new ArrayList<NameValuePair>();
        postParams.add(new BasicNameValuePair("name", brokerName));
        postParams.add(new BasicNameValuePair("addinfo4", brokerRegisterNo));
        postParams.add(new BasicNameValuePair("addinfo2", bossName));
        postParams.add(new BasicNameValuePair("addinfo5", phoneNo));
        postParams.add(new BasicNameValuePair("address1", address));
        postParams.add(new BasicNameValuePair("addinfo3", agentName));
        postParams.add(new BasicNameValuePair("id", mAgentEmail));
        postParams.add(new BasicNameValuePair("hphone", agentMobileNo));
        postParams.add(new BasicNameValuePair("passwd", password));
        postParams.add(new BasicNameValuePair("addinfo6", deviceId));

        new PlusHttpClient(this, this, false).execute(SIGN_UP,
                BBGGApiConstants.SIGN_UP_BROKER, new PlusInputStreamStringConverter(), postParams);

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
        e.putString(BBGGConstants.KEY_USER_ID, mAgentEmail);
        e.putString(BBGGConstants.KEY_USER_TYPE, BBGGConstants.USER_TYPE_BROKER);
        e.commit();
    }


    public void goBack(View v) {

        finish();

    }

}
